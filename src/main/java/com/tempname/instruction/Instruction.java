package com.tempname.instruction;

import com.tempname.RuntimeContext;

public abstract class Instruction {
    private Integer arg;
    public abstract void run(RuntimeContext context);
    public final int getArgument(RuntimeContext context) {
        if (arg == null) arg = context.pop();
        return arg;
    }
    public final void setArgument(Integer arg) {
        this.arg = arg;
    }
    public final Instruction createNewInstance() {
        try {
            return getClass().newInstance();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
