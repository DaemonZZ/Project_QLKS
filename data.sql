USE [QuanLyKS]
GO
INSERT [dbo].[KhachHang] ([ID_KH], [HoTen], [GioiTinh], [DonVi], [CMND], [NgayCap], [NoiCap], [Loai], [QuocTich]) VALUES (1, N'Lê Minh Hằng', 0, NULL, N'25369658345', CAST(N'2012-06-19' AS Date), N'Công An Gia Lâm', 0, N'Việt Nam')
INSERT [dbo].[KhachHang] ([ID_KH], [HoTen], [GioiTinh], [DonVi], [CMND], [NgayCap], [NoiCap], [Loai], [QuocTich]) VALUES (2, N'Hoàng Minh Huy', 1, NULL, N'15613156662', CAST(N'1998-05-06' AS Date), N'Công An Khánh Hòa', 1, N'Việt Nam')
INSERT [dbo].[KhachHang] ([ID_KH], [HoTen], [GioiTinh], [DonVi], [CMND], [NgayCap], [NoiCap], [Loai], [QuocTich]) VALUES (3, N'Alexandre Grahambell', 1, N'Tele.Co', N'21341523241', NULL, NULL, 1, N'France')
GO
INSERT [dbo].[NhanVien] ([ID_NV], [Hoten], [DienThoai], [TaiKhoan], [MatKhau], [Loai]) VALUES (1, N'Đỗ Ngọc Thắng', N'01693366935', N'0123456789', N'admin', 0)
INSERT [dbo].[NhanVien] ([ID_NV], [Hoten], [DienThoai], [TaiKhoan], [MatKhau], [Loai]) VALUES (2, N'Nguyễn Thị Thu Hiền', N'09023586954', N'1234567890', N'123', 1)
INSERT [dbo].[NhanVien] ([ID_NV], [Hoten], [DienThoai], [TaiKhoan], [MatKhau], [Loai]) VALUES (3, N'Hoàng Lê Bảo Quốc', N'09355558865', N'2589328515', N'123', 1)
INSERT [dbo].[NhanVien] ([ID_NV], [Hoten], [DienThoai], [TaiKhoan], [MatKhau], [Loai]) VALUES (4, N'Nguyễn Ngọc Bảo Trâm', N'01212252535', N'2542555252', N'123', 1)
INSERT [dbo].[NhanVien] ([ID_NV], [Hoten], [DienThoai], [TaiKhoan], [MatKhau], [Loai]) VALUES (5, N'Lê  Xuân Hưng', N'0977256256', N'3241548215', N'456', 2)
INSERT [dbo].[NhanVien] ([ID_NV], [Hoten], [DienThoai], [TaiKhoan], [MatKhau], [Loai]) VALUES (6, N'Lê Hoàng Vương', N'0399665852', N'2568465486', N'456', 4)
INSERT [dbo].[NhanVien] ([ID_NV], [Hoten], [DienThoai], [TaiKhoan], [MatKhau], [Loai]) VALUES (7, N'Hoàng Hồng Trang', N'0152425523', N'234156451', N'456', 3)
INSERT [dbo].[NhanVien] ([ID_NV], [Hoten], [DienThoai], [TaiKhoan], [MatKhau], [Loai]) VALUES (8, N'Nguyễn Thị Mỹ Duyên', N'0123456785', N'348646515', N'456', 3)
INSERT [dbo].[NhanVien] ([ID_NV], [Hoten], [DienThoai], [TaiKhoan], [MatKhau], [Loai]) VALUES (9, N'Lê Hồng Kiều', N'0915015325', N'2156466648', N'456', 2)
INSERT [dbo].[NhanVien] ([ID_NV], [Hoten], [DienThoai], [TaiKhoan], [MatKhau], [Loai]) VALUES (10, N'Nguyễn Ngọc Long', N'09225254524', N'2315649643', N'456', 4)
GO
INSERT [dbo].[Dangky] ([ID_DK], [SoPhong], [NgayDat], [TuNgay], [DenNgay], [SoKhach], [Nam], [TreEm], [ID_KH], [ID_NV], [Tiencoc]) VALUES (1, 3, CAST(N'2020-10-08' AS Date), CAST(N'2020-10-08' AS Date), CAST(N'2020-10-13' AS Date), 4, 3, 1, 1, 3, 750000)
INSERT [dbo].[Dangky] ([ID_DK], [SoPhong], [NgayDat], [TuNgay], [DenNgay], [SoKhach], [Nam], [TreEm], [ID_KH], [ID_NV], [Tiencoc]) VALUES (2, 2, CAST(N'2020-10-08' AS Date), CAST(N'2020-10-12' AS Date), CAST(N'2020-10-14' AS Date), 3, 1, NULL, 2, 3, 250000)
INSERT [dbo].[Dangky] ([ID_DK], [SoPhong], [NgayDat], [TuNgay], [DenNgay], [SoKhach], [Nam], [TreEm], [ID_KH], [ID_NV], [Tiencoc]) VALUES (3, 1, CAST(N'2020-10-07' AS Date), CAST(N'2020-10-08' AS Date), CAST(N'2020-10-09' AS Date), 1, 1, NULL, 3, 2, NULL)
GO
INSERT [dbo].[LoaiPhong] ([ID_Loai], [TenLoai]) VALUES (1, N'Double')
INSERT [dbo].[LoaiPhong] ([ID_Loai], [TenLoai]) VALUES (2, N'Tripple')
INSERT [dbo].[LoaiPhong] ([ID_Loai], [TenLoai]) VALUES (3, N'Family')
INSERT [dbo].[LoaiPhong] ([ID_Loai], [TenLoai]) VALUES (4, N'Double-VIP')
INSERT [dbo].[LoaiPhong] ([ID_Loai], [TenLoai]) VALUES (5, N'Tripple-VIP')
INSERT [dbo].[LoaiPhong] ([ID_Loai], [TenLoai]) VALUES (6, N'Family-VIP')
INSERT [dbo].[LoaiPhong] ([ID_Loai], [TenLoai]) VALUES (7, N'Working')
INSERT [dbo].[LoaiPhong] ([ID_Loai], [TenLoai]) VALUES (8, N'Hall')
GO
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'001', 0, 8, 5500000, 0, N'001', NULL, NULL)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'101', 1, 2, 700000, 4, N'101', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'102', 1, 2, 700000, 4, N'102', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'103', 1, 2, 700000, 0, N'103', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'104', 1, 1, 550000, 4, N'104', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'105', 1, 1, 550000, 4, N'105', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'106', 1, 1, 550000, 4, N'106', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'107', 1, 4, 650000, 0, N'107', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'108', 1, 5, 900000, 0, N'108', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'109', 1, 5, 900000, 0, N'109', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'110', 1, 1, 550000, 4, N'110', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'111', 1, 1, 550000, 0, N'111', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'112', 1, 3, 1000000, 0, N'112', 3, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'201', 2, 2, 700000, 0, N'201', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'202', 2, 2, 700000, 0, N'202', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'203', 2, 2, 700000, 4, N'203', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'204', 2, 1, 550000, 0, N'204', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'205', 2, 1, 550000, 0, N'205', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'206', 2, 1, 550000, 0, N'206', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'207', 2, 4, 650000, 4, N'207', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'208', 2, 5, 900000, 0, N'208', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'209', 2, 5, 900000, 0, N'209', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'210', 2, 1, 550000, 0, N'210', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'211', 2, 1, 550000, 0, N'211', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'212', 2, 6, 1300000, 0, N'212', 3, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'301', 3, 2, 700000, 0, N'301', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'302', 3, 2, 700000, 0, N'302', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'303', 3, 2, 700000, 0, N'303', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'304', 3, 1, 550000, 0, N'304', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'305', 3, 1, 550000, 0, N'305', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'306', 3, 1, 550000, 0, N'306', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'307', 3, 4, 650000, 0, N'307', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'308', 3, 5, 900000, 0, N'308', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'309', 3, 5, 900000, 0, N'309', 2, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'310', 3, 1, 550000, 0, N'310', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'311', 3, 1, 550000, 0, N'311', 1, 0)
INSERT [dbo].[Phong] ([MaPhong], [Tang], [ID_Loai], [Dongia], [TrangThai], [Phone], [Giuong], [Nguoi]) VALUES (N'312', 3, 3, 1000000, 0, N'312', 1, 0)
GO
INSERT [dbo].[QuanLyPhong] ([ID_QL], [ID_DK], [ID_KH], [MaPhong], [CheckIn], [CheckOut], [Gia], [PhuThu], [GhiChu], [TrangThai]) VALUES (1, 1, 1, N'101', CAST(N'2020-10-08T00:00:00.000' AS DateTime), CAST(N'2020-10-13T00:00:00.000' AS DateTime), 550000, 100000, NULL, 4)
INSERT [dbo].[QuanLyPhong] ([ID_QL], [ID_DK], [ID_KH], [MaPhong], [CheckIn], [CheckOut], [Gia], [PhuThu], [GhiChu], [TrangThai]) VALUES (2, 1, 1, N'102', CAST(N'2020-10-08T00:00:00.000' AS DateTime), CAST(N'2020-10-13T00:00:00.000' AS DateTime), 550000, 100000, NULL, 4)
INSERT [dbo].[QuanLyPhong] ([ID_QL], [ID_DK], [ID_KH], [MaPhong], [CheckIn], [CheckOut], [Gia], [PhuThu], [GhiChu], [TrangThai]) VALUES (3, 1, 1, N'103', CAST(N'2020-10-08T00:00:00.000' AS DateTime), CAST(N'2020-10-13T00:00:00.000' AS DateTime), 550000, NULL, NULL, 4)
INSERT [dbo].[QuanLyPhong] ([ID_QL], [ID_DK], [ID_KH], [MaPhong], [CheckIn], [CheckOut], [Gia], [PhuThu], [GhiChu], [TrangThai]) VALUES (4, 2, 2, N'105', CAST(N'2020-10-09T00:00:00.000' AS DateTime), CAST(N'2020-10-12T00:00:00.000' AS DateTime), 700000, NULL, NULL, 4)
INSERT [dbo].[QuanLyPhong] ([ID_QL], [ID_DK], [ID_KH], [MaPhong], [CheckIn], [CheckOut], [Gia], [PhuThu], [GhiChu], [TrangThai]) VALUES (5, 3, 1, N'101', CAST(N'2020-10-19T00:00:00.000' AS DateTime), CAST(N'2020-10-21T00:00:00.000' AS DateTime), 550000, NULL, NULL, 1)
INSERT [dbo].[QuanLyPhong] ([ID_QL], [ID_DK], [ID_KH], [MaPhong], [CheckIn], [CheckOut], [Gia], [PhuThu], [GhiChu], [TrangThai]) VALUES (6, 3, 1, N'106', CAST(N'2020-10-19T00:00:00.000' AS DateTime), CAST(N'2020-10-21T00:00:00.000' AS DateTime), 550000, NULL, NULL, 1)
GO
INSERT [dbo].[ChungTu] ([SoCT], [NgayCT], [Loai], [ID_KH], [ID_NV], [NoiDung], [Giam], [VAT], [SoHoaDon], [ID_QL]) VALUES (N'1', CAST(N'2020-10-15T00:00:00.000' AS DateTime), 3, 1, 3, NULL, NULL, NULL, N'23154632', 1)
INSERT [dbo].[ChungTu] ([SoCT], [NgayCT], [Loai], [ID_KH], [ID_NV], [NoiDung], [Giam], [VAT], [SoHoaDon], [ID_QL]) VALUES (N'2', CAST(N'2020-10-13T00:00:00.000' AS DateTime), 3, 2, 3, NULL, NULL, NULL, N'32153215', 2)
INSERT [dbo].[ChungTu] ([SoCT], [NgayCT], [Loai], [ID_KH], [ID_NV], [NoiDung], [Giam], [VAT], [SoHoaDon], [ID_QL]) VALUES (N'3', CAST(N'2020-10-16T00:00:00.000' AS DateTime), 3, 3, 3, N'Trả phòng', NULL, NULL, N'32155666', 3)
GO
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (1, N'Cafe', N'Ly', 20000, NULL, 2, NULL, NULL)
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (2, N'Mỳ gói', N'Tô', 15000, NULL, 2, NULL, NULL)
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (3, N'Bia Tiger', N'Lon', 20000, NULL, 2, NULL, NULL)
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (4, N'Bia Ken', N'Lon', 30000, NULL, 2, NULL, NULL)
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (5, N'StrongBow', N'Lon', 40000, NULL, 2, NULL, NULL)
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (6, N'CoCa', N'Lon', 15000, NULL, 2, NULL, NULL)
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (7, N'Giặt ủi', N'bộ', 30000, NULL, 3, NULL, NULL)
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (8, N'Thuê xe máy', N'ngày', 200000, NULL, 3, NULL, NULL)
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (9, N'Thuê xe đạp', N'ngày', 100000, NULL, 3, NULL, NULL)
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (10, N'Thuê oto', N'ngày', 500000, NULL, 3, NULL, NULL)
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (11, N'Phòng ở', N'ngày', NULL, NULL, 3, NULL, NULL)
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (12, N'TV', N'Cái', 12000000, NULL, 0, 10, NULL)
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (13, N'Tủ lạnh', N'Cái', 5500000, NULL, 0, 10, NULL)
INSERT [dbo].[DichVu] ([ID_DV], [TenDV], [DVT], [DonGia], [GhiChu], [Loai], [SLDK], [GTDK]) VALUES (14, N'Máy lạnh', N'Cái', 1600000, NULL, 0, 10, NULL)
GO
INSERT [dbo].[DongChungTu] ([ID], [SoCT], [ID_DV], [SoLuong], [DonGia], [GhiChu]) VALUES (1, N'1', 1, 5, 15000, NULL)
INSERT [dbo].[DongChungTu] ([ID], [SoCT], [ID_DV], [SoLuong], [DonGia], [GhiChu]) VALUES (2, N'1', 5, 2, 30000, NULL)
INSERT [dbo].[DongChungTu] ([ID], [SoCT], [ID_DV], [SoLuong], [DonGia], [GhiChu]) VALUES (3, N'1', 4, 5, 25000, NULL)
INSERT [dbo].[DongChungTu] ([ID], [SoCT], [ID_DV], [SoLuong], [DonGia], [GhiChu]) VALUES (4, N'2', 5, 4, 30000, NULL)
INSERT [dbo].[DongChungTu] ([ID], [SoCT], [ID_DV], [SoLuong], [DonGia], [GhiChu]) VALUES (5, N'2', 2, 6, 20000, NULL)
INSERT [dbo].[DongChungTu] ([ID], [SoCT], [ID_DV], [SoLuong], [DonGia], [GhiChu]) VALUES (6, N'2', 5, 3, 30000, NULL)
GO
INSERT [dbo].[SuDungDichVu] ([ID_SD], [ID_QL], [ID_DV], [ID_NV], [Soluong], [DonGia], [GhiChu]) VALUES (1, 1, 6, 3, 5, 15000, NULL)
INSERT [dbo].[SuDungDichVu] ([ID_SD], [ID_QL], [ID_DV], [ID_NV], [Soluong], [DonGia], [GhiChu]) VALUES (2, 1, 5, 2, 4, 30000, NULL)
GO
INSERT [dbo].[ThietBiPhong] ([ID_TB], [MaPhong], [ID_DV], [Soluong], [TrangThai], [SerialNO]) VALUES (1, N'101', 12, 1, N'good', N'123456')
INSERT [dbo].[ThietBiPhong] ([ID_TB], [MaPhong], [ID_DV], [Soluong], [TrangThai], [SerialNO]) VALUES (2, N'101', 13, 1, N'good', N'123445')
INSERT [dbo].[ThietBiPhong] ([ID_TB], [MaPhong], [ID_DV], [Soluong], [TrangThai], [SerialNO]) VALUES (3, N'101', 14, 1, N'good', N'123558')
INSERT [dbo].[ThietBiPhong] ([ID_TB], [MaPhong], [ID_DV], [Soluong], [TrangThai], [SerialNO]) VALUES (4, N'102', 12, 1, NULL, N'25356')
INSERT [dbo].[ThietBiPhong] ([ID_TB], [MaPhong], [ID_DV], [Soluong], [TrangThai], [SerialNO]) VALUES (5, N'102', 13, 1, NULL, N'564666')
INSERT [dbo].[ThietBiPhong] ([ID_TB], [MaPhong], [ID_DV], [Soluong], [TrangThai], [SerialNO]) VALUES (6, N'102', 14, 1, NULL, N'546985')
INSERT [dbo].[ThietBiPhong] ([ID_TB], [MaPhong], [ID_DV], [Soluong], [TrangThai], [SerialNO]) VALUES (7, N'103', 12, 1, N'bảo trì', N'546489')
INSERT [dbo].[ThietBiPhong] ([ID_TB], [MaPhong], [ID_DV], [Soluong], [TrangThai], [SerialNO]) VALUES (8, N'103', 13, 1, NULL, NULL)
INSERT [dbo].[ThietBiPhong] ([ID_TB], [MaPhong], [ID_DV], [Soluong], [TrangThai], [SerialNO]) VALUES (9, N'103', 14, 1, N'good', N'5431231')
INSERT [dbo].[ThietBiPhong] ([ID_TB], [MaPhong], [ID_DV], [Soluong], [TrangThai], [SerialNO]) VALUES (10, N'104', 13, 1, NULL, N'3214588')
INSERT [dbo].[ThietBiPhong] ([ID_TB], [MaPhong], [ID_DV], [Soluong], [TrangThai], [SerialNO]) VALUES (11, N'104', 12, 1, NULL, N'3241853')
GO
