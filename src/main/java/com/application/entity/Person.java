package com.application.entity;

import com.application.entity.personCharacteristics.Gender;


import java.time.LocalDate;

/**
 * This is a class for creating a person
 */
public class Person {
    private int ID;
    private String lastName;
    private String firstName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Gender gender;
    private int passportNumber;
    private int age;

    /**
     * This is a method for calculating the age of a person
     * @param dateOfBirth birthday values
     * @return how old is a person
     */
    private int ageCalculate(LocalDate dateOfBirth){
        LocalDate nowDate = LocalDate.now();
        int nowYear = nowDate.getYear();
        int nowMonth = nowDate.getMonthValue();
        int nowDayOfMonth = nowDate.getDayOfMonth();
        int birthYear = dateOfBirth.getYear();
        int birthMonth = dateOfBirth.getMonthValue();
        int birthDayOfMonth = dateOfBirth.getDayOfMonth();

        if(nowMonth>=birthMonth & nowDayOfMonth>birthDayOfMonth){
            return nowYear - birthYear;
        }
        else
            return nowYear - birthYear - 1;
    }

    public Person(int ID, String lastName, String firstName, String patronymic, LocalDate dateOfBirth, Gender gender, int passportNumber) {
        this.ID = ID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.passportNumber = passportNumber;
        this.age = ageCalculate(dateOfBirth);
    }

    public int getID() {
        return ID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public int getAge() {
        return age;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        ageCalculate(dateOfBirth);
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
}
