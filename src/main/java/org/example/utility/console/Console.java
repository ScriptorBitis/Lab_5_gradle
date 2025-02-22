package org.example.utility.console;

import org.example.exeptions.ЕmergencyЕxitException;

public interface Console {
    String getUserInputString(String message) throws ЕmergencyЕxitException;

    int getUserInputInt(String message);

    Integer getUserInputIntMayBeNull(String message);

    double getUserInputDouble (String message);

    float getUserInputFloat (String message);
}
