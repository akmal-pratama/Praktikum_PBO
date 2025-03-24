package model;

public class Donasi {
    // Private access modifier - only accessible within this class
    private String namaDonatur;
    private double jumlahDonasi;
    private String metodePembayaran;
    
    // Protected access modifier - accessible within package and subclasses
    protected String waktuDonasi;
    
    // Default access modifier (no modifier) - accessible within package only
    String kategoriDonasi;
    
    // Public access modifier - accessible from anywhere
    public boolean statusVerifikasi;
    
    // Constructor
    public Donasi(String namaDonatur, double jumlahDonasi, String metodePembayaran) {
        this.namaDonatur = namaDonatur;
        this.jumlahDonasi = jumlahDonasi;
        this.metodePembayaran = metodePembayaran;
        this.waktuDonasi = java.time.LocalDateTime.now().toString();
        this.kategoriDonasi = "Umum";
        this.statusVerifikasi = false;
    }
    
    // Getter methods
    public String getNamaDonatur() {
        return namaDonatur;
    }
    
    public double getJumlahDonasi() {
        return jumlahDonasi;
    }
    
    public String getMetodePembayaran() {
        return metodePembayaran;
    }
    
    protected String getWaktuDonasi() {
        return waktuDonasi;
    }
    
    public String getKategoriDonasi() {
        return kategoriDonasi;
    }
    
    // Setter methods
    public void setNamaDonatur(String namaDonatur) {
        this.namaDonatur = namaDonatur;
    }
    
    public void setJumlahDonasi(double jumlahDonasi) {
        if (jumlahDonasi > 0) {
            this.jumlahDonasi = jumlahDonasi;
        } else {
            System.out.println("Jumlah donasi harus lebih dari 0!");
        }
    }
    
    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }
    
    protected void setWaktuDonasi(String waktuDonasi) {
        this.waktuDonasi = waktuDonasi;
    }
    
    public void setKategoriDonasi(String kategoriDonasi) {
        this.kategoriDonasi = kategoriDonasi;
    }
    
    // Method to display donation data
    public void TampilkanData() {
        System.out.println("Nama Donatur: " + namaDonatur);
        System.out.println("Jumlah Donasi: Rp " + jumlahDonasi);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("Waktu Donasi: " + waktuDonasi);
        System.out.println("Kategori: " + kategoriDonasi);
        System.out.println("Status Verifikasi: " + (statusVerifikasi ? "Terverifikasi" : "Belum Terverifikasi"));
    }
}