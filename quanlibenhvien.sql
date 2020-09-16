use master
go 
drop database QLBenhVien
go
create database QLBenhVien
go
use QLBenhVien
go
create table NguoiDung(
	TenDangNhap varchar(20) primary key,
	MatKhau varchar(20),
	VaiTro varchar(20)
)
go
create table NhanVien(
	MaNhanVien varchar(20) primary key,
	TenNhanVien nvarchar(50),
	NgaySinh date,
	DiaChi nvarchar(50),
	DienThoai char(10),
	AnhNhanVien nvarchar(50)
)
go
create table HoSoBenhAn(
	MaHoSo varchar(20) primary key,
	HoTen nvarchar(50),
	GioiTinh bit,
	NgaySinh date,
	DiaChi nvarchar(50),
	DienThoai char(10),
	NgayLapHoSo date,
	NgayHetHanHoSo date,
	MaNhanVien varchar(20),
	foreign key (MaNhanVien) references NhanVien(MaNhanVien)
)
go
create table PhieuDangKiKhamBenh(
	SoPhieuDangKiKhamBenh int primary key,
	MaHoSo varchar(20),
	MaNhanVien varchar(20),
	foreign key (MaHoSo) references HoSoBenhAn(MaHoSo),
	foreign key (MaNhanVien) references NhanVien(MaNhanVien)
)
go

create table VienPhi(
	MaHoaDonVienPhi varchar(20),
	SoTienVienPhi int,
	NgayDongVienPhi date,
	MaHoSo varchar(20)
	foreign key (MaHoSo) references HoSoBenhAn(MaHoSo)
)
go
create table Khoa(
	MaKhoa varchar(20) primary key,
	TenKhoa nvarchar(50)
)
go
create table Thuoc(
	MaThuoc varchar(20) primary key,
	TenThuoc nvarchar(50),
)
go
create table BacSi(
	MaBacSi varchar(20) primary key,
	MaKhoa varchar(20),
	TenBacSi nvarchar(50),
	NgaySinh date,
	DiaChi nvarchar(50),
	DienThoai char(10),
	AnhBacSi nvarchar(50)
	foreign key (MaKhoa) references Khoa(MaKhoa)
)
go
create table PhieuKhamBenh(
	SoPhieuKhamBenh varchar(20) primary key,
	MaHoSo varchar(20),
	MaBacSi varchar(20),
	TenBenh nvarchar(50),
	NgayKhamBenh date
	foreign key (MaHoSo) references HoSoBenhAn(MaHoSo),
	foreign key (MaBacSi) references BacSi(MaBacSi)
)
go
create table ToaThuoc(
	SoPhieuKhamBenh varchar(20) primary key,
	 MaThuoc varchar(20),
	 CachSuDung nvarchar(50),
	 foreign key (SoPhieuKhamBenh) references PhieuKhamBenh(SoPhieuKhamBenh),
	 foreign key (MaThuoc) references Thuoc(MaThuoc)
)
go

---- thêm nguoidung
insert into NguoiDung
	values('admin','admin','admin')
insert into NguoiDung
	values('tung','123','BS')
insert into NguoiDung
	values('nhi','123123','NV')
	select * from NguoiDung where TenDangNhap='Nhi' and MatKhau='123123'
	------------------------------------------
insert into NhanVien
	values('NV001',N'Nguyễn  Trung','01/02/1980',N'Bình Thạnh','098525462','trung.png')
insert into NhanVien
	values('NV002',N'Lê Bảo ','10/05/1990',N'Quận 7','085225462','binh.jpg')
insert into NhanVien
	values('NV003',N'Đài Trang','11/03/1991',N'Quận 5','096985462','trang.jpg')
insert into NhanVien
	values('NV004',N'Nguyễn Lập','09/05/1978',N'Thủ Đức','098568562','lap.png')
	select * from NhanVien
---------------------------
-------- hosobenhan
insert into HoSoBenhAn
	values('BA001',N'Phạm Văn Tùng',1,'01/05/1990',N'Tân Phú','0985215635','08/02/2017','08/02/2018','NV001')
insert into HoSoBenhAn
	values('BA002',N'Hoàng Thị Vy',0,'10/18/2000',N'Quận 9','0925815115','10/10/2018','10/10/2019','NV002')
