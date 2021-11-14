package com.tuyennguyen.repository;

import com.tuyennguyen.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findProductsByMenuDongId(int menuDongId);

    public List<Product> findProductsByFavouriteAndVisible(int favourite, int visible);

    public List<Product> findProductsByFavourite(int favourite);

    public List<Product> findProductsByVisible(int visible);

}
