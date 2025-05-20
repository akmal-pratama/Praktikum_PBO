package model;

public class Barber extends User {
    private static int idCounter = 1;
    private final int ID_Barber;
    private boolean status;

    public Barber(String username, String password) {
        super(username, password);
        this.ID_Barber = idCounter++;
        this.status = false;
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void updateStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public int getIDBarber() {
        return ID_Barber;
    }
}
