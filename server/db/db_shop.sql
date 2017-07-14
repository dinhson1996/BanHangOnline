-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 15, 2017 at 01:41 AM
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
(4, 'Subface Pro', 50000000, '/server/image/sanpham/Surface-Pro-3.jpg', 'Đẹp đến từng chi tiết', 1);

--
-- Indexes for dumped tables
--

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
-- AUTO_INCREMENT for table `tb_loaisp`
--
ALTER TABLE `tb_loaisp`
  MODIFY `id_loaisp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tb_sanpham`
--
ALTER TABLE `tb_sanpham`
  MODIFY `id_sanpham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
