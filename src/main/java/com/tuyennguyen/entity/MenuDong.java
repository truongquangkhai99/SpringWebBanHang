package com.tuyennguyen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_MENU_DONG")
public class MenuDong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuDongId;

    @Column(nullable = true)
    private String menuName;

    @Column(nullable = true)
    private String url;

    @Column(nullable = true)
    private int menuOrder;

    @Column(nullable = true)
    private int isParent;

    @Column(nullable = true)
    private int parentId;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private int isVisible;

//    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="menuDong")
//    private List<Product> products;
}