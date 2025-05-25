package model;

import java.util.List;

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

    public void setNamaBarber (String namaBaru) {
        this.username = namaBaru;
    }

    public boolean getStatus() {
        return status;
    }

    public int getIDBarber() {
        return ID_Barber;
    }

    public static void TampilBarber(List<Barber> barberList) {
        System.out.println(util.BLUE + "--------------------------------------");
        System.out.printf(util.BLUE + "| " + util.GREEN + "%-3s" + util.BLUE + " | " + util.GREEN + "%-10s" + util.BLUE + " | " + util.GREEN + "%-15s" + util.BLUE + " |\n",
        "No", "ID", "Username");
        System.out.println(util.BLUE + "--------------------------------------");

        // Isi tabel
        int no = 1;
        for (Barber b : barberList) {
            System.out.printf(util.BLUE + "| " + util.GREEN + "%-3d" + util.BLUE + " | " + util.GREEN + "%-10s" + util.BLUE + " | " + util.GREEN + "%-15s" + util.BLUE + " |\n",
                            no++, b.getIDBarber(), b.getUsername());
        }
    }
}