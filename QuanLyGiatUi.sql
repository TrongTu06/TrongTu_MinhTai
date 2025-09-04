-- Tạo cơ sở dữ liệu
CREATE DATABASE QuanLyTiemGiatUi;
GO
USE QuanLyTiemGiatUi;
GO

-- Bảng KhachHang
CREATE TABLE KhachHang (
    MaKhachHang INT IDENTITY(1,1) PRIMARY KEY,
    TenKhachHang NVARCHAR(100) NOT NULL,
    SoDienThoai NVARCHAR(15),
    DiaChi NVARCHAR(255)
);
GO

-- Bảng DichVuGiat
CREATE TABLE DichVuGiat (
    MaDichVu INT IDENTITY(1,1) PRIMARY KEY,
    TenDichVu NVARCHAR(100) NOT NULL,
    GiaTien DECIMAL(18,2) NOT NULL,
    DonViTinh NVARCHAR(50) NOT NULL
);
GO

-- Bảng DonGiat
CREATE TABLE DonGiat (
    MaDon INT IDENTITY(1,1) PRIMARY KEY,
    MaKhachHang INT NOT NULL,
    NgayLap DATE NOT NULL,
    TrangThai NVARCHAR(50),
    TongTien DECIMAL(18,2),
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang)
);
GO

-- Bảng ChiTietDonGiat
CREATE TABLE ChiTietDonGiat (
    MaChiTiet INT IDENTITY(1,1) PRIMARY KEY,
    MaDon INT NOT NULL,
    MaDichVu INT NOT NULL,
    SoLuong INT NOT NULL,
    MoTa NVARCHAR(255),
    FOREIGN KEY (MaDon) REFERENCES DonGiat(MaDon),
    FOREIGN KEY (MaDichVu) REFERENCES DichVuGiat(MaDichVu)
);
GO

-- Thêm dữ liệu mẫu cho KhachHang
INSERT INTO KhachHang (TenKhachHang, SoDienThoai, DiaChi) VALUES
(N'Nguyễn Văn A', '0901234567', N'Hà Nội'),
(N'Trần Thị B', '0912345678', N'Hồ Chí Minh'),
(N'Lê Văn C', '0923456789', N'Đà Nẵng');
GO

-- Thêm dữ liệu mẫu cho DichVuGiat
INSERT INTO DichVuGiat (TenDichVu, GiaTien, DonViTinh) VALUES
(N'Giặt khô', 50000, N'kg'),
(N'Giặt ướt', 30000, N'kg'),
(N'Sấy khô', 20000, N'kg');
GO

-- Thêm dữ liệu mẫu cho DonGiat
INSERT INTO DonGiat (MaKhachHang, NgayLap, TrangThai, TongTien) VALUES
(1, '2025-09-01', N'Chờ xử lý', NULL),
(2, '2025-09-02', N'Đang giặt', NULL);
GO

-- Thêm dữ liệu mẫu cho ChiTietDonGiat
INSERT INTO ChiTietDonGiat (MaDon, MaDichVu, SoLuong, MoTa) VALUES
(1, 1, 2, N'Áo sơ mi'),
(1, 2, 3, N'Quần jean'),
(2, 3, 5, N'Chăn mỏng');
GO
