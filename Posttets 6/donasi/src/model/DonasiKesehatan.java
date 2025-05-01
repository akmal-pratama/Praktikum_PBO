package model;

public class DonasiKesehatan extends Donasi implements PengelolaanDonasi {
    private String rumahSakitPenerima;
    private static int jumlahDonasiKesehatan = 0; // Variabel static untuk menghitung jumlah donasi kesehatan

    public DonasiKesehatan(String namaDonatur, double jumlahDonasi, String metodePembayaran, String rumahSakitPenerima) {
        super(namaDonatur, jumlahDonasi, metodePembayaran);
        this.kategoriDonasi = "Kesehatan";
        this.rumahSakitPenerima = rumahSakitPenerima;
        jumlahDonasiKesehatan++; // Menambah counter setiap kali objek baru dibuat
    }

    public String getRumahSakitPenerima() {
        return rumahSakitPenerima;
    }

    public void setRumahSakitPenerima(String rumahSakitPenerima) {
        this.rumahSakitPenerima = rumahSakitPenerima;
    }

    // Method static untuk mendapatkan jumlah donasi kesehatan
    public static int getJumlahDonasiKesehatan() {
        return jumlahDonasiKesehatan;
    }

    @Override
    public void TampilkanData() {
        super.TampilkanData();
        System.out.println("Rumah Sakit Penerima: " + rumahSakitPenerima);
    }

    @Override
    public String getJenisDonasi() {
        return "Donasi Kesehatan";
    }

    // Implementasi dari interface PengelolaanDonasi
    @Override
    public void prosesDonasi() throws Exception {
        if (getJumlahDonasi() <= 0) {
            throw new Exception("Jumlah donasi harus lebih dari 0");
        }
        if (rumahSakitPenerima == null || rumahSakitPenerima.trim().isEmpty()) {
            throw new Exception("Rumah sakit penerima harus diisi");
        }
        // Proses donasi berhasil
        System.out.println("Donasi kesehatan sedang diproses untuk " + getRumahSakitPenerima());
    }

    @Override
    public boolean validasiDonasi() throws Exception {
        if (getJumlahDonasi() < 10000) {
            throw new Exception("Minimal donasi kesehatan adalah Rp 10.000");
        }
        return true;
    }
}