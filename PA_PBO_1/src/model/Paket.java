package model;

public class Paket {
    private static int idCounter = 1;
    private final int ID_Paket;
    private String nama;
    private String deskripsi;
    private double harga;

    public Paket(String nama, String deskripsi, double harga) {
        this.ID_Paket = idCounter++;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }

    public int getIDPaket() {
        return ID_Paket;
    }

    public String getNama() {
        return nama;
    }

    public String getDesk() {
        return deskripsi;
    }

    public double getHarga() {
        return harga;
    }
}