package com.kdhm.nerapplication.model;

public enum Type {

    PERSON("Person"),
    CITY("City"),
    STATE_OR_PROVINCE("State_Or_Province"),
    COUNTRY("Country"),
    EMAIL("Email"),
    TITLE("Title"),
    EXPENSE("Expense"),
    NUMBER("Number");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getName() {
        return type;
    }
}
