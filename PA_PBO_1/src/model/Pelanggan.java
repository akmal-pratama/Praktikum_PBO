package model;

public class Pelanggan extends User {
    private static int idCounter = 1;
    private final int ID_Pelanggan;
    private String noTelp;

    public Pelanggan(String username, String password, String noTelp) {
        super(username, password);
        this.noTelp = noTelp;
        this.ID_Pelanggan = idCounter++;
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public int getIDPelanggan() {
        return ID_Pelanggan;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
}