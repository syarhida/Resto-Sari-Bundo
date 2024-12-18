package saribundo;

import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenMenu {
    private ArrayList<Menu> daftarMenu = new ArrayList<>();
    private ArrayList<Menu> pesanan = new ArrayList<>();
    private ArrayList<Integer> jumlahPesanan = new ArrayList<>();

    // konstruktor: tambahkan menu awal
    public ManajemenMenu() {
        tambahMenuAwal();
    }

    private void tambahMenuAwal() {
        daftarMenu.add(new Menu("Sate Taichan", 15000, "Makanan"));
        daftarMenu.add(new Menu("Mie Pangsit", 20000, "Makanan"));
        daftarMenu.add(new Menu("Ayam Penyet", 15000, "Makanan"));
        daftarMenu.add(new Menu("Kupat Tahu", 15000, "Makanan"));
        daftarMenu.add(new Menu("Nasi Bakar", 10000, "Makanan"));
        daftarMenu.add(new Menu("Air Mineral", 5000, "Minuman"));
        daftarMenu.add(new Menu("Lemon Tea", 10000, "Minuman"));
        daftarMenu.add(new Menu("Es Dugan", 10000, "Minuman"));
        daftarMenu.add(new Menu("Jus Alpukat", 15000, "Minuman"));
        daftarMenu.add(new Menu("Jus Mangga", 15000, "Minuman"));
    }

    // ni buat pajak sama biaya pelayanan
    static double pajak = 0.1;
    static double biayaPelayanan = 20000;

    // menampilkan daftar menu
    public void tampilkanMenu() {
        System.out.println("\n------------------------------------");
        System.out.println("--------- RESTO SARI BUNDO ---------");
        System.out.println("------------------------------------");
        System.out.println("\n----------- MENU MAKANAN -----------\n");
        for (Menu item : daftarMenu) {
            if (item.getKategori().equals("Makanan")) {
                System.out.printf("%s\t\tRp%,.0f%n", item.getNama(), item.getHarga());
            }
        }
        System.out.println("\n----------- MENU MINUMAN -----------\n");
        for (Menu item : daftarMenu) {
            if (item.getKategori().equals("Minuman")) {
                System.out.printf("%s\t\tRp%,.0f%n", item.getNama(), item.getHarga());
            }
        }
    }

    // cari menu berdasarkan nama
    public Menu cariMenu(String namaMenu) {
        for (Menu menu : daftarMenu) {
            if (menu.getNama().equalsIgnoreCase(namaMenu)) {
                return menu;
            }
        }
        return null;
    }

    // fungsi pemesanan
    public void lakukanPemesanan() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            tampilkanMenu();
            System.out.print("\nMasukkan Pesanan Anda: ");
            String namaMenu = scanner.nextLine();

            if (namaMenu.equalsIgnoreCase("selesai")) {
                cetakStruk();
                return;
            }

            Menu menu = cariMenu(namaMenu);
            if (menu != null) {
                System.out.print("Masukkan jumlah: ");
                int jumlah = scanner.nextInt();
                scanner.nextLine(); // clear buffer

                pesanan.add(menu);
                jumlahPesanan.add(jumlah);
                System.out.println("Pesanan ditambahkan!");
            } else {
                System.out.println("Menu tidak ditemukan. Coba lagi.");
            }
        }
    }

    // print struk pemesanan
    public void cetakStruk() {
        double totalBiaya = 0;
        System.out.println("\n------------------------------------");
        System.out.println("----------- STRUK BELANJA ----------");
        System.out.println("--------- RESTO SARI BUNDO ---------");
        System.out.println("------------------------------------\n");
        for (int i = 0; i < pesanan.size(); i++) {
            Menu menu = pesanan.get(i);
            int jumlah = jumlahPesanan.get(i);
            double hargaItem = menu.getHarga() * jumlah;
            System.out.println(menu.getNama());
            System.out.printf("%d x %,.0f\t\tRp%,.0f%n", jumlah, menu.getHarga(), hargaItem);
            totalBiaya += hargaItem;
        }

        // minuman gratis kalo total belanja diatas 50.000
        if (totalBiaya > 50000) {
            Menu minumanGratis = null;
            // Cari pesanan minuman terakhir
            for (int i = pesanan.size() - 1; i >= 0; i--) {
                if (pesanan.get(i).getKategori().equalsIgnoreCase("Minuman")) {
                    minumanGratis = pesanan.get(i);
                    break;
                }
            }
            // cetak promo minuman gratis
            if (minumanGratis != null) {
                System.out.println("\nMinuman Gratis:");
                System.out.printf("1 x %s\t\tRp%,.0f", minumanGratis.getNama(), minumanGratis.getHarga());
                System.out.printf("\n\t\t\t-%,.0f%n", minumanGratis.getHarga());
            }
        }

        // tambahan pajak dan biaya pelayanan
        double totalPajak = totalBiaya * pajak;
        double totalAkhir = totalBiaya + totalPajak + biayaPelayanan;

        // diskon 10% kalo belanja diatas 100 ribu
        double totalDiskon = totalBiaya * 0.1;
        if (totalBiaya > 100000) {
            totalAkhir = totalAkhir - totalDiskon;
        }

        System.out.println("\n------------------------------------\n");
        System.out.printf("Subtotal\t\tRp%,.0f", totalBiaya);
        // diskon 10% kalo belanja diatas 100 ribu
        if (totalBiaya > 100000) {
            System.out.printf("\nDiskon 10%%\t\t-%,.0f", totalDiskon);
        }
        System.out.printf("\nPajak 10%%\t\tRp%,.0f", totalPajak);
        System.out.printf("\nBiaya Pelayanan\t\tRp%,.0f", biayaPelayanan);
        System.out.printf("\nTotal\t\t\tRp%,.0f%n", totalAkhir);
        System.out.println("\n------------------------------------");
        System.out.println("--------- TERIMAKASIH SUDAH --------");
        System.out.println("------------ BERBELANJA ------------");
        System.out.println("------------------------------------\n");

        // reset pesanan setelah cetak struk
        pesanan.clear();
        jumlahPesanan.clear();
    }

    // ni buat kelola menu
    public void kelolaMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n------------------------------------");
            System.out.println("--------- RESTO SARI BUNDO ---------");
            System.out.println("------------------------------------");
            System.out.println("\n---------- MENU MANAJEMEN ----------\n");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Ubah Harga Menu");
            System.out.println("3. Hapus Menu");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.println("\n------------------------------------\n");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahMenuBaru(scanner);
                    break;
                case 2:
                    ubahHargaMenu(scanner);
                    break;
                case 3:
                    hapusMenu(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    private void tambahMenuBaru(Scanner scanner) {
        scanner.nextLine(); // clear buffer
        System.out.print("Masukkan nama menu: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga menu: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); // clear buffer
        System.out.print("Masukkan kategori (Makanan/Minuman): ");
        String kategori = scanner.nextLine();

        daftarMenu.add(new Menu(nama, harga, kategori));
        System.out.println("Menu berhasil ditambahkan!");
    }

    private void ubahHargaMenu(Scanner scanner) {
        tampilkanMenu();
        System.out.print("\nMasukkan nama menu yang ingin diubah: ");
        scanner.nextLine();
        String namaMenu = scanner.nextLine();
        Menu menu = cariMenu(namaMenu);

        if (menu != null) {
            System.out.print("Masukkan harga baru: ");
            double hargaBaru = scanner.nextDouble();
            menu.setHarga(hargaBaru);
            System.out.println("Harga menu berhasil diubah!");
        } else {
            System.out.println("Menu tidak ditemukan.");
        }
    }

    private void hapusMenu(Scanner scanner) {
        tampilkanMenu();
        System.out.print("\nMasukkan nama menu yang ingin dihapus: ");
        scanner.nextLine();
        String namaMenu = scanner.nextLine();
        Menu menu = cariMenu(namaMenu);

        if (menu != null) {
            daftarMenu.remove(menu);
            System.out.println("Menu berhasil dihapus!");
        } else {
            System.out.println("Menu tidak ditemukan.");
        }
    }
}