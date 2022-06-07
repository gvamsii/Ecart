package com.ecart.miracle.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecart.miracle.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	// @Query ("SELECT m FROM User m WHERE m.mobile LIKE %?1%")
	List<User> getByMobile(long mobile);

	@Query("select u from User u where u.email = :email")
	List<User> getByEmail(@Param("email") String email);

	// This query is to get the all details from user table based on mobile and
	// password for user login
	@Query("select u from User u where u.mobile = :mobile and u.password = :password")
	Optional<User> login(@Param("mobile") long mobile, @Param("password") String password);

	// This query is for update password based on mobile when user click on forgot
	// password
	@Modifying
	@Transactional
	@Query("UPDATE User SET password=:password where mobile=:mobile")
	void updatePassword(@Param("password") String password, @Param("mobile") long mobile);

	// This query is for update cart details based on the user id.
	@Modifying
	@Transactional
	@Query("UPDATE User SET cart=:cart where mobile=:mobile")
	void updateCart(@Param("cart") String id, @Param("mobile") long mobile);

	// This query is for update the wish list based on the user id.
	@Modifying
	@Transactional
	@Query("UPDATE User SET wishlist=:wishlist where mobile=:mobile")
	void updateWishList(@Param("wishlist") String id, @Param("mobile") long mobile);

	// This query is for update the quantity and cart based on the user id
	@Modifying
	@Transactional
	@Query("UPDATE User SET updated_quantity=:updated_quantity,cart=:cart where mobile=:mobile")
	void updateUserCartQuantity(@Param("updated_quantity") String updated_quantity, @Param("cart") String cart,
			@Param("mobile") long mobile);

	// This query is to get the updated quantity from cart based on the user id
	@Query("select u.updated_quantity from User u where u.mobile = :mobile")
	String getupdated_quantity(@Param("mobile") long mobile);

}
