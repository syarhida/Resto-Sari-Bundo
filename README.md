# Resto Sari Bundo

## Deskripsi
Program ini adalah aplikasi sederhana untuk simulasi sistem kasir pada Resto Sari Bundo. Fitur utama dari aplikasi ini meliputi:
1. **Pemesanan Menu**: Pelanggan dapat memesan makanan atau minuman dan mendapatkan struk otomatis.
2. **Manajemen Menu**: Admin dapat menambah, mengubah harga, atau menghapus menu yang tersedia.

## Fitur Utama
### 1. Pemesanan Menu
- Pelanggan dapat melihat daftar menu makanan dan minuman yang tersedia.
- Sistem mendukung promo:
  - Minuman gratis jika total belanja lebih dari Rp50.000.
  - Diskon 10% untuk total belanja di atas Rp100.000.
- Struk akan menampilkan rincian pesanan, subtotal, pajak, diskon, dan total akhir.

### 2. Manajemen Menu
- Admin dapat:
  - **Menambah menu baru** dengan nama, harga, dan kategori (makanan/minuman).
  - **Mengubah harga** menu yang sudah ada.
  - **Menghapus menu** dari daftar.

## Struktur Kode
### 1. **Main.java**
Berfungsi sebagai _entry point_ aplikasi. Mengelola navigasi utama antara:
- Pemesanan
- Manajemen Menu
- Keluar dari aplikasi.

### 2. **Menu.java**
Kelas yang merepresentasikan menu makanan/minuman dengan atribut:
- **Nama**: Nama menu.
- **Harga**: Harga menu.
- **Kategori**: Jenis menu (Makanan/Minuman).

### 3. **ManajemenMenu.java**
Mengelola operasi utama seperti:
- Menampilkan daftar menu.
- Mengelola pesanan pelanggan.
- Mengatur menu (tambah, ubah harga, hapus).

## Cara Penggunaan
### **Persyaratan**
- Java Development Kit (JDK) 8 atau versi lebih baru.

### **Langkah-langkah**
1. **Clone atau Download** repository ini.
2. **Kompilasi** semua file Java:
   ```bash
   javac saribundo/*.java
