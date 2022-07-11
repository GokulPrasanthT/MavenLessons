package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//import com.chainsys.mavenlessons.entity.Passport;
import com.chainsys.mavenlessons.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findById(int id);

//	Passport findByPassportId(int id);
	List<User> findAll();

	User save(User user);

	void deleteById(int id);

	@Query("select u from User u where u.id=?1")
	User getUser(int uid); // This is Example of JPQL

	@Query(value = "select * from users u where u.USER_ID=?1", nativeQuery = true)
	User getUserNativeSQL(int uid); // Example of Native Query

	@Query("")
	void modifyUser(int id, String name, String city);
}

//Query . Two types of queries
/*
 * 1. JPQL (Java Persistence Query Language) Query on POJO Entity classes 2.
 * Native SQL Queries
 *
 *
 */