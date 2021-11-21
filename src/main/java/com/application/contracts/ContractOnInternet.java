package com.application.contracts;

import com.application.entity.person.Person;

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

    @Override
    public String toString() {
        return "ContractOnInternet{" +
                "ID=" + getID() +
                ", contractStartDate=" + getContractEndDate() +
                ", contractEndDate=" + getContractEndDate() +
                ", numberContract=" + getNumberContract() +
                ", contractOwner=" + getContractOwner() +
                ", internetConnectionSpeed=" + internetConnectionSpeed +
                '}';
    }
}
