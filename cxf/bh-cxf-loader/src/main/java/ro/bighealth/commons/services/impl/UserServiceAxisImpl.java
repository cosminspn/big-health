/**
 * 
 */
package ro.bighealth.commons.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bighealth.commons.entity.xsd.ObjectFactory;
import ro.bighealth.commons.entity.xsd.User;
import ro.bighealth.commons.service.UserAxisServicePortType;
import ro.bighealth.commons.service.UserService;

/**
 * @author CosminS
 *
 * @since 31 oct. 2014
 */
@Service("userAxisService")
@WebService(targetNamespace = "http://service.commons.bighealth.ro", name = "userAxisServicePortType")
public class UserServiceAxisImpl implements UserAxisServicePortType {

	@Autowired
	private UserService userService;

	@Override
	public List<User> findByEmail(String email) {

		List<ro.bighealth.commons.entity.User> usersFiltered = userService.findByEmail(email);

		List<User> usersList = new ArrayList<User>();

		for (ro.bighealth.commons.entity.User user : usersFiltered) {

			ObjectFactory objectFactory = new ObjectFactory();

			User newUser = objectFactory.createUser();
			newUser.setId(user.getId());
			newUser.setUsername(objectFactory.createUserUsername(user.getUsername()));

			usersList.add(newUser);

		}

		return usersList;
	}
}
