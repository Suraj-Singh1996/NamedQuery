package com.over2cloud.advancedjpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.over2cloud.advancedjpa.model.Book;
import com.over2cloud.advancedjpa.model.CustomType;
import com.over2cloud.advancedjpa.model.Employee;
import com.over2cloud.advancedjpa.model.Person;
import com.over2cloud.advancedjpa.model.Publisher;
import com.over2cloud.advancedjpa.service.PersonService;

@SpringBootApplication
public class AdvancedJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(AdvancedJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// createPersons();
		// getPersons();
		// findByFirstName();
		// findByFirstNameAndLastName();
		// findByFirstNameOrLastName();
		// findByEmail();
		// findByLastNameOrderByCreatedDateDesc();
		// findByAgeLessThanEqual();
		// findByFirstNameLike();
		// findByLastNameAndAgeLessThanEqual();
		// findByCreatedDateBetweenWithTime();
		// giveDataByName();
		// saveBookPulishers();
		// getBooksByDerivedQuery();
		// listBookData();
		// createEmployess();
		// findMaxSalariesByDept();
		//giveFewColumns();
		findPersonInfoByFirstNameOrEmail(); //Query
		findPersonInfobyFirstName(); // Native Query
	}

	private void findPersonInfoByFirstNameOrEmail() {

		Iterable<Person> personList = personService.findPersonInfoByFirstNameOrEmail("Signora", "signora@gmail.com");
		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());
		}
	}

	private void findPersonInfobyFirstName() {

		Iterable<Person> personList = personService.findPersonInfobyFirstName("Signora");
		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());
		}
	}

	private void createEmployess() {
		List<Employee> emplist = Arrays.asList(
				// Admin department
				Employee.create("Ram", "Admin", 20000), Employee.create("Gopi", "Admin", 35000),

				// Sales Department
				Employee.create("Sita", "Sale", 10000), Employee.create("Ganesh", "Sale", 30000),

				// IT Department
				Employee.create("Laxman", "IT", 40000), Employee.create("Seenu", "IT", 25000),

				// HR Department
				Employee.create("Swathi", "HR", 80000), Employee.create("Sneha", "HR", 65000));

		Iterable<Employee> list = personService.saveAllEmployess(emplist);
		for (Employee emps : list) {
			System.out.println("Employee Object " + emps);
		}
	}

	private void findMaxSalariesByDept() {
		List<Object[]> list = personService.findMaxSalariesByDept(Arrays.asList("Admin", "IT", "HR"));
		list.forEach(arr -> {
			System.out.println(Arrays.toString(arr));
		});
	}

	private void saveBookPulishers() {

		Publisher publisherA = new Publisher("Abdul Kalam Sir");
		Publisher publisherB = new Publisher("Robard Kowasacki");
		Publisher publisherC = new Publisher("Chatan Bhagat");
		Publisher publisherD = new Publisher("Auther2");
		Publisher publisherE = new Publisher("Auther2");
		Publisher publisherF = new Publisher("Nazir");

		Book bookA = new Book("WingsOfFire", new HashSet<>(Arrays.asList(publisherA)));
		Book bookB = new Book("Reach Dad poor Dad", new HashSet<>(Arrays.asList(publisherB)));
		Book bookC = new Book("TwoStates", new HashSet<>(Arrays.asList(publisherC)));
		// One two Many from Book to Publisher
		Book bookD = new Book("Book2", new HashSet<>(Arrays.asList(publisherD, publisherE)));
		// One to Many from Publisher to Book
		Book bookE = new Book("Book5", new HashSet<>(Arrays.asList(publisherF)));
		Book bookF = new Book("Book6", new HashSet<>(Arrays.asList(publisherF)));

		personService.saveBooks(Arrays.asList(bookA, bookB, bookC, bookD, bookE, bookF));

		// fetch all publishers
		for (Book book : personService.getAllBooks()) {
			System.out.println(book.toString());
		}
	}

	private void getBooksByDerivedQuery() {
		Iterable<Book> bookList = personService.findByBookName("Book2");
		for (Book bookslists : bookList) {
			System.out.println(bookslists);
		}

	}

	private void listBookData() {
		Iterable<Book> bookList = personService.listBookData("Book2");
		for (Book bookslists : bookList) {
			System.out.println(bookslists);
		}

	}

	private void createPersons() {

		List<Person> personList = Arrays.asList(new Person("Poonam", "Chauhan", "poonam@gmail.com", 20),
				new Person("Sanjana", "Chauhan", "sanju@gmail.com", 20),
				new Person("Ashwanee", "kumar", "ashwaneekumar@gmail.com", 20),
				new Person("Bhavnarushi", "Cehanuri", "rushi@gmail.com", 20),
				new Person("Pankaj", "Singh", "singh7@gmail.com", 20),
				new Person("Dheeraj", "Chauhan", "dershtiyog@gmail.com", 20),
				new Person("Signora", "koonar", "signora@gmail.com", 20),
				new Person("Sneh", "Kumari", "kumari@gmail.com", 20),
				new Person("Aditya", "Singh", "aditeya@gmail.com", 20),
				new Person("Adharsh", "Singh", "asharsh@gmail.com", 20));

		Iterable<Person> list = personService.saveAllPersons(personList);
		for (Person person : list) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void giveFewColumns() {
		Iterable<CustomType> personsList = personService.giveFewColumns("Sanjana");
		for (CustomType person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findByFirstName() {
		Iterable<Person> personsList = personService.findByFirstName("Sanjana");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findByFirstNameAndLastName() {
		Person person = personService.findByLastNameAndFirstName("Chauhan", "Sanjana");
		System.out.println("Person Object" + person.toString());
	}

	private void findByFirstNameOrLastName() {
		Iterable<Person> personsList = personService.findByLastNameOrFirstName("Chauhan", "Sanjana");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	public void findByEmail() {
		Iterable<Person> personsList = personService.findByEmail("poonam@gmail.com");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findByLastNameOrderByCreatedDateDesc() {

		Iterable<Person> personList = personService.findByLastNameOrderByCreatedDateDesc("Singh");

		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());
		}
	}

	private void findByAgeLessThanEqual() {

		Iterable<Person> personList = personService.findByAgeLessThanEqual(20);

		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());
		}
	}

	private void findByFirstNameLike() {

		Iterable<Person> personList = personService.findByFirstNameLike("Pankaj");

		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());
		}
	}

	private void findByLastNameAndAgeLessThanEqual() {
		Iterable<Person> personsList = personService.findByLastNameAndAgeLessThanEqual("Singh", 20);
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void findByCreatedDateBetweenWithTime() {
		Iterable<Person> personsList = personService.findByCreatedDateBetween(getDateWithTime("2022-09-30 23:47:22"),
				getDateWithTime("2022-09-30 23:50:22"));
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private Date getDateWithTime(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.parse(dateString);
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}

	private void giveDataByName() {
		Iterable<Person> personsList = personService.giveDataByName("Sneh");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

}
