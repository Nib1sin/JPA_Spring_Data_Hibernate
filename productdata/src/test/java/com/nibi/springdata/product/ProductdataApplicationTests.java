package com.nibi.springdata.product;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nibi.springdata.product.entities.Product;
import com.nibi.springdata.product.repos.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductdataApplicationTests {

	@Autowired
	ProductRepository repository;
	
	
	//
	@Test
	public void contextLoads() {
	}
	
	
	//
	@Test
	public void testCreate() {
		Product product = new Product();
		
		product.setId(1);
		product.setName("Iphone");
		product.setDesc("Nice");
		product.setPrice(250d);
		
		repository.save(product);
	}
	
	
	//
	@Test
	public void testRead() {
		
		Product product = repository.findById(1).get();
	
		assertNotNull(product);
		assertEquals("Iphone",  product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + product.getDesc());
	
	}

	
	//
	@Test
	public void testUpdate() {
		
		Product product = repository.findById(1).get();
		product.setPrice(1200d);
		repository.save(product);
		
	}
	
	
	//
	@Test
	public void testDelete() {
		
		if(repository.existsById(1)) {
			System.out.println("Deleting a product");
			repository.deleteById(1);
		}
	}
	
	
	
	//
	@Test
	public void testCount() {
		System.out.println("Total recount ------>>>" + repository.count());
	}

}

