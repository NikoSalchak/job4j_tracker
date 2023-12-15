package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phone = new PhoneDictionary();
        phone.add(new Person(
                "Petr", "Arsentev", "534872", "Bryansk")
        );
        var person = phone.find("Petr");
        assertThat(person.get(0).getName()).isEqualTo("Petr");
    }

    @Test
    public void whenNotFindByName() {
        var phone = new PhoneDictionary();
        var person = phone.find("Petr");
        assertThat(person).isEmpty();
    }
}