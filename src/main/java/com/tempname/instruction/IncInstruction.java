package com.tempname.instruction;

import com.tempname.RuntimeContext;

public class IncInstruction extends Instruction {
    public void run(RuntimeContext context) {
        int a = context.pop();
        int b = getArgument(context);
        context.push(a + b);
    }
}