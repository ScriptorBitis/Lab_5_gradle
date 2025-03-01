package org.example.utility.console;

import org.example.exeptions.InterraptЕxitException;

public interface Console {
    String getUserInputString(String message) throws InterraptЕxitException;

    int getUserInputInt(String message);

    Integer getUserInputIntMayBeNull(String message);

    double getUserInputDouble(String message);

    float getUserInputFloat(String message);
}
