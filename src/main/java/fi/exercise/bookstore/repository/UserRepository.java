package fi.exercise.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import fi.exercise.bookstore.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}