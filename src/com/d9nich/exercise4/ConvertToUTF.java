package com.d9nich.exercise4;

import java.io.*;
import java.util.Scanner;

public class ConvertToUTF {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java ConvertToUTF input.txt output.utf");
            System.exit(1);
        }
        File inFile = new File(args[0]);
        File outFile = new File(args[1]);
        if (!inFile.exists()) {
            System.out.println("File you enter doesn't exist");
            System.exit(2);
        }
        try (Scanner input = new Scanner(new BufferedInputStream(new FileInputStream(inFile)));
             DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)))) {
            while (input.hasNext())
                output.writeUTF(input.nextLine());
        } catch (FileNotFoundException ex) {
            System.out.println("Problem with opening File");
        } catch (IOException ex) {
            System.out.println("Problem with stream");
        }
        System.out.println("Text file size = " + inFile.length());
        System.out.println("Binary file size = " + outFile.length());
    }
}
