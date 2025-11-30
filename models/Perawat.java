package models;

public class Perawat extends TenagaMedis implements JagaMalam{
    private int jumlahLembur;
    private int jamJagaMalam;

    public Perawat(String id, String nama, double gajiPokok, int jumlahLembur, int jamJagaMalam){
        super(JenisTenagaMedis.PERAWAT, id, nama, gajiPokok);
        this.jumlahLembur = jumlahLembur;
        this.jamJagaMalam = jamJagaMalam;
    }

    public int getJumlahLembur(){
        return jumlahLembur;
    }
    public void setJumlahLembur(int jumlahLembur){
        this.jumlahLembur = jumlahLembur;
    }
    
    public int getJamJagaMalam(){
        return jamJagaMalam;
    }
    public void setJamJagaMalam(int jamJagaMalam){
        this.jamJagaMalam = jamJagaMalam;
    }

    @Override
    public void tambahShiftMalam(int jumlahJam){
        System.out.println("Shift malam: " + jumlahJam);
    }

    @Override
    public double hitungBonusMalam(){
        return jamJagaMalam * 50000;
    }

    @Override
    public double hitungTotalGaji(){
        return getGajiPokok() + (jumlahLembur * 50000) + hitungBonusMalam();
    }

    @Override 
    public String getInfo(){
        return "Status: " + super.getNamaString() + "ID: " + getId() + "\nNama: " + getNama() + "\nGaji Pokok: " + getGajiPokok() + "\nJumlah lembur: " + jumlahLembur + "\nJam Jaga Malam: " + jamJagaMalam + "\ntotal gaji: " + hitungTotalGaji() + "\nBonus Malam: " + hitungBonusMalam(); 
    }
}
