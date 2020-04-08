package com.d9nich.exercise1;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class TextFileAdder {
    public static void main(String[] args) {
        try (PrintWriter output = new PrintWriter(new BufferedOutputStream(new FileOutputStream("Exercise17_01.txt",
                true)) )) {
            Random random = new Random();
            for (int i = 0; i < 150; i++)
                output.print(random.nextInt()+" ");
        } catch (FileNotFoundException ex) {
            System.out.println("Problem with opening of the file!");
        }
    }
}
