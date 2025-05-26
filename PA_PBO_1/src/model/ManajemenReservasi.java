package model;

import java.util.ArrayList;
import java.util.Date;

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

    public Boolean isReservasiTaken(Barber barber, Date waktuMulai) {
        for (Reservasi r : reservasiList) {
            if (r.getBarber().equals(barber) && r.getWaktuMulai().equals(waktuMulai)) {
                return true; // Reservasi sudah ada
            }
        }
        return false; // Reservasi belum ada
    }

    public void getAllReservasi() {

        if (reservasiList.isEmpty()) {
            System.out.println(util.GREEN + "====================================================");
            System.out.println(util.RED + "                TIDAK ADA RESERVASI!                ");
            System.out.println(util.GREEN + "====================================================");
        } else {
            System.out.println(util.BLUE
                    + "+---------+-----------------+----------------+----------------------------------+-----------------+----------+----------------+");
            System.out.printf(
                    util.BLUE + "|" + util.GREEN + " %-7s " + util.BLUE + "|" + util.GREEN + " %-15s " + util.BLUE + "|"
                            + util.GREEN + " %-14s " + util.BLUE + "|" + util.GREEN + " %-32s " + util.BLUE + "|"
                            + util.GREEN + " %-15s " + util.BLUE + "|" + util.GREEN + " %-8s " + util.BLUE + "|"
                            + util.GREEN + " %-14s " + util.BLUE + "|%n",
                    "ID", "Barber", "Pelanggan", "Waktu Mulai", "Paket", "Harga", "Status");
            System.out.println(util.BLUE
                    + "+---------+-----------------+----------------+----------------------------------+-----------------+----------+----------------+");
            for (Reservasi r : reservasiList) {
                String namaBarber = (r.getBarber() != null) ? r.getBarber().username : "Belum dipilih";
                String statusReservasi = r.isStatus() ? "Pesanan Selesai" : "Belum Cukur";
                String namaPelanggan = (r.getPelanggan() != null) ? r.getPelanggan().getUsername() : "Tidak ada";
                System.out.printf(
                        util.BLUE + "|" + util.GREEN + " %-7d " + util.BLUE + "|" + util.GREEN + " %-15s " + util.BLUE
                                + "|" + util.GREEN + " %-14s " + util.BLUE + "|" + util.GREEN + " %-32s " + util.BLUE
                                + "|" + util.GREEN + " %-15s " + util.BLUE + "|" + util.GREEN + " %-8d " + util.BLUE
                                + "|" + util.GREEN + " %-14s " + util.BLUE + "|%n",
                        r.getIDReservasi(),
                        namaBarber,
                        namaPelanggan,
                        r.getWaktuMulai(),
                        r.getPaket().getNama(),
                        (int) r.getPaket().getHarga(),
                        statusReservasi);
            }
            System.out.println(util.BLUE
                    + "+---------+-----------------+----------------+----------------------------------+-----------------+----------+----------------+");
        }
    }

    public void getReservasiByBarber(Barber barber) {
        System.out.println(util.BLUE
                + "+---------+----------------+----------------------------------+-----------------+----------+----------------+");
        System.out.printf(
                util.BLUE + "|" + util.GREEN + " %-7s " + util.BLUE + "|"
                        + util.GREEN + " %-14s " + util.BLUE + "|" + util.GREEN + " %-32s " + util.BLUE + "|"
                        + util.GREEN + " %-15s " + util.BLUE + "|" + util.GREEN + " %-8s " + util.BLUE + "|"
                        + util.GREEN + " %-14s " + util.BLUE + "|%n",
                "ID", "Pelanggan", "Waktu Mulai", "Paket", "Harga", "Status");
        System.out.println(util.BLUE
                + "+---------+----------------+----------------------------------+-----------------+----------+----------------+");
        for (Reservasi r : reservasiList) {
            if (r.getBarber().equals(barber) && !r.isStatus()) {
                String statusReservasi = r.isStatus() ? "Pesanan Selesai" : "Belum Cukur";
                String namaPelanggan = (r.getPelanggan() != null) ? r.getPelanggan().getUsername() : "Tidak ada";
                System.out.printf(
                        util.BLUE + "|" + util.GREEN + " %-7d " + util.BLUE + "|"
                                + util.GREEN + " %-14s " + util.BLUE + "|" + util.GREEN + " %-32s " + util.BLUE
                                + "|" + util.GREEN + " %-15s " + util.BLUE + "|" + util.GREEN + " %-8d " + util.BLUE
                                + "|" + util.GREEN + " %-14s " + util.BLUE + "|%n",
                        r.getIDReservasi(),
                        namaPelanggan,
                        r.getWaktuMulai(),
                        r.getPaket().getNama(),
                        (int) r.getPaket().getHarga(),
                        statusReservasi);
            }
        }
        System.out.println(util.BLUE
                + "+---------+-----------------+----------------+----------------------------------+-----------------+----------+----------------+");
    }

    public void getReservasiByPelanggan(Pelanggan pelanggan) {
        System.out.println(util.BLUE
                + "+---------+-----------------+----------------------------------+-----------------+----------+----------------+");
        System.out.println(util.BLUE + "|" + util.GREEN + " ID      " + util.BLUE + "|" + util.GREEN
                + " Barber          " + util.BLUE + "|" + util.GREEN + " Waktu Mulai                      " + util.BLUE
                + "|"
                + util.GREEN + " Paket           " + util.BLUE + "|" + util.GREEN + " Harga    " + util.BLUE + "|"
                + util.GREEN + " Status         " + util.BLUE + "|");
        System.out.println(util.BLUE
                + "+---------+-----------------+----------------------------------+-----------------+----------+----------------+");
        for (Reservasi r : reservasiList) {
            if (r.getPelanggan().equals(pelanggan)) {
                String namaBarber = (r.getBarber() != null) ? r.getBarber().username : "Belum dipilih";
                String statusReservasi = r.isStatus() ? "Pesanan Selesai" : "Belum Cukur";
                System.out.printf(
                        util.GREEN + "| %-7d " + util.BLUE + "|" + util.GREEN + " %-15s " + util.BLUE + "|" + util.GREEN
                                + " %-16s " + util.BLUE + "   |" + util.GREEN + " %-15s " + util.BLUE + "|" + util.GREEN
                                + " %-8d " + util.BLUE + "|" + util.GREEN + " %-14s " + util.BLUE + "|%n",
                        r.getIDReservasi(),
                        namaBarber,
                        r.getWaktuMulai(),
                        r.getPaket().getNama(),
                        (int) r.getPaket().getHarga(),
                        statusReservasi);
            }
        }
        System.out.println(util.BLUE
                + "+---------+-----------------+----------------------------------+-----------------+----------+----------------+");
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