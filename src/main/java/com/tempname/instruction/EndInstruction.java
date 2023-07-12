package com.tempname.instruction;

import com.tempname.RuntimeContext;

public class EndInstruction extends Instruction {
    public void run(RuntimeContext context) {
        System.exit(0);
    }
}
