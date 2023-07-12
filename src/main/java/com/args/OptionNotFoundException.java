package com.args;

public class OptionNotFoundException extends RuntimeException {
    public OptionNotFoundException(String msg) {
        super(msg);
    }
}
