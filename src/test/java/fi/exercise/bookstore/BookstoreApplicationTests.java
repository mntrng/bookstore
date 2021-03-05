package fi.exercise.bookstore;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.exercise.bookstore.controller.BookController;
import fi.exercise.bookstore.controller.UserDetailServiceImpl;

@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookController bcontroller;
	
	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Test
	void contextLoads() throws Exception {
		assertNotNull(bcontroller);
		assertNotNull(userDetailsService);
	}
}