package com.d9nich.exercise17;

import java.io.*;
import java.util.InputMismatchException;

public class BitOutputStream {
    private final static byte AMOUNT_OF_BITS = 8;
    private BufferedOutputStream outputStream;
    private int bits = 0;
    private byte freeBits = AMOUNT_OF_BITS;

    public BitOutputStream(File file) throws FileNotFoundException {
        outputStream = new BufferedOutputStream(new FileOutputStream(file));
    }

    public void writeBit(char bit) throws IOException {
        if (bit != '0' && bit != '1')
            throw new InputMismatchException();
        bits += (bit - '0') * Math.pow(2, AMOUNT_OF_BITS - freeBits);
        freeBits--;
        if (freeBits == 0) {
            outputStream.write(bits);
            freeBits = AMOUNT_OF_BITS;
            bits = 0;
        }
    }

    public void writeBit(String bit) throws IOException {
        for (int i = 0; i < bit.length(); i++)
            writeBit(bit.charAt(i));
    }

    public void close() throws IOException {
        outputStream.write(bits);
        outputStream.close();
    }
}
