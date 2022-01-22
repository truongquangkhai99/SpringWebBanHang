
-- tbl_menu_dong
CREATE TABLE `tbl_menu_dong` (
    `menu_dong_id` int(11) NOT NULL AUTO_INCREMENT,
    `description` varchar(255) DEFAULT NULL,
    `menu_name` varchar(255) DEFAULT NULL,
    `menu_link` varchar(255) DEFAULT NULL,
    `color` varchar(255) DEFAULT NULL,
    `is_visible` int(11) DEFAULT '1',
    `is_parent` tinyint(1) unsigned NOT NULL,
    `menu_order` tinyint(1) unsigned NOT NULL,
    `parent_id` int(11) unsigned NOT NULL,
    PRIMARY KEY (`menu_dong_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
INSERT INTO `tbl_menu_dong` VALUES (1,'Xe đẹp 2021','Ô Tô Kia','ô-tô-kia','#0000ff',1,0,0,0),(4,'Xe đẹp 2021','Mecerdes','mecerdes','#00ff00',1,0,0,0),(6,'Xe đẹp 2021','Vinfast','Vinfast','#00ff00',1,0,0,0),(13,'','Toyota','toyota','#00ff00',1,0,0,0),(31,'','Ô Tô Huyndai','ô-tô-huyndai','#000000',1,0,0,0);

-- tbl_product
CREATE TABLE `tbl_product` (
    `product_id` int(11) NOT NULL AUTO_INCREMENT,
    `description` varchar(255) DEFAULT NULL,
    `menu_dong_id` int(11) DEFAULT '0',
    `image_name` varchar(255) DEFAULT NULL,
    `product_name` varchar(255) DEFAULT NULL,
    `is_visible` int(11) DEFAULT NULL,
    `price` varchar(255) DEFAULT NULL,
    `sale_percent` varchar(255) DEFAULT NULL,
    `sale_price` varchar(255) DEFAULT NULL,
    `gia_con_lai` varchar(255) DEFAULT NULL,
    `favourite` tinyint(1) unsigned NOT NULL,
    `sale` tinyint(1) unsigned NOT NULL,
    `quantity` smallint(5) unsigned NOT NULL,
    PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
INSERT INTO `tbl_product` VALUES (1,'Xe đẹp 2021',6,'vinfast-lux-sa-2_0-ra-mat-tai-viet-nam.jpg','Ô tô Vinfast',1,'350.000.000','10','35.000.000','315.000.000',0,0,0),(5,'Xe đẹp 2021',4,'mercedes-s500-2021-autodaily-46.jpg','Mercedes',1,'1.700.000.000','20','340.000.000','1.360.000.000',0,0,0),(6,'Xe đẹp 2021',1,'gia-xe-toyota-camry-20g-2021-muaxebanxe-com-30.jpg','Toyota camry',1,'1.029.000.000','',NULL,'1.029.000.000',1,1,0),(10,'Xe đẹp 2021',1,'640-kia-morning-2021-ra-mat-tai-viet-nam.jfif','Kia Morning',1,'329.000.000','10','32.900.000','296.100.000',0,1,0),(11,'Xe đẹp 2021',13,'toyota-vios.jpg','Toyota Vios',1,'478.000.000','','478.000.000','478.000.000',0,0,0),(33,'Xe đẹp 2021',1,'honda-brio.jpg','Honda Brio',0,'420.000.000','10','42,000,000','378,000,000',0,0,0),(36,'Xe đẹp 2021',1,'640-kia-morning-2021-ra-mat-tai-viet-nam.jfif','Kia Đỏ',1,'50.000.000','20','10,000,000','40,000,000',1,0,0);

-- tbl_setting
CREATE TABLE `tbl_setting` (
    `setting_id` int(11) NOT NULL AUTO_INCREMENT,
    `copyright` varchar(255) NOT NULL,
    `email` varchar(255) DEFAULT NULL,
    `phone` varchar(255) DEFAULT NULL,
    `web_name` varchar(255) DEFAULT NULL,
    `image_name` varchar(255) DEFAULT NULL,
    `link1` varchar(255) DEFAULT NULL,
    `link10` varchar(255) DEFAULT NULL,
    `link11` varchar(255) DEFAULT NULL,
    `link12` varchar(255) DEFAULT NULL,
    `link13` varchar(255) DEFAULT NULL,
    `link14` varchar(255) DEFAULT NULL,
    `link15` varchar(255) DEFAULT NULL,
    `link16` varchar(255) DEFAULT NULL,
    `link2` varchar(255) DEFAULT NULL,
    `link3` varchar(255) DEFAULT NULL,
    `link4` varchar(255) DEFAULT NULL,
    `link5` varchar(255) DEFAULT NULL,
    `link6` varchar(255) DEFAULT NULL,
    `link7` varchar(255) DEFAULT NULL,
    `link8` varchar(255) DEFAULT NULL,
    `link9` varchar(255) DEFAULT NULL,
    `module1` varchar(255) DEFAULT NULL,
    `module2` varchar(255) DEFAULT NULL,
    `module3` varchar(255) DEFAULT NULL,
    `module4` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`setting_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
INSERT INTO `tbl_setting` VALUES (1,'Ô Tô Phạm Hùng','nguyenvantuyen6789@gmail.com','0888.662.354','Ô Tô Phạm Hùng','ban16243474218043.jpg','xedep.com','Techcombank','HRM','Foody','IBM','Oracle','Vietcombank','Tinh Vân','kia.com','google.com','github.com','Sale Ô Tô','CSKH','Giải Ngân','Kế Toán','BIDV','Trang Chủ','Tuyển Dụng','Liên Kết','Khách Hàng');

-- tbl_user
CREATE TABLE `tbl_user` (
    `user_id` int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `address` varchar(255) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `full_name` varchar(255) DEFAULT NULL,
    `gender` varchar(255) DEFAULT NULL,
    `role` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
INSERT INTO `tbl_user` VALUES (1,'nguyenvantuyen6789','123456','Phú Đô','nguyenvantuyen6789@gmail.com','Tuyên Nguyễn','Nam','Admin'),(2,'nguyenvantuyen67891','123456','Phú Đô','nguyenvantuyen67891@gmail.com','Tuyên Nguyễn 3','Nam','User'),(11,'nguyenvantuyen67892','123456','','nguyenvantuyen67892@gmail.com','Tuyên Nguyễn','Nam','Admin'),(12,'nguyenvantuyen67893','123456','','nguyenvantuyen67893@gmail.com','Tuyên Nguyễn','Nam','Admin');

-- tbl_y_kien
CREATE TABLE `tbl_y_kien` (
    `y_kien_id` int(11) NOT NULL AUTO_INCREMENT,
    `email` varchar(255) DEFAULT NULL,
    `full_name` varchar(255) DEFAULT NULL,
    `phone` varchar(255) DEFAULT NULL,
    `y_kien` text,
    PRIMARY KEY (`y_kien_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
INSERT INTO `tbl_y_kien` VALUES (11,NULL,'',NULL,NULL),(12,NULL,'Tuyên',NULL,NULL),(13,'t','t','t','t');
