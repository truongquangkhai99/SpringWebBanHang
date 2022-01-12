package com.tuyennguyen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_y_kien")
public class YKien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer yKienId;

    @Column(nullable = true)
    private String fullName;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = true, length = 65535, columnDefinition = "text")
    private String yKien;

}
