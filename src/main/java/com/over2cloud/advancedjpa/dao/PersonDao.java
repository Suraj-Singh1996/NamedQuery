/**
 * 
 */
package com.over2cloud.advancedjpa.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.over2cloud.advancedjpa.model.CustomType;
import com.over2cloud.advancedjpa.model.Person;

/**
 * @author Suraj.Singh
 *
 */

@Repository
public interface PersonDao extends CrudRepository<Person, Integer> {
	
	// Derived methods section 
	
	public List<Person> findByFirstName(String firstName);
	//Select * from tbl_person where first_name=firstName;
		
	public Person findByLastNameAndFirstName(String lastName, String firstName);
	// Select * from tbl_person where last_name=lastName and first_name=firstName;
	
	public List<Person> findByLastNameOrFirstName(String lastName, String firstName);
	// Select * from tbl_person where last_name=lastName or first_name=firstName;
	
	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName);
	//Select * from tbl_person where last_name=lastName order by created_date desc;
	
	public List<Person> findByAgeLessThanEqual(Integer age);
	// Select * from tbl_person where age<=age;
		
	public List<Person> findByFirstNameLike(String firstName);
	// Wild card search and "%" symbol should be add by developer
	// firstName ==> %firstName%'; ==> wild card search
	// Select * from tbl_person where first name like %firstName%
	
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName, Integer age);
	//Select * from tbl_person where last_name=lastName and age<=age;
	
	public List<Person> findByCreatedDateBetween(Date startDate, Date endDate);

	public List<Person> findByEmail(String email);// Surjsingh777@gmail.com
	
	//NamedQuery
	//Abstract Method at interface Layer and Implementation at POJO/ENTITY/MODEL layer
	
	public List<Person> giveDataByName(String firstName);
	
	public Iterable<CustomType> giveFewColumns(String firstName);
	
	//Query==> We are going to write JPQL==> Writing java class and java properties 
	@Query(value = "SELECT p from Person p where p.firstName=?1 OR p.email=?2")//Implementation 
	List<Person> findPersonInfoByFirstNameOrEmail(String firstName, String email);//Abstract Method
	
	//Native Query -> WE are going to write SQL -> Writing database name and database column
	@Query(value = "select * from tbl_person where first_name=?1",nativeQuery = true)
	List<Person> findPersonInfobyFirstName(String firstName);
	
}
