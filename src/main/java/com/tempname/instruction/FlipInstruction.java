package com.tempname.instruction;

import com.tempname.RuntimeContext;

public class FlipInstruction extends Instruction {
    public void run(RuntimeContext context) {
        context.reverseStack();
    }
}
