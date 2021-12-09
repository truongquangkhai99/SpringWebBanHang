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

    @Column(nullable = true)
    private Integer menuOrder;

    @Column(nullable = false)
    private Integer isParent;

    @Column(nullable = true)
    private Integer parentId;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private Integer isVisible;

//    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="menuDong")
//    private List<Product> products;
}