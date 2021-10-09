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
    private MenuDongRepository repository;

    public List<MenuDong> findAll() {
        return repository.findAll();
    }

    public Optional<MenuDong> findById(int id) {
        return repository.findById(id);
    }

    public MenuDong save(MenuDong obj) {
        return repository.save(obj);
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
