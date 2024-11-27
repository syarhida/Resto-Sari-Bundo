package saribundo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManajemenMenu manager = new ManajemenMenu();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n------------------------------------");
            System.out.println("---------- SELAMAT DATANG ----------");
            System.out.println("--------- RESTO SARI BUNDO ---------");
            System.out.println("------------------------------------\n");
            System.out.println("1. Pemesanan");
            System.out.println("2. Manajemen Menu");
            System.out.println("3. Keluar");
            System.out.println("\n------------------------------------\n");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    manager.lakukanPemesanan();
                    break;
                case 2:
                    manager.kelolaMenu();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}
