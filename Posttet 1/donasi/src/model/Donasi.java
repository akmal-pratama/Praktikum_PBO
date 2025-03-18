package model;

public class Donasi {
    private String namaDonatur;
    private double jumlahDonasi;
    private String metodePembayaran;

    public Donasi(String namaDonatur, double jumlahDonasi, String metodePembayaran) {
        this.namaDonatur = namaDonatur;
        this.jumlahDonasi = jumlahDonasi;
        this.metodePembayaran = metodePembayaran;
    }

    public void TampilkanData() {
        System.out.println("Nama Donatur: " + namaDonatur);
        System.out.println("Jumlah Donasi: Rp " + jumlahDonasi);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
    }
}
