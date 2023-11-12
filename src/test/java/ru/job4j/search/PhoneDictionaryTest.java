package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(new Person(
                "Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> person = phone.find("Petr");
        assertThat(person.get(0).getName()).isEqualTo("Petr");
    }

    @Test
    public void whenNotFindByName() {
        PhoneDictionary phone = new PhoneDictionary();
        ArrayList<Person> person = phone.find("Petr");
        ArrayList<Person> empty = new ArrayList<>();
        assertThat(person).isEqualTo(empty);
    }
}