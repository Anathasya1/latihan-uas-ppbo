package models;

public class Administrasi extends TenagaMedis{
    private double tunjanganKehadiran;

    public Administrasi(String id, String nama, double gajiPokok, double tunjanganKehadiran) {
        super(JenisTenagaMedis.ADMINISTRASI, id, nama, gajiPokok);
        this.tunjanganKehadiran = tunjanganKehadiran;
    }

    public double getTunjanganKehadiran(){
        return tunjanganKehadiran;
    }
    public void setTunjanganKehadiran(double tunjanganKehadiran){
        this.tunjanganKehadiran = tunjanganKehadiran;
    }

    @Override
    public double hitungTotalGaji(){
        return getGajiPokok() + tunjanganKehadiran;
    }

    @Override
    public String getInfo(){
        return "Status: " + super.getNamaString() + "ID: " + getId() + "\nNama: " + getNama() + "\nGaji Pokok: " + getGajiPokok() + "\nTunjangan kehadiran: " + tunjanganKehadiran + "\ntotal gaji: " + hitungTotalGaji();
    }
}
