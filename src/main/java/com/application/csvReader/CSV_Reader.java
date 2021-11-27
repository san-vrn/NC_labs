package com.application.csvReader;
//ID;ДатаНачалаКонтракта;ДатаКонцаКонтракта;НомерКонтракта;Фамилия;Имя;Отчество;ДатаРождения;ПолКлиента;СерияНомерПаспорта;ТипКонтракта;ДопИнформацияПоКонтракту
import com.application.contracts.ContractOnInternet;
import com.application.contracts.ContractOnMobile;
import com.application.contracts.ContractOnTV;
import com.application.contracts.Contracts;
import com.application.contracts.utils.validator.Validator;
import com.application.entity.person.Person;
import com.application.entity.person.personCharacteristics.Gender;
import com.application.repository.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class CSV_Reader {
    Validator validator = new Validator();

    public Repository read(Repository repo, String fileName) throws IOException {
        // открываем файл
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        // считываем построчно
        String line;
        Scanner scanner;
        int index = 0;

        while ((line = reader.readLine()) != null) {

            Person contractOwner;
            CSV_Parser parser = new CSV_Parser();
            int id_contractowner = (int) (Math.random() * 999999);

            Contracts contract = null;
            int id=0;
            LocalDate startDate=null;
            LocalDate endDate=null;
            int numberContract = 0;
            String lastName=null;
            String firstName=null;
            String patronymic=null;
            LocalDate dateOfBirth=null;
            Gender gender=null;
            int passportNumber=0;
            String typeContract=null;
            double[] otherInformation=null;

            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    id = Integer.parseInt(data);
                else if (index == 1)
                    startDate = LocalDate.parse(data);
                else if (index == 2)
                    endDate = LocalDate.parse(data);
                else if (index == 3)
                    numberContract = Integer.parseInt(data);
                else if (index == 4)
                    lastName = data;
                else if (index == 5)
                    firstName = data;
                else if (index == 6)
                    patronymic = data;
                else if (index == 7)
                    dateOfBirth = LocalDate.parse(data);
                else if (index == 8)
                    gender = parser.parseGender(data);
                else if (index == 9)
                    passportNumber = Integer.parseInt(data);
                else if (index == 10)
                    typeContract = data;
                else if (index == 11)
                    otherInformation = Arrays.stream(data.split(",")).mapToDouble(Double::parseDouble).toArray();
                else
                    System.out.println("Некорректные данные::" + data);

                index++;

            }
            contractOwner = new Person(id_contractowner, lastName, firstName, patronymic, dateOfBirth, gender, passportNumber);
            switch (Objects.requireNonNull(typeContract)) {
                case ("ТВ"):
                    contract = new ContractOnTV(id, startDate, endDate, numberContract, contractOwner, (int) (Objects.requireNonNull(otherInformation))[0]);
                    break;
                case ("Мобильный"):
                    contract = new ContractOnMobile(id, startDate, endDate, numberContract, contractOwner, Objects.requireNonNull(otherInformation)[0], (int) otherInformation[1], otherInformation[2]);
                    break;
                case ("Интернет"):
                    contract = new ContractOnInternet(id, startDate, endDate, numberContract, contractOwner, (int) Objects.requireNonNull(otherInformation)[0]);
                    break;
            }
            validator.check(contract);
            repo.add(contract);
            index = 0;
        }

        //закрываем наш ридер
        reader.close();

        return repo;
    }
}
