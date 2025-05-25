package model;

public class Cabang {
    private static int idCounter = 1;
    private final int ID_Cabang;
    private String nama;
    private String alamat;

    public Cabang(String nama, String alamat) {
        this.ID_Cabang = idCounter++;
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }
    public int getID() { return ID_Cabang; }

    public void setNama(String nama) { this.nama = nama; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
}