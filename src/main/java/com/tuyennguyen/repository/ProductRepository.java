package com.tuyennguyen.repository;

import com.tuyennguyen.entity.Product;
import com.tuyennguyen.model.mapping.ProductMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT b.menu_name AS menuName FROM TBL_PRODUCT a JOIN TBL_MENU_DONG b ON a.menu_dong_id = b.menu_dong_id", nativeQuery = true)
    public List<ProductMap> getListProductShowProductList();

    public List<Product> findProductsByMenuDongId(int menuDongId);

    public int countProductByProductName(String productName);

    public List<Product> findProductsByFavouriteAndIsVisible(int favourite, int isVisible);

    public List<Product> findProductsByFavourite(int favourite);

    public List<Product> findProductsByIsVisible(int isVisible);

}
