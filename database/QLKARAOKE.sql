CREATE DATABASE QLYKARAOKE
USE QLYKARAOKE
Drop database QLYKARAOKE


--Tạo bảng Nhân Viên
CREATE TABLE tb_nhanvien(
ma_nv int IDENTITY(1,1) PRIMARY KEY NOT NULL,
username nvarchar(40) NOT NULL,
password nvarchar(40) NOT NULL,
name nvarchar(40) NOT NULL,
gioi_tinh nvarchar(20) NOT NULL,
phone int NOT NULL,
email nvarchar(40)
)

--Tạo bảng Khách Hàng
CREATE TABLE tb_khachhang(
ma_kh int IDENTITY(1,1) PRIMARY KEY NOT NULL,
ho_ten nvarchar(40) NOT NULL,
phone int,
dia_chi nvarchar(40),
ngay_sinh date,
)

--Tạo bảng Phòng
CREATE TABLE tb_phong(
ma_phong int IDENTITY(1,1) PRIMARY KEY NOT NULL,
loai_phong nvarchar(20) NOT NULL,
ten_phong nvarchar(20) NOT NULL,
gia_phong int NOT NULL,
tinh_trang int NOT NULL
)

--Tạo bảng Sản Phẩm
CREATE TABLE tb_sanpham(
ma_sp int IDENTITY(1,1) PRIMARY KEY NOT NULL,
ten_sp nvarchar(40) NOT NULL,
so_luong int NOT NULL,
don_vi_tinh nvarchar(20),
don_gia int NOT NULL,
tinh_trang int
)

--Tạo bảng Hóa Đơn
CREATE TABLE tb_hoadon(
ma_hd int IDENTITY(1,1) PRIMARY KEY NOT NULL,
ma_phong int NOT NULL FOREIGN KEY REFERENCES tb_phong(ma_phong) ON DELETE CASCADE,
ma_kh int NOT NULL FOREIGN KEY REFERENCES tb_khachhang(ma_kh) ON DELETE CASCADE,
ma_nv int NOT NULL FOREIGN KEY REFERENCES tb_nhanvien(ma_nv) ON DELETE CASCADE,
tong_tien int NOT NULL,
thoi_gian date NOT NULL
)

--Tạo bảng Chi Tiết Hóa Đơn
CREATE TABLE tb_cthd(
ma_hd int NOT NULL FOREIGN KEY REFERENCES tb_hoadon(ma_hd),
ma_kh int NOT NULL FOREIGN KEY REFERENCES tb_khachhang(ma_kh),
ma_sp int NOT NULL FOREIGN KEY REFERENCES tb_sanpham(ma_sp),
don_gia int NOT NULL,
so_luong int NOT NULL,
tong_so_gio int
)

ALTER TABLE tb_cthd ADD PRIMARY KEY (ma_hd,ma_kh)

--Thêm dữ liệu

SET DATEFORMAT dmy

INSERT tb_nhanvien(username, password, name, gioi_tinh, phone, email) VALUES (N'admin', '123', N'Admin', N'Nữ', 123456, N'admin@gmail.com')
INSERT tb_nhanvien(username, password, name, gioi_tinh, phone, email) VALUES (N'kimvy', '123', N'Kim Vy', N'Nam', 123456, N'kimvy@gmail.com')
INSERT tb_nhanvien(username, password, name, gioi_tinh, phone, email) VALUES (N'thach', '123', N'Thạch', N'Nam', 123456, N'thach@gmail.com')
INSERT tb_nhanvien(username, password, name, gioi_tinh, phone, email) VALUES (N'thinh', '123', N'Thịnh', N'Nam', 123456, N'thinh@gmail.com')

