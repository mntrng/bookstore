package fi.exercise.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fi.exercise.bookstore.model.Book;
import fi.exercise.bookstore.repository.BookRepository;
import fi.exercise.bookstore.repository.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	@GetMapping("/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	// Page for adding a new book
	@GetMapping("/addbook")
	public String addBookForm(Model model) {
		model.addAttribute("newbook", new Book());
		model.addAttribute("categories", catRepository.findAll());
		return "addbook";
	}
	
	@PostMapping("/save")
	public String addBook(Book newbook) {
		repository.save(newbook);
		return "redirect:/booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") long bookId, Model model) {
	    repository.deleteById(bookId);
	    return "redirect:/booklist";
	}
	
	// Edit book info
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") long bookId, Model model) {
	    model.addAttribute("book", repository.findById(bookId));
	    return "editbook";
	}
}