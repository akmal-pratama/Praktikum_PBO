package model;

public interface PengelolaanDonasi {
    // Method untuk memproses donasi
    void prosesDonasi() throws Exception;
    
    // Method untuk validasi donasi
    boolean validasiDonasi() throws Exception;
    
    // Tambahkan method default jika diperlukan
    default void notifikasiDonasi() {
        System.out.println("Notifikasi donasi dikirim");
    }
} 