package com.application.contracts.utils.validator;

import com.application.contracts.ContractOnInternet;
import com.application.entity.person.Person;
import com.application.entity.person.personCharacteristics.Gender;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void check() {
        Person testPerson = new Person(1, "Fedorov", "Fedor123", "Fedorovich", LocalDate.parse("1995-10-10"), Gender.MALE, 2015106604);
        ContractOnInternet contract = new ContractOnInternet(-1, LocalDate.now(), LocalDate.parse("2025-10-10"), 1010, testPerson, 200);
        Validator validator = new Validator();
        System.out.println(validator.check(contract));
    }
}