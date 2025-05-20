import model.*;
import java.util.*;
import java.text.SimpleDateFormat;

// import javax.swing.text.Utilities;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Pelanggan> pelangganList = new ArrayList<>();
    static ArrayList<Barber> barberList = new ArrayList<>();
    static ArrayList<Admin> adminList = new ArrayList<>();
    static ArrayList<Cabang> cabangList = new ArrayList<>();
    static {
        // Data default pelanggan, admin
        pelangganList.add(new Pelanggan("akmal", "123", "0812345678"));
        adminList.add(new Admin("admin", "admin"));

        // Data default barber (3 data)
        barberList.add(new Barber("barber", "barber"));
        barberList.add(new Barber("barber2", "barber2"));
        barberList.add(new Barber("barber3", "barber3"));

        // Data default cabang (3 data)
        cabangList.add(new Cabang("Cabang A", "Jl. Mawar No.1"));
        cabangList.add(new Cabang("Cabang B", "Jl. Melati No.2"));
        cabangList.add(new Cabang("Cabang C", "Jl. Kenanga No.3"));
    }

    public static void main(String[] args) {
        while (true) {
            util.clearConsole();
            System.out.println(util.BLUE + "\n====================" + util.GREEN + " MENU UTAMA " + util.BLUE + "====================" + util.GREEN);
            System.out.println("   [1] Login");
            System.out.println("   [2] Register");
            System.out.println(  "   [3] Keluar" + util.BLUE);
            System.out.println("====================================================" + util.GREEN);
            System.out.print("Pilih menu : " + util.YELLOW);
            int pilih = 0;
            try {
                pilih = sc.nextInt(); sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(util .RED + "====================================================");
                System.out.println(          "            INPUT HARUS BERUPA ANGKA!               ");
                System.out.println(          "====================================================");
                util.delay(2000);
                util.clearConsole();
                sc.nextLine(); // clear buffer
                continue;
            }

            switch (pilih) {
                case 1: loginMenu(); break;
                case 2: registerMenu(); break;
                case 3:
                    util.clearConsole();
                    System.out.println(util.GREEN + """
                            ████████╗███████╗██████╗ ██╗███╗   ███╗ █████╗ ██╗  ██╗ █████╗ ███████╗██╗██╗  ██╗
                            ╚══██╔══╝██╔════╝██╔══██╗██║████╗ ████║██╔══██╗██║ ██╔╝██╔══██╗██╔════╝██║██║  ██║
                               ██║   █████╗  ██████╔╝██║██╔████╔██║███████║█████╔╝ ███████║███████╗██║███████║
                               ██║   ██╔══╝  ██╔══██╗██║██║╚██╔╝██║██╔══██║██╔═██╗ ██╔══██║╚════██║██║██╔══██║
                               ██║   ███████╗██║  ██║██║██║ ╚═╝ ██║██║  ██║██║  ██╗██║  ██║███████║██║██║  ██║
                               ╚═╝   ╚══════╝╚═╝  ╚═╝╚═╝╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝╚═╝  ╚═╝
                            """);
                    return;
                default:
                    System.out.println(util.RED + "====================================================");
                    System.out.println(         "               PILIHAN TIDAK VALID!                 ");
                    System.out.println(         "====================================================");
                    util.delay(2000);
                    util.clearConsole();
            }
        }
    }

    static void loginMenu() {
        System.out.println("""
                ██╗      ██████╗  ██████╗ ██╗███╗   ██╗
                ██║     ██╔═══██╗██╔════╝ ██║████╗  ██║
                ██║     ██║   ██║██║  ███╗██║██╔██╗ ██║
                ██║     ██║   ██║██║   ██║██║██║╚██╗██║
                ███████╗╚██████╔╝╚██████╔╝██║██║ ╚████║
                ╚══════╝ ╚═════╝  ╚═════╝ ╚═╝╚═╝  ╚═══╝
        """);
        System.out.println(util.BLUE + "====================================================");
        System.out.print(util.GREEN + "Username : " + util.YELLOW);
        String user = sc.nextLine();
        System.out.print(util.GREEN + "Password : " + util.YELLOW);
        String pass = sc.nextLine();

        // Cek admin
        for (Admin a : adminList) {
            if (a.login(user, pass)) {
                adminMenu(a);
                return;
            }
        }
        // Cek barber
        for (Barber b : barberList) {
            if (b.login(user, pass)) {
                barberMenu(b);
                return;
            }
        }
        // Cek pelanggan
        for (Pelanggan p : pelangganList) {
            if (p.login(user, pass)) {
                pelangganMenu(p);
                return;
            }
        }
        System.out.println(util.RED + "====================================================");
        System.out.println(         "                   LOGIN GAGAL!                     ");
        System.out.println(         "====================================================");
        util.delay(2000);
        util.clearConsole();
    }

    static void registerMenu() {
        System.out.println("""
                ██████╗ ███████╗ ██████╗ ██╗███████╗
                ██╔══██╗██╔════╝██╔════╝ ██║██╔════╝
                ██████╔╝█████╗  ██║  ███╗██║███████╗
                ██╔══██╗██╔══╝  ██║   ██║██║╚════██║
                ██║  ██║███████╗╚██████╔╝██║███████║
                ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝╚══════╝
                """);
        try {
            System.out.print(util.GREEN + "Username: " + util.YELLOW);
            String user = sc.nextLine();
            System.out.print(util.GREEN + "Password: " + util.YELLOW);
            String pass = sc.nextLine();
            
            // Validasi nomor telepon
            String telp;
            boolean validTelp = false;
            do {
                System.out.print(util.GREEN + "No Telp: " + util.YELLOW);
                telp = sc.nextLine();
                if (telp.matches("\\d+")) {
                    validTelp = true;
                } else {
                    System.out.println(util.RED + "====================================================");
                    System.out.println(         "        NOMOR TELEPON HARUS BERUPA ANGKA!           ");
                    System.out.println(         "====================================================");
                }
            } while (!validTelp);
            
            pelangganList.add(new Pelanggan(user, pass, telp));
            System.out.println("Registrasi berhasil!");
        } catch (Exception e) {
            System.out.println(util.RED + "====================================================");
            System.out.println(         "      TERJADI KESALAHAN INPUT, SILAHKAN ULANGI      ");
            System.out.println(         "====================================================");
            util.delay(2000);
            util.clearConsole();
            sc.nextLine();
        }
    }

    static void pelangganMenu(Pelanggan p) {
        while (true) {
            System.out.println("\n=== MENU PELANGGAN ===");
            System.out.println("1. Buat Reservasi");
            System.out.println("2. Lihat Detail Reservasi");
            System.out.println("3. Logout");
            System.out.print(util.GREEN + "Pilih menu: " + util.YELLOW);
            int pilih = 0;
            try {
                pilih = sc.nextInt(); sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(util.RED + "====================================================");
                System.out.println(         "            INPUT HARUS BERUPA ANGKA!               ");
                System.out.println(         "====================================================");
                util.delay(2000);
                util.clearConsole();
                sc.nextLine();
                continue;
            }
            switch (pilih) {
                case 1:
                    try {
                        // Input nama reservasi
                        System.out.print(util.GREEN + "Nama Reservasi : " + util.YELLOW);
                        String nama = sc.nextLine();
                        
                        // Pilih barber
                        System.out.println(util.BLUE + "\n=== DAFTAR BARBER ===" + util.GREEN);
                        for (int i = 0; i < barberList.size(); i++) {
                            System.out.println((i+1) + ". " + barberList.get(i).getUsername());
                        }
                        System.out.print(util.GREEN + "\nPilih barber (1-" + barberList.size() + "): " + util.YELLOW);
                        int pilihBarber = sc.nextInt(); sc.nextLine();
                        if (pilihBarber < 1 || pilihBarber > barberList.size()) {
                            throw new Exception("Pilihan barber tidak valid");
                        }
                        Barber barberPilihan = barberList.get(pilihBarber - 1);
                        
                        // Input tanggal
                        System.out.print(util.GREEN + "Tanggal (dd/MM/yyyy): " + util.YELLOW);
                        String tanggal = sc.nextLine();
                        
                        // Input waktu
                        System.out.print(util.GREEN + "Waktu (HH:mm): " + util.YELLOW);
                        String waktu = sc.nextLine();
                        
                        // Buat objek Date dari input tanggal dan waktu
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        Date tanggalWaktu = dateFormat.parse(tanggal + " " + waktu);
                        
                        // Buat reservasi
                        Reservasi reservasi = new Reservasi(nama, tanggalWaktu);
                        reservasi.setBarber(barberPilihan);
                        p.buatReservasi(reservasi);
                        
                        System.out.println(util.BLUE + "====================================================");
                        System.out.println(util.GREEN + "           RESERVASI BERHASIL DIBUAT!             ");
                        System.out.println(util.BLUE + "====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        
                    } catch (Exception e) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println(         "              INPUT RESERVASI GAGAL                 ");
                        System.out.println(         "====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        sc.nextLine();
                    }
                    break;
                case 2:
                    p.detailReservasi();
                    break;
                case 3:
                    p.logout();
                    return;
                default:
                    System.out.println(util.RED + "====================================================");
                    System.out.println(         "               PILIHAN TIDAK VALID!                 ");
                    System.out.println(         "====================================================");
                    util.delay(2000);
                    util.clearConsole();
            }
        }
    }

    static void adminMenu(Admin a) {
        while (true) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Lihat Cabang");
            System.out.println("2. Tambah Cabang");
            System.out.println("3. Update Cabang");
            System.out.println("4. Hapus Cabang");
            System.out.println("5. Lihat Barber");
            System.out.println("6. Tambah Barber");
            System.out.println("7. Update Barber");
            System.out.println("8. Hapus Barber");
            System.out.println("9. Logout");
            System.out.print(util.GREEN + "Pilih menu: " + util.YELLOW);
            int pilih = 0;
            try {
                pilih = sc.nextInt(); sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(util .RED + "====================================================");
                System.out.println(          "            INPUT HARUS BERUPA ANGKA!               ");
                System.out.println(          "====================================================");
                util.delay(2000);
                util.clearConsole();
                sc.nextLine();
                continue;
            }
            switch (pilih) {
                case 1:
                    for (Cabang c : cabangList) {
                        System.out.println("ID: " + c.getID() + ", Nama: " + c.getNama() + ", Alamat: " + c.getAlamat());
                    }
                    break;
                case 2:
                    try {
                        System.out.print(util.GREEN + "Nama Cabang: " + util.YELLOW);
                        String nama = sc.nextLine();
                        System.out.print(util.GREEN + "Alamat: " + util.YELLOW);
                        String alamat = sc.nextLine();
                        cabangList.add(new Cabang(nama, alamat));
                        System.out.println(util.BLUE  + "====================================================");
                        System.out.println(util.GREEN + "           CABANG BERHASIL DITAMBAHKAN!             ");
                        System.out.println(util.BLUE  + "====================================================");
                        util.delay(2000);
                        util.clearConsole();
                    } catch (Exception e) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println(         "                INPUT CABANG GAGAL!                 ");
                        System.out.println(         "====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        sc.nextLine();
                    }
                    break;
                case 3:
                    try {
                        System.out.print(util.GREEN + "ID Cabang: " + util.YELLOW);
                        int idU = sc.nextInt(); sc.nextLine();
                        for (Cabang c : cabangList) {
                            if (c.getID() == idU) {
                                System.out.print(util.GREEN + "Nama baru: " + util.YELLOW);
                                c.setNama(sc.nextLine());
                                System.out.print(util.GREEN + "Alamat baru: " + util.YELLOW);
                                c.setAlamat(sc.nextLine());
                                System.out.println(util.BLUE  + "====================================================");
                                System.out.println(util.GREEN + "            CABANG BERHASIL DIUPDATE!               ");
                                System.out.println(util.BLUE  + "====================================================");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println(         "            INPUT UPDATE CABANG GAGAL!              ");
                        System.out.println(         "====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        sc.nextLine();
                    }
                    break;
                case 4:
                    try {
                        System.out.print(util.GREEN + "ID Cabang: " + util.YELLOW);
                        int idH = sc.nextInt(); sc.nextLine();
                        cabangList.removeIf(c -> c.getID() == idH);
                        System.out.println(util.BLUE  + "====================================================");
                        System.out.println(util.GREEN + "             CABANG BERHASIL DIHAPUS!               ");
                        System.out.println(util.BLUE  + "====================================================");
                    } catch (Exception e) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println(         "             INPUT HAPUS CABANG GAGAL!              ");
                        System.out.println(         "====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        sc.nextLine();
                    }
                    break;
                case 5:
                    for (Barber b : barberList) {
                        System.out.println("Username: " + b.getUsername());
                    }
                    break;
                case 6:
                    try {
                        System.out.print(util.GREEN + "Username Barber: " + util.YELLOW);
                        String userB = sc.nextLine();
                        System.out.print(util.GREEN + "Password: " + util.YELLOW);
                        String passB = sc.nextLine();
                        barberList.add(new Barber(userB, passB));
                        System.out.println(util.BLUE  + "====================================================");
                        System.out.println(util.GREEN + "           BARBER BERHASIL DITAMBAHKAN!             ");
                        System.out.println(util.BLUE  + "====================================================");
                    } catch (Exception e) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println(         "                INPUT BARBER GAGAL!                 ");
                        System.out.println(         "====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        sc.nextLine();
                    }
                    break;
                case 7:
                    System.out.println("Fitur update barber belum diimplementasi.");
                    break;
                case 8:
                    try {
                        System.out.print(util.GREEN + "Username Barber: " + util.YELLOW);
                        String userDel = sc.nextLine();
                        barberList.removeIf(b -> b.getUsername().equals(userDel));
                        System.out.println(util.BLUE  + "====================================================");
                        System.out.println(util.GREEN + "             CABANG BERHASIL DIHAPUS!               ");
                        System.out.println(util.BLUE  + "====================================================");
                    } catch (Exception e) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println(         "             INPUT HAPUS BARBER GAGAL!              ");
                        System.out.println(         "====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        sc.nextLine();
                    }
                    break;
                case 9:
                    a.logout();
                    return;
                default:
                    System.out.println(util.RED + "====================================================");
                    System.out.println(         "               PILIHAN TIDAK VALID!                 ");
                    System.out.println(         "====================================================");
                    util.delay(2000);
                    util.clearConsole();
            }
        }
    }

    static void barberMenu(Barber b) {
        while (true) {
            System.out.println("\n=== MENU BARBER ===");
            System.out.println("1. Lihat Reservasi Hari Ini");
            System.out.println("2. Logout");
            System.out.print(util.GREEN + "Pilih menu: " + util.YELLOW);
            int pilih = 0;
            try {
                pilih = sc.nextInt(); sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(util.RED + "====================================================");
                System.out.println(         "            INPUT HARUS BERUPA ANGKA!               ");
                System.out.println(         "====================================================");
                util.delay(2000);
                util.clearConsole();
                sc.nextLine();
                continue;
            }

            switch (pilih) {
                case 1:
                    boolean adaReservasi = false;
                    System.out.println(util.BLUE + "\n=== DAFTAR RESERVASI HARI INI ===" + util.GREEN);
                    for (Pelanggan p : pelangganList) {
                        for (Reservasi r : p.getReservasiList()) {
                            if (r.getBarber() != null && r.getBarber().getUsername().equals(b.getUsername())) {
                                System.out.println("\nDetail Reservasi:");
                                r.detailReservasi();
                                adaReservasi = true;
                            }
                        }
                    }
                    if (!adaReservasi) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println(util.GREEN + "                BELUM ADA RESERVASI                 ");
                        System.out.println(util.RED + "====================================================");
                    }
                    util.delay(2000);
                    break;
                case 2:
                    b.logout();
                    return;
                default:
                    System.out.println(util.RED + "====================================================");
                    System.out.println(         "               PILIHAN TIDAK VALID!                 ");
                    System.out.println(         "====================================================");
                    util.delay(2000);
                    util.clearConsole();
            }
        }
    }
}
