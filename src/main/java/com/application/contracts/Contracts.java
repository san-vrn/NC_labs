package com.application.contracts;

import com.application.entity.person.Person;
import java.time.LocalDate;

/**
 * This is an abstract class for creating a contract
 */
public abstract class Contracts {

    private int ID;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private int numberContract;
    private Person contractOwner;

    public int getID() { return ID;
    }

    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public int getNumberContract() {
        return numberContract;
    }

    public Person getContractOwner() {
        return contractOwner;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }

    public void setContractOwner(Person contractOwner) {
        this.contractOwner = contractOwner;
    }

    public Contracts(int ID, LocalDate contractStartDate, LocalDate contractEndDate, int numberContract, Person contractOwner) {
        this.ID = ID;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.numberContract = numberContract;
        this.contractOwner = contractOwner;
    }

    public Contracts() {

    }


    @Override
    public String toString() {
        return "Contracts{" +
                "ID=" + ID +
                ", contractStartDate=" + contractStartDate +
                ", contractEndDate=" + contractEndDate +
                ", numberContract=" + numberContract +
                ", contractOwner=" + contractOwner +
                '}';
    }

}
