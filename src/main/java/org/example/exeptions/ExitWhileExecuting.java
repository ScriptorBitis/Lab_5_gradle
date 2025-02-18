package org.example.exeptions;

public class ExitWhileExecuting extends RuntimeException {
    public ExitWhileExecuting(String message) {
    super(message);
  }

}
