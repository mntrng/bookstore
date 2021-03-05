package fi.exercise.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.exercise.bookstore.model.User;
import fi.exercise.bookstore.repository.UserRepository;

@DataJpaTest
class UserRepositoryTests {
	
	@Autowired
	private UserRepository uRepo;
	
	@Test
	void createNewUser() {
		User user = new User("test", "dsadsa341", "a@a.fi", "GOD");
		uRepo.save(user);
		assertNotNull(user.getUsername());
	}
	
	@Test
	void findUser() {
		User user = uRepo.findByUsername("admin");
		assertEquals("admin", user.getUsername());
	}
	
	@Test
	void deleteUser() {
		User user = uRepo.findByUsername("admin");
		uRepo.delete(user);
		User deletedUser = uRepo.findByUsername("admin");
		assertNull(deletedUser);
	}
}