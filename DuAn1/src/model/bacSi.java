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
public class bacSi {
    String MaBacSi;
    String MaKhoa;
    String TenBacSi;
    String NgaySinh;
    String DiaChi;
    String DienThoai;
    String AnhBacSi;

    public bacSi() {
    }

    public bacSi(String MaBacSi, String MaKhoa, String TenBacSi, String NgaySinh, String DiaChi, String DienThoai, String AnhBacSi) {
        this.MaBacSi = MaBacSi;
        this.MaKhoa = MaKhoa;
        this.TenBacSi = TenBacSi;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.AnhBacSi = AnhBacSi;
    }

    public String getMaBacSi() {
        return MaBacSi;
    }

    public void setMaBacSi(String MaBacSi) {
        this.MaBacSi = MaBacSi;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String MaKhoa) {
        this.MaKhoa = MaKhoa;
    }

    public String getTenBacSi() {
        return TenBacSi;
    }

    public void setTenBacSi(String TenBacSi) {
        this.TenBacSi = TenBacSi;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getAnhBacSi() {
        return AnhBacSi;
    }

    public void setAnhBacSi(String AnhBacSi) {
        this.AnhBacSi = AnhBacSi;
    }
    
            
    
    
}
