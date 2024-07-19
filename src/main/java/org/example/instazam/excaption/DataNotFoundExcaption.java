package org.example.instazam.excaption;

public class DataNotFoundExcaption extends RuntimeException{
    public DataNotFoundExcaption(String message) {
        super(message);
    }
}
