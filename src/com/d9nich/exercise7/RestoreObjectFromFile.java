package com.d9nich.exercise7;

import com.d9nich.exercise6.Loan;

import java.io.*;

public class RestoreObjectFromFile {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        double totalLoanAmount = 0;
        try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream("Exercise17_06.dat")))) {
            while (true) {
                Loan loan = (Loan) input.readObject();
                totalLoanAmount += loan.getLoanAmount();
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Problem with finding class file");
        } catch (EOFException ex) {
            System.out.println("Total loan amount = " + totalLoanAmount);
        } catch (FileNotFoundException ex) {
            System.out.println("Problem with finding file");

        } catch (IOException ex) {
            System.out.println("Problem with stream");
        }

    }
}
