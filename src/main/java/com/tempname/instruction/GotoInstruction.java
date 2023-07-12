package com.tempname.instruction;

import com.tempname.RuntimeContext;

public class GotoInstruction extends Instruction {
    public void run(RuntimeContext context) {
        context.setPointer(getArgument(context));
    }
}
