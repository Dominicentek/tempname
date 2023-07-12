package com.tempname;

import com.tempname.instruction.Instruction;
import com.tempname.instruction.InstructionRegistry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class RuntimeContext {
    private int pointer = 0;
    private ArrayList<Instruction> instructions = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();
    public RuntimeContext(String program) {
        for (String line : program.split("\n")) {
            int spaceIndex = line.indexOf(' ');
            String instrName;
            String arg = null;
            if (spaceIndex == -1) instrName = line;
            else {
                instrName = line.substring(0, spaceIndex);
                arg = line.substring(spaceIndex + 1);
            }
            Instruction instr = InstructionRegistry.instructions.get(instrName);
            instr = instr.createNewInstance();
            if (arg != null) {
                try {
                    instr.setArgument(Integer.parseInt(arg));
                }
                catch (Exception e) {}
            }
            instructions.add(instr);
        }
    }
    public void setPointer(int pointer) {
        this.pointer = pointer - 1;
    }
    public int getCurrentLine() {
        return pointer;
    }
    public void push(int value) {
        stack.push(value);
    }
    public int pop() {
        return stack.pop();
    }
    public void reverseStack() {
        Collections.reverse(stack);
    }
    public boolean hasNextInstruction() {
        return pointer < instructions.size();
    }
    public void execute() {
        if (pointer < 0) pointer = 0;
        instructions.get(pointer++).run(this);
    }
}
