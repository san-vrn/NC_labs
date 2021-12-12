package com.application.contracts.utils.validator.checkers.personCheckers;

import com.application.entity.person.Person;
import com.application.entity.person.personCharacteristics.Gender;

import java.time.LocalDate;

public class PersonCheck {
    public boolean checkId(Person person){
        if(person.getID() >= 0){
            return true;
        }
        else return false;
    }

    // if(person.getFirstName().matches("[а-яА-Яa-zA-Z]+")){
    public boolean checkLastName(Person person){
        if(person.getLastName().matches("[a-zA-Z]+")){
            return true;
        }
        else return false;
    }

    public boolean checkFirstName(Person person){
        if(person.getFirstName().matches("[a-zA-Z]+")){
            return true;
        }
        else return false;
    }

    public boolean checkPatronymic(Person person){
        if(person.getPatronymic().matches("[а-яА-Яa-zA-Z]+")){
            return true;
        }
        else return false;
    }

    public boolean checkDateOfBirth(Person person){
        if(person.getDateOfBirth() instanceof LocalDate){
            return true;
        }
        else return false;
    }
    public boolean checkGender(Person person){
        if(person.getGender() instanceof Gender){
            return true;
        }
        else return false;
    }

    public boolean checkPassportNumberLength(Person person){
        if(((int) (Math.log10(person.getPassportNumber()) + 1)) == 10){
            return true;
        }
        else return false;
    }

    public boolean checkAge(Person person){
        if(person.getAge() >= 18 && person.getAge()<105){
            return true;
        }
        else return false;
    }
}
