package com.d9nich.exercise2;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class BinaryNumbers {
    public static void main(String[] args) {
        try (DataOutputStream output = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("temp.dat", true)))) {
            Random random = new Random();
            for (int i = 0; i < 150; i++)
                output.writeInt(random.nextInt());
        } catch (IOException ex) {
            System.out.println("Problem with writing file!");
        }
    }
}
