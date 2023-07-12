package com.args;

public class Option {
    OptionType type;
    Object defaultValue = null;
    Object value;
    public Option(OptionType type, Object defaultValue) {
        if (defaultValue instanceof Number) defaultValue = ((Number)defaultValue).doubleValue();
        value = defaultValue;
        this.type = type;
        if (type == OptionType.FLAG) value = false;
        throwExceptionIfValueNotCompatible();
    }
    public Option(OptionType type) {
        this(type, null);
    }
    private void throwExceptionIfValueNotCompatible() {
        if (defaultValue == null) return;
        if (type == OptionType.FLAG ||
                (type == OptionType.NUMBER && !(defaultValue instanceof Number)) ||
                (type == OptionType.STRING && !(defaultValue instanceof String)))
            throw new IllegalOptionValueException("Default value not compatible with option type");
    }
}
