package com.tuyennguyen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private double price;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private int quantity;

    @Column(nullable = true)
    private int visible;

    @ColumnDefault("0")
    @Column(nullable = true)
    private int menuDongId;

}
