package com.tuyennguyen.model.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductMap {

    private Integer productId;

    private Integer isVisible;

    private String productName;

    private Integer favourite;

    private String price;

    private Integer quantity;

    private Integer sale;

    private String menuName;

    private String imageName;

    private String giaConLai;

}
