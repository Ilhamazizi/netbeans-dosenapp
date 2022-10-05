package com.app.entity;

import java.sql.ResultSet;    
import java.sql.SQLException;
/**
 *
 * @author casper
 */
public class Dosen {
    private int id;
    private String nama;
    private String kompetensi;
    
    public Dosen() {
        
    }
    
    public Dosen(int id, String nama, String kompetensi) {
        this.id = id;
        this.nama = nama;
        this.kompetensi = kompetensi;
    }
    
    public Dosen(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.nama = rs.getString("nama");
        this.kompetensi = rs.getString("kompetensi");
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getKompetensi() {
        return kompetensi;
    }
    
    public void setKompetensi(String kompetensi) {
        this.kompetensi = kompetensi;
    }
}
