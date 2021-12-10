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
    private Integer menuDongId;

    @Column(nullable = false)
    private String menuName;

    @Column(nullable = false)
    private String menuLink;

    @Column(nullable = false)
    private Integer menuOrder = 0;

    @Column(nullable = false)
    private Integer isParent = 0;

    @Column(nullable = true)
    private Integer parentId = 0;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private Integer isVisible = 1;

    @Column(nullable = true)
    private String color;

//    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="menuDong")
//    private List<Product> products;
}