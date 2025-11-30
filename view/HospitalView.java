package view;

import java.util.ArrayList;

import controllers.HospitalController;
import exceptions.DataNotFoundException;
import exceptions.InvalidDataException;
import models.TenagaMedis;
import utils.CLIUtil;

public class HospitalView {
    HospitalController hospitalController;

    public HospitalView(){
        this.hospitalController = new HospitalController();
    }

    public void menuUtama(){
        int menu = -1;

        while (menu != 0) {
            System.out.print("""
                    Menu: 
                    \n1. Tambah Tenaga medis
                    \n2. Lihat Daftar
                    \n3. Hitung total Pengeluaran
                    \n4. Hapus
                    \nInput menu: 
                    """);
            menu = CLIUtil.getInt();

            switch (menu) {
                case 1:
                    System.out.print("""
                            1.Dokter
                            \n2. Perawat
                            \n3. Administrasi
                            \nMasukkan tipe tenaga medis yang ingin ditambahkan: 
                            """);
                    int jenisTenagaMedis = CLIUtil.getInt();
                    addTenagaMedis(jenisTenagaMedis);
                    break;
                case 2:
                    printListView();
                    break;
                case 3:
                    double total = hospitalController.hitungTotalPengeluaran();
                    System.out.println("Total pengeluaran: " + total);
                    break;
                case 4:
                    deleteTenagaMedis();
                    break;
            
                default:
                    break;
            }
        }
    }

    public void addTenagaMedis(int tipeTenagaMedis){
        System.out.print("Masukkan id: ");
        String inputId = CLIUtil.getString();
        System.out.print("Masukkan Nama: ");
        String inputNama = CLIUtil.getString();
        System.out.print("Masukkan gaji pokok: ");
        double inputGajiPokok = CLIUtil.getDouble();

        try {
            switch (tipeTenagaMedis) {
            case 1:
                System.out.print("Masukkan tarif konsultasi: ");
                double inputTarifKonsultasi = CLIUtil.getDouble();
                System.out.print("Masukkan jumlah pasien: ");
                int inputJumlahPasien = CLIUtil.getInt();
                System.out.print("Masukkan jam jaga malam: ");
                int inputJamJagaMalem = CLIUtil.getInt();
                hospitalController.addTenagaMedis(inputId, inputNama, inputGajiPokok, inputTarifKonsultasi, inputJumlahPasien, inputJamJagaMalem);
                break;
            case 2:
                System.out.print("Masukkan Jumlah lembur: ");
                int inputJumlahLembur = CLIUtil.getInt();
                System.out.print("Masukkan jam jaga malam: ");
                inputJamJagaMalem = CLIUtil.getInt();  
                hospitalController.addTenagaMedis(inputId, inputNama, inputGajiPokok, inputJumlahLembur, inputJamJagaMalem);
                break;
            case 3:
                System.out.print("Masukkan tunjangan kehadiran: ");
                int inputTunjanganJagaMalam = CLIUtil.getInt();
                hospitalController.addTenagaMedis(inputId, inputNama, inputGajiPokok, inputTunjanganJagaMalam);           
                break;
            default:
                break;
        }
            
        } catch (InvalidDataException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }

    public void printListView(){
        var listTenagaMedis = hospitalController.getAllObjects();
        printListView(listTenagaMedis);
    }
    private void printListView(ArrayList<TenagaMedis> listTenagaMedis){
        for (int i = 0; i < listTenagaMedis.size(); i++) {
            TenagaMedis tenagaMedis = listTenagaMedis.get(i);
            String tipe = tenagaMedis.getNamaString();
            String id = tenagaMedis.getId();
            String nama = tenagaMedis.getNama();
            double gajiPokok = tenagaMedis.getGajiPokok();
            double totalGaji = tenagaMedis.hitungTotalGaji();
            System.out.println("Tipe tenaga medis: " + tipe + "\nid: " + id + "\nNama: " + nama + "\nGaji pokok: " + gajiPokok + "\nTotal Gaji: " + totalGaji);
        }
    }

    public void deleteTenagaMedis(){
        System.out.print("Masukkan id: ");
        String inputId = CLIUtil.getString();

        try {
            hospitalController.deleteTenagaMedis(inputId);
            System.out.println("Berhasil di hapus id " + inputId);
        } catch (DataNotFoundException e) {
            System.out.println("Gagal hapus: " + e.getMessage());
        }   
    }
}
