package com.tuyennguyen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tuyennguyen.model.mapping.ProductMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_Product")
@SqlResultSetMapping(name = "listProductWithMenuName", classes = {
    @ConstructorResult(targetClass = ProductMap.class, columns = {
        @ColumnResult(name = "productId", type = Integer.class),
        @ColumnResult(name = "isVisible", type = Integer.class),
        @ColumnResult(name = "productName", type = String.class),
        @ColumnResult(name = "favourite", type = Integer.class),
        @ColumnResult(name = "price", type = String.class),
        @ColumnResult(name = "quantity", type = Integer.class),
        @ColumnResult(name = "sale", type = Integer.class),
        @ColumnResult(name = "menuName", type = String.class),
        @ColumnResult(name = "imageName", type = String.class),
    })
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(nullable = true)
    private String productName;

    @Column(nullable = true)
    private String price;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private String imageName;

    @Column(nullable = true)
    private Integer quantity;

    @Column(nullable = true)
    private Integer isVisible;

    @ColumnDefault("0")
    @Column(nullable = true)
    private Integer menuDongId;

    @Column(nullable = true, columnDefinition = "INT(11) UNSIGNED")
    private Integer favourite;

    @Column(nullable = true, columnDefinition = "INT(11) UNSIGNED")
    private Integer sale;

    @Column(nullable = true)
    private String salePercent;

    @Column(nullable = true)
    private String salePrice;

    @Column(nullable = true)
    private String giaConLai;

}
