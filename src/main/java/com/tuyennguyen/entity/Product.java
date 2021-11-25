package com.tuyennguyen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(nullable = true)
    private String productName;

    @Column(nullable = true)
    private double price;

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

}
