package com.demo.warehouse.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
public class DTOProduct {

    private long productId;
    private String productCod;
    private String categoryName;
    private String productName;
    private int quantity;
    private String unit;
    private String notes;

}
