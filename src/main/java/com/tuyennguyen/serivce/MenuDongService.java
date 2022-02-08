package com.tuyennguyen.serivce;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.repository.MenuDongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuDongService {

    @Autowired
    private MenuDongRepository menuDongRepo;

    public List<MenuDong> findAll() {
        return menuDongRepo.findAll();
    }

    public List<MenuDong> findAllByIsParent(int isParent) {
        return menuDongRepo.findAllByIsParent(isParent);
    }

    public List<MenuDong> findAllByIsVisible(int isVisible) {
        return menuDongRepo.findAllByIsVisible(isVisible);
    }

    public MenuDong save(MenuDong obj) {
        return menuDongRepo.save(obj);
    }

    public void deleteById(int id) {
        menuDongRepo.deleteById(id);
    }

}
