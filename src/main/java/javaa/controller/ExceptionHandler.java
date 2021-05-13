package javaa.controller;

public @interface ExceptionHandler {
    Class<DivideByZeroException> value();
}
