/**
 * 
 */
package com.over2cloud.advancedjpa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.over2cloud.advancedjpa.dao.BookDao;
import com.over2cloud.advancedjpa.dao.EmployeeDao;
import com.over2cloud.advancedjpa.dao.PersonDao;
import com.over2cloud.advancedjpa.model.Book;
import com.over2cloud.advancedjpa.model.CustomType;
import com.over2cloud.advancedjpa.model.Employee;
import com.over2cloud.advancedjpa.model.Person;

/**
 * @author Suraj.Singh
 *
 */

@Service
public class PersonService {
	
	@Autowired
	private PersonDao pesronDao;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	// SaveAll
	public Iterable<Person> saveAllPersons(Iterable<Person> personsData){
		return pesronDao.saveAll(personsData);
		
	}
	
	// Find all By ID
	public Iterable<Person> findAllPerson(Iterable<Integer> personIds){
		
		return pesronDao.findAllById(personIds);
	}
	
	// Derived Method Section
	
	public List<Person> findByFirstName(String firstName)
	{
		return pesronDao.findByFirstName(firstName);
	}
	
	public Person findByLastNameAndFirstName(String lastName, String firstName) 
	{
		return pesronDao.findByLastNameAndFirstName(lastName, firstName);
	}
	
	public List<Person> findByLastNameOrFirstName(String lastName, String firstName)
	{
		return pesronDao.findByLastNameOrFirstName(lastName, firstName);
	}
	
	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName)
	{
		return pesronDao.findByLastNameOrderByCreatedDateDesc(lastName);
	}
	
	public List<Person> findByAgeLessThanEqual(Integer age)
	{
		return pesronDao.findByAgeLessThanEqual(age);
	}
		
	public List<Person> findByFirstNameLike(String firstName)
	{
		return pesronDao.findByFirstNameLike(firstName);
	}
	
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName, Integer age){
		return pesronDao.findByLastNameAndAgeLessThanEqual(lastName,age);
	}
	
	public List<Person> findByCreatedDateBetween(Date startDate, Date endDate){
		return pesronDao.findByCreatedDateBetween(startDate, endDate);
	}

	public List<Person> findByEmail(String email){
		return pesronDao.findByEmail(email);
	}
	
	public List<Person> giveDataByName(String firstName){
		return pesronDao.giveDataByName(firstName);
	}
	
	public Iterable<Book> saveBooks(Iterable<Book> bookData){
		return bookDao.saveAll(bookData);
	}
	
	public Iterable<Book> getAllBooks(){
		return bookDao.findAll();
	}
	
	public Iterable<Book> findByBookName(String bookName){
		return bookDao.findByBookName(bookName);
	}
	
	public Iterable<Book> listBookData(String bookName){
		return bookDao.listBookData(bookName);
	}
	
	public Iterable<Employee> saveAllEmployess(Iterable<Employee> emplist){
		
		return employeeDao.saveAll(emplist);
	}
	
	public Iterable<Employee> giveAllEmployees(){
		return employeeDao.findAll();
	}
	
	public List<Object[]> findMaxSalariesByDept(List<String> deptNames){
		return employeeDao.findMaxSalariesByDept(deptNames);
	}
	
	public Iterable<CustomType> giveFewColumns(String firstName) {
		return pesronDao.giveFewColumns(firstName);
	}
	
	public List<Person> findPersonInfoByFirstNameOrEmail(String firstName, String email){
		return pesronDao.findPersonInfoByFirstNameOrEmail(firstName, email);
	}
	
	public List<Person> findPersonInfobyFirstName(String firstName){
		return pesronDao.findPersonInfobyFirstName(firstName);
	}
}
