package com.tuyennguyen.serivce;

import com.tuyennguyen.entity.Product;
import com.tuyennguyen.model.mapping.ProductMap;
import com.tuyennguyen.repository.ProductRepository;
import com.tuyennguyen.util.UtilCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @PersistenceContext
    private javax.persistence.EntityManager entityManager;

    public List<ProductMap> getListProductShowProductList() {
        return productRepo.getListProductShowProductList();
    }

    public List<ProductMap> getListProductMap(int type) {
        String sql = "";
        sql += "SELECT";
        sql += "    a.product_id            productId                       , ";
        sql += "    a.is_visible            isVisible                       , ";
        sql += "    a.product_name          productName                     , ";
        sql += "    a.favourite             favourite                       , ";
        sql += "    a.price                 price                           , ";
        sql += "    a.quantity              quantity                        , ";
        sql += "    a.sale                  sale                            , ";
        sql += "    b.menu_name             menuName                        , ";
        sql += "    a.image_name            imageName                         ";
        sql += "FROM                                                          ";
        sql += "    TBL_PRODUCT a JOIN      TBL_MENU_DONG b                   ";
        sql += "                   ON       a.menu_dong_id = b.menu_dong_id   ";

        if (type == UtilCon.ALL_ITEM) {

        } else if (type == UtilCon.FAVOURITE_ITEM) {
            sql += "WHERE                                                     ";
            sql += "    a.favourite     = 1                                   ";

        } else if (type == UtilCon.INVISIBLE_ITEM) {
            sql += "WHERE                                                     ";
            sql += "    a.is_visible    = 0                                   ";
        }

        System.out.println(sql.replaceAll("\\s{2,}"," "));
        Query sqlQuery = entityManager.createNativeQuery(sql, "listProductWithMenuName");

        List<ProductMap> listProductMap = sqlQuery.getResultList();
        System.out.println(listProductMap.size());
        return listProductMap;
    }

    public Optional<Product> findById(int id) {
        return productRepo.findById(id);
    }

    public Product save(Product obj) {
        return productRepo.save(obj);
    }

    public void deleteById(int id) {
        productRepo.deleteById(id);
    }

}
