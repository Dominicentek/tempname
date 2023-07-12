package com.tempname.instruction;

import com.tempname.RuntimeContext;

public class StdoutInstruction extends Instruction {
    public void run(RuntimeContext context) {
        System.out.println(getArgument(context));
    }
}
