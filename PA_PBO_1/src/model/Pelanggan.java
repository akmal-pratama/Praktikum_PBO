package model;

import java.util.ArrayList;

public class Pelanggan extends User implements ReservasiInterface {
    private static int idCounter = 1;
    private final int ID_Pelanggan;
    private String noTelp;
    private ArrayList<Reservasi> reservasiList = new ArrayList<>();

    public Pelanggan(String username, String password, String noTelp) {
        super(username, password);
        this.noTelp = noTelp;
        this.ID_Pelanggan = idCounter++;
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void buatReservasi(Reservasi reservasi) {
        reservasiList.add(reservasi);
        System.out.println("Reservasi berhasil dibuat!");
    }

    @Override
    public void detailReservasi() {
        if (reservasiList.isEmpty()) {
            System.out.println("Belum ada reservasi.");
        } else {
            for (Reservasi r : reservasiList) {
                r.detailReservasi();
            }
        }
    }

    public int getIDPelanggan() {
        return ID_Pelanggan;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public ArrayList<Reservasi> getReservasiList() {
        return reservasiList;
    }
}