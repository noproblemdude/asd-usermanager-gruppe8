package App;

public class Account {
    private String Vorname;
    private String Nachname;
    private String Benutzername;
    private Integer Passwort;

    public void main(String Vorname,String Nachname,String Benutzername,Integer Passwort){
        this.Vorname=Vorname;
        this.Nachname=Nachname;
        this.Benutzername=Benutzername;
        this.Passwort=Passwort;
    }

    public String getVorname(){
        return Vorname;
    }

    public String getNachname(){
        return Nachname;
    }

    public String getBenutzername(){
        return Benutzername;
    }

    public Integer getPasswort(){
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

    public void setPasswort(Integer passwort) {
        Passwort = passwort;
    }

}
