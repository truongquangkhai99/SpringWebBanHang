package com.tuyennguyen.repository;

import com.tuyennguyen.entity.MenuDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDongRepository extends JpaRepository<MenuDong, Integer> {

    public List<MenuDong> findMenuDongByMenuName(String menuName);

    public int countMenuDongByMenuName(String menuName);

    public MenuDong findMenuDongByMenuLink(String menuLink);

    public List<MenuDong> findAllByIsParent(int isParent);

    public List<MenuDong> findAllByIsVisible(int isVisible);

}
