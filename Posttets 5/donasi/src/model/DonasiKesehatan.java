package model;

public class DonasiKesehatan extends Donasi {
    private String rumahSakitPenerima;

    public DonasiKesehatan(String namaDonatur, double jumlahDonasi, String metodePembayaran, String rumahSakitPenerima) {
        super(namaDonatur, jumlahDonasi, metodePembayaran);
        this.kategoriDonasi = "Kesehatan";
        this.rumahSakitPenerima = rumahSakitPenerima;
    }

    public String getRumahSakitPenerima() {
        return rumahSakitPenerima;
    }

    public void setRumahSakitPenerima(String rumahSakitPenerima) {
        this.rumahSakitPenerima = rumahSakitPenerima;
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
}