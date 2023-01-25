package src.main.resources.Service;

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

    public static void changePassword(Account account){
        System.out.println("Bitte geben Sie Ihr altes Passwort ein");
        String oldpasswordHashed = RegistrationManager.PasswordHasher(RegistrationManager.TerminalReader());
        if (oldpasswordHashed.equals(account.getPassword())){
            System.out.println("Bitte geben Sie Ihr neues Passwort ein");
            String pass1 = RegistrationManager.TerminalReader();
            System.out.println("Bitte geben Sie Ihr neues Passwort erneut ein");
            String pass2 = RegistrationManager.TerminalReader();
            if (confirmEnteredPasswordsSame(pass1,pass2)){
                account.setPassword(RegistrationManager.PasswordHasher(pass2));
                JsonLoader.SaveJson(account);
                System.out.println("Passwort wurde erfolgreich geändert");
            }
        }

    }
}
