package App;

import App.JsonLoader;
import App.RegistrationManager;

public class PasswordChange {
    private String initiallyEnteredPass;
    private String secondlyEnteredPass;

    public String getInitiallyEnteredPass() {
        return initiallyEnteredPass;
    }

    public void setInitiallyEnteredPass(String initiallyEnteredPass) {
        this.initiallyEnteredPass = initiallyEnteredPass;
    }

    public String getSecondlyEnteredPass() {
        return secondlyEnteredPass;
    }

    public void setSecondlyEnteredPass(String secondlyEnteredPass) {
        this.secondlyEnteredPass = secondlyEnteredPass;
    }

    public static boolean confirmEnteredPasswordsSame(String initiallyEnteredPass, String secondlyEnteredPass){
        return secondlyEnteredPass.equals(initiallyEnteredPass);
    }

    public void static changePassword(Account account){
        System.out.println("Please enter your old password");
        String oldpasswordHashed = RegistrationManager.PasswordHasher(RegistrationManager.TerminalReader());
        if (oldpasswordHashed.equals(account.getPasswort())){
            System.out.println("Please enter your new password");
            String pass1 = RegistrationManager.TerminalReader();
            System.out.println("Please re-enter your new password");
            String pass2 = RegistrationManager.TerminalReader();
            if (confirmEnteredPasswordsSame(pass1,pass2)){
                account.setPasswort(RegistrationManager.PasswordHasher(pass2));
                JsonLoader.SaveJson(account);
                System.out.println("Password has been changed succesfully");
        }}

    }
}
