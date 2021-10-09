package com.tuyennguyen.repository;

import com.tuyennguyen.entity.MenuDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDongRepository extends JpaRepository<MenuDong, Integer> {
}
