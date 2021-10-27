package com.application.entity;

import com.application.entity.personCharacteristics.Gender;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void testPerson() {
        Person testPerson = new Person(1, "Fedorov", "Fedor", "Fedorovich", LocalDate.parse("1995-10-10"), Gender.MALE, 2015106604);
    }
}