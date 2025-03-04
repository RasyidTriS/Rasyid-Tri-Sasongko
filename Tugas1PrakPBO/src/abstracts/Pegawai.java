package abstracts;

public abstract class Pegawai {
    private String nama;    // Encapsulation: atribut private
    private double gaji;

    // Konstruktor
    public Pegawai(String nama, double gaji) {
        this.nama = nama;
        setGaji(gaji);  // Validasi gaji dilakukan di setter
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        if (gaji < 0) {
            throw new IllegalArgumentException("Gaji tidak boleh negatif");
        }
        this.gaji = gaji;
    }

    // Method abstrak
    public abstract void tampilkanInfo();
}