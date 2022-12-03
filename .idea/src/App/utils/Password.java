package App.utils;

import java.io.IOException;

public class Password {
    private Password() throws IOException{}

    private static final int MIN_PASSWORD_LENGTH = 3;
    private static final int MAX_PASSWORD_LENGTH = 255;

    public static boolean confirmEnteredPasswordsSame(String initiallyEnteredPass, String secondlyEnteredPass){
        return secondlyEnteredPass.equals(initiallyEnteredPass);
    }

    public static boolean confirmEnteredPasswordsLength(String password){
        if (password.length() > MAX_PASSWORD_LENGTH && password.length() < MIN_PASSWORD_LENGTH)
            return false;
        else return true;
    }

}
