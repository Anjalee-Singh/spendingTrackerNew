package com.expense.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.expense.dao.UserDetailsDao;
import com.expense.entity.UserDetailsEntity;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDetailsDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		// FIXME get user details from Database
		UserDetailsEntity user = (UserDetailsEntity) userDao.findByPhoneNumber(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getPhoneNumber(), user.getPdfPassword(),
				new ArrayList<>());
		
		
	}
	/*public UserDao save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return (UserDao) userDao.save(newUser);
		}
	}*/
	//}
}
