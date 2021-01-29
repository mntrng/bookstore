package fi.exercise.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.exercise.bookstore.model.Book;
import fi.exercise.bookstore.repository.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner addRandomData(BookRepository bookRepository) {
		return (args) -> {
			log.info("Adding some dummy data");
			bookRepository.save(new Book("Dark Hole 1", "Stephen Hawking", "000-11-2222-0", 1970, 111.22));
			bookRepository.save(new Book("Dark Hole 2", "Albert Einstein", "000-11-2222-1", 1975, 22.40));
			bookRepository.save(new Book("Dark Hole 3", "Bukma Dahal", "000-11-2222-2", 1990, 1.12));
		};
	}
}