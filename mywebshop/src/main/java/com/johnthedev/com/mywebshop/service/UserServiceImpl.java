package com.johnthedev.com.mywebshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.johnthedev.com.mywebshop.dao.RoleRepository;
import com.johnthedev.com.mywebshop.dao.UserRepository;
import com.johnthedev.com.mywebshop.entity.Role;
import com.johnthedev.com.mywebshop.entity.User;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private UserRepository userRepository;

	private RoleRepository roleRepository;

	private final String USER_ROLE = "CUSTOMER";

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new UserDetailsImpl(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public String registerUser(User user) {
		User userCheck = userRepository.findByEmail(user.getEmail());

		if (userCheck != null)
			return "alreadyExists";

		Role userRole = roleRepository.findByRole(USER_ROLE);
		if (userRole != null) {
			user.getRoles().add(userRole);
		} else {
			user.addRoles(USER_ROLE);
		}
		
		user.setEnabled(true);
		user.setActivation(generateKey());
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		userRepository.save(user);
		

		return "ok";
	}

	public String generateKey()
    {
		String key = "";
		Random random = new Random();
		char[] word = new char[16]; 
		for (int j = 0; j < word.length; j++) {
			word[j] = (char) ('a' + random.nextInt(26));
		}
		String toReturn = new String(word);
		log.debug("random code: " + toReturn);
		return new String(word);
    }

	@Override
	public String userActivation(String code) {
		User user = userRepository.findByActivation(code);
		if (user == null)
		    return "noresult";
		
		user.setEnabled(true);
		user.setActivation("");
		userRepository.save(user);
		return "ok";
	}

	@Override
	public List<User> findAllUsers() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User findUserById(long theId) {
		
		Optional<User> foundUser= userRepository.findById(theId);
		
		User theUser = new User();
		
		if (foundUser.isPresent()) {
			
			theUser = foundUser.get(); 
			
		} else {
			
			throw new RuntimeException("Did not find user id - " + theId);
		}
		
		return theUser;
	}

	@Override
	public void updateUserData(User theUser) {
		
		List<User> allUsers = new ArrayList<User>();
		allUsers = findAllUsers();
		
		for (User tempUser : allUsers) {
			if (tempUser.getId() == theUser.getId()) {
				
				tempUser.setActivation(theUser.getActivation());
				tempUser.setEmail(theUser.getEmail());
				tempUser.setEnabled(true);
				tempUser.setFullName(theUser.getFullName());
				
				PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
				tempUser.setPassword(encoder.encode(theUser.getPassword()));

				
				Role userRole = roleRepository.findByRole(USER_ROLE);
				if (userRole != null) {
					tempUser.getRoles().add(userRole);
				} else {
					tempUser.addRoles(USER_ROLE);
				}
				
				userRepository.save(tempUser);
	
			}
		}
	}

	@Override
	public void deleteById(long theId) {

		userRepository.deleteById(theId);
		
	}

}
