package com.d9nich.exercise18;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GetBytes {
    public static void main(String[] args) {
        System.out.print("Enter a file name: ");
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(
                new Scanner(System.in).nextLine()))) {
            int v;
            while ((v = inputStream.read()) != -1)
                System.out.println(getBits(v));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Stream error");
        }
    }

    public static String getBits(int value) {
        StringBuilder bits = new StringBuilder();
        for (byte i = 7; i >= 0; i--)
            bits.append((byte) ((byte) 1 & (value >> i)));
        return bits.toString();
    }
}
