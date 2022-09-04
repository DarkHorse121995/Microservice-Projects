package com.shopping.homeListing.controller;

import com.shopping.homeListing.dto.ItemDTO;
import com.shopping.homeListing.entity.Item;
import com.shopping.homeListing.exception.ItemNotFoundException;
import com.shopping.homeListing.service.HomeListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeListingController {

    @Autowired
    private HomeListingService listingService;

    @GetMapping(value = "/getAllItems", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAllItems(){
        return listingService.getAllItems();
    }

    @GetMapping(value = "/getItem/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Item getItembyId(@PathVariable("id") Long itemId) throws ItemNotFoundException{
        return listingService.getItembyId(itemId);
    }

    @PostMapping(value = "/addNewItem", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Item addNewItem(@RequestBody @Valid ItemDTO item){
        return listingService.addNewItem(item);
    }

    @PutMapping(value = "/updateItem/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Item updateItem(@RequestBody @Valid ItemDTO item, @PathVariable("id") Long itemId) throws ItemNotFoundException {
        return listingService.updateItem(item, itemId);
    }

    @DeleteMapping("/delete/{id}")
    public List<Item> deleteById(@PathVariable("id") Long itemId) throws ItemNotFoundException{
        listingService.deleteById(itemId);
        return listingService.getAllItems();
    }

}
