package fi.exercise.bookstore.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
	private String title;
	private String author;
	private String isbn;
	private int year;
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	@JsonManagedReference
	private Category category;
	
	public Book() {}
	
	public Book(String title, String author, String isbn, int year, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null) {
			return "Book: " + title + " by " + author + " in " + year + " . Category: " + category;
		} else {
			return "Book: " + title + " by " + author + " in " + year;
		}
	}

}