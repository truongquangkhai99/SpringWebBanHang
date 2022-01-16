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
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT                                                          ");
        sql.append("    a.product_id            productId                         , ");
        sql.append("    a.is_visible            isVisible                         , ");
        sql.append("    a.product_name          productName                       , ");
        sql.append("    a.favourite             favourite                         , ");
        sql.append("    a.price                 price                             , ");
        sql.append("    a.quantity              quantity                          , ");
        sql.append("    a.sale                  sale                              , ");
        sql.append("    b.menu_name             menuName                          , ");
        sql.append("    a.image_name            imageName                         , ");
        sql.append("    a.gia_con_lai           giaConLai                           ");
        sql.append("FROM                                                            ");
        sql.append("    tbl_product a JOIN      tbl_menu_dong b                     ");
        sql.append("                   ON       a.menu_dong_id = b.menu_dong_id     ");

        if (type == UtilCon.ALL_ITEM) {
            // do nothing
        } else if (type == UtilCon.FAVOURITE_ITEM) {
            sql.append("WHERE                                                       ");
            sql.append("    a.favourite     = 1                                     ");

        } else if (type == UtilCon.INVISIBLE_ITEM) {
            sql.append("WHERE                                                       ");
            sql.append("    a.is_visible    = 0                                     ");
        } else if (type == UtilCon.VISIBLE_ITEM) {
            sql.append("WHERE                                                       ");
            sql.append("    a.is_visible    = 1                                     ");
        }

        Query sqlQuery = entityManager.createNativeQuery(sql.toString(), "listProductMapName");
        List<ProductMap> listProductMap = sqlQuery.getResultList();

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
