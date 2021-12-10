package com.tuyennguyen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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

    @Column(nullable = false, columnDefinition = "TINYINT(1) UNSIGNED")
    private Integer menuOrder = 0;

    @Column(nullable = false, columnDefinition = "TINYINT(1) UNSIGNED")
    private Integer isParent = 0;

    @Column(nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private Integer parentId = 0;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false, columnDefinition = "TINYINT(1) UNSIGNED")
    private Integer isVisible = 1;

    @Column(nullable = false)
    private String color = "#000000";

//    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="menuDong")
//    private List<Product> products;
}