package com.tempname.instruction;

import com.tempname.RuntimeContext;

public class PopInstruction extends Instruction {
    public void run(RuntimeContext context) {
        context.pop();
    }
}
