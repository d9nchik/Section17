package com.d9nich.exercise16;

import java.io.*;
import java.util.Scanner;

public class FrequencyOfCharacter {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        System.out.println("Enter the name of an ASCII text file: ");
        String nameOfFile = new Scanner(System.in).nextLine();
        try (DataInputStream inputStream = new DataInputStream(new BufferedInputStream(
                new FileInputStream(nameOfFile)))) {
            while (true) {
                System.out.print((char) inputStream.readByte());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (EOFException ex) {
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Problem with stream");
        }
    }
}
