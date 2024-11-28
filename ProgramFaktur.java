import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProgramFaktur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Proses login
            System.out.println("Log in");
            System.out.println("=======================================================");
            System.out.print("Username : ");
            String username = scanner.nextLine(); // Username disimpan sebagai String

            System.out.print("Password  : ");
            String password = scanner.nextLine(); // Password disimpan sebagai String

            // Validasi username dan password
            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Username dan Password tidak boleh kosong!");
            }
            if (!username.equals("admin") || !password.equals("admin")) {
                throw new IllegalArgumentException("Username atau Password salah!");
            }
            

            // Captcha 
            int captchaValue = (int) (Math.random() * 9000) + 1000; // Angka 4 digit random
            System.out.print("Captcha    : " + captchaValue + "\nMasukkan Captcha: ");
            int captchaInput = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            // Validasi captcha
            if (captchaInput != captchaValue) {
                throw new IllegalArgumentException("Captcha salah! Silakan coba lagi.");
            }

            System.out.println("Login berhasil!");
            System.out.println("=======================================================\n");

            // Welcoming
            System.out.println("Selamat Datang di Supermarket ComboWombo");

            // Menampilkan tanggal dan waktu
            LocalDateTime now = LocalDateTime.now(); 
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            System.out.println("Tanggal dan Waktu : " + now.format(formatter));
            System.out.println("=======================================================");

            // Input data faktur
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();
            if (noFaktur.isEmpty()) {
                throw new IllegalArgumentException("No Faktur tidak boleh kosong!");
            }

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();
            if (kodeBarang.isEmpty()) {
                throw new IllegalArgumentException("Kode Barang tidak boleh kosong!");
            }

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();
            if (namaBarang.isEmpty()) {
                throw new IllegalArgumentException("Nama Barang tidak boleh kosong!");
            }

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = scanner.nextDouble();
            if (hargaBarang <= 0) {
                throw new IllegalArgumentException("Harga Barang harus lebih dari 0!");
            }

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = scanner.nextInt();
            if (jumlahBeli <= 0) {
                throw new IllegalArgumentException("Jumlah Beli harus lebih dari 0!");
            }

            scanner.nextLine(); // Membersihkan buffer
            System.out.print("Masukkan Nama Kasir: ");
            String namaKasir = scanner.nextLine();
            if (namaKasir.isEmpty()) {
                throw new IllegalArgumentException("Nama Kasir tidak boleh kosong!");
            }

            // Membuat objek Faktur
            Faktur faktur = new Faktur(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Menampilkan faktur
            System.out.println("\n--- Detail Faktur Pembelian ---");
            System.out.println("=======================================================");
            faktur.tampilkanFaktur();
            System.out.println("Kasir : " + namaKasir);
            System.out.println("=======================================================");

        } catch (IllegalArgumentException e) {
            // Menangani exception jika input tidak valid
            System.out.println("Error: " + e.getMessage());
            System.out.println("=======================================================\n");
        } catch (Exception e) {
            // Menangani exception lainnya
            System.out.println("Terjadi kesalahan: " + e.getMessage());
            System.out.println("=======================================================\n");
        } finally {
            scanner.close();
        }
    }
}
