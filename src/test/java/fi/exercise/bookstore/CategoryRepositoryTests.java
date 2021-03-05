package fi.exercise.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.exercise.bookstore.model.Category;
import fi.exercise.bookstore.repository.CategoryRepository;

@DataJpaTest
class CategoryRepositoryTests {
	
	@Autowired
	private CategoryRepository cRepo;
	
	@Test
	void createNewCat() {
		Category cat = new Category("Philosophy");
		cRepo.save(cat);
		assertNotNull(cat);
	}
	
	@Test
	void findCat() {
		List<Category> cat = cRepo.findByName("Comedy");
		assertEquals("Comedy", cat.get(0).getName());
	}
	
	@Test
	void deleteCat() {
		List<Category> cat = cRepo.findByName("Science");
		cRepo.delete(cat.get(0));
		List<Category> deletedCat = cRepo.findByName("Science");
		assertEquals(0, deletedCat.size());
	}
}