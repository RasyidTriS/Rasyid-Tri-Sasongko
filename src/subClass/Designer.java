package subClass;

import interfaces.BonusTahunan;
import abstracts.Pegawai;
import java.util.List;

public class Designer extends Pegawai implements BonusTahunan {
    private List<String> softwareDesain;

    // Konstruktor
    public Designer(String nama, double gaji, List<String> softwareDesain) {
        super(nama, gaji);
        this.softwareDesain = softwareDesain;
    }

    // Getter dan Setter
    public List<String> getSoftwareDesain() {
        return softwareDesain;
    }

    public void setSoftwareDesain(List<String> softwareDesain) {
        this.softwareDesain = softwareDesain;
    }

    // Implementasi method abstrak
    @Override
    public void tampilkanInfo() {
        System.out.println("Nama: " + getNama());
        System.out.println("Gaji: " + getGaji());
        System.out.println("Bidang Pekerjaan: Designer");
        System.out.println("Software Desain: " + String.join(", ", softwareDesain));
    }

    // Implementasi method interface
    @Override
    public double hitungBonus() {
        return getGaji() * 0.08;  // Bonus 8% dari gaji
    }
}