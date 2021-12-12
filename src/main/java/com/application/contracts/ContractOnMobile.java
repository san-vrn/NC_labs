package com.application.contracts;

import com.application.entity.person.Person;

import java.time.LocalDate;

/**
 * Class for creating a contract for mobile
 */
public class ContractOnMobile extends Contracts {
    private double minutes;
    private int sms;
    private double dataUsage;

    public ContractOnMobile(int ID, LocalDate contractStartDate, LocalDate contractEndDate, int numberContract, Person contractOwner, double minutes, int sms, double dataUsage) {
        super(ID, contractStartDate, contractEndDate, numberContract, contractOwner);
        this.minutes = minutes;
        this.sms = sms;
        this.dataUsage = dataUsage;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "ContractOnMobile{" +
                "minutes=" + minutes +
                ", sms=" + sms +
                ", dataUsage=" + dataUsage +
                "} ";
    }
}
