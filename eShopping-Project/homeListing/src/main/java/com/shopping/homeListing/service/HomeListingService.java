package com.shopping.homeListing.service;

import com.shopping.homeListing.dto.ItemDTO;
import com.shopping.homeListing.entity.Item;
import com.shopping.homeListing.exception.ItemNotFoundException;
import com.shopping.homeListing.repository.HomeListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HomeListingService {

    @Autowired
    private HomeListingRepository listingRepository;

    @Transactional
    public List<Item> getAllItems(){
        return listingRepository.findAll();
    }

    @Transactional
    public Item getItembyId(String itemId) throws ItemNotFoundException{
        return listingRepository.findById(itemId).orElseThrow(() -> new ItemNotFoundException(itemId + " not found!!"));
    }

    @Transactional
    public Item addNewItem(ItemDTO item){
        Item entity = Item.createNew("0",item.getItemName(),item.getItemCompany(),item.getItemDetails(),item.getItemCategory(),item.getItemStockRemaining());
//        Item entity = new Item();
//        entity.setItemName(item.getItemName());
//        entity.setItemCompany(item.getItemCompany());
//        entity.setItemDetails(item.getItemDetails());
//        entity.setItemCategory(item.getItemCategory());
//        entity.setItemStockRemaining(item.getItemStockRemaining());
        System.out.println(entity.toString());
        return listingRepository.save(entity);
    }

    @Transactional
    public Item updateItem(ItemDTO item, String itemId) throws ItemNotFoundException{
        Item entity = listingRepository.findById(itemId)
                .orElseThrow(() -> {return new ItemNotFoundException("Item " + item.getItemName()+ " not found!!");});
        entity.setItemCompany(item.getItemCompany());
        entity.setItemDetails(item.getItemDetails());
        entity.setItemName(item.getItemName());
        entity.setItemCategory(item.getItemCategory());
        entity.setItemStockRemaining(item.getItemStockRemaining());
        return listingRepository.save(entity);
    }

    @Transactional
    public void deleteById(String itemId) throws ItemNotFoundException{
        Item entity = listingRepository.findById(itemId).orElseThrow(() -> {return new ItemNotFoundException(itemId + " not deleted!!");});
        listingRepository.deleteById(itemId);
    }

}