INSERT tb_khachhang(ho_ten, phone, dia_chi, ngay_sinh) VALUES ( N'Nguyễn Văn A', 654321, N'Quận 1, TPHCM', '01-01-1990')
INSERT tb_khachhang(ho_ten, phone, dia_chi, ngay_sinh) VALUES ( N'Nguyễn Thị B', 654321, N'Quận 2, TPHCM', '01-01-1991')
INSERT tb_khachhang(ho_ten, phone, dia_chi, ngay_sinh) VALUES ( N'Trần Thiên C', 654321, N'Quận 8, TPHCM', '01-01-1998')
INSERT tb_khachhang(ho_ten, phone, dia_chi, ngay_sinh) VALUES ( N'Ngô Hữu D', 654321, N'Quận Tân Bình, TPHCM', '01-01-1995')
INSERT tb_khachhang(ho_ten, phone, dia_chi, ngay_sinh) VALUES ( N'Võ Nguyễn E', 654321, N'Quận 12, TPHCM', '01-01-1999')

INSERT tb_phong(ten_phong, loai_phong, gia_phong, tinh_trang) VALUES ('1', N'Thường', 120000, 0)
INSERT tb_phong(ten_phong, loai_phong, gia_phong, tinh_trang) VALUES ('2', N'Thường', 100000, 0)
INSERT tb_phong(ten_phong, loai_phong, gia_phong, tinh_trang) VALUES ('3', N'Thường', 100000, 0)
INSERT tb_phong(ten_phong, loai_phong, gia_phong, tinh_trang) VALUES ('VIP 1', N'Vip', 250000, 0)
INSERT tb_phong(ten_phong, loai_phong, gia_phong, tinh_trang) VALUES ('VIP 2', N'Vip', 250000, 0)
INSERT tb_phong(ten_phong, loai_phong, gia_phong, tinh_trang) VALUES ('VIP 3', N'Vip', 200000, 0)
INSERT tb_phong(ten_phong, loai_phong, gia_phong, tinh_trang) VALUES ('VIP 4', N'Vip', 200000, 0)

INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Nước Suối', 500, 'Chai', 15000, 1)
INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Bia Sài Gòn', 1000, 'Lon', 17000, 1)
INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Bia Tiger', 1000, 'Lon', 21000, 1)
INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Bia 333', 700, 'Lon', 23000, 1)
INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Trái cây', 500, N'Dĩa', 100000, 1)
INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Khăn Lạnh', 2000, 'Cái', 5000, 1)
INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Đồ Ăn Vặt', 1000, 'Gói', 20000, 1)
INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Cocacola', 500, 'Lon', 15000, 1)
INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Pepsi', 500, 'Lon', 15000, 1)
INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Trà Xanh', 600, 'Chai', 15000, 1)
INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Bò Khô', 300, 'Gói', 50000, 1)
INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Thuốc Jet', 200, 'Gói', 25000, 1)
INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Thuốc 555', 200, 'Gói', 40000, 1)
INSERT tb_sanpham(ten_sp, so_luong, don_vi_tinh, don_gia, tinh_trang) VALUES (N'Khác', 1, 'Theo yêu cầu', 1, 1)

INSERT tb_hoadon(ma_phong, ma_kh, ma_nv,tong_tien,thoi_gian) VALUES (1,1,2,500000,'01/05/2020')
INSERT tb_hoadon(ma_phong, ma_kh, ma_nv,tong_tien,thoi_gian) VALUES (1,2,1,800000,'03/05/2020')
INSERT tb_hoadon(ma_phong, ma_kh, ma_nv,tong_tien,thoi_gian) VALUES (4,3,3,2000000,'20/09/2019')
INSERT tb_hoadon(ma_phong, ma_kh, ma_nv,tong_tien,thoi_gian) VALUES (3,2,1,1000000,'17/06/2020')
INSERT tb_hoadon(ma_phong, ma_kh, ma_nv,tong_tien,thoi_gian) VALUES (2,1,2,700000,'21/06/2020')
INSERT tb_hoadon(ma_phong, ma_kh, ma_nv,tong_tien,thoi_gian) VALUES (1,1,2,500000,'01/05/2020')
INSERT tb_hoadon(ma_phong, ma_kh, ma_nv,tong_tien,thoi_gian) VALUES (1,5,2,300000,'01/09/2020')

