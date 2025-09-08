package com.mycompany.memancing;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Inner class untuk data aktivitas
    static class Aktivitas {
        String lokasi;
        String tanggal;
        String jenisIkan;
        int jumlah;

        Aktivitas(String lokasi, String tanggal, String jenisIkan, int jumlah) {
            this.lokasi = lokasi;
            this.tanggal = tanggal;
            this.jenisIkan = jenisIkan;
            this.jumlah = jumlah;
        }
    }

    public static void main(String[] args) {
        ArrayList<Aktivitas> daftarAktivitas = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== SISTEM PENCATATAN AKTIVITAS MEMANCING ===");
            System.out.println("1. Tambah Aktivitas");
            System.out.println("2. Lihat Aktivitas");
            System.out.println("3. Ubah Aktivitas");
            System.out.println("4. Hapus Aktivitas");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // clear buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Lokasi: ");
                    String lokasi = input.nextLine();
                    System.out.print("Masukkan Tanggal (dd-mm-yyyy): ");
                    String tanggal = input.nextLine();
                    System.out.print("Masukkan Jenis Ikan: ");
                    String jenisIkan = input.nextLine();
                    System.out.print("Masukkan Jumlah Ikan: ");
                    int jumlah = input.nextInt();

                    daftarAktivitas.add(new Aktivitas(lokasi, tanggal, jenisIkan, jumlah));
                    System.out.println("Aktivitas berhasil ditambahkan!");
                    break;

                case 2:
                    if (daftarAktivitas.isEmpty()) {
                        System.out.println("Belum ada aktivitas.");
                    } else {
                        System.out.println("\nDaftar Aktivitas:");
                        for (int i = 0; i < daftarAktivitas.size(); i++) {
                            Aktivitas a = daftarAktivitas.get(i);
                            System.out.println((i+1) + ". Lokasi: " + a.lokasi +
                                    " | Tanggal: " + a.tanggal +
                                    " | Jenis Ikan: " + a.jenisIkan +
                                    " | Jumlah: " + a.jumlah);
                        }
                    }
                    break;

                case 3:
                    if (daftarAktivitas.isEmpty()) {
                        System.out.println("Tidak ada data untuk diubah.");
                    } else {
                        System.out.print("Nomor aktivitas yang diubah: ");
                        int idx = input.nextInt() - 1;
                        input.nextLine();

                        if (idx >= 0 && idx < daftarAktivitas.size()) {
                            Aktivitas a = daftarAktivitas.get(idx);
                            System.out.print("Lokasi baru: ");
                            a.lokasi = input.nextLine();
                            System.out.print("Tanggal baru: ");
                            a.tanggal = input.nextLine();
                            System.out.print("Jenis Ikan baru: ");
                            a.jenisIkan = input.nextLine();
                            System.out.print("Jumlah baru: ");
                            a.jumlah = input.nextInt();

                            System.out.println("Data berhasil diubah!");
                        } else {
                            System.out.println("Nomor tidak valid.");
                        }
                    }
                    break;

                case 4:
                    if (daftarAktivitas.isEmpty()) {
                        System.out.println("Tidak ada data untuk dihapus.");
                    } else {
                        System.out.print("Nomor aktivitas yang dihapus: ");
                        int idxHapus = input.nextInt() - 1;

                        if (idxHapus >= 0 && idxHapus < daftarAktivitas.size()) {
                            daftarAktivitas.remove(idxHapus);
                            System.out.println("Data berhasil dihapus!");
                        } else {
                            System.out.println("Nomor tidak valid.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Salam satu joran. Sampai jumpa!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 5);
    }
}
