package com.tuyennguyen.repository;

import com.tuyennguyen.entity.YKien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YKienRepository extends JpaRepository<YKien, Integer> {


}
