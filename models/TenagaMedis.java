package models;

public abstract class TenagaMedis {
    private String id;
    private String nama;
    private double gajiPokok;
    private JenisTenagaMedis jenisTenagaMedis;

    public TenagaMedis(JenisTenagaMedis jenisTenagaMedis, String id, String nama, double gajiPokok){
        this.jenisTenagaMedis = jenisTenagaMedis;
        this.id = id;
        this.nama = nama;
        this.gajiPokok = gajiPokok;
    }

    public JenisTenagaMedis getNamaJenisTenagaMedis(){
        return this.jenisTenagaMedis;
    }

    public String getNamaString(){
        switch (jenisTenagaMedis) {
            case DOKTER:
                return "Dokter";
            case ADMINISTRASI:
                return "Administrasi";
            case PERAWAT:
                return "Perawat";
            default:
                return "Unknown";
        }
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getNama(){
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getGajiPokok(){
        return gajiPokok;
    }
     public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }
    public abstract double hitungTotalGaji();

    public String getInfo(){
        return "ID: " + id + "\nNama: " + nama + "\nGaji Pokok: " + gajiPokok;
    }

}
