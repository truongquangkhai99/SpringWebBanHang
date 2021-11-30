package com.tuyennguyen.model.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ColumnResult;
import javax.persistence.SqlResultSetMapping;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SqlResultSetMapping(
        name="FridayEmployeeResult",
        columns = {@ColumnResult(name="menuName")}
)
public class ProductMap {

//    private int productId;
//
//    private String name;
//
//    private double price;
//
//    private String description;
//
//    private String imageName;
//
//    private int quantity;
//
//    private int visible;
//
//    private int menuDongId;
//
//    private int favourite;

    private String menuName;

}
