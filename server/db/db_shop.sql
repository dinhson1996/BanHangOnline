-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 28, 2017 at 05:02 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_chitietdonhang`
--

CREATE TABLE `tb_chitietdonhang` (
  `id_chitiet` int(11) NOT NULL,
  `id_donhang` int(11) NOT NULL,
  `id_sanpham` int(11) NOT NULL,
  `ten_sanpham` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `gia_sanpham` int(11) NOT NULL,
  `soluong_sanpham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tb_chitietdonhang`
--

INSERT INTO `tb_chitietdonhang` (`id_chitiet`, `id_donhang`, `id_sanpham`, `ten_sanpham`, `gia_sanpham`, `soluong_sanpham`) VALUES
(1, 9, 40, 'Lenovo IdeaPad 310 15LKB', 11990000, 1),
(2, 9, 6, 'Sony Xperia XZs', 27980000, 2),
(3, 9, 23, 'Macbook MLH72 ', 91470000, 3),
(4, 10, 3, 'Macbook Pro 3', 180000000, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tb_donhang`
--

CREATE TABLE `tb_donhang` (
  `id_donhang` int(11) NOT NULL,
  `ten_khachhang` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sodienthoai_khachhang` int(15) NOT NULL,
  `email_khachhang` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tb_donhang`
--

INSERT INTO `tb_donhang` (`id_donhang`, `ten_khachhang`, `sodienthoai_khachhang`, `email_khachhang`) VALUES
(9, 'admin', 123456789, 'admin@gmail.com\r\n		'),
(10, 'vuong bach thu', 972297198, 'vuongbachthu@gmail.com\r\n		');

-- --------------------------------------------------------

--
-- Table structure for table `tb_loaisp`
--

CREATE TABLE `tb_loaisp` (
  `id_loaisp` int(11) NOT NULL,
  `ten_loaisp` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `anh_loaisp` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tb_loaisp`
--

INSERT INTO `tb_loaisp` (`id_loaisp`, `ten_loaisp`, `anh_loaisp`) VALUES
(1, 'Laptop', '/server/image/menu/ic_laptop.png'),
(2, 'Điện thoại', '/server/image/menu/ic_mobile.png');

-- --------------------------------------------------------

--
-- Table structure for table `tb_sanpham`
--

CREATE TABLE `tb_sanpham` (
  `id_sanpham` int(11) NOT NULL,
  `ten_sanpham` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `gia_sanpham` int(11) NOT NULL,
  `anh_sanpham` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mota_sanpham` text COLLATE utf8_unicode_ci NOT NULL,
  `id_loaisp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tb_sanpham`
--

INSERT INTO `tb_sanpham` (`id_sanpham`, `ten_sanpham`, `gia_sanpham`, `anh_sanpham`, `mota_sanpham`, `id_loaisp`) VALUES
(1, 'Iphone 7 Plus', 19000000, '/server/image/sanpham/iphone7plus.png', 'Iphone 7 chụp ảnh đẹp', 2),
(2, 'Galaxy S8', 20500000, '/server/image/sanpham/galaxy-s8-plus.png', 'Màn hình vô cực', 2),
(3, 'Macbook Pro 3', 45000000, '/server/image/sanpham/MacBook-Pro.jpg', 'Macbook đẹp', 1),
(4, 'Subface Pro', 50000000, '/server/image/sanpham/Surface-Pro-3.jpg', 'Đẹp đến từng chi tiết', 1),
(5, 'Sam Sung Galaxy S8+', 20450000, '/server/image/sanpham/samsungs8.png', 'Hình ảnh siêu nét, và nhiều tính năng mới', 2),
(6, 'Sony Xperia XZs', 13990000, '/server/image/sanpham/sony-xperia.png', 'sang trọng và mạnh mẽ', 2),
(7, 'HTC U11', 16990000, '/server/image/sanpham/htc.png', 'sắc nét', 2),
(8, 'HTC U Ultra', 14990000, '/server/image/sanpham/htc-u.png', 'cùng cảm nhận sự sắc nét của HTC', 2),
(9, 'Iphone 6S 32gb', 14490000, '/server/image/sanpham/iphone-6s.png', 'sắc nét và đầy tính năng mới', 2),
(10, 'Motorola Moto Z2 Play', 10990000, '/server/image/sanpham/motorola.png', 'mạnh mẽ ', 2),
(11, 'SamSung galaxy C9 Pro', 11490000, '/server/image/sanpham/samsungc9.png', 'kích thước màn hình 6 inh', 2),
(12, 'Samsung Galaxy A7', 9999000, '/server/image/sanpham/samsunga7.png', 'Sang trọng và đẳng cấp', 2),
(13, 'Samsung Galaxy j7 Pro', 6990000, '/server/image/sanpham/samsungj7.png', 'Đặc biệt lạ mắt', 2),
(14, 'Samsung Galaxy A3', 6490000, '/server/image/sanpham/samsunga3.png', 'Tính năng chống nước chuẩn', 2),
(15, 'OPPO F3 Plus', 10630000, '/server/image/sanpham/oppo-f3.png', 'Nguyên khối sang trọng', 2),
(16, 'Sony Xperia XZ Premium', 18450000, '/server/image/sanpham/sony-xz.png', 'Tuyệt mỹ đến từng góc cạnh', 2),
(17, 'Sony Xperia XZ', 10990000, '/server/image/sanpham/sony-xperia-xz.png', 'Mềm mại và tinh tế', 2),
(18, 'Samsung Galaxy Note 5', 10690000, '/server/image/sanpham/samsungnote5.png', 'mặt kính cường lực ', 2),
(19, 'Sony Xperia XA1 Ultra', 8990000, '/server/image/sanpham/sony-xa1.png', 'màn hình 6inh không viền', 2),
(20, 'Oppo F3 Lite (A57)', 5490000, '/server/image/sanpham/oppo-a57.png', 'lịch lãm, sang trọng', 2),
(21, 'Samsung Galaxy j1', 2190000, '/server/image/sanpham/galaxy-j1.png', 'bo tròn viền đẹp mắt', 2),
(22, 'Samsung Galaxy j1 mini', 1521000, '/server/image/sanpham/samsungj1mini.png', 'cắt vát  viền sang trọng', 2),
(23, 'Macbook MLH72 ', 30490000, '/server/image/sanpham/apple-macbook.png', 'sang trọng thể hiện đẳng cấp', 1),
(24, 'Macbook Pro Touch', 56990000, '/server/image/sanpham/apple.png', 'Độc đáo với thanh cảm ứng', 1),
(25, 'Dell Inspiron 3567 ', 11490000, '/server/image/sanpham/dell-inspiron.png', 'màn hình rộng', 1),
(26, 'Dell Vostro 3568', 11990000, '/server/image/sanpham/dell-vostro.png', 'sang trọng và mạnh mẽ', 1),
(27, 'Dell Inspiron 7460 ', 19990000, '/server/image/sanpham/dell-7460.png', 'Kiểu dáng sang trọng', 1),
(28, 'Asus E402SA N3060', 6290000, '/server/image/sanpham/asus-e402sa.png', 'đơn giản nhẹ nhàng', 1),
(29, 'Asus A541UA i3', 10990000, '/server/image/sanpham/asus-a541ua-i3.png', 'Vỏ xanh nổi bật', 1),
(30, 'Asus A441UA i3 6006U', 9999000, '/server/image/sanpham/asus-a441ua.png', 'Sonic Master', 1),
(31, 'HP 15 ay526TU i3', 10290000, '/server/image/sanpham/hp-15.png', 'lạ mắt, độc đáo', 1),
(32, 'HP pavilion 14', 11690000, '/server/image/sanpham/hp-pavilion-14.png', 'sắc vàng sang trọng', 1),
(33, 'HP Pavilion 15', 13490000, '/server/image/sanpham/hp-pavilion-15.png', 'màn hình lớn', 1),
(34, 'HP Probook 450 G4', 15990000, '/server/image/sanpham/hp-probook-450.png', 'bảo mật vân tay', 1),
(35, 'HP Pavilion 15 AU072TX', 19490000, '/server/image/sanpham/hp-pavilion.png', 'đồ họa cao', 1),
(36, 'HP Envy 13 2016', 19990000, '/server/image/sanpham/hp-envy-13.png', 'mạnh mẽ', 1),
(37, 'Lenovo Yoga 900', 31990000, '/server/image/sanpham/lenovo-yoga.png', 'siêu mỏng', 1),
(38, 'Dell XPS 9360', 48990000, '/server/image/sanpham/dell-xps-9360.png', 'cấu hình khủng', 1),
(39, 'Lenovo Yoga 510 14ISK', 10990000, '/server/image/sanpham/lenovo-yoga-510.png', 'mạnh mẽ sang trọng', 1),
(40, 'Lenovo IdeaPad 310 15LKB', 11990000, '/server/image/sanpham/lenovo-ideapad.png', 'mạnh mẽ sang trọng với cấu hình khủng', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_chitietdonhang`
--
ALTER TABLE `tb_chitietdonhang`
  ADD PRIMARY KEY (`id_chitiet`);

--
-- Indexes for table `tb_donhang`
--
ALTER TABLE `tb_donhang`
  ADD PRIMARY KEY (`id_donhang`);

--
-- Indexes for table `tb_loaisp`
--
ALTER TABLE `tb_loaisp`
  ADD PRIMARY KEY (`id_loaisp`);

--
-- Indexes for table `tb_sanpham`
--
ALTER TABLE `tb_sanpham`
  ADD PRIMARY KEY (`id_sanpham`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_chitietdonhang`
--
ALTER TABLE `tb_chitietdonhang`
  MODIFY `id_chitiet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tb_donhang`
--
ALTER TABLE `tb_donhang`
  MODIFY `id_donhang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tb_loaisp`
--
ALTER TABLE `tb_loaisp`
  MODIFY `id_loaisp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tb_sanpham`
--
ALTER TABLE `tb_sanpham`
  MODIFY `id_sanpham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
