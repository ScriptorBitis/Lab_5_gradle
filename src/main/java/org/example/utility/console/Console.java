package org.example.utility.console;

import org.example.exeptions.InterraptExitException;

public interface Console {
    String getUserInputString(String message) throws InterraptExitException;

    int getUserInputInt(String message);

    Integer getUserInputIntMayBeNull(String message);

    double getUserInputDouble(String message);

    float getUserInputFloat(String message);
}
