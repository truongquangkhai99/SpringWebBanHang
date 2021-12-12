package com.tuyennguyen.serivce;

import com.tuyennguyen.entity.Setting;
import com.tuyennguyen.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettingService {

    @Autowired
    private SettingRepository settingRepo;

    public Optional<Setting> findById(int id) {
        return settingRepo.findById(id);
    }

    public Setting save(Setting obj) {
        return settingRepo.save(obj);
    }

}
