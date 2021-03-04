package fi.exercise.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.exercise.bookstore.model.Book;
import fi.exercise.bookstore.model.Category;
import fi.exercise.bookstore.model.User;
import fi.exercise.bookstore.repository.BookRepository;
import fi.exercise.bookstore.repository.CategoryRepository;
import fi.exercise.bookstore.repository.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner addRandomData(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepo) {
		return (args) -> {
			log.info("Adding some dummy data");
			categoryRepository.save(new Category("Science"));
			categoryRepository.save(new Category("History"));
			categoryRepository.save(new Category("Comedy"));
			categoryRepository.save(new Category("Technology"));
			bookRepository.save(new Book("Dark Hole 1", "Stephen Hawking", "000-11-2222-0", 1970, 111.22, categoryRepository.findByName("Science").get(0)));
			bookRepository.save(new Book("Dark Hole 2", "Albert Einstein", "000-11-2222-1", 1975, 22.40, categoryRepository.findByName("History").get(0)));
			bookRepository.save(new Book("Databases", "Bukma Dahal", "000-11-2222-2", 1990, 1.12, categoryRepository.findByName("Technology").get(0)));
			bookRepository.save(new Book("Programming I", "Alan Turing", "000-11-2244-2", 1940, 1000.8, categoryRepository.findByName("Technology").get(0)));
			bookRepository.save(new Book("Laugh Right Now", "Russell Peters", "000-11-2222-5", 1995, 33.5, categoryRepository.findByName("Comedy").get(0)));
			userRepo.save(new User("user", "$2a$10$DYtVGWDB63MXIdRL8GMAnOseSGxdV/pbOrPO4SSSSVvx.Hn7NToTC", "user@user.com", "USER"));
			userRepo.save(new User("admin", "$2a$10$qVA9GwzeRyGPEyF/u398lu3CWmdKVdVaTpg98o2D.LD9LNbOyBxUa", "admin@admin.com", "ADMIN"));
		};
	}
}