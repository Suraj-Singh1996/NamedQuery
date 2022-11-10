/**
 * 
 */
package com.over2cloud.advancedjpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.over2cloud.advancedjpa.model.Book;

/**
 * @author Suraj.Singh
 *
 */

@Repository
public interface BookDao extends CrudRepository<Book, Integer> {
	
	//Derived Query
	
	public Iterable<Book> findByBookName(String bookName);
	
	//Named Query
	public Iterable<Book> listBookData(String bookName);

}
