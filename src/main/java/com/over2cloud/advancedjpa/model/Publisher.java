/**
 * 
 */
package com.over2cloud.advancedjpa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Suraj.Singh
 *
 */

@Entity
@Table(name = "tbl_publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "publisher_id")
	private Integer publisherId;

	@Column(name = "publisher_name")
	private String publisherName;

	@ManyToMany(mappedBy = "publishers")
	// mappedBy==> Already we define relationship from book to publisher
	// Same relationship is there from publisher to book
	// Relationship define in the property publishers
	private Set<Book> books;

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	/**
	 * @param publisherName
	 * @param books
	 */
	public Publisher(String publisherName) {
		super();
		this.publisherName = publisherName;
	}

	public Publisher() {
	}

	public String toString() {
		String result = String.format("Publisher Data [id=%d, name='%s']%n", publisherId, publisherName);

		if (books != null) {
			for (Book book : books) {
				result += String.format("publisher [id=%d, name='%s']%n", book.getBookId(),
						book.getBookName());
			}
		}

		return result;

	}

}
