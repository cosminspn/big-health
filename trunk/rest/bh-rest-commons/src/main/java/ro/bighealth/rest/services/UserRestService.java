/**
 * 
 */
package ro.bighealth.rest.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.bighealth.commons.entity.User;
import ro.bighealth.commons.service.UserService;

/**
 * REST services for {@link User}.
 * 
 * @author CosminS
 * @since Mar 12, 2014
 */
@Component
@Path("users")
public class UserRestService {

	/**
	 * Injected {@link UserService} service.
	 */
	@Autowired
	private UserService userService;

	/**
	 * REST service for creating an user.
	 * 
	 * @param user
	 *            user to be created.
	 * @return created user.
	 */
	@Path("createUser")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User createUser(User user) {
		User persisted = userService.create(user);

		return persisted;
	}

	/**
	 * REST service for getting all users.
	 * 
	 * @return list with all users.
	 */
	@GET
	@Path("getUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		List<User> usersList = userService.findAll();

		return usersList;
	}

	/**
	 * REST service for getting an user with a specified id.
	 * 
	 * @param userId
	 *            the specified user id
	 * @return the user with the specified id.
	 */
	@GET
	@Path("getUser/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam(value = "userId") long userId) {
		User user = userService.findById(userId);

		return user;
	}

	/**
	 * REST service for creating an user.
	 * 
	 * @param user
	 *            user to be created.
	 * @return created user.
	 */
	@Path("updateUser")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User updateUser(User user) {
		User updated = userService.update(user);

		return updated;
	}

	/**
	 * REST service for deleting an user.
	 * 
	 * @param userId
	 *            the user id
	 */
	@Path("deleteUser")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(@QueryParam(value = "userId") long userId) {
		userService.remove(userId);
	}

	/**
	 * REST service for deleting an user.
	 * 
	 * @param email
	 *            the email of the user
	 * @return the user.
	 */
	@Path("getUser")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findUserByEmail(@QueryParam(value = "email") String email) {
		
		List<User> found = userService.findByEmail(email);
		
		return found;
	}
}