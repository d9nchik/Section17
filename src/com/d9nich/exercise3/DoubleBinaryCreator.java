package com.d9nich.exercise3;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class DoubleBinaryCreator {
    public static void main(String[] args) {
        try (DataOutputStream output = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("Exercise17_03.dat", true)))) {
            Random random = new Random();
            for (int i = 0; i < 5; i++)
                output.writeDouble(random.nextDouble());
        } catch (IOException ex) {
            System.out.println("Problem with writing file!");

        }
    }
}
