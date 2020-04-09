package com.d9nich.exercise10;

import java.io.*;

public class DivideOfHugeFile {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java DivideOfHugeFile numberOfPieces");
            System.exit(1);
        }
        int numberOfFiles = Integer.parseInt(args[1]);
        File file = new File(args[0]);
        long numberOfBytes = file.length();
        try (BufferedInputStream input = new BufferedInputStream(
                new FileInputStream(args[0]))) {
            BufferedOutputStream output;
            for (int i = 1; i < numberOfFiles; i++) {
                output = new BufferedOutputStream(
                        new FileOutputStream(args[0] + "." + i));
                for (int j = 0; j < numberOfBytes / numberOfFiles; j++)
                    output.write(input.read());
                output.close();
            }
            int value;
            output = new BufferedOutputStream(
                    new FileOutputStream(args[0] + "." + numberOfFiles));
            while ((value = input.read()) != -1)
                output.write(value);
            output.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Stream problem");
        }
    }
}
