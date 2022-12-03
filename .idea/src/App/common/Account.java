package App.common;

import com.sun.tools.javac.Main;

public class Account {
    private String Vorname;
    private String Nachname;
    private String Benutzername;
    private String Passwort;

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

}
