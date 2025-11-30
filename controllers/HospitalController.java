package controllers;

import java.util.ArrayList;

import exceptions.DataNotFoundException;
import exceptions.InvalidDataException;
import models.Administrasi;
import models.Dokter;
import models.Perawat;
import models.TenagaMedis;

public class HospitalController {
    ArrayList<TenagaMedis> listTenagaMedis;

    public HospitalController(){
        this.listTenagaMedis = new ArrayList<>();
    }

    private void validateInput(String nama, double gajiPokok) throws InvalidDataException{
        if (nama.isEmpty()) {
            throw new InvalidDataException("nama tidak bolehh kosong");
        }

        if (gajiPokok < 0) {
            throw new InvalidDataException("gaji yang anda masukan tidak boleh negatif, input anda: " + gajiPokok);
        }
    }

    public void addTenagaMedis(String id, String nama, double gajiPokok, double tarifKonsultasi, int jumlahPasien, int jamJagaMalam) throws InvalidDataException{
        validateInput(nama, gajiPokok);
        if (jamJagaMalam < 0 || jumlahPasien < 0 || tarifKonsultasi < 0) {
            throw new InvalidDataException("input tidak valid (tidak boleh negatif)");
        }

        this.listTenagaMedis.add(new Dokter(id, nama, gajiPokok, tarifKonsultasi, jumlahPasien, jamJagaMalam));
    }

    public void addTenagaMedis(String id, String nama, double gajiPokok, int jumlahLembur, int jamJagaMalam) throws InvalidDataException{
        validateInput(nama, gajiPokok);
        if (jumlahLembur < 0 || jamJagaMalam < 0) {
            throw new InvalidDataException("input tidak valid (tidak boleh negatif)");
        }

        this.listTenagaMedis.add(new Perawat(id, nama, gajiPokok, jumlahLembur, jamJagaMalam));
    }

    public void addTenagaMedis(String id, String nama, double gajiPokok, double tunjanganKehadiran) throws InvalidDataException{
        validateInput(nama, gajiPokok);
        if (tunjanganKehadiran < 0) {
            throw new InvalidDataException("input tidak valid (tidak boleh negatif), input anda: " + tunjanganKehadiran);
        }
        this.listTenagaMedis.add(new Administrasi(id, nama, gajiPokok, tunjanganKehadiran));
    }

    public ArrayList<TenagaMedis> getAllObjects(){
        return this.listTenagaMedis;
    }

    public double hitungTotalPengeluaran(){
        double totalPengeluaran = 0;

        for (TenagaMedis tenagaMedis : listTenagaMedis) {
            totalPengeluaran += tenagaMedis.hitungTotalGaji();
        }
        
        return totalPengeluaran;
    }

    public void deleteTenagaMedis(String id) throws DataNotFoundException{
        TenagaMedis tenagaMedisTarget = null;
        for (TenagaMedis tenagaMedis : listTenagaMedis) {
            if (tenagaMedis.getId().equalsIgnoreCase(id)) {
                tenagaMedisTarget = tenagaMedis;
                break;
            }
        }

        if (tenagaMedisTarget != null) {
            this.listTenagaMedis.remove(tenagaMedisTarget);
        } else {
            throw new DataNotFoundException("Tenaga medis dengan id: " + id + " tidak di temukan");
        }
    }




}
