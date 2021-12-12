package com.application.contracts.utils.validator;

import com.application.contracts.Contracts;
import com.application.contracts.utils.validator.checkers.contractCheckers.ContractCheck;
import com.application.contracts.utils.validator.checkers.personCheckers.PersonCheck;
import com.application.d_injector.Autoinjectable;
import com.application.d_injector.Injector;

public class Validator {
        @Autoinjectable
        ContractCheck contract_check;
        @Autoinjectable
        PersonCheck person_check;

    public ValidatorReport check(Contracts contract){
            ValidatorReport report = new ValidatorReport();
            report.setStatus("ok");

            if(!(contract_check.checkId(contract))){
                report.setStatus("error");
                report.addErrorDescription("Contract : Отрицательный id");
                report.addVariableName("Contract id");
            }

            if(!(contract_check.checkContractStartDate(contract))){
                report.setStatus("error");
                report.addErrorDescription("Contract : Ошибка в переменной \"startDate\"");
                report.addVariableName("Contract startDate");
            }

            if(!(contract_check.checkContractEndDate(contract))){
                report.setStatus("error");
                report.addErrorDescription("Contract : Ошибка в переменной \"endDate\"");
                report.addVariableName("Contract endDate");
            }

            if(!(contract_check.checkNumberContract(contract))){
                report.setStatus("error");
                report.addErrorDescription("Contract : Ошибка в переменной \"numberContract\"");
                report.addVariableName("Contract numberContract");
            }

            if(!(contract_check.checkContractOwner(contract))){
                report.setStatus("error");
                report.addErrorDescription("Contract : Ошибка типа переменной ContractOwner");
                report.addVariableName("Contract contractOwner");
            }
            else{
                if(!(person_check.checkId(contract.getContractOwner()))){
                    report.setStatus("error");
                    report.addErrorDescription("ContractOwner : Отрицательный id");
                    report.addVariableName("ContractOwner id");
                }
                if(!(person_check.checkLastName(contract.getContractOwner()))){
                    report.setStatus("error");
                    report.addErrorDescription("ContractOwner : фамилия не может содержать цифры и символы");
                    report.addVariableName("ContractOwner lastName");
                }
                if(!(person_check.checkFirstName(contract.getContractOwner()))){
                    report.setStatus("error");
                    report.addErrorDescription("ContractOwner : имя не может содержать цифры и символы");
                    report.addVariableName("ContractOwner firstName");
                }

                if(!(person_check.checkPatronymic(contract.getContractOwner()))){
                    report.setStatus("error");
                    report.addErrorDescription("ContractOwner : отчество не может содержать цифры и символы");
                    report.addVariableName("ContractOwner patronymic");
                }
                if(!(person_check.checkDateOfBirth(contract.getContractOwner()))){
                    report.setStatus("error");
                    report.addErrorDescription("ContractOwner : Ошибка в дате рождения");
                    report.addVariableName("ContractOwner dateOfBirth");
                }
                if(!(person_check.checkGender(contract.getContractOwner()))){
                    report.setStatus("error");
                    report.addErrorDescription("ContractOwner : Ошибка в определении пола клиента");
                    report.addVariableName("ContractOwner gender");
                }
                if(!(person_check.checkPassportNumberLength(contract.getContractOwner()))){
                    report.setStatus("error");
                    report.addErrorDescription("ContractOwner : Номер паспорта должен состоять из 10 цифр");
                    report.addVariableName("ContractOwner passportNumber");
                }
                if(!(person_check.checkAge(contract.getContractOwner()))){
                    report.setStatus("error");
                    report.addErrorDescription("ContractOwner : Возраст клиента должен быть больше 18-ти лет");
                    report.addVariableName("ContractOwner age");
                }
            }
            return report;
        }

    public Validator() {
        Injector inj = new Injector(this);
    }
}
