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

-- Dumping data for table spring_web_ban_hang.tbl_menu_dong: ~3 rows (approximately)
DELETE FROM `tbl_menu_dong`;
/*!40000 ALTER TABLE `tbl_menu_dong` DISABLE KEYS */;
INSERT INTO `tbl_menu_dong` (`menu_dong_id`, `description`, `is_parent`, `is_visible`, `menu_name`, `menu_order`, `parent_id`, `menu_link`) VALUES
	(1, 'Xe đẹp 2021', 0, 1, 'Ô Tô Kia', 1, 0, 'o-to-kia'),
	(4, 'Xe đẹp 2021', 0, 1, 'Ô Tô Mecerdes', 1, 0, 'o-to-mecerdes'),
	(6, 'Xe đẹp 2021', 0, 1, 'Ô Tô Kia Tự Động 4', 1, 0, 'o-to-kia-tu-dong-4'),
	(13, '', 0, 0, 'Ô Tô Kia Tự Động 3', 0, 0, 'Ô-Tô-Kia-Tự-Động-3');
/*!40000 ALTER TABLE `tbl_menu_dong` ENABLE KEYS */;

-- Dumping data for table spring_web_ban_hang.tbl_product: ~9 rows (approximately)
DELETE FROM `tbl_product`;
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
INSERT INTO `tbl_product` (`product_id`, `description`, `menu_dong_id`, `price`, `quantity`, `visible`, `favourite`, `image_name`, `product_name`, `is_visible`) VALUES
	(1, 'Xe đẹp 2021', 1, 0, 2, 1, 1, 'vinfast-lux-sa-2_0-ra-mat-tai-viet-nam.jpg', 'Ô tô Vinfast', 1),
	(5, 'Xe đẹp 2021', 1, 0, 2, 0, 1, 'mercedes-s500-2021-autodaily-46.jpg', 'Mercedes', 1),
	(6, 'Xe đẹp 2021', 1, 0, 2, 1, 0, 'gia-xe-toyota-camry-20g-2021-muaxebanxe-com-30.jpg', 'Toyota camry', 1),
	(10, 'Xe đẹp 2021', 1, 0, 0, 1, 1, '640-kia-morning-2021-ra-mat-tai-viet-nam.jfif', 'Kia Morning', 1),
	(11, 'Xe đẹp 2021', 1, 0, 20, 0, 1, 'toyota-vios.jpg', 'Toyota Vios', 1),
	(33, 'Xe đẹp 2021', 1, 0, 0, 1, 1, 'honda-brio.jpg', 'Honda Brio', 0),
	(34, 'Xe đẹp 2021', 1, 0, 0, 1, 0, '640-kia-morning-2021-ra-mat-tai-viet-nam.jfif', 'Kia Morning 2021', 1),
	(35, '', 1, 0, NULL, NULL, NULL, '640-kia-morning-2021-ra-mat-tai-viet-nam.jfif', 'Kia Đỏ', 1);
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;

-- Dumping data for table spring_web_ban_hang.tbl_user: ~3 rows (approximately)
DELETE FROM `tbl_user`;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` (`user_id`, `username`, `password`, `address`, `email`, `full_name`, `gender`, `role`) VALUES
	(1, 'nguyenvantuyen6789', '123456', 'Phú Đô', 'nguyenvantuyen6789@gmail.com', 'Tuyên Nguyễn', 'Nam', 'Admin'),
	(2, 'nguyenvantuyen67891', '123456', 'Phú Đô', 'nguyenvantuyen67891@gmail.com', 'Tuyên Nguyễn 3', 'Nam', 'User'),
	(3, NULL, NULL, 'Phú Đô', 'nguyenvantuyen6789@gmail.com', 'Tuyên Nguyễn', 'Nam', NULL),
	(10, 'tuyennguyen7', '123456', '', 'nguyenvantuyen67892@gmail.com', 'Tuyên Nguyễn', 'Nam', 'Admin');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
