package com.tuyennguyen.repository;

import com.tuyennguyen.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Integer> {

    public List<Setting> findSettingBySettingId(int settingId);

}
