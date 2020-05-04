package com.d9nich.exercise9;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AddressBookFileWork {
    private static final int SIZE_OF_STRUCTURE = (32 + 32 + 20 + 2 + 5) * 2;
    private RandomAccessFile inout;

    public AddressBookFileWork() {
        try {
            inout = new RandomAccessFile("db.dat", "rw");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
    }

    public void add(ContactOfPerson contactOfPerson) {
        try {
            long position = inout.getFilePointer();
            inout.seek(inout.length());
            writeData(contactOfPerson);
            inout.seek(position);
        } catch (IOException ex) {
            System.out.println("Problem with stream");
        }
    }

    private void writeData(ContactOfPerson contactOfPerson) throws IOException {
        inout.writeChars(String.format("%-32s", contactOfPerson.getName()));
        inout.writeChars(String.format("%-32s", contactOfPerson.getStreet()));
        inout.writeChars(String.format("%-20s", contactOfPerson.getCity()));
        inout.writeChars(String.format("%-2s", contactOfPerson.getState()));
        inout.writeChars(String.format("%-5s", contactOfPerson.getZip()));
    }

    public ContactOfPerson first() {
        try {
            inout.seek(0);
        } catch (IOException ex) {
            System.out.println("Problem with stream");
        }
        return next();
    }

    public ContactOfPerson next() {
        try {
            if (inout.getFilePointer() == inout.length())
                return last();
        } catch (IOException ex) {
            System.out.println("Problem with stream");
        }
        return new ContactOfPerson(readChars(32), readChars(32), readChars(20),
                readChars(2), readChars(5));
    }

    private String readChars(int size) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (int i = 0; i < size; i++)
                stringBuilder.append(inout.readChar());
        } catch (IOException ex) {
            System.out.println("Problem with stream");
        }
        return stringBuilder.toString().trim();
    }

    public ContactOfPerson previous() {
        try {
            final long pos = inout.getFilePointer() - 2 * SIZE_OF_STRUCTURE;
            inout.seek(pos > 0 ? pos : 0);
        } catch (IOException ex) {
            System.out.println("Problem with stream");
        }
        return next();
    }

    public ContactOfPerson last() {
        try {
            if (inout.length() == 0)
                return new ContactOfPerson();
            inout.seek(inout.length() - SIZE_OF_STRUCTURE);
        } catch (IOException ex) {
            System.out.println("Problem with stream");
        }
        return next();
    }

    public void update(ContactOfPerson contactOfPerson) {
        try {
            inout.seek(inout.getFilePointer() - SIZE_OF_STRUCTURE);
            writeData(contactOfPerson);
        } catch (IOException ex) {
            System.out.println("Problem with stream");
        }
    }
}
