package com.tuyennguyen.serivce;

import com.tuyennguyen.entity.YKien;
import com.tuyennguyen.repository.YKienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YKienService {

    @Autowired
    private YKienRepository yKienRepo;

    public List<YKien> findAll() {
        return yKienRepo.findAll();
    }

    public YKien save(YKien yKien) {
        return yKienRepo.save(yKien);
    }

}
