package com.application.contracts.utils.validator.checkers.contractCheckers;

import com.application.contracts.Contracts;
import com.application.entity.person.Person;

import java.time.LocalDate;

public class ContractCheck {

    /*
     private int ID;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private int numberContract;
    private Person contractOwner;
     */

    public boolean checkId(Contracts contract){
        if(contract.getID() >= 0){
            return true;
        }
        else return false;
    }

    public boolean checkContractStartDate(Contracts contract){
        if(contract.getContractStartDate() instanceof LocalDate){
            return true;
        }
        else return false;
    }

    public boolean checkContractEndDate(Contracts contract){
        if(contract.getContractEndDate() instanceof LocalDate &&
                !(contract.getContractEndDate().isBefore(LocalDate.now()))){
            return true;
        }
        else return false;
    }

    public boolean checkNumberContract(Contracts contract){
        if(contract.getNumberContract()>= 0){
            return true;
        }
        else return false;
    }

    public boolean checkContractOwner(Contracts contract){
        if(contract.getContractOwner() instanceof Person){
            return true;
        }
        else return false;
    }

}
