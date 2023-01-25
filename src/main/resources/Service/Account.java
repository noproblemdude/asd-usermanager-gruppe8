package src.main.resources.Service;

public class Account {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private int numberOfFailedLogins = 0;
    private String dateTimeWhenUserWasLocked;
    private String dateTimeTillUserWasLocked;
    private boolean isLocked = false;

    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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
