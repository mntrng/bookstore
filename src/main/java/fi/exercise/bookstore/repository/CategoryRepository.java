package fi.exercise.bookstore.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import fi.exercise.bookstore.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findByName(String name);
}