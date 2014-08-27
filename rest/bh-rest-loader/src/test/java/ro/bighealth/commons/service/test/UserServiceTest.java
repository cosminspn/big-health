/**
 * 
 */
package ro.bighealth.commons.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByName;

import ro.bighealth.commons.entity.User;
import ro.bighealth.commons.service.UserService;
import ro.bighealth.restloader.test.core.BaseTest;
import ro.bighealth.restloader.test.core.EntityBuilder;

/**
 * Unit test class for {@link UserService}.
 * 
 * @author CosminS
 * @since Mar 10, 2014
 */
public class UserServiceTest extends BaseTest {

	/**
	 * Injected {@link UserService} service.
	 */
	@SpringBeanByName
	private UserService userService;

	/**
	 * Test for create and find an {@link User}.
	 */
	@Test
	public void createAndFindUser() {
		User dummy = userService.create(EntityBuilder.createUser());
		long expectedId = dummy.getId();
		User toSearch = userService.findById(expectedId);

		long actualId = toSearch.getId();

		assertNotNull(toSearch);
		assertEquals(expectedId, actualId);
	}

	/**
	 * Test for update and remove an {@link User}.
	 */
	@Test
	public void updateAndRemoveUser() {
		User dummy = userService.create(EntityBuilder.createUser());

		String newFirstName = "newfname";
		dummy.setFirstName(newFirstName);

		User updated = userService.update(dummy);
		User fromDb = userService.findById(updated.getId());

		assertEquals(newFirstName, fromDb.getFirstName());

		userService.remove(fromDb.getId());
		User deleted = userService.findById(fromDb.getId());

		assertNull(deleted);
	}
}