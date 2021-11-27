package com.application.contracts.utils.validator;

import java.util.ArrayList;

public class ValidatorReport {
    private String status;
    private ArrayList<String> errorDescription = new ArrayList<>();
    private ArrayList<String> variableName = new ArrayList<>();

    public void setStatus(String status) {
        this.status = status;
    }

    public void addErrorDescription(String errorDescription) {
        this.errorDescription.add(errorDescription);
    }

    public void addVariableName(String variableName) {
        this.variableName.add(variableName);
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<String> getErrorDescription() {
        return errorDescription;
    }

    public ArrayList<String> getVariableName() {
        return variableName;
    }

    @Override
    public String toString() {
        return "ValidatorReport{" +
                "status='" + status + '\'' +
                ", errorDescription=" + errorDescription +
                ", variableName=" + variableName +
                '}';
    }
}
