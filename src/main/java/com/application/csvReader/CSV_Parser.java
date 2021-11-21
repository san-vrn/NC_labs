package com.application.csvReader;

import com.application.entity.person.personCharacteristics.Gender;

public class CSV_Parser {

    public Gender parseGender(String data){
        if(data.equals("Мужской")){
            return Gender.MALE;
        }
        else {
            return Gender.FEMALE;
        }
    }
}
