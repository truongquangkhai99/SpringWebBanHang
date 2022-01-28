package com.tuyennguyen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_article")
public class Article {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleId;
    private String title;
    private String imgStandFor;
    private String articleContent;
    private Integer userId;
    private Integer categoryId;

}
