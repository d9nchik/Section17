package com.d9nich.exercise8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class HowManyTimesExecutes {
    public static void main(String[] args) {
        try (RandomAccessFile accessFile = new RandomAccessFile("Exercise17_08.dat", "rw")) {
            if (accessFile.length() == 0)
                accessFile.writeInt(1);
            else {
                int v = accessFile.readInt() + 1;
                accessFile.seek(0);
                accessFile.writeInt(v);
                System.out.println("Time " + v);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File cannot be found!");
        } catch (IOException ex) {
            System.out.println("Problem with stream");
        }
    }
}
