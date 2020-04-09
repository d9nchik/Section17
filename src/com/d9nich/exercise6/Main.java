package com.d9nich.exercise6;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Loan[] loans = new Loan[5];
        for (int i = 0; i < loans.length; i++)
            loans[i] = new Loan();
        try (ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream("Exercise17_06.dat")))) {
            for (Loan loan : loans) output.writeObject(loan);
        } catch (IOException ex) {
            System.out.println("Problem with opening file");
        }
    }
}