insert into HoSoBenhAn
	values('BA003',N'Phạm Hùng Hồ',1,'11/07/2002',N'Quận 8','0854215635','08/02/2017','08/02/2018','NV003')
insert into HoSoBenhAn
	values('BA004',N'Lê Thị Loan',0,'02/10/1990',N'Quận 9','0985315115','05/01/2019','05/01/2020','NV004')
	select * from HoSoBenhAn
	---------------
insert into PhieuDangKiKhamBenh
	values('1110','BA001','NV001')
insert into PhieuDangKiKhamBenh
	values('1111','BA002','NV002')
insert into PhieuDangKiKhamBenh
	values('1112','BA003','NV003')
insert into PhieuDangKiKhamBenh
	values('2012','BA004','NV004')
insert into PhieuDangKiKhamBenh
	values('2013','BA001','NV003')
	select * from PhieuDangKiKhamBenh
	-----------------------
insert into VienPhi
	values('HDVP01','2000000','08/02/2017','BA001')
insert into VienPhi
	values('HDVP02','5000000','10/10/2018','BA002')
insert into VienPhi
	values('HDVP03','3500000','08/02/2017','BA003')
insert into VienPhi
	values('HDVP04','10000000','05/01/2019','BA004')
	SELECT * FROM VienPhi
	----------
insert into Khoa
	values('KNTH',N'Khoa ngoại tổng hợp')
insert into Khoa
	values('KCXK',N'Khoa cơ xương khớp')
insert into Khoa
	values('KTMH',N'Khoa tai mũi họng')
insert into Khoa
	values('KNSH',N'Khoa nhịp sinh học')
	select * from Khoa
------------
insert into Thuoc
	values('THUOC01',N'Thuốc gây mê')
insert into Thuoc
	values('THUOC02',N'Thuốc chống dị ứng')
insert into Thuoc
	values('THUOC03',N'Thuốc chống dị ứng')
insert into Thuoc
	values('THUOC04',N'Thuốc chống dị ứng')
insert into Thuoc
	values('THUOC05 ',N'Thuốc chống tiêu chảy')
	select * from Thuoc
------------------------
insert into BacSi
	values('BS001','KNTH',N'Nguyễn Chí Trung','01/02/1980',N'Bình Thạnh','098525462','trung.png')
insert into BacSi
	values('BS002','KCXK',N'Lê Bảo Bình','10/05/1990',N'Quận 7','085225462','binh.jpg')
insert into BacSi
	values('BS003','KTMH',N'Nguyễn Đài Trang','11/03/1991',N'Quận 5','096985462','trang.jpg')
insert into BacSi
	values('BS004','KNSH',N'Nguyễn Văn Lập','09/05/1978',N'Thủ Đức','098568562','lap.png')
	select * from BacSi
---------------------------
insert into PhieuKhamBenh
	values('SPKB01','BA001','BS001',N'Gãy tay','01/02/2019')
insert into PhieuKhamBenh
	values('SPKB02','BA002','BS002',N'Tắc nghẽn mạch máu','01/02/2019')
insert into PhieuKhamBenh
	values('SPKB03','BA003','BS003',N'Gãy chân','01/02/2017')
insert into PhieuKhamBenh
	values('SPKB04','BA004','BS004',N'Tay chân miệng','01/05/2018')

	select * from PhieuKhamBenh
	--------------
insert into ToaThuoc
	values('SPKB01','THUOC01',N'Ngày uống 2 lần')
insert into ToaThuoc
	values('SPKB02','THUOC02',N'Uống sau khi ăn')
insert into ToaThuoc
	values('SPKB03','THUOC03',N'Uống trước khi ăn')
insert into ToaThuoc
	values('SPKB04','THUOC04',N'Ngày uống 2 lần')
insert into ToaThuoc
	values('SPKB04','THUOC05',N'Ngày uống 2 lần')
	select * from ToaThuoc

	select SoPhieuKhamBenh from PhieuKhamBenh
	select PhieuKhamBenh.SoPhieuKhamBenh,MaHoSo,MaBacSi,TenBenh,NgayKhamBenh,MaThuoc,CachSuDung  from PhieuKhamBenh,ToaThuoc where PhieuKhamBenh.SoPhieuKhamBenh = ToaThuoc.SoPhieuKhamBenh
