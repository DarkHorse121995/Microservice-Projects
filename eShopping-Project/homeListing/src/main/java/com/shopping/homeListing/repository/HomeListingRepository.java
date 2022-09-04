package com.shopping.homeListing.repository;

import com.shopping.homeListing.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeListingRepository extends JpaRepository<Item,Long> {
}
