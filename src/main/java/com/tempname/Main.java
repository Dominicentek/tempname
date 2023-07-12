package com.tempname;

import com.args.Option;
import com.args.OptionType;
import com.args.Options;
import com.tempname.instruction.InstructionRegistry;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        File seedfile = new File("seed.bin");
        long seed = new Random(System.currentTimeMillis()).nextLong();
        if (seedfile.exists()) seed = ByteBuffer.wrap(readFile(seedfile)).getLong();
        Options options = new Options();
        options.addOption("file", new Option(OptionType.STRING));
        options.addOption("seed", new Option(OptionType.NUMBER, seed));
        options.addOption("no-random", new Option(OptionType.FLAG));
        options.load(args);
        writeFile(seedfile, ByteBuffer.allocate(8).putLong(seed).array());
        InstructionRegistry.register();
        if (!(boolean)options.getValue("no-random")) InstructionRegistry.swap((long)(double)options.getValue("seed"));
        RuntimeContext context = new RuntimeContext(new String(readFile(new File((String)options.getValue("file")))).replaceAll("\r", ""));
        while (context.hasNextInstruction()) {
            context.execute();
        }
    }
    public static byte[] readFile(File file) throws IOException {
        InputStream in = new FileInputStream(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = in.read(buffer)) > 0) {
            baos.write(buffer, 0, bytesRead);
        }
        return baos.toByteArray();
    }
    public static void writeFile(File file, byte[] data) throws IOException {
        OutputStream out = new FileOutputStream(file);
        out.write(data);
        out.close();
    }
    public static int safeParseInt(String str, int def) {
        try {
            return Integer.parseInt(str);
        }
        catch (Exception e) {
            return def;
        }
    }
}
