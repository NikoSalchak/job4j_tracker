package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items;")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveItemThenReturn() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        assertThat(tracker.add(item)).isEqualTo(item);
        assertThat(tracker.add(item)).isNotEqualTo(new Item("anotherItem"));
    }

    @Test
    public void whenSaveItemFindByGeneratedIdThenItIsNotTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item dbItem = new Item("DBItem");
        tracker.add(dbItem);
        assertThat(tracker.findById(dbItem.getId())).isNotEqualTo(new Item("notDBItem"));
        assertThat(tracker.findById(dbItem.getId())).isEqualTo(dbItem);
    }

    @Test
    public void whenSaveSomeItemsFindAllThenMustBeTHeSame() {
        SqlTracker sqlTracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        sqlTracker.add(item1);
        sqlTracker.add(item2);
        sqlTracker.add(item3);
        assertThat(sqlTracker.findAll()).containsAll(List.of(item1, item2, item3));
        assertThat(sqlTracker.findAll().get(0)).isNotEqualTo(new Item("notDBItem"));
        assertThat(sqlTracker.findAll().get(0)).isNotEqualTo(item2);
        assertThat(sqlTracker.findAll().get(1)).isEqualTo(item2);
    }

    @Test
    public void whenSaveItemThenReplaceItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item oldItem = new Item("oldItem");
        tracker.add(oldItem);
        tracker.replace(1, new Item("newItem"));
        assertThat(tracker.replace(oldItem.getId(), new Item("newItem"))).isTrue();
        assertThat(tracker.replace(0, new Item("newItem"))).isFalse();
    }

    @Test
    public void whenSaveItemThenDeleteItem() {
        SqlTracker sqlTracker = new SqlTracker(connection);
        Item item = new Item("item");
        sqlTracker.add(item);
        sqlTracker.delete(item.getId());
        assertThat(sqlTracker.findAll()).isEmpty();
        sqlTracker.add(item);
        sqlTracker.delete(new Item("anotherItem").getId());
        assertThat(sqlTracker.findByName("item").get(0)).isEqualTo(item);
    }

    @Test
    public void whenSaveItemsThenFindByName() {
        SqlTracker sqlTracker = new SqlTracker(connection);
        Item item = new Item("Item");
        Item item1 = new Item("Item");
        Item item2 = new Item("item");
        sqlTracker.add(item);
        sqlTracker.add(item1);
        sqlTracker.add(item2);
        assertThat(sqlTracker.findAll()).containsAll(List.of(item, item1, item2));
        assertThat(sqlTracker.findAll().get(2)).isEqualTo(item2);
        assertThat(sqlTracker.findByName("Item")).isNotEqualTo(List.of(
                new Item("Item"),
                new Item("Item"),
                new Item("Item"))
        );
    }
}