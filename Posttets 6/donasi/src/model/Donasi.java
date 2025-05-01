package model;

// Abstract Class
public abstract class Donasi {
    private String namaDonatur;
    private double jumlahDonasi;
    private String metodePembayaran;
    protected String waktuDonasi;
    String kategoriDonasi;
    public final boolean statusVerifikasi = false; // contoh final variable

    public Donasi(String namaDonatur, double jumlahDonasi, String metodePembayaran) {
        this.namaDonatur = namaDonatur;
        this.jumlahDonasi = jumlahDonasi;
        this.metodePembayaran = metodePembayaran;
        this.waktuDonasi = java.time.LocalDateTime.now().toString();
        this.kategoriDonasi = "Umum";
    }

    public String getNamaDonatur() { return namaDonatur; }
    public double getJumlahDonasi() { return jumlahDonasi; }
    public String getMetodePembayaran() { return metodePembayaran; }
    protected String getWaktuDonasi() { return waktuDonasi; }
    public String getKategoriDonasi() { return kategoriDonasi; }

    public void setNamaDonatur(String namaDonatur) { this.namaDonatur = namaDonatur; }

    public void setJumlahDonasi(double jumlahDonasi) {
        this.jumlahDonasi = jumlahDonasi;
    }

    public void setJumlahDonasi(String jumlah) {
        try {
            double jumlahParsed = Double.parseDouble(jumlah);
            if (jumlahParsed > 0) {
                this.jumlahDonasi = jumlahParsed;
            } else {
                System.out.println("Jumlah donasi harus lebih dari 0. Nilai tidak diubah.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Format jumlah donasi tidak valid. Nilai tidak diubah.");
        }
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public final void setKategoriDonasi(String kategoriDonasi) { // final method
        this.kategoriDonasi = kategoriDonasi;
    }

    public void TampilkanData() {
        System.out.println("Nama Donatur: " + namaDonatur);
        System.out.println("Jumlah Donasi: Rp " + jumlahDonasi);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("Waktu Donasi: " + waktuDonasi);
        System.out.println("Kategori: " + kategoriDonasi);
        System.out.println("Status Verifikasi: " + (statusVerifikasi ? "Terverifikasi" : "Belum Terverifikasi"));
        System.out.println("Jenis Donasi: " + getJenisDonasi()); // Menampilkan hasil abstract method
    }

    // Abstract method
    public abstract String getJenisDonasi();
}