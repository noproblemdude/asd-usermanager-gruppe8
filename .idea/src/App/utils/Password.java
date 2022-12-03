package App.utils;

import java.io.IOException;

import netscape.javascript.JSObject;
import org.mindrot.jbcrypt.BCrypt;

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

    public static String encryptPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassWithHash(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }

    //TODO check old password in DB if it is correct or not
    public static boolean checkIfOldPassCorrect(String password){return JSObject.class.contains(password)//try to reach DB here
    }


}
