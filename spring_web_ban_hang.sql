-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.31-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table spring_web_ban_hang.tbl_menu_dong: ~5 rows (approximately)
DELETE FROM `tbl_menu_dong`;
/*!40000 ALTER TABLE `tbl_menu_dong` DISABLE KEYS */;
INSERT INTO `tbl_menu_dong` (`menu_dong_id`, `description`, `is_parent`, `is_visible`, `menu_name`, `menu_order`, `parent_id`, `url`) VALUES
	(1, 'Xe đẹp 2021', 0, 1, 'Ô Tô Kia Tự Động 1', 1, 0, 'o-to-kia-tu-dong-1'),
	(4, 'Xe đẹp 2021', 0, 1, 'Ô Tô Kia Tự Động 2', 1, 0, 'o-to-kia-tu-dong-2'),
	(5, 'Xe đẹp 2021', 0, 1, 'Ô Tô Kia Tự Động 3', 1, 0, 'o-to-kia-tu-dong-3'),
	(6, 'Xe đẹp 2021', 0, 1, 'Ô Tô Kia Tự Động 4', 1, 0, 'o-to-kia-tu-dong-4'),
	(7, 'Xe đẹp 2021', 0, 1, 'Ô Tô Kia Tự Động 5', 1, 0, 'o-to-kia-tu-dong-5');
/*!40000 ALTER TABLE `tbl_menu_dong` ENABLE KEYS */;

-- Dumping data for table spring_web_ban_hang.tbl_product: ~5 rows (approximately)
DELETE FROM `tbl_product`;
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
INSERT INTO `tbl_product` (`product_id`, `description`, `menu_dong_id`, `name`, `price`, `quantity`, `visible`, `favourite`, `image_name`) VALUES
	(1, 'Xe đẹp 2021', 0, 'Ô Tô Kia 4', 0, 2, 1, 1, 'under-the-sea.jpg'),
	(5, 'Xe đẹp 2021', 0, 'Ô Tô Kia 4', 0, 2, 1, 1, 'under-the-sea.jpg'),
	(6, 'Xe đẹp 2021', 1, 'Ô Tô Kia 4', 0, 2, 1, 0, 'under-the-sea.jpg'),
	(10, 'Xe đẹp 2021', 7, 'Ô Tô Kia 5', 0, 0, 1, 1, 'under-the-sea.jpg'),
	(11, 'Xe đẹp 2021', 7, 'Ô Tô Kia', 0, 20, 1, 1, 'under-the-sea.jpg'),
	(33, 'Xe đẹp 2021', 1, 'Ô Tô Kia 9', 0, 0, 0, 0, 'pic5.jpg');
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;

-- Dumping data for table spring_web_ban_hang.tbl_user: ~7 rows (approximately)
DELETE FROM `tbl_user`;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` (`user_id`, `username`, `password`, `address`, `email`, `full_name`, `gender`, `role`) VALUES
	(1, 'nguyenvantuyen6789', '123456', 'Phú Đô', 'nguyenvantuyen6789@gmail.com', 'Tuyên Nguyễn', 'Nam', 'Admin'),
	(2, 'nguyenvantuyen67891', '123456', 'Phú Đô', 'nguyenvantuyen67891@gmail.com', 'Tuyên Nguyễn 3', 'Nam', 'User'),
	(3, NULL, NULL, 'Phú Đô', 'nguyenvantuyen6789@gmail.com', 'Tuyên Nguyễn', 'Nam', NULL),
	(4, NULL, NULL, 'Phú Đô', 'nguyenvantuyen6789@gmail.com', 'Tuyên Nguyễn', 'Nam', NULL),
	(5, NULL, NULL, 'Phú Đô', 'nguyenvantuyen6789@gmail.com', 'Tuyên Nguyễn', 'Nam', 'Admin'),
	(6, NULL, NULL, 'Phú Đô', 'nguyenvantuyen6789@gmail.com', 'Tuyên Nguyễn', 'Nam', 'Admin'),
	(7, NULL, NULL, 'Phú Đô', 'nguyenvantuyen6789@gmail.com', 'Tuyên Nguyễn', 'Nữ', 'Admin');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
