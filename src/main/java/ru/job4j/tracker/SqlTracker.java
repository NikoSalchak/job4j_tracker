package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Item> getItemsFromDB(ResultSet resultSet) throws SQLException {
        List<Item> rsl = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            LocalDateTime localDateTime = resultSet.getTimestamp("created").toLocalDateTime();
            rsl.add(new Item(id, name, localDateTime));
        }
        return rsl;
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = connection
                .prepareStatement("INSERT INTO items(name, created) VALUES(?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setObject(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement = connection
                .prepareStatement("UPDATE items SET name = ?, created = ? WHERE id = ?")) {
            statement.setString(1, item.getName());
            statement.setObject(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                rsl = getItemsFromDB(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE name LIKE ?;")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                rsl = getItemsFromDB(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item = new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
