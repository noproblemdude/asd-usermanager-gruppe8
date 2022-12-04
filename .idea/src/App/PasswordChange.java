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

    public void changePassword(Account account){
        System.out.println("Please enter your old password");
        String oldpasswordHashed = RegistrationManager.PasswordHasher(RegistrationManager.TerminalReader());
        if (oldpasswordHashed.equals(account.getPasswort())){
            System.out.println("Please enter your new password");
            initiallyEnteredPass = RegistrationManager.TerminalReader();
            System.out.println("Please re-enter your new password");
            secondlyEnteredPass = RegistrationManager.TerminalReader();
            if (confirmEnteredPasswordsSame(initiallyEnteredPass,secondlyEnteredPass)){
                account.setPasswort(RegistrationManager.PasswordHasher(secondlyEnteredPass));
                JsonLoader.SaveJson(account);
                System.out.println("Password has been changed succesfully");
        }}

    }
}
