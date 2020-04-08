package com.d9nich.exercise3;

import java.io.*;

public class SumOfDoubleBinary {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        double total = 0;
        try (DataInputStream output = new DataInputStream(
                new BufferedInputStream(new FileInputStream("Exercise17_03.dat")))) {
            while (true)
                total += output.readDouble();
        } catch (EOFException ex) {
            System.out.println(total);
        } catch (IOException ex) {
            System.out.println("Problem with writing file!");
        }

    }
}
