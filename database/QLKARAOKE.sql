CREATE DATABASE QLYKARAOKE
USE QLYKARAOKE

--Tạo bảng Nhân Viên
CREATE TABLE tb_nhanvien(
ma_nv int PRIMARY KEY NOT NULL,
username char(40) NOT NULL,
password char(40) NOT NULL,
name nvarchar(40) NOT NULL,
phone int NOT NULL,
email char(40)
)

--Tạo bảng Khách Hàng
CREATE TABLE tb_khachhang(
ma_kh int PRIMARY KEY NOT NULL,
ho_ten nvarchar(40) NOT NULL,
phone int,
dia_chi nvarchar(40),
ngay_sinh date,
)

--Tạo bảng Phòng
CREATE TABLE tb_phong(
ma_phong int PRIMARY KEY NOT NULL,
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
ma_hd int PRIMARY KEY NOT NULL,
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

INSERT tb_nhanvien(ma_nv, username, password, name, phone, email) VALUES (1, 'admin', '123', 'admin', 123456, 'admin@gmail.com')
INSERT tb_nhanvien(ma_nv, username, password, name, phone, email) VALUES (2, 'kimvy', '123', 'Kim Vy', 123456, 'kimvy@gmail.com')
INSERT tb_nhanvien(ma_nv, username, password, name, phone, email) VALUES (3, 'thach', '123', 'Thach', 123456, 'thach@gmail.com')
INSERT tb_nhanvien(ma_nv, username, password, name, phone, email) VALUES (4, 'thinh', '123', 'Thinh', 123456, 'thinh@gmail.com')

INSERT tb_khachhang(ma_kh, ho_ten, phone, dia_chi, ngay_sinh) VALUES (1, N'Nguyễn Văn A', 654321, N'Quận 1, TPHCM', '01-01-1990')
INSERT tb_khachhang(ma_kh, ho_ten, phone, dia_chi, ngay_sinh) VALUES (2, N'Nguyễn Thị B', 654321, N'Quận 2, TPHCM', '01-01-1991')
INSERT tb_khachhang(ma_kh, ho_ten, phone, dia_chi, ngay_sinh) VALUES (3, N'Trần Thiên C', 654321, N'Quận 8, TPHCM', '01-01-1998')
INSERT tb_khachhang(ma_kh, ho_ten, phone, dia_chi, ngay_sinh) VALUES (4, N'Ngô Hữu D', 654321, N'Quận Tân Bình, TPHCM', '01-01-1995')
INSERT tb_khachhang(ma_kh, ho_ten, phone, dia_chi, ngay_sinh) VALUES (5, N'Võ Nguyễn E', 654321, N'Quận 12, TPHCM', '01-01-1999')

INSERT tb_phong(ma_phong, ten_phong, loai_phong, gia_phong, tinh_trang) VALUES (1, '1', N'Thường', 120000, 0)
INSERT tb_phong(ma_phong, ten_phong, loai_phong, gia_phong, tinh_trang) VALUES (2, '2', N'Thường', 100000, 0)
INSERT tb_phong(ma_phong, ten_phong, loai_phong, gia_phong, tinh_trang) VALUES (3, '3', N'Thường', 100000, 0)
INSERT tb_phong(ma_phong, ten_phong, loai_phong, gia_phong, tinh_trang) VALUES (4, 'VIP 1', N'Vip', 250000, 0)
INSERT tb_phong(ma_phong, ten_phong, loai_phong, gia_phong, tinh_trang) VALUES (5, 'VIP 2', N'Vip', 250000, 0)
INSERT tb_phong(ma_phong, ten_phong, loai_phong, gia_phong, tinh_trang) VALUES (6, 'VIP 3', N'Vip', 200000, 0)
INSERT tb_phong(ma_phong, ten_phong, loai_phong, gia_phong, tinh_trang) VALUES (7, 'VIP 4', N'Vip', 200000, 0)

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
