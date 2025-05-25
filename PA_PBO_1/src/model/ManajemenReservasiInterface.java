package model;

public interface ManajemenReservasiInterface {
    int getJumlahReservasi();
    void tambahReservasi(Reservasi reservasi);
    void getAllReservasi();
    void getReservasiByBarber(Barber barber);
    void getReservasiByPelanggan(Pelanggan pelanggan);
    void selesaikanReservasiByBarber(Barber barber, int id);
}