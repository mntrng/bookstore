package fi.exercise.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import fi.exercise.bookstore.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}