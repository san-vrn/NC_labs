package com.application.contracts;

import com.application.entity.person.Person;

import java.time.LocalDate;

/**
 * Class for creating a contract for TV
 */
public class ContractOnTV extends Contracts {
    private int TV_plans;

    public ContractOnTV(int ID, LocalDate contractStartDate, LocalDate contractEndDate, int numberContract, Person contractOwner, int TV_plans) {
        super(ID, contractStartDate, contractEndDate, numberContract, contractOwner);
        this.TV_plans = TV_plans;
    }

    public ContractOnTV() {
        super();
    }

    @Override
    public String toString() {
        return  super.toString() +
                "ContractOnTV{" +
                "TV_plans=" + TV_plans +
                "} ";
    }
}
