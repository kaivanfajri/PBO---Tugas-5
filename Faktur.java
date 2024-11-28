public class Faktur extends Barang {
    // Class Faktur merupakan child class dari Class Barang
    private String noFaktur;
    private int jumlahBeli;

    public Faktur(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang); // Pemanggilan constructor dari parent class
        this.noFaktur = noFaktur;
        this.jumlahBeli = jumlahBeli;
    }

    // Method untuk menghitung total
    public double hitungTotal() {
        return hargaBarang * jumlahBeli;
    }

    // Method untuk menampilkan informasi faktur
    public void tampilkanFaktur() {
        System.out.println("No. Faktur      : " + noFaktur);
        System.out.println("Kode Barang     : " + kodeBarang);
        System.out.println("Nama Barang     : " + namaBarang);
        System.out.println("Harga Barang    : " + hargaBarang);
        System.out.println("Jumlah Beli     : " + jumlahBeli);
        System.out.println("TOTAL           : " + hitungTotal());
    }
}
