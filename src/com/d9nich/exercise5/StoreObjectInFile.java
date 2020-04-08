package com.d9nich.exercise5;

import java.io.*;
import java.util.Date;

public class StoreObjectInFile {
    public static void main(String[] args) {
        try (ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream("Exercise17_05.dat")))) {
            int[] array = {1, 2, 3, 4, 5, 6};
            output.writeObject(array);
            output.writeObject(new Date());
            output.writeDouble(10.5);
        } catch (FileNotFoundException ex) {
            System.out.println("Problem with opening file");
        } catch (IOException ex) {
            System.out.println("Problem with stream");
        }
    }
}
