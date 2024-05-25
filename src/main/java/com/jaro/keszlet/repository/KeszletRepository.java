package com.jaro.keszlet.repository;

import com.jaro.keszlet.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KeszletRepository extends JpaRepository <Product, UUID> {

}
