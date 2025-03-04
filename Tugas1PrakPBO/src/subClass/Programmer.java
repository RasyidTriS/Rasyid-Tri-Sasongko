package subClass;

import interfaces.BonusTahunan;
import abstracts.Pegawai;
import java.util.List;

public class Programmer extends Pegawai implements BonusTahunan {
    private List<String> bahasaPemrograman;

    // Konstruktor
    public Programmer(String nama, double gaji, List<String> bahasaPemrograman) {
        super(nama, gaji);
        this.bahasaPemrograman = bahasaPemrograman;
    }

    // Getter dan Setter
    public List<String> getBahasaPemrograman() {
        return bahasaPemrograman;
    }

    public void setBahasaPemrograman(List<String> bahasaPemrograman) {
        this.bahasaPemrograman = bahasaPemrograman;
    }

    // Implementasi method abstrak
    @Override
    public void tampilkanInfo() {
        System.out.println("Nama: " + getNama());
        System.out.println("Gaji: " + getGaji());
        System.out.println("Bidang Pekerjaan: Programmer");
        System.out.println("Bahasa Pemrograman: " + String.join(", ", bahasaPemrograman));
    }

    // Implementasi method interface
    @Override
    public double hitungBonus() {
        return getGaji() * 0.10;  // Bonus 10% dari gaji
    }
}