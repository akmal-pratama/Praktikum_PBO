import model.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Pelanggan> pelangganList = new ArrayList<>();
    static ArrayList<Barber> barberList = new ArrayList<>();
    static ArrayList<Admin> adminList = new ArrayList<>();
    static ArrayList<Paket> paketList = new ArrayList<>();
    static ArrayList<Waktu> waktuList = new ArrayList<>();
    static ManajemenReservasi manajemenReservasi = new ManajemenReservasi();

    static {
        // Data default pelanggan, admin
        pelangganList.add(new Pelanggan("akmal", "123", "0812345678"));
        adminList.add(new Admin("admin", "admin"));

        // Data default barber (3 data)
        barberList.add(new Barber("Ghazali", "123"));
        barberList.add(new Barber("Vicky", "123"));
        barberList.add(new Barber("Adi", "123"));

        paketList.add(new Paket("Cukur Reguler", "cukur A", 25000));
        paketList.add(new Paket("Cukur Premium", "cukur B", 45000));
        paketList.add(new Paket("Cukur Anak-Anak", "cukur C", 20000));

        waktuList.add(new Waktu("09:00"));
        waktuList.add(new Waktu("10:30"));
        waktuList.add(new Waktu("12:00"));
        waktuList.add(new Waktu("14:00"));
        waktuList.add(new Waktu("15:30"));
        waktuList.add(new Waktu("17:00"));

    }

    public static void main(String[] args) {

        while (true) {
            util.clearConsole();
            System.out.println(util.GREEN + """
                    ███╗   ███╗███████╗███╗   ██╗██╗   ██╗    ██╗   ██╗████████╗ █████╗ ███╗   ███╗ █████╗
                    ████╗ ████║██╔════╝████╗  ██║██║   ██║    ██║   ██║╚══██╔══╝██╔══██╗████╗ ████║██╔══██╗
                    ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║    ██║   ██║   ██║   ███████║██╔████╔██║███████║
                    ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║    ██║   ██║   ██║   ██╔══██║██║╚██╔╝██║██╔══██║
                    ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝    ╚██████╔╝   ██║   ██║  ██║██║ ╚═╝ ██║██║  ██║
                    ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝      ╚═════╝    ╚═╝   ╚═╝  ╚═╝╚═╝     ╚═╝╚═╝  ╚═╝""");
            System.out.println(util.BLUE
                    + "========================================================================================="
                    + util.GREEN);
            System.out.println("   [1] Login");
            System.out.println("   [2] Register");
            System.out.println("   [3] Keluar" + util.BLUE);
            System.out
                    .println("========================================================================================="
                            + util.GREEN);
            int pilih = inputInteger(util.GREEN + "Pilih Menu : " + util.YELLOW);

            switch (pilih) {
                case 1:
                    util.clearConsole();
                    loginMenu();
                    break;
                case 2:
                    util.clearConsole();
                    registerMenu();
                    break;
                case 3:
                    util.clearConsole();
                    System.out.println(util.GREEN + """
                            ████████╗███████╗██████╗ ██╗███╗   ███╗ █████╗ ██╗  ██╗ █████╗ ███████╗██╗██╗  ██╗
                            ╚══██╔══╝██╔════╝██╔══██╗██║████╗ ████║██╔══██╗██║ ██╔╝██╔══██╗██╔════╝██║██║  ██║
                               ██║   █████╗  ██████╔╝██║██╔████╔██║███████║█████╔╝ ███████║███████╗██║███████║
                               ██║   ██╔══╝  ██╔══██╗██║██║╚██╔╝██║██╔══██║██╔═██╗ ██╔══██║╚════██║██║██╔══██║
                               ██║   ███████╗██║  ██║██║██║ ╚═╝ ██║██║  ██║██║  ██╗██║  ██║███████║██║██║  ██║
                               ╚═╝   ╚══════╝╚═╝  ╚═╝╚═╝╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝╚═╝  ╚═╝""");
                    return;
                default:
                    System.out.println(util.RED + "====================================================");
                    System.out.println("               PILIHAN TIDAK VALID!                 ");
                    System.out.println("====================================================");
                    util.delay(2000);
                    util.clearConsole();
            }
        }
    }

    static void loginMenu() {
        System.out.println(util.GREEN + """
                ██╗      ██████╗  ██████╗ ██╗███╗   ██╗
                ██║     ██╔═══██╗██╔════╝ ██║████╗  ██║
                ██║     ██║   ██║██║  ███╗██║██╔██╗ ██║
                ██║     ██║   ██║██║   ██║██║██║╚██╗██║
                ███████╗╚██████╔╝╚██████╔╝██║██║ ╚████║
                ╚══════╝ ╚═════╝  ╚═════╝ ╚═╝╚═╝  ╚═══╝""");
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
        System.out.println("                   LOGIN GAGAL!                     ");
        System.out.println("====================================================");
        util.delay(2000);
        util.clearConsole();
    }

    static void registerMenu() {
        System.out.println(util.GREEN + """
                ██████╗ ███████╗ ██████╗ ██╗███████╗
                ██╔══██╗██╔════╝██╔════╝ ██║██╔════╝
                ██████╔╝█████╗  ██║  ███╗██║███████╗
                ██╔══██╗██╔══╝  ██║   ██║██║╚════██║
                ██║  ██║███████╗╚██████╔╝██║███████║
                ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝╚══════╝""");
        System.out.println(util.BLUE + "====================================================");
        try {
            System.out.print(util.GREEN + "Username: " + util.YELLOW);
            String user = sc.nextLine();

            // Cek apakah username sudah terdaftar di pelanggan
            boolean usernameSudahAda = false;
            for (Pelanggan p : pelangganList) {
                if (p.getUsername().equals(user)) {
                    usernameSudahAda = true;
                    break;
                }
            }

            // Cek apakah username sudah terdaftar di barber
            for (Barber b : barberList) {
                if (b.getUsername().equals(user)) {
                    usernameSudahAda = true;
                    break;
                }
            }

            if (usernameSudahAda) {
                System.out.println(util.RED + "====================================================");
                System.out.println("           USERNAME SUDAH TERDAFTAR!              ");
                System.out.println("====================================================");
                util.delay(2000);
                util.clearConsole();
                return;
            }

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
                    System.out.println("        NOMOR TELEPON HARUS BERUPA ANGKA!           ");
                    System.out.println("====================================================");
                }
            } while (!validTelp);

            pelangganList.add(new Pelanggan(user, pass, telp));
            System.out.println(util.BLUE + "====================================================");
            System.out.println(util.GREEN + "           REGISTRASI BERHASIL!             ");
            System.out.println(util.BLUE + "====================================================");
            util.delay(2000);
            util.clearConsole();
        } catch (Exception e) {
            System.out.println(util.RED + "====================================================");
            System.out.println("      TERJADI KESALAHAN INPUT, SILAHKAN ULANGI      ");
            System.out.println("====================================================");
            util.delay(2000);
            util.clearConsole();
            sc.nextLine();
        }
    }

    static void pelangganMenu(Pelanggan p) {
        while (true) {
            util.clearConsole();
            System.out.println(util.GREEN + """
                    ██████╗ ███████╗██╗      █████╗ ███╗   ██╗ ██████╗  ██████╗  █████╗ ███╗   ██╗
                    ██╔══██╗██╔════╝██║     ██╔══██╗████╗  ██║██╔════╝ ██╔════╝ ██╔══██╗████╗  ██║
                    ██████╔╝█████╗  ██║     ███████║██╔██╗ ██║██║  ███╗██║  ███╗███████║██╔██╗ ██║
                    ██╔═══╝ ██╔══╝  ██║     ██╔══██║██║╚██╗██║██║   ██║██║   ██║██╔══██║██║╚██╗██║
                    ██║     ███████╗███████╗██║  ██║██║ ╚████║╚██████╔╝╚██████╔╝██║  ██║██║ ╚████║
                    ╚═╝     ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝""");
            System.out.println(util.BLUE
                    + "================================================================================" + util.GREEN);
            System.out.println("   [1] Buat Reservasi");
            System.out.println("   [2] Lihat Detail Reservasi");
            System.out.println("   [3] Update Profil");
            System.out.println("   [4] Logout");
            System.out.println(
                    util.BLUE + "================================================================================");
            int pilih = inputInteger(util.GREEN + "Pilih Menu : " + util.YELLOW);

            switch (pilih) {
                case 1:
                    try {
                        Barber barberPilihan = null;
                        Paket paketPilihan = null;
                        while (true) {
                            while (true) {
                                // Pilih barber
                                System.out.println(util.BLUE + "--------------------------------------");
                                System.out.printf(
                                        util.BLUE + "| " + util.GREEN + "%-3s" + util.BLUE + " | " + util.GREEN + "%-10s"
                                                + util.BLUE + " | " + util.GREEN + "%-15s" + util.BLUE + " |\n",
                                        "No", "ID", "Username");
    
                                System.out.println(util.BLUE + "--------------------------------------");
                                
                                for (int i = 0; i < barberList.size(); i++) {
                                    Barber barber = barberList.get(i);
                                    System.out.printf(
                                        util.BLUE + "| " + util.GREEN + "%-3d" + util.BLUE + " | " + util.GREEN
                                        + "%-10s" + util.BLUE + " | " + util.GREEN + "%-15s" + util.BLUE
                                        + " |\n",
                                        (i + 1), barber.getIDBarber(), barber.getUsername());
                                    }
                                    
                                System.out.println(util.BLUE + "--------------------------------------");
                                System.out
                                        .print(util.GREEN + "\nPilih barber (1-" + barberList.size() + "): " + util.YELLOW);
                                int pilihBarber = inputInteger(util.GREEN + "Pilih barber : " + util.YELLOW);
    
                                if (pilihBarber < 1 || pilihBarber > barberList.size()) {
                                    System.out.println(util.RED + "====================================================");
                                    System.out.println("           PILIHAN BARBER TIDAK VALID!              ");
                                    System.out.println("====================================================");
                                    continue;
                                }
    
                                barberPilihan = barberList.get(pilihBarber - 1);
                                break;
                            }
    
                            // Pilih paket
                            while (true) {
                                System.out.println(util.BLUE + "==========================================================================");
                                System.out.println(util.GREEN + "                               PILIH PAKET                               ");
                                System.out.println(util.BLUE + "==========================================================================");
                                System.out.printf(
                                        util.BLUE + "| " + util.GREEN + "%-3s" + util.BLUE + " | " + util.GREEN + "%-10s"
                                                + util.BLUE + " | " + util.GREEN + "%-15s" + util.BLUE + " | " + util.GREEN
                                                + "%-20s"
                                                + util.BLUE + " | " + util.GREEN + "%-10s" + util.BLUE + " |\n",
                                        "No", "ID", "Nama Paket", "Deskripsi", "Harga");
                                System.out.println(
                                        util.BLUE
                                                + "--------------------------------------------------------------------------");
                                for (int i = 0; i < paketList.size(); i++) {
                                    Paket paket = paketList.get(i);
                                    System.out.printf(
                                            util.BLUE + "| " + util.GREEN + "%-3d" + util.BLUE + " | " + util.GREEN
                                                    + "%-10s" + util.BLUE + " | " + util.GREEN + "%-15s" + util.BLUE + " | "
                                                    + util.GREEN + "%-20s" + util.BLUE + " | " + util.GREEN + "Rp%-8d"
                                                    + util.BLUE + " |\n",
                                            (i + 1), paket.getIDPaket(), paket.getNama(), paket.getDesk(),
                                            (int) paket.getHarga());
                                }
                                System.out.println(
                                        util.BLUE
                                                + "--------------------------------------------------------------------------");
                                System.out.print(util.GREEN + "\nPilih paket (1-" + paketList.size() + "): " + util.YELLOW);
                                int pilihPaket = sc.nextInt();
                                sc.nextLine(); // untuk membersihkan buffer
                                if (pilihPaket < 1 || pilihPaket > paketList.size()) {
                                    System.out.println(util.RED + "====================================================");
                                    System.out.println("           PILIHAN PAKET TIDAK VALID!              ");
                                    System.out.println("====================================================");
                                    continue;
                                }
                                paketPilihan = paketList.get(pilihPaket - 1);
                                break;
                            }
    
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            dateFormat.setLenient(false);
    
                            Date tanggalWaktu = null;
    
                            while (true) {
                                try {
                                    // Input tanggal
                                    System.out.print(util.GREEN + "Tanggal (dd/MM/yyyy): " + util.YELLOW);
                                    String tanggal = sc.nextLine();
    
                                    // Tampilkan daftar waktu yang tersedia
                                    System.out.println(util.BLUE + "====================");
                                    System.out.println(util.GREEN +"    PILIH WAKTU     ");
                                    System.out.println(util.BLUE + "====================");
                                    System.out.printf(
                                            util.BLUE + "| " + util.GREEN + "%-3s" + util.BLUE + " | " + util.GREEN
                                                    + "%-10s" + util.BLUE + " |\n",
                                            "No", "Waktu");
                                    System.out.println(util.BLUE + "--------------------");
    
                                    for (int i = 0; i < waktuList.size(); i++) {
                                        Waktu waktu = waktuList.get(i);
                                        System.out.printf(
                                                util.BLUE + "| " + util.GREEN + "%-3d" + util.BLUE + " | " + util.GREEN
                                                        + "%-10s" + util.BLUE + " |\n",
                                                (i + 1), waktu.getWaktu());
                                    }
    
                                    System.out.print(
                                            util.GREEN + "\nPilih waktu (1-" + waktuList.size() + "): " + util.YELLOW);
                                    int pilihWaktu = inputInteger("");
    
                                    if (pilihWaktu < 1 || pilihWaktu > waktuList.size()) {
                                        System.out
                                                .println(util.RED + "====================================================");
                                        System.out.println("           PILIHAN WAKTU TIDAK VALID!              ");
                                        System.out.println("====================================================");
                                        continue;
                                    }
    
                                    String waktu = waktuList.get(pilihWaktu - 1).getWaktu();
    
                                    // Gabungkan & parse
                                    tanggalWaktu = dateFormat.parse(tanggal + " " + waktu);
                                    if (tanggalWaktu.before(new Date())) {
                                        System.out
                                                .println(util.RED + "====================================================");
                                        System.out.println("            TANGGAL/WAKTU TIDAK BOLEH LAMPAU        ");
                                        System.out.println("====================================================");
                                        continue;
                                    }
                                    break;
    
                                } catch (ParseException e) {
                                    System.out.println(util.RED + "====================================================");
                                    System.out.println("         FORMAT TANGGAL / WAKTU TIDAK VALID!        ");
                                    System.out.println("         Gunakan format dd/MM/yyyy dan HH:mm        ");
                                    System.out.println("====================================================");
                                }
                            }
                            
                            if (manajemenReservasi.isReservasiTaken(barberPilihan, tanggalWaktu).equals(true)) {
                                System.out.println(util.RED + "====================================================");
                                System.out.println("           BARBER SEDANG SIBUK PADA WAKTU INI!      ");
                                System.out.println("====================================================");
                                util.delay(2000);
                                util.clearConsole();
                                continue;
                            }else {
                                Reservasi reservasi = new Reservasi(tanggalWaktu, barberPilihan, p, paketPilihan);
                                manajemenReservasi.tambahReservasi(reservasi);
                                System.out.println(util.BLUE + "====================================================");
                                System.out.println(util.GREEN + "           RESERVASI BERHASIL DIBUAT!              ");
                                System.out.println(util.BLUE + "====================================================");
                            }
                            break;
                        }
                        
                    } catch (Exception e) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println("              INPUT RESERVASI GAGAL                 ");
                        System.out.println("====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        sc.nextLine();
                    }
                    break;
                        
                case 2:
                    manajemenReservasi.getReservasiByPelanggan(p);
                    break;
                case 3:
                    try {
                        System.out.println(util.BLUE + "====================================================");
                        System.out.println(util.GREEN + "                  UPDATE PROFIL                    ");
                        System.out.println(util.BLUE + "====================================================");
                        System.out.println(util.GREEN + "   [1] Update Username");
                        System.out.println("   [2] Update Password");
                        System.out.println("   [3] Update Nomor Telepon");
                        System.out.println("   [4] Kembali");
                        System.out.println(util.BLUE + "====================================================");

                        int pilihUpdate = inputInteger(util.GREEN + "Pilih yang ingin diupdate: " + util.YELLOW);

                        switch (pilihUpdate) {
                            case 1: // Update Username
                                System.out.print(util.GREEN + "Username Baru: " + util.YELLOW);
                                String usernameBaru = sc.nextLine();

                                // Cek apakah username baru sudah ada
                                boolean usernameSudahAda = false;
                                if (!usernameBaru.equals(p.getUsername())) {
                                    for (Pelanggan pl : pelangganList) {
                                        if (pl.getUsername().equals(usernameBaru)) {
                                            usernameSudahAda = true;
                                            break;
                                        }
                                    }
                                    for (Barber b : barberList) {
                                        if (b.getUsername().equals(usernameBaru)) {
                                            usernameSudahAda = true;
                                            break;
                                        }
                                    }
                                }

                                if (usernameSudahAda) {
                                    System.out
                                            .println(util.RED + "====================================================");
                                    System.out.println("           USERNAME SUDAH TERDAFTAR!              ");
                                    System.out.println("====================================================");
                                } else {
                                    p.setUsername(usernameBaru);
                                    System.out.println(
                                            util.BLUE + "====================================================");
                                    System.out.println(
                                            util.GREEN + "           USERNAME BERHASIL DIUPDATE!             ");
                                    System.out.println(
                                            util.BLUE + "====================================================");
                                }
                                break;

                            case 2: // Update Password
                                System.out.print(util.GREEN + "Password Baru: " + util.YELLOW);
                                String passwordBaru = sc.nextLine();
                                p.setPassword(passwordBaru);
                                System.out.println(util.BLUE + "====================================================");
                                System.out.println(util.GREEN + "           PASSWORD BERHASIL DIUPDATE!             ");
                                System.out.println(util.BLUE + "====================================================");
                                break;

                            case 3: // Update Nomor Telepon
                                String telpBaru;
                                boolean validTelp = false;
                                do {
                                    System.out.print(util.GREEN + "No Telp Baru: " + util.YELLOW);
                                    telpBaru = sc.nextLine();
                                    if (telpBaru.matches("\\d+")) {
                                        validTelp = true;
                                    } else {
                                        System.out.println(
                                                util.RED + "====================================================");
                                        System.out.println("        NOMOR TELEPON HARUS BERUPA ANGKA!           ");
                                        System.out.println("====================================================");
                                    }
                                } while (!validTelp);

                                p.setNoTelp(telpBaru);
                                System.out.println(util.BLUE + "====================================================");
                                System.out.println(
                                        util.GREEN + "           NOMOR TELEPON BERHASIL DIUPDATE!             ");
                                System.out.println(util.BLUE + "====================================================");
                                break;

                            case 4: // Kembali
                                break;

                            default:
                                System.out.println(util.RED + "====================================================");
                                System.out.println("               PILIHAN TIDAK VALID!                 ");
                                System.out.println("====================================================");
                        }

                        util.delay(2000);
                        util.clearConsole();

                    } catch (Exception e) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println("              UPDATE PROFIL GAGAL!                 ");
                        System.out.println("====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        sc.nextLine();
                    }
                    break;
                case 4:
                    p.logout();
                    return;
                default:
                    System.out.println(util.RED + "====================================================");
                    System.out.println("               PILIHAN TIDAK VALID!                 ");
                    System.out.println("====================================================");
                    util.delay(2000);
                    util.clearConsole();
            }
        }
    }

    static void adminMenu(Admin a) {
        while (true) {
            util.clearConsole();
            System.out.println(util.GREEN + """
                     █████╗ ██████╗ ███╗   ███╗██╗███╗   ██╗
                    ██╔══██╗██╔══██╗████╗ ████║██║████╗  ██║
                    ███████║██║  ██║██╔████╔██║██║██╔██╗ ██║
                    ██╔══██║██║  ██║██║╚██╔╝██║██║██║╚██╗██║
                    ██║  ██║██████╔╝██║ ╚═╝ ██║██║██║ ╚████║
                    ╚═╝  ╚═╝╚═════╝ ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝""");
            System.out.println(util.BLUE + "====================================================");
            System.out.println(util.GREEN + "   [1] Lihat Reservasi");
            System.out.println("   [2] Lihat Barber");
            System.out.println("   [3] Tambah Barber");
            System.out.println("   [4] Update Barber");
            System.out.println("   [5] Hapus Barber");
            System.out.println("   [0] Logout");
            System.out.println(util.BLUE + "====================================================");

            int pilih = inputInteger(util.GREEN + "Pilih Menu : " + util.YELLOW);
            switch (pilih) {
                case 1:
                    manajemenReservasi.getAllReservasi();
                    break;
                case 2:
                    Barber.TampilBarber(barberList);
                    break;
                case 3:
                    try {
                        System.out.print(util.GREEN + "Username Barber: " + util.YELLOW);
                        String userB = sc.nextLine();

                        // Cek apakah username barber sudah ada
                        boolean usernameBarberSudahAda = false;
                        for (Barber b : barberList) {
                            if (b.getUsername().equals(userB)) {
                                usernameBarberSudahAda = true;
                                break;
                            }
                        }

                        if (usernameBarberSudahAda) {
                            System.out.println(util.RED + "====================================================");
                            System.out.println("           USERNAME BARBER SUDAH TERDAFTAR!              ");
                            System.out.println("====================================================");
                            util.delay(2000);
                            util.clearConsole();
                            break;
                        }

                        System.out.print(util.GREEN + "Password: " + util.YELLOW);
                        String passB = sc.nextLine();
                        barberList.add(new Barber(userB, passB));
                        System.out.println(util.BLUE + "====================================================");
                        System.out.println(util.GREEN + "           BARBER BERHASIL DITAMBAHKAN!             ");
                        System.out.println(util.BLUE + "====================================================");
                        util.delay(2000);
                        util.clearConsole();
                    } catch (Exception e) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println("                INPUT BARBER GAGAL!                 ");
                        System.out.println("====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        sc.nextLine();
                    }
                    break;
                case 4:
                    Barber.TampilBarber(barberList);
                    int id = inputInteger(util.GREEN + "Masukkan ID Barber yang akan diupdate: " + util.YELLOW);
                    for (Barber b : barberList) {
                        if (b.getIDBarber() == id) {
                            System.out.print(util.GREEN + "Username Baru Barber: " + util.YELLOW);
                            String namaBaru = sc.nextLine();

                            b.setNamaBarber(namaBaru);
                            System.out.println(util.BLUE + "====================================================");
                            System.out.println(util.GREEN + "             BARBER BERHASIL DIUPDATE!              ");
                            System.out.println(util.BLUE + "====================================================");
                            break;
                        }
                    }
                    System.out.println(util.RED + "====================================================");
                    System.out.println("              BARBER TIDAK DITEMUKAN!               ");
                    System.out.println("====================================================");
                    break;
                case 5:
                    try {
                        System.out.print(util.GREEN + "Username Barber: " + util.YELLOW);
                        String userDel = sc.nextLine();
                        barberList.removeIf(b -> b.getUsername().equals(userDel));
                        System.out.println(util.BLUE + "====================================================");
                        System.out.println(util.GREEN + "             BARBER BERHASIL DIHAPUS!               ");
                        System.out.println(util.BLUE + "====================================================");
                    } catch (Exception e) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println("             INPUT HAPUS BARBER GAGAL!              ");
                        System.out.println("====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        sc.nextLine();
                    }
                    break;
                case 0:
                    a.logout();
                    return;
                default:
                    System.out.println(util.RED + "====================================================");
                    System.out.println("               PILIHAN TIDAK VALID!                 ");
                    System.out.println("====================================================");
                    util.delay(2000);
                    util.clearConsole();
            }
        }
    }

    static void barberMenu(Barber b) {
        while (true) {
            util.clearConsole();
            System.out.println(util.GREEN + """
                    ██████╗  █████╗ ██████╗ ██████╗ ███████╗██████╗
                    ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔══██╗
                    ██████╔╝███████║██████╔╝██████╔╝█████╗  ██████╔╝
                    ██╔══██╗██╔══██║██╔══██╗██╔══██╗██╔══╝  ██╔══██╗
                    ██████╔╝██║  ██║██║  ██║██████╔╝███████╗██║  ██║
                    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝╚═╝  ╚═╝""");
            System.out.println(util.BLUE + "====================================================");
            System.out.println(util.GREEN + "   [1] Lihat Reservasi Hari Ini");
            System.out.println("   [2] Logout");
            System.out.println(util.BLUE + "====================================================");
            int pilih = inputInteger(util.GREEN + "Pilih Menu : " + util.YELLOW);

            switch (pilih) {
                case 1:
                    manajemenReservasi.getReservasiByBarber(b);
                    break;
                case 2:
                    int id = inputInteger(util.GREEN + "Masukkan ID Reservasi yang sudah selesai: " + util.YELLOW);
                    manajemenReservasi.selesaikanReservasiByBarber(b, id);
                    System.out.println(util.BLUE + "====================================================");
                    System.out.println(util.GREEN + "             RESERVASI SELESAI!                    ");
                    System.out.println(util.BLUE + "====================================================");
                    util.delay(2000);
                    break;
                case 3:
                    b.logout();
                    return;
                default:
                    System.out.println(util.RED + "====================================================");
                    System.out.println("               PILIHAN TIDAK VALID!                 ");
                    System.out.println("====================================================");
                    util.delay(2000);
                    util.clearConsole();
            }
        }
    }

    public static int inputInteger(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                int angka = sc.nextInt();
                sc.nextLine();
                return angka;
            } catch (InputMismatchException e) {
                System.out.println(util.RED + "====================================================");
                System.out.println("            INPUT HARUS BERUPA ANGKA!               ");
                System.out.println("====================================================");
                sc.nextLine();
                continue;
            }
        }
    }
}