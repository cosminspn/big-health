/**
 * 
 */
package ro.bighealth.soap.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bighealth.commons.service.UserService;
import ro.bighealth.soap.service.ObjectFactory;
import ro.bighealth.soap.service.User;
import ro.bighealth.soap.service.UserServicePortType;

/**
 * @author CosminS
 *
 * @since 3 nov. 2014
 */
@Service("userCxfService")
@WebService(targetNamespace = "http://service.commons.bighealth.ro/", name = "UserServicePortType")
public class UserCxfServiceImpl implements UserServicePortType {

	@Autowired
	private UserService userService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.bighealth.cxf.service.UserServicePortType#create(ro.bighealth.cxf.service.User)
	 */
	@Override
	public User create(User entity) {

		ro.bighealth.commons.entity.User newUser = new ro.bighealth.commons.entity.User();

		newUser.setEmail(entity.getEmail());
		newUser.setFirstName(entity.getFirstName());
		newUser.setLastName(entity.getLastName());
		newUser.setPassword(entity.getPassword());
		newUser.setUsername(entity.getUsername());

		userService.create(newUser);

		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.bighealth.cxf.service.UserServicePortType#update(ro.bighealth.cxf.service.User)
	 */
	@Override
	public User update(User entity) {

		ro.bighealth.commons.entity.User newUser = new ro.bighealth.commons.entity.User();

		newUser.setId(entity.getId());
		newUser.setEmail(entity.getEmail());
		newUser.setFirstName(entity.getFirstName());
		newUser.setLastName(entity.getLastName());
		newUser.setPassword(entity.getPassword());
		newUser.setUsername(entity.getUsername());
		
		userService.update(newUser);

		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.bighealth.cxf.service.UserServicePortType#remove(java.lang.Long)
	 */
	@Override
	public void remove(Long entityId) {
		userService.remove(entityId);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.bighealth.cxf.service.UserServicePortType#findByEmail(java.lang.String)
	 */
	@Override
	public List<User> findByEmail(String email) {
		List<ro.bighealth.commons.entity.User> plainUsersFiltered = userService.findByEmail(email);

		List<User> usersList = new ArrayList<User>();

		for (ro.bighealth.commons.entity.User plainUser : plainUsersFiltered) {

			ObjectFactory objectFactory = new ObjectFactory();

			User newUser = objectFactory.createUser();

			newUser.setId(plainUser.getId());
			newUser.setUsername(plainUser.getUsername());
			newUser.setEmail(plainUser.getEmail());
			newUser.setPassword(plainUser.getPassword());
			newUser.setFirstName(plainUser.getFirstName());
			newUser.setLastName(plainUser.getLastName());

			usersList.add(newUser);

		}

		return usersList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.bighealth.cxf.service.UserServicePortType#findAll()
	 */
	@Override
	public List<User> findAll() {

		List<ro.bighealth.commons.entity.User> plainUsersFiltered = userService.findAll();

		List<User> newUsersList = new ArrayList<User>();

		for (ro.bighealth.commons.entity.User plainUser : plainUsersFiltered) {

			ObjectFactory objectFactory = new ObjectFactory();

			User newUser = objectFactory.createUser();

			newUser.setId(plainUser.getId());
			newUser.setUsername(plainUser.getUsername());
			newUser.setEmail(plainUser.getEmail());
			newUser.setPassword(plainUser.getPassword());
			newUser.setFirstName(plainUser.getFirstName());
			newUser.setLastName(plainUser.getLastName());

			newUsersList.add(newUser);
		}

		return newUsersList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.bighealth.cxf.service.UserServicePortType#findById(java.lang.Long)
	 */
	@Override
	public User findById(Long entityId) {
		ro.bighealth.commons.entity.User plainUser = userService.findById(entityId);
		
		ObjectFactory objectFactory = new ObjectFactory();

		User newUser = objectFactory.createUser();

		newUser.setId(plainUser.getId());
		newUser.setUsername(plainUser.getUsername());
		newUser.setEmail(plainUser.getEmail());
		newUser.setPassword(plainUser.getPassword());
		newUser.setFirstName(plainUser.getFirstName());
		newUser.setLastName(plainUser.getLastName());
		
		
		return newUser;
	}
}