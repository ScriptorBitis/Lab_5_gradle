package org.example.exeptions;

public class WrongInput extends RuntimeException {
    public WrongInput(String message) {
        super(message);
    }
}
