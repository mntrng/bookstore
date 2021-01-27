package fi.exercise.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import fi.exercise.bookstore.model.Book;

@Controller
public class BookController {
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("book", new Book("No title", "Trung Nguyen", "123456XXX", 2021, 19999.2222));
		return "index";
	}
}