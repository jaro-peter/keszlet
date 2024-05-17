package com.jaro.keszlet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeszletRepository extends JpaRepository <Product,Long> {

    List<Product> findAll();
}
