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
public class HoaDonVienPhi {
    String MaHoaDonVP;
    String tienVP;
    String ngayDongVP;
    String maHS;

    public HoaDonVienPhi() {
    }

    public HoaDonVienPhi(String MaHoaDonVP, String tienVP, String ngayDongVP, String maHS) {
        this.MaHoaDonVP = MaHoaDonVP;
        this.tienVP = tienVP;
        this.ngayDongVP = ngayDongVP;
        this.maHS = maHS;
    }

    public String getMaHoaDonVP() {
        return MaHoaDonVP;
    }

    public void setMaHoaDonVP(String MaHoaDonVP) {
        this.MaHoaDonVP = MaHoaDonVP;
    }

    public String getTienVP() {
        return tienVP;
    }

    public void setTienVP(String tienVP) {
        this.tienVP = tienVP;
    }

    public String getNgayDongVP() {
        return ngayDongVP;
    }

    public void setNgayDongVP(String ngayDongVP) {
        this.ngayDongVP = ngayDongVP;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }
    
}
