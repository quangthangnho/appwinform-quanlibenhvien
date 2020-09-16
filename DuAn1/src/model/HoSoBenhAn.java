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
public class HoSoBenhAn {
    String maHoSo;
    String hoTen;
    boolean gioiTinh;
    String ngaySinh;
    String diaChi;
    String dienThoai;
    String ngayLapHS;
    String ngayHetHanHS;
    String maNhanVien;

    public HoSoBenhAn() {
    }

    public HoSoBenhAn(String maHoSo, String hoTen, boolean gioiTinh, String ngaySinh, String diaChi, String dienThoai, String ngayLapHS, String ngayHetHanHS, String maNhanVien) {
        this.maHoSo = maHoSo;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.ngayLapHS = ngayLapHS;
        this.ngayHetHanHS = ngayHetHanHS;
        this.maNhanVien = maNhanVien;
    }

    public String getMaHoSo() {
        return maHoSo;
    }

    public void setMaHoSo(String maHoSo) {
        this.maHoSo = maHoSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getNgayLapHS() {
        return ngayLapHS;
    }

    public void setNgayLapHS(String ngayLapHS) {
        this.ngayLapHS = ngayLapHS;
    }

    public String getNgayHetHanHS() {
        return ngayHetHanHS;
    }

    public void setNgayHetHanHS(String ngayHetHanHS) {
        this.ngayHetHanHS = ngayHetHanHS;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    
    
}
