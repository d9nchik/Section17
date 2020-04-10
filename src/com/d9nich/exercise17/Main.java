package com.d9nich.exercise17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BitOutputStream outputStream = new BitOutputStream(new File("Exercise17_17.dat"));
            outputStream.writeBit("010000100100001001101");
            outputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (IOException ex) {
            System.out.println("Stream  error");
        }
    }
}
