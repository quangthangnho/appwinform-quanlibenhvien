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
public class phieuKhamBenh {
    String SoPhieuKhamBenh;
    String MaHoSo;
    String MaBacSi;
    String TenBenh;
    String NgayKhamBenh;

    public phieuKhamBenh() {
    }

    public phieuKhamBenh(String SoPhieuKhamBenh, String MaHoSo, String MaBacSi, String TenBenh, String NgayKhamBenh) {
        this.SoPhieuKhamBenh = SoPhieuKhamBenh;
        this.MaHoSo = MaHoSo;
        this.MaBacSi = MaBacSi;
        this.TenBenh = TenBenh;
        this.NgayKhamBenh = NgayKhamBenh;
    }

    public String getSoPhieuKhamBenh() {
        return SoPhieuKhamBenh;
    }

    public void setSoPhieuKhamBenh(String SoPhieuKhamBenh) {
        this.SoPhieuKhamBenh = SoPhieuKhamBenh;
    }

    public String getMaHoSo() {
        return MaHoSo;
    }

    public void setMaHoSo(String MaHoSo) {
        this.MaHoSo = MaHoSo;
    }

    public String getMaBacSi() {
        return MaBacSi;
    }

    public void setMaBacSi(String MaBacSi) {
        this.MaBacSi = MaBacSi;
    }

    public String getTenBenh() {
        return TenBenh;
    }

    public void setTenBenh(String TenBenh) {
        this.TenBenh = TenBenh;
    }

    public String getNgayKhamBenh() {
        return NgayKhamBenh;
    }

    public void setNgayKhamBenh(String NgayKhamBenh) {
        this.NgayKhamBenh = NgayKhamBenh;
    }
    
}
