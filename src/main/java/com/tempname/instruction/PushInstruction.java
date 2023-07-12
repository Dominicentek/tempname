package com.tempname.instruction;

import com.tempname.RuntimeContext;

public class PushInstruction extends Instruction {
    public void run(RuntimeContext context) {
        context.push(getArgument(context));
    }
}
