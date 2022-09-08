package com.shopping.homeListing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {

    private String    itemId;

    @NotNull(message = "Item Name cannot be empty")
    private String  itemName;

    @NotNull(message = "Company cannot be empty")
    private String  itemCompany;

    private String  itemDetails;

    @NotNull(message = "Category name cannot be empty")
    private String  itemCategory;

    @NotNull(message = "Stock Remaining cannot be empty")
    @Min(0)
    @Max(Integer.MAX_VALUE)
    @Digits(integer = 10, fraction = 0)
    private Integer itemStockRemaining;
}
