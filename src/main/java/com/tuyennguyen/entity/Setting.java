package com.tuyennguyen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_setting")
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer settingId;

    @Column(nullable = false)
    private String copyright;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String webName;

    @Column(nullable = true)
    private String imageName;

    @Column(nullable = true)
    private String module1;

    @Column(nullable = true)
    private String link1;

    @Column(nullable = true)
    private String link2;

    @Column(nullable = true)
    private String link3;

    @Column(nullable = true)
    private String link4;

    @Column(nullable = true)
    private String module2;

    @Column(nullable = true)
    private String link5;

    @Column(nullable = true)
    private String link6;

    @Column(nullable = true)
    private String link7;

    @Column(nullable = true)
    private String link8;

    @Column(nullable = true)
    private String module3;

    @Column(nullable = true)
    private String link9;

    @Column(nullable = true)
    private String link10;

    @Column(nullable = true)
    private String link11;

    @Column(nullable = true)
    private String link12;

    @Column(nullable = true)
    private String module4;

    @Column(nullable = true)
    private String link13;

    @Column(nullable = true)
    private String link14;

    @Column(nullable = true)
    private String link15;

    @Column(nullable = true)
    private String link16;

}
