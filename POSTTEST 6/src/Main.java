import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class Main {
    private static final ArrayList<Tas> daftarTas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    static int jumlahTas = 0;

    public static void main(final String[] args) {
        boolean exit = false;
        while (!exit) {
            tampilanmenu();
            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    clearscreen();
                    tambahtas();
                    break;
                case 2:
                    clearscreen();
                    tampilkansemuatas();
                    break;
                case 3:
                    clearscreen();
                    tampilkansemuatas();
                    updatedatatas();
                    break;
                case 4:
                    clearscreen();
                    tampilkansemuatas();
                    hapusTas();
                    break;
                case 5:
                    clearscreen();
                    exit = true;
                    System.out.println("Arigatou bro");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        }
        scanner.close();
    }

    private static void clearscreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void tampilanmenu() {
        System.out.println("\n===== Sistem Pendataan Toko Tas XornT =====");
        System.out.println("| 1. Tambah Tas                           |");
        System.out.println("| 2. Tampilkan Semua Tas                  |");
        System.out.println("| 3. Perbarui Data Tas                    |");
        System.out.println("| 4. Hapus Tas                            |");
        System.out.println("| 5. Keluar Program                       |");
        System.out.println("===========================================");
        System.out.print(" Pilih menu: ");
    }

    private static void tambahtas() {
        System.out.println("Jenis Tas:");
        System.out.println("1. Ransel");
        System.out.println("2. Tangan");
        System.out.print("Pilih jenis tas: ");
        int jenis = 0;
        boolean validJenis = false;
        while (!validJenis) {
            try {
                jenis = scanner.nextInt();
                if (jenis < 1 || jenis > 2) {
                    throw new IllegalArgumentException("Pilihan jenis tas tidak valid.");
                }
                validJenis = true;
            } catch (InputMismatchException e) {
                System.out.println("Masukkan nomor untuk memilih jenis tas.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.nextLine();

        System.out.print("\nMasukkan kode tas: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan nama tas: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga tas: ");
        double harga = 0;
        boolean validHarga = false;
        while (!validHarga) {
            try {
                harga = scanner.nextDouble();
                validHarga = true;
            } catch (InputMismatchException e) {
                System.out.println("Masukkan harga yang benar.");
                scanner.nextLine();
            }
        }

        switch (jenis) {
            case 1:
                int kapasitas = 0;
                boolean validKapasitas = false;
                while (!validKapasitas) {
                    try {
                        System.out.print("Masukkan kapasitas tas ransel (liter): ");
                        kapasitas = scanner.nextInt();
                        validKapasitas = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Masukkan angka untuk kapasitas.");
                        scanner.nextLine();
                    }
                }
                TasRansel tasRansel = new TasRansel(kode, nama, harga, kapasitas);
                daftarTas.add(tasRansel);
                jumlahTas++;
            break;
            case 2:
                boolean taliPanjang = false;
                boolean validTaliPanjang = false;
                while (!validTaliPanjang) {
                    try {
                        System.out.print("Apakah tas tangan memiliki tali panjang? (true/false): ");
                        taliPanjang = scanner.nextBoolean();
                        validTaliPanjang = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Masukkan 'true' atau 'false'.");
                        scanner.nextLine();
                    }
                }
                TasTangan tasTangan = new TasTangan(kode, nama, harga, taliPanjang);
                daftarTas.add(tasTangan);
                jumlahTas++;
                break;
            default:
                System.out.println("Pilihan jenis tas tidak valid.");
                break;
        }
        clearscreen();
        System.out.println("\nTas berhasil ditambahkan.");
        System.out.print("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        scanner.nextLine();
    }

    private static void tampilkansemuatas() {
        System.out.println("\nDaftar Tas:");
        if (daftarTas.isEmpty()) {
            System.out.println("Tidak ada tas yang terdaftar.");
        } else {
            for (Tas tas : daftarTas) {
                tas.printDetails();
                System.out.println();
            }
        }
    }

    private static void updatedatatas() {
        System.out.print("\nMasukkan kode tas yang akan diupdate: ");
        String kode = scanner.nextLine();
        boolean found = false;
        for (Tas tas : daftarTas) {
            if (tas.getKode().equalsIgnoreCase(kode)) {
                System.out.print("Masukkan nama baru: ");
                String namaBaru = scanner.nextLine();
                System.out.print("Masukkan harga baru: ");
                double hargaBaru = 0;
                boolean validHarga = false;
                while (!validHarga) {
                    try {
                        hargaBaru = scanner.nextDouble();
                        validHarga = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Masukkan harga yang benar.");
                        scanner.nextLine(); // Clear the invalid input
                    }
                }
                tas.setNama(namaBaru);
                tas.setHarga(hargaBaru);
                found = true;
                System.out.println("Data tas berhasil diupdate.");
                break;
            }
        }
        if (!found) {
            System.out.println("Tas dengan kode " + kode + " tidak ditemukan.");
            System.out.print("Tekan Enter untuk melanjutkan...");
            scanner.nextLine();
        }
    }

    private static void hapusTas() {
        System.out.print("\nMasukkan kode tas yang akan dihapus: ");
        String kode = scanner.nextLine();
        boolean removed = false;
        for (int i = 0; i < daftarTas.size(); i++) {
            if (daftarTas.get(i).getKode().equalsIgnoreCase(kode)) {
                daftarTas.remove(i);
                removed = true;
                System.out.println("Tas berhasil dihapus.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Tas dengan kode " + kode + " tidak ditemukan.");
            System.out.print("Tekan Enter untuk melanjutkan...");
            scanner.nextLine();
        }
    }
}