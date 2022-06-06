package com.ecart.miracle.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ecart.miracle.models.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

	
	//This query is for update the price details based on the id
	@Modifying
	@Transactional
	@Query("UPDATE Product SET price=:price where id=:id")
	void updatePrice(@Param("price") int price, @Param("id") Long id);

    
	//This query is for update the quantity details based on the id
	@Modifying
	@Transactional
	@Query("UPDATE Product SET quantity=:quantity where id=:id")
	void updateQuantity(@Param("quantity") int quantity, @Param("id") Long id);


	//This query is for update the color details based on the id
	@Modifying
	@Transactional
	@Query("UPDATE Product SET colour=:colour where id=:id")
	 void updateColour(@Param("colour") String colour,@Param("id") Long id);
	
	
	

}
