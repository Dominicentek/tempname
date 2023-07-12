package com.args;

import java.util.ArrayList;
import java.util.HashMap;

public class Options {
    private final HashMap<String, Option> options = new HashMap<>();
    private static final String optionPrefix = "--";
    public Options addOption(String name, Option option) {
        options.put(name, option);
        return this;
    }
    public Options load(String[] args) {
        int index = 0;
        while (index < args.length) {
            String name = args[index];
            if (name.startsWith(optionPrefix)) name = name.substring(2);
            else continue;
            index++;
            Option option = options.get(name);
            if (option == null) continue;
            if (option.type == OptionType.FLAG) option.value = true;
            if (option.type == OptionType.NUMBER) {
                if (index == args.length) throw new IllegalOptionValueException("Option " + name + " does not contain a number value");
                String number = args[index];
                index++;
                if (number.startsWith(optionPrefix)) throw new IllegalOptionValueException("Option " + name + " does not contain a number value");
                try {
                    option.value = Double.parseDouble(number);
                }
                catch (Exception e) {
                    throw new IllegalOptionValueException("Option " + name + " has a value that is not a number");
                }
            }
            if (option.type == OptionType.STRING) {
                if (index == args.length) throw new IllegalOptionValueException("Option " + name + " does not contain a string value");
                StringBuilder str = new StringBuilder();
                while (index < args.length) {
                    String word = args[index];
                    if (word.startsWith("--")) break;
                    str.append(word).append(" ");
                    index++;
                }
                option.value = str.substring(0, str.length() - 1);
            }
        }
        for (String name : options.keySet()) {
            Option option = options.get(name);
            if (option.value == null && option.defaultValue == null) throw new OptionNotFoundException("Option '" + name + "' does not exist in the arguments, but is required");
        }
        return this;
    }
    public Object getValue(String name) {
        Option option = options.get(name);
        if (option == null) throw new OptionNotFoundException("Option " + name + " doesn't exist");
        if (option.value == null) return option.defaultValue;
        return option.value;
    }
}
