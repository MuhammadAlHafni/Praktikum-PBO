import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Tas> daftarTas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
        System.out.print("\nMasukkan kode tas: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan nama tas: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga tas: ");
        double harga = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                harga = Double.parseDouble(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.print("Masukkan harga yang benar: ");
            }
        }

        Tas tasBaru = new Tas(kode, nama, harga);
        daftarTas.add(tasBaru);
        clearscreen();
        System.out.println("\nTas berhasil ditambahkan.");
    }

    private static void tampilkansemuatas() {
        System.out.println("\nDaftar Tas:");
        if (daftarTas.isEmpty()) {
            System.out.println("gada ada tas yang terdaftar.");
        } else {
            for (Tas tas : daftarTas) {
                tas.printDetails();
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
                double hargaBaru = scanner.nextDouble();
                tas.setNama(namaBaru);
                tas.setHarga(hargaBaru);
                found = true;
                System.out.println("Data tas berhasil diupdate.");
                break;
            }
        }
        if (!found) {
            System.out.println("Tas dengan kode " + kode + " gada.");
        }
    }

    private static void hapusTas() {
        System.out.print("\nMasukkan kode tas yang dihapus: ");
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
            System.out.println("Tas dengan kode " + kode + " gada.");
        }
    }
}
