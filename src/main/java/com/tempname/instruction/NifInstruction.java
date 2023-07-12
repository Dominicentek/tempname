package com.tempname.instruction;

import com.tempname.RuntimeContext;

public class NifInstruction extends Instruction {
    public void run(RuntimeContext context) {
        if (getArgument(context) != 0) context.setPointer(context.getCurrentLine() + 2);
    }
}
