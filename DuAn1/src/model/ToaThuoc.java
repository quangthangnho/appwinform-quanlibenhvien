/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Quang
 */
public class ToaThuoc {
    String SoPhieuKhamBenh;
    String MaThuoc;
    String CachSuDung;

    public ToaThuoc() {
    }

    public ToaThuoc(String SoPhieuKhamBenh, String MaThuoc, String CachSuDung) {
        this.SoPhieuKhamBenh = SoPhieuKhamBenh;
        this.MaThuoc = MaThuoc;
        this.CachSuDung = CachSuDung;
    }

    public String getSoPhieuKhamBenh() {
        return SoPhieuKhamBenh;
    }

    public void setSoPhieuKhamBenh(String SoPhieuKhamBenh) {
        this.SoPhieuKhamBenh = SoPhieuKhamBenh;
    }

    public String getMaThuoc() {
        return MaThuoc;
    }

    public void setMaThuoc(String MaThuoc) {
        this.MaThuoc = MaThuoc;
    }

    public String getCachSuDung() {
        return CachSuDung;
    }

    public void setCachSuDung(String CachSuDung) {
        this.CachSuDung = CachSuDung;
    }
    
    
}
