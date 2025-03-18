import model.Donasi;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Donasi> dataDonasi = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int pilihan;
        while (true) {
            try {
                System.out.println("=== Sistem Pengelolaan Donasi Online ===");
                System.out.println("1. Tambah Donasi");
                System.out.println("2. Tampilkan Semua Donasi");
                System.out.println("3. Update Donasi");
                System.out.println("4. Hapus Donasi");
                System.out.println("5. Keluar");
                System.out.print("Pilih Menu: ");
                if (!input.hasNextInt()) {
                    throw new Exception("Inputan Harus Angka");
                }
                pilihan = input.nextInt();
                input.nextLine(); 
                switch (pilihan) {
                    case 1:
                        TambahDonasi(dataDonasi, input);
                        break;
                    case 2:
                        TampilkanDonasi(dataDonasi);
                        break;
                    case 3:
                        UpdateDonasi(dataDonasi, input);
                        break;
                    case 4:
                        HapusDonasi(dataDonasi, input);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan: " + e.getMessage());
                input.nextLine();
            }
        }
    }

    public static void TampilkanDonasi(ArrayList<Donasi> dataDonasi) {
        System.out.println("\n=== Data Donasi ===");
        if (dataDonasi.isEmpty()) {
            System.out.println("Belum ada donasi yang tercatat.");
            return;
        }
        for (int i = 0; i < dataDonasi.size(); i++) {
            System.out.println("Donasi Ke-" + (i + 1));
            dataDonasi.get(i).TampilkanData();
            System.out.println("=====================================");
        }
    }

    public static void TambahDonasi(ArrayList<Donasi> dataDonasi, Scanner input) {
        try {
            System.out.println("\n=== Tambah Donasi ===");
            System.out.print("Nama Donatur: ");
            String namaDonatur = input.nextLine();
            
            double jumlahDonasi;
            while (true) {
                System.out.print("Jumlah Donasi (Rp): ");
                if (input.hasNextDouble()) {
                    jumlahDonasi = input.nextDouble();
                    if (jumlahDonasi <= 0) {
                        System.out.println("Jumlah donasi harus lebih dari 0!");
                        input.nextLine();
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Input harus berupa angka!");
                    input.nextLine();
                }
            }
            
            input.nextLine(); // Consume newline
            System.out.print("Metode Pembayaran: ");
            String metodePembayaran = input.nextLine();
            
            Donasi donasi = new Donasi(namaDonatur, jumlahDonasi, metodePembayaran);
            dataDonasi.add(donasi);
            System.out.println("Donasi Berhasil Ditambahkan");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menambahkan donasi: " + e.getMessage());
        }
    }

    public static void UpdateDonasi(ArrayList<Donasi> dataDonasi, Scanner input) {
        try {
            System.out.println("\n=== Update Donasi ===");
            System.out.print("Masukkan Nomor Donasi: ");
            if (!input.hasNextInt()) {
                System.out.println("Input harus berupa angka.");
                input.next();
                return;
            }
            int nomor = input.nextInt();
            input.nextLine();
            if (nomor < 1 || nomor > dataDonasi.size()) {
                System.out.println("Data Tidak Ditemukan.");
            } else {
                System.out.print("Nama Donatur: ");
                String namaDonatur = input.nextLine();
                System.out.print("Jumlah Donasi (Rp): ");
                double jumlahDonasi = input.nextDouble();
                input.nextLine(); // Consume newline
                System.out.print("Metode Pembayaran: ");
                String metodePembayaran = input.nextLine();
                
                Donasi donasi = new Donasi(namaDonatur, jumlahDonasi, metodePembayaran);
                dataDonasi.set(nomor - 1, donasi);
                System.out.println("Donasi Berhasil Diupdate");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat mengupdate donasi: " + e.getMessage());
        }
    }

    public static void HapusDonasi(ArrayList<Donasi> dataDonasi, Scanner input) {
        try {
            System.out.println("\n=== Hapus Donasi ===");
            System.out.print("Masukkan Nomor Donasi: ");
            if (!input.hasNextInt()) {
                System.out.println("Input harus berupa angka.");
                input.next();
                return;
            }
            int nomor = input.nextInt();
            input.nextLine();
            if (nomor < 1 || nomor > dataDonasi.size()) {
                System.out.println("Data Tidak Ditemukan.");
            } else {
                dataDonasi.remove(nomor - 1);
                System.out.println("Donasi Berhasil Dihapus");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menghapus donasi: " + e.getMessage());
        }
    }
}
