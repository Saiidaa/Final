package javaa.controller;

public class DivideByZeroException extends ArithmeticException {

    public DivideByZeroException() {
        super("Cannot divide by zero.");
    }

    public DivideByZeroException(String s) {
        super(s);
    }
}

