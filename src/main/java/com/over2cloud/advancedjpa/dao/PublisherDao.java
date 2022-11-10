/**
 * 
 */
package com.over2cloud.advancedjpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.over2cloud.advancedjpa.model.Publisher;

/**
 * @author Suraj.Singh
 *
 */

@Repository
public interface PublisherDao extends CrudRepository<Publisher, Integer> {

}
