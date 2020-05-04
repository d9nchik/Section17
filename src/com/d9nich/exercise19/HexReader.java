package com.d9nich.exercise19;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.d9nich.exercise18.GetBytes.getBits;

public class HexReader {
    public static void main(String[] args) {
        System.out.print("Enter a file name: ");
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(
                new Scanner(System.in).nextLine()))) {
            int v;
            while ((v = inputStream.read()) != -1)
                System.out.println(getHex(v));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Stream error");
        }
    }

    public static String getHex(int value) {
        String bits = getBits(value);
        String firstLetter = bits.substring(0, 4);
        String secondLetter = bits.substring(4, 8);
        return "" + getSymbolOfHex(firstLetter) + getSymbolOfHex(secondLetter);
    }

    private static char getSymbolOfHex(String bytes) {
        if (bytes.matches("[01]{4}")) {
            int number = 0;
            for (int i = 0; i < 4; i++) {
                number = number << 1;
                if (bytes.charAt(i) == '1')
                    number++;
            }
            if (number < 10)
                return ((char) (number + '0'));
            else
                return ((char) (number - 10 + 'A'));
        } else
            throw new InputMismatchException();
    }
}
