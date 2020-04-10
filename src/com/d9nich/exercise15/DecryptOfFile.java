package com.d9nich.exercise15;

import java.io.*;
import java.util.Scanner;

public class DecryptOfFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an encrypted file name: ");
        String inputFile = input.nextLine();
        System.out.print("Enter where place decrypted file name: ");
        String outputFile = input.nextLine();
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFile));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            int v;
            while ((v = inputStream.read()) != -1)
                outputStream.write(v - 10);
        } catch (FileNotFoundException ex) {
            System.out.println("Problem with opening file");
        } catch (IOException ex) {
            System.out.println("Stream error");
        }
    }
}
