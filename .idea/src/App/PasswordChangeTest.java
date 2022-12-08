package App;

import static org.junit.jupiter.api.Assertions.*;

class PasswordChangeTest {  //generating test resulted in creating test cases for each individual method in the class. Lecturer said we should test the smallest components (unit testing). See passwordHasher test in RegistrationManagerTest.java

    @org.junit.jupiter.api.Test //polarity: negative
    void confirmEnteredPasswordsSame() {
        String initiallyEnteredPassword = "1234";
        String secondlyEnteredPassword = "12345";
        boolean expected = false;
        assertEquals(expected,PasswordChange.confirmEnteredPasswordsSame(initiallyEnteredPassword,secondlyEnteredPassword));
    }
    @org.junit.jupiter.api.Test
    void confirmEnteredPasswordsSame2() { //Test polarity: positive
        String initiallyEnteredPassword = "1234";
        String secondlyEnteredPassword = "1234";
        boolean expected = true;
        assertEquals(expected,PasswordChange.confirmEnteredPasswordsSame(initiallyEnteredPassword,secondlyEnteredPassword));
    }

    @org.junit.jupiter.api.Test
    void confirmEnteredPasswordsSame3() { //polarity: positive (expected should be true)
        String initiallyEnteredPassword = "12345";
        String secondlyEnteredPassword = "12345";
        boolean expected = true;
        assertEquals(expected,PasswordChange.confirmEnteredPasswordsSame(initiallyEnteredPassword,secondlyEnteredPassword));
    }

    @org.junit.jupiter.api.Test
    void confirmEnteredPasswordsSame4() { //polarity: negative (the expected should be false)
        String initiallyEnteredPassword = "12345";
        String secondlyEnteredPassword = "1234";
        boolean expected = false;
        assertEquals(expected,PasswordChange.confirmEnteredPasswordsSame(initiallyEnteredPassword,secondlyEnteredPassword));
    }

    @org.junit.jupiter.api.Test
    void changePassword() { //we can try changing the password for a user and then try to login with the old pass. however this cannot be automatized with our system for now :/ (manual testing)
    }

    //TODO add more scenarios for the confirm function, for ex: null pass, int pass, characters...
}

