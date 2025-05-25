package model;

import java.util.ArrayList;

public class ManajemenReservasi implements ManajemenReservasiInterface {
    private ArrayList<Reservasi> reservasiList;

    public ManajemenReservasi() {
        this.reservasiList = new ArrayList<>();
    }

    public int getJumlahReservasi() {
        return reservasiList.size();
    }

    public void tambahReservasi(Reservasi reservasi) {
        reservasiList.add(reservasi);
    }

    public void getAllReservasi() {

        if (reservasiList.isEmpty()) {
            System.out.println(util.GREEN + "====================================================");
            System.out.println(util.RED + "                TIDAK ADA RESERVASI!                ");
            System.out.println(util.GREEN + "====================================================");
        } else {
            System.out.println(util.BLUE
                    + "+---------+-----------------+----------------+------------------+-----------------+----------+----------------+");
            System.out.println(util.BLUE + "|" + util.GREEN + " ID      " + util.BLUE + "|" + util.GREEN
                    + " Barber          " + util.BLUE + "|" + util.GREEN + " Pelanggan      " + util.BLUE + "|"
                    + util.GREEN + " Waktu Mulai     " + util.BLUE + "|" + util.GREEN + " Paket          " + util.BLUE
                    + "|" + util.GREEN + " Harga    " + util.BLUE + "|" + util.GREEN + " Status         " + util.BLUE
                    + "|");
            System.out.println(util.BLUE
                    + "+---------+-----------------+----------------+------------------+-----------------+----------+----------------+");
            for (Reservasi r : reservasiList) {
                String namaBarber = (r.getBarber() != null) ? r.getBarber().username : "Belum dipilih";
                String statusReservasi = r.isStatus() ? "Pesanan Selesai" : "Belum Cukur";
                String namaPelanggan = (r.getPelanggan() != null) ? r.getPelanggan().getUsername() : "Tidak ada";
                System.out.printf(util.GREEN + "| %-7d | %-15s | %-14s | %-16s | %-15s | %-8d | %-14s |%n",
                        r.getIDReservasi(),
                        namaBarber,
                        namaPelanggan,
                        r.getWaktuMulai(),
                        r.getPaket().getNama(),
                        (int)r.getPaket().getHarga(),
                        statusReservasi);
            }
            System.out.println(util.BLUE
                    + "+---------+-----------------+----------------+------------------+-----------------+----------+----------------+");
        }
    }

    public void getReservasiByBarber(Barber barber) {
        System.out.println(util.BLUE
                + "+---------+----------------+------------------+-----------------+----------+----------------+");
        System.out.println(util.BLUE + "|" + util.GREEN + " ID      " + util.BLUE + "|" + util.GREEN
                + " Pelanggan      " + util.BLUE + "|" + util.GREEN + " Waktu Mulai     " + util.BLUE + "|" + util.GREEN
                + " Paket          " + util.BLUE + "|" + util.GREEN + " Harga    " + util.BLUE + "|" + util.GREEN
                + " Status         " + util.BLUE + "|");
        System.out.println(util.BLUE
                + "+---------+----------------+------------------+-----------------+----------+----------------+");
        System.out.println("Reservasi untuk Barber " + barber.getUsername() + ":");
        for (Reservasi r : reservasiList) {
            if (r.getBarber().equals(barber) && !r.isStatus()) {
                String statusReservasi = r.isStatus() ? "Pesanan Selesai" : "Belum Cukur";
                String namaPelanggan = (r.getPelanggan() != null) ? r.getPelanggan().getUsername() : "Tidak ada";
                System.out.printf(util.GREEN + "| %-7d | %-14s | %-16s | %-15s | %-8d | %-14s |%n",
                        r.getIDReservasi(),
                        namaPelanggan,
                        r.getWaktuMulai(),
                        r.getPaket().getNama(),
                        (int)r.getPaket().getHarga(),
                        statusReservasi);
            }
        }
        System.out.println(util.BLUE
                + "+---------+----------------+------------------+-----------------+----------+----------------+");
    }

    public void getReservasiByPelanggan(Pelanggan pelanggan) {
        System.out.println("Reservasi untuk Pelanggan " + pelanggan.getUsername() + ":");
        System.out.println(util.BLUE
                + "+---------+-----------------+------------------+-----------------+----------+----------------+");
        System.out.println(util.BLUE + "|" + util.GREEN + " ID      " + util.BLUE + "|" + util.GREEN
                + " Barber          " + util.BLUE + "|" + util.GREEN + " Waktu Mulai     " + util.BLUE + "|"
                + util.GREEN + " Paket          " + util.BLUE + "|" + util.GREEN + " Harga    " + util.BLUE + "|"
                + util.GREEN + "Status         " + util.BLUE + "|");
        System.out.println(util.BLUE
                + "+---------+-----------------+------------------+-----------------+----------+----------------+");
        for (Reservasi r : reservasiList) {
            if (r.getPelanggan().equals(pelanggan)) {
                String namaBarber = (r.getBarber() != null) ? r.getBarber().username : "Belum dipilih";
                String statusReservasi = r.isStatus() ? "Pesanan Selesai" : "Belum Cukur";
                System.out.printf(util.GREEN + "| %-7d | %-15s | %-16s | %-15s | %-8d | %-14s |%n",
                        r.getIDReservasi(),
                        namaBarber,
                        r.getWaktuMulai(),
                        r.getPaket().getNama(),
                        (int)r.getPaket().getHarga(),
                        statusReservasi);
            }
        }
        System.out.println(util.BLUE
                + "+---------+-----------------+------------------+-----------------+----------+----------------+");
    }

    public void selesaikanReservasiByBarber(Barber barber, int id) {
        for (Reservasi r : reservasiList) {
            if (r.getBarber().equals(barber) && r.getIDReservasi() == id) {
                r.setStatus(true);
                System.out.println("Reservasi ID " + id + " telah diselesaikan oleh Barber " + barber.getUsername());
                return;
            }
        }
        System.out.println("Reservasi tidak ditemukan atau tidak sesuai dengan Barber.");
    }
}