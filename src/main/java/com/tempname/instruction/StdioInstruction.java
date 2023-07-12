package com.tempname.instruction;

import com.tempname.Main;
import com.tempname.RuntimeContext;

import java.util.Scanner;

public class StdioInstruction extends Instruction {
    public void run(RuntimeContext context) {
        Scanner scanner = new Scanner(System.in);
        context.push(Main.safeParseInt(scanner.nextLine(), 0));
        scanner.close();
    }
}
