package model;

// Parent Class
public class Donasi {
    private String namaDonatur;
    private double jumlahDonasi;
    private String metodePembayaran;
    protected String waktuDonasi;
    String kategoriDonasi;
    public boolean statusVerifikasi;

    public Donasi(String namaDonatur, double jumlahDonasi, String metodePembayaran) {
        this.namaDonatur = namaDonatur;
        this.jumlahDonasi = jumlahDonasi;
        this.metodePembayaran = metodePembayaran;
        this.waktuDonasi = java.time.LocalDateTime.now().toString();
        this.kategoriDonasi = "Umum";
        this.statusVerifikasi = false;
    }

    public String getNamaDonatur() { return namaDonatur; }
    public double getJumlahDonasi() { return jumlahDonasi; }
    public String getMetodePembayaran() { return metodePembayaran; }
    protected String getWaktuDonasi() { return waktuDonasi; }
    public String getKategoriDonasi() { return kategoriDonasi; }

    public void setNamaDonatur(String namaDonatur) { this.namaDonatur = namaDonatur; }

    // Method asli
    public void setJumlahDonasi(double jumlahDonasi) {
        this.jumlahDonasi = jumlahDonasi;
    }

    // 🔁 Method Overloading
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

    public void setMetodePembayaran(String metodePembayaran) { this.metodePembayaran = metodePembayaran; }
    public void setKategoriDonasi(String kategoriDonasi) { this.kategoriDonasi = kategoriDonasi; }

    public void TampilkanData() {
        System.out.println("Nama Donatur: " + namaDonatur);
        System.out.println("Jumlah Donasi: Rp " + jumlahDonasi);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("Waktu Donasi: " + waktuDonasi);
        System.out.println("Kategori: " + kategoriDonasi);
        System.out.println("Status Verifikasi: " + (statusVerifikasi ? "Terverifikasi" : "Belum Terverifikasi"));
    }
}

// Subclass Donasi Pendidikan
class DonasiPendidikan extends Donasi {
    private String institusiPenerima;

    public DonasiPendidikan(String namaDonatur, double jumlahDonasi, String metodePembayaran, String institusiPenerima) {
        super(namaDonatur, jumlahDonasi, metodePembayaran);
        this.kategoriDonasi = "Pendidikan";
        this.institusiPenerima = institusiPenerima;
    }

    public String getInstitusiPenerima() { return institusiPenerima; }
    public void setInstitusiPenerima(String institusiPenerima) { this.institusiPenerima = institusiPenerima; }

    @Override
    public void TampilkanData() {
        super.TampilkanData();
        System.out.println("Institusi Penerima: " + institusiPenerima);
    }
}

// Subclass Donasi Kesehatan
class DonasiKesehatan extends Donasi {
    private String rumahSakitPenerima;

    public DonasiKesehatan(String namaDonatur, double jumlahDonasi, String metodePembayaran, String rumahSakitPenerima) {
        super(namaDonatur, jumlahDonasi, metodePembayaran);
        this.kategoriDonasi = "Kesehatan";
        this.rumahSakitPenerima = rumahSakitPenerima;
    }

    public String getRumahSakitPenerima() { return rumahSakitPenerima; }
    public void setRumahSakitPenerima(String rumahSakitPenerima) { this.rumahSakitPenerima = rumahSakitPenerima; }

    @Override
    public void TampilkanData() {
        super.TampilkanData();
        System.out.println("Rumah Sakit Penerima: " + rumahSakitPenerima);
    }
}