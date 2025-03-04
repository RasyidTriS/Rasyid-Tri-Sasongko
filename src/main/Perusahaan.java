package main;

import subClass.Designer;
import subClass.Programmer;
import interfaces.BonusTahunan;
import abstracts.Pegawai;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perusahaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pegawai> daftarPegawai = new ArrayList<>();  // Polymorphism: menyimpan berbagai jenis Pegawai

        // Input data Programmer
        System.out.println("Masukkan data Programmer:");
        String namaProgrammer = inputNama(scanner);
        double gajiProgrammer = inputGaji(scanner);
        List<String> bahasaPemrograman = inputList(scanner, "Bahasa Pemrograman");
        Programmer programmer = new Programmer(namaProgrammer, gajiProgrammer, bahasaPemrograman);
        daftarPegawai.add(programmer);

        // Input data Designer
        System.out.println("\nMasukkan data Designer:");
        String namaDesigner = inputNama(scanner);
        double gajiDesigner = inputGaji(scanner);
        List<String> softwareDesain = inputList(scanner, "Software Desain");
        Designer designer = new Designer(namaDesigner, gajiDesigner, softwareDesain);
        daftarPegawai.add(designer);

        // Menampilkan informasi semua pegawai
        System.out.println("\nInformasi Pegawai:");
        for (Pegawai pegawai : daftarPegawai) {
            pegawai.tampilkanInfo();
            if (pegawai instanceof BonusTahunan) {
                System.out.println("Bonus Tahunan: " + ((BonusTahunan) pegawai).hitungBonus());
            }
            System.out.println();
        }

        scanner.close();
    }

    // Method untuk input nama
    private static String inputNama(Scanner scanner) {
        System.out.print("Nama: ");
        return scanner.nextLine();
    }

    // Method untuk input gaji dengan exception handling
    private static double inputGaji(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Gaji: ");
                String input = scanner.nextLine();
                double gaji = Double.parseDouble(input);
                if (gaji < 0) {
                    throw new IllegalArgumentException("Gaji tidak boleh negatif");
                }
                return gaji;
            } catch (NumberFormatException e) {
                System.out.println("Error: Input harus berupa angka.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Silakan masukkan kembali.");
            }
        }
    }

    // Method untuk input list (bahasa pemrograman atau software desain)
    private static List<String> inputList(Scanner scanner, String jenis) {
        System.out.print(jenis + " (pisahkan dengan koma): ");
        String input = scanner.nextLine();
        String[] items = input.split(",");
        List<String> list = new ArrayList<>();
        for (String item : items) {
            list.add(item.trim());  // Menghapus spasi berlebih
        }
        return list;
    }
}