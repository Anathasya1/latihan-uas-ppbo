package models;

public class Dokter extends TenagaMedis implements JagaMalam{
    private double tarifKonsultasi;
    private int jumlahPasien;
    private int jamJagaMalam;
    
    public Dokter(String id, String nama, double gajiPokok, double tarifKonsultasi, int jumlahPasien, int jamJagaMalam){
        super(JenisTenagaMedis.DOKTER, id, nama, gajiPokok);
        this.tarifKonsultasi = tarifKonsultasi;
        this.jumlahPasien = jumlahPasien;
        this.jamJagaMalam = jamJagaMalam;
    }

    public double getTarifKonsultasi(){
        return tarifKonsultasi;
    }
    public void setTarifKonsultasi(double tarifKonsultasi){
        this.tarifKonsultasi = tarifKonsultasi;
    }

    public int getJumlahPasien(){
        return jumlahPasien;
    }
    public void setJumlahPasien(int jumlahPasien){
        this.jumlahPasien = jumlahPasien;
    }

    public int getJamJagaMalam(){
        return jamJagaMalam;
    }
    public void setJamJagaMalam(int jamJagaMalam){
        this.jamJagaMalam = jamJagaMalam;
    }
    
    @Override
    public double hitungBonusMalam(){
        return jamJagaMalam * 100000;
    }

    @Override
    public double hitungTotalGaji(){
        return getGajiPokok() + (tarifKonsultasi * jumlahPasien) + hitungBonusMalam();
    }

    @Override
    public void tambahShiftMalam(int jumlahJam){
        System.out.println("jam jaga malam: " + jumlahJam);
    }

    @Override 
    public String getInfo(){
        return "Status: " + super.getNamaString() + "ID: " + getId() + "\nNama: " + getNama() + "\nGaji Pokok: " + getGajiPokok() + "\nTarif Konsultasi: " + tarifKonsultasi + "\njumlah pasien: " + jumlahPasien + "\njam jaga malam: " + jamJagaMalam + "\nBonus Malam: " + hitungBonusMalam(); 
    }

    
}
