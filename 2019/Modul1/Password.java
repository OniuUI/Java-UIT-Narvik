package Modul1;

public class Password {

    public boolean checkPassword(String password) {
        if (checkPasswordLength(password) && checkPasswordForAlphanumerics(password) && checkPasswordForDigitCount(password)) {
            return true;
        }
        return false;
    }

    public boolean checkPasswordLength(String password) {

        return password.length() >= 10;
    }

    public boolean checkPasswordForAlphanumerics(String password) {
        if (password.matches("^[a-zA-Z0-9]*$")) {
            return true;
        }
        return false;
    }

    public boolean checkPasswordForDigitCount(String password) {
        if (password.matches("(?:\\D*\\d){3,}.*")) {
            return true;
        }
        return false;
    }
}
