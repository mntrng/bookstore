package fi.exercise.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.exercise.bookstore.model.Book;
import fi.exercise.bookstore.repository.BookRepository;

@DataJpaTest
class BookRepositoryTests {
	
	@Autowired
	private BookRepository bRepo;
	
	@Test
	void createNewBook() {
		Book book = new Book("Philosophy 101", "Maria Ozawa", "69693213123", 2000, 12.2, null);
		bRepo.save(book);
		assertNotNull(book.getAuthor());
	}
	
	@Test
	void findBook() {
		Book book = bRepo.findByTitle("Dark Hole 1");
		assertEquals("Dark Hole 1", book.getTitle());;
	}
	
	@Test
	void deleteBook() {
		Book book = bRepo.findByTitle("Dark Hole 1");
		bRepo.delete(book);
		Book deletedBook = bRepo.findByTitle("Dark Hole 1");
		assertNull(deletedBook);
	}
}