package fi.exercise.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.exercise.bookstore.model.User;
import fi.exercise.bookstore.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final UserRepository repository;
	
	@Autowired
	public UserDetailServiceImpl(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User currentUser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, 
				currentUser.getPasswordHash(), 
				AuthorityUtils.createAuthorityList(currentUser.getRole()));
		return user;
	}
}