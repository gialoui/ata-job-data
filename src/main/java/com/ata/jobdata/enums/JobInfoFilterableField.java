package com.ata.jobdata.enums;

public enum JobInfoFilterableField {
    JOB_TITLE("job_title"), GENDER("gender"), SALARY("salary");

    private final String label;

    private JobInfoFilterableField(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
