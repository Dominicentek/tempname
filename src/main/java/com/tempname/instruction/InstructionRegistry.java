package com.tempname.instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InstructionRegistry {
    public static final HashMap<String, Instruction> instructions = new HashMap<>();
    public static void register() {
        instructions.put("dec", new DecInstruction());
        instructions.put("div", new DivInstruction());
        instructions.put("flip", new FlipInstruction());
        instructions.put("goto", new GotoInstruction());
        instructions.put("if", new IfInstruction());
        instructions.put("inc", new IncInstruction());
        instructions.put("mul", new MulInstruction());
        instructions.put("nif", new NifInstruction());
        instructions.put("pop", new PopInstruction());
        instructions.put("push", new PushInstruction());
        instructions.put("stdio", new StdioInstruction());
        instructions.put("stdout", new StdoutInstruction());
        instructions.put("end", new EndInstruction());
    }
    public static void swap(long seed) {
        Random random = new Random(seed);
        for (String key1 : instructions.keySet()) {
            for (String key2 : instructions.keySet()) {
                if (random.nextBoolean()) continue;
                Instruction temp = instructions.get(key1);
                instructions.put(key1, instructions.get(key2));
                instructions.put(key2, temp);
            }
        }
        for (String key : instructions.keySet()) {
            String newType = instructions.get(key).getClass().getSimpleName();
            newType = newType.substring(0, newType.length() - "instruction".length()).toLowerCase();
            System.out.println(key + " -> " + newType);
        }
    }
}
