package App;

import com.sun.tools.javac.Main;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Account {
    private String Vorname;
    private String Nachname;
    private String Benutzername;
    private String Passwort;
    private int numberOfFailedLogins = 0;
    private String dateTimeWhenUserWasLocked;
    private String dateTimeTillUserWasLocked;
    private boolean isLocked = false;

    public String getVorname(){
        return Vorname;
    }

    public String getNachname(){
        return Nachname;
    }

    public String getBenutzername(){
        return Benutzername;
    }

    public String getPasswort(){
        return Passwort;
    }

    public int getNumberOfFailedLogins() {
        return numberOfFailedLogins;
    }

    public String getDateTimeWhenUserWasLocked() {
        return dateTimeWhenUserWasLocked;
    }

    public String getDateTimeTillUserWasLocked() {
        return dateTimeTillUserWasLocked;
    }

    public boolean getIsLocked() {
        return isLocked;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public void setBenutzername(String benutzername) {
        Benutzername = benutzername;
    }

    public void setPasswort(String passwort) {
        Passwort = passwort;
    }

    public void setNumberOfFailedLogins(int numberOfFailedLogins) {
        this.numberOfFailedLogins = numberOfFailedLogins;
    }

    public void setDateTimeWhenUserWasLocked(String dateTimeWhenUserWasLocked) {
        this.dateTimeWhenUserWasLocked = dateTimeWhenUserWasLocked;
    }

    public void setDateTimeTillUserWasLocked(String dateTimeTillUserWasLocked) {
        this.dateTimeTillUserWasLocked = dateTimeTillUserWasLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

}
