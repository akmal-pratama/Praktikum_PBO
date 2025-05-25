package model;

public class Admin extends User {
    private static int idCounter = 1;
    private final int ID_Admin;

    public Admin(String username, String password) {
        super(username, password);
        this.ID_Admin = idCounter++;
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public int getIDAdmin() {
        return ID_Admin;
    }
}