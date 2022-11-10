/**
 * 
 */
package com.over2cloud.advancedjpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.over2cloud.advancedjpa.model.Employee;

/**
 * @author Suraj.Singh
 *
 */
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	//By default Result set will converted into Java.Lang.Object
	public List<Object[]> findMaxSalariesByDept(List<String> deptNames);
}
