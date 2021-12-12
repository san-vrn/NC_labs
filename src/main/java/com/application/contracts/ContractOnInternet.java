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

    public int getInternetConnectionSpeed() {
        return internetConnectionSpeed;
    }

    public void setInternetConnectionSpeed(int internetConnectionSpeed) {
        this.internetConnectionSpeed = internetConnectionSpeed;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "ContractOnInternet{" +
                "internetConnectionSpeed=" + internetConnectionSpeed +
                "} ";
    }
}
