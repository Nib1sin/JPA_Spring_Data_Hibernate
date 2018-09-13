package com.nibi.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.nibi.springdata.product.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
