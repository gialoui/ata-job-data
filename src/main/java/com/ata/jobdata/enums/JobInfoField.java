package com.ata.jobdata.enums;

public enum JobInfoField {
    TIMESTAMP("timestamp"),
    EMPLOYER("employer"),
    LOCATION("location"),
    JOB_TITLE("jobTitle"),
    YEARS_AT_EMPLOYER("yearsAtEmployer"),
    YEARS_OF_EXPERIENCE("yearsOfExperience"),
    SALARY("salary"),
    SIGNING_BONUS("signingBonus"),
    ANNUAL_BONUS("annualBonus"),
    ANNUAL_STOCK_VALUE_OR_BONUS("annualStockValueOrBonus"),
    GENDER("gender"),
    ADDITIONAL_COMMENTS("additionalComments");

    private final String fieldName;

    private JobInfoField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
