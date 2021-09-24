package com.srccode.enums;

public enum InputType {
    CONSOLE("Console"), FILE("File"), MONGODB("MongoDB"), MYSQL("MySQL"), NEWSTRING("NewString");

    private final String inputType;

    InputType(String inputType) {
        this.inputType = inputType;
    }

    public String getInputType() {
        return inputType;
    }
}
