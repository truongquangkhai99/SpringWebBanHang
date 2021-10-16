-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 16, 2021 lúc 05:16 AM
-- Phiên bản máy phục vụ: 10.1.31-MariaDB
-- Phiên bản PHP: 7.1.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `spring_web_ban_hang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `menu_dong`
--

CREATE TABLE `menu_dong` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_visible` int(11) DEFAULT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_order` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `is_parent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `menu_dong`
--

INSERT INTO `menu_dong` (`id`, `description`, `is_visible`, `menu_name`, `menu_order`, `parent_id`, `url`, `is_parent`) VALUES
(1, '', 1, 'Ô Tô', 0, 0, 'o-to', 1),
(2, '', 0, 'Ô Tô Kia Tự Động 3', 0, 0, 'o-to-kia-tu-dong-3', 1),
(3, '', 1, 'Ô Tô Kia Tự Động 4', 0, 0, 'o-to-kia-tu-dong-4', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `visible` int(11) DEFAULT NULL,
  `menu_dong_id` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `description`, `name`, `price`, `quantity`, `visible`, `menu_dong_id`) VALUES
(1, 'Xe đẹp 2021', 'Ô Tô Kia', 0, 0, 0, 1),
(8, 'Xe đẹp 2022', 'Ô Tô Kia 2', 0, 0, 0, 0),
(9, 'Xe đẹp 2022', 'Ô Tô Kia 3', 1, 0, 0, 0),
(10, 'Xe đẹp 2022', 'Ô Tô Kia 4', 1, 2, 0, 0),
(11, 'Xe đẹp 2022', 'Ô Tô Kia 5', 1, 3, 0, 0),
(12, 'Xe đẹp 2022', 'Ô Tô Kia 6', 1, 4, 0, 0),
(13, 'Xe đẹp 2022', 'Ô Tô Kia 7', 1, 5, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `address`, `email`, `full_name`, `gender`) VALUES
(1, 'Phú Đô, Nam Từ Liêm', 'nguyenvantuyen6789@gmail.com', 'Tuyên Nguyễn', 'Nam'),
(5, 'Phú Đô, Nam Từ Liêm', 'nguyenvantuyen6789@gmail.com', 'Tuyên Nguyễn', 'Nam'),
(8, 'Phú Đô, Nam Từ Liêm, Hà Nội', 'nguyenvantuyen6789@gmail.com', 'Tuyên Nguyễn', 'Nam');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `menu_dong`
--
ALTER TABLE `menu_dong`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `menu_dong`
--
ALTER TABLE `menu_dong`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
