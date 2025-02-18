package utility.console;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.util.Scanner;

public class StandartConsole implements Console{

    @Override
    public void print(Object obj) {

    }

    @Override
    public void println(Object obj) {

    }

    @Override
    public String readln() {
        return "";
    }

    @Override
    public boolean isCanReadln() {
        return false;
    }

    @Override
    public void printError(Object obj) {

    }

    @Override
    public void printTable(Object obj1, Object obj2) {

    }

    @Override
    public void prompt() {

    }

    @Override
    public String getPrompt() {
        return "";
    }

    @Override
    public void selectFileScanner(Scanner obj) {

    }

    @Override
    public void selectConsoleScanner() {

    }
}
