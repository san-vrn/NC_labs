package com.application.contracts;

import com.application.entity.Person;

import java.time.LocalDate;

/**
 * Class for creating a contract for internet
 */
public class ContractOnInternet extends Contracts {
    private int internetConnectionSpeed;

    public ContractOnInternet(int ID, LocalDate contractStartDate, LocalDate contractEndDate, int numberContract, Person contractOwner, int internetConnectionSpeed) {
        super(ID, contractStartDate, contractEndDate, numberContract, contractOwner);
        this.internetConnectionSpeed = internetConnectionSpeed;
    }
}
