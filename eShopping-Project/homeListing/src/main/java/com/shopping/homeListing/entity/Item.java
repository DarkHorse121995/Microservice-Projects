package com.shopping.homeListing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "createNew")
@Table(name = "ITEM_DETAILS")
public class Item {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private String itemId;
    private String  itemName;
    private String  itemCompany;
    private String  itemDetails;
    private String  itemCategory;
    private Integer itemStockRemaining;
}
