package com.d9nich.exercise12;

import java.io.*;

public class CombinerOfFile {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java CombinerOfFile SourceFile1 . . . SourceFilen TargetFile");
            System.exit(1);
        }
        try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(args[args.length - 1]))) {
            for (int i = 0; i < args.length - 1; i++) {
                BufferedInputStream input = new BufferedInputStream(new FileInputStream(args[i]));
                int v;
                while ((v = input.read()) != -1)
                    output.write(v);
                input.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Stream problem");
        }
    }
}
