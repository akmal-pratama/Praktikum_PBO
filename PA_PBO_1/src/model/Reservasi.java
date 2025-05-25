package model;

import java.util.Date;

public class Reservasi implements ReservasiInterface {
    private static int idCounter = 1;
    private final int ID_Reservasi;
    private boolean status;
    private Date waktuMulai;
    private Barber barber;
    private Pelanggan pelanggan;
    private Paket paket;

    public Reservasi(Date waktuMulai, Barber barber, Pelanggan pelanggan, Paket paket) {
        this.ID_Reservasi = idCounter++;
        this.waktuMulai = waktuMulai;
        this.status = false; // Default status is false (waiting)
        this.barber = barber;
        this.pelanggan = pelanggan;
        this.paket = paket;
    }

    public int getIDReservasi() {
        return this.ID_Reservasi;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public Barber getBarber() {
        return barber;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public Date getWaktuMulai() {
        return waktuMulai;
    }

    public void setWaktuMulai(Date waktuMulai) {
        this.waktuMulai = waktuMulai;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Paket getPaket() {
        return paket;
    }

    public void setPaket(Paket paket) {
        this.paket = paket;
    }

    @Override
    public void detailReservasi() {
        String namaBarber = (barber != null) ? barber.getUsername() : "Belum dipilih";
        String statusReservasi = status ? "Pesanan Selesai" : "Belum Cukur";
        String namaPelanggan = (pelanggan != null) ? pelanggan.getUsername() : "Tidak ada";

        // Header
        System.out.printf("| %-12s | %-15s | %-20s | %-15s | %-15s | %-10s |\n",
                "ID", "Waktu", "Barber", "Pelanggan", "Status");
        System.out.println(
                "-----------------------------------------------------------------------------------------------");

        // Isi data
        System.out.printf("| %-12s | %-15s | %-20s | %-15s | %-15s | %-10s |\n",
                ID_Reservasi, waktuMulai, namaBarber, namaPelanggan, statusReservasi);
    }

}