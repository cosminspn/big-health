/**
 * 
 */
package ro.bighealth.commons.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByName;

import ro.bighealth.commons.entity.BloodTest;
import ro.bighealth.commons.entity.Patient;
import ro.bighealth.commons.entity.User;
import ro.bighealth.commons.service.PatientService;
import ro.bighealth.commons.service.UserService;
import ro.bighealth.restloader.test.core.BaseTest;
import ro.bighealth.restloader.test.core.EntityBuilder;

/**
 * Unit test class for {@link BloodTest}.
 * 
 * @author CosminS
 * @since Mar 11, 2014
 */
public class PatientServiceTest extends BaseTest {
	
	/**
	 * Injected {@link PatientService} service.
	 */
	@SpringBeanByName
	private PatientService patientService;
	
	/**
	 * Injected {@link UserService} service.
	 */
	@SpringBeanByName
	private UserService userService;

	/**
	 * Test for create and find an {@link User}.
	 */
	@Test
	public void createAndFindPatient() {

		User dummyUser = userService.create(EntityBuilder.createUser());
		Patient dummyPatient = EntityBuilder.createPatient();
		dummyPatient.setUser(dummyUser);
		
		Patient dummy = patientService.create(dummyPatient);
		long expectedId = dummy.getId();
		Patient toSearch = patientService.findById(expectedId);

		long actualId = toSearch.getId();

		assertNotNull(toSearch);
		assertEquals(expectedId, actualId);
	}

	/**
	 * Test for update and remove an {@link User}.
	 */
	@Test
	public void updateAndRemovePatient() {
		
		User dummyUser = userService.create(EntityBuilder.createUser());
		Patient dummyPatient = EntityBuilder.createPatient();
		dummyPatient.setUser(dummyUser);
		
		Patient dummy = patientService.create(dummyPatient);
		
		String newCity = "newcity";
		dummy.setCity(newCity);

		Patient updated = patientService.update(dummy);
		Patient fromDb = patientService.findById(updated.getId());

		assertEquals(newCity, fromDb.getCity());

		patientService.remove(fromDb.getId());
		Patient deleted = patientService.findById(fromDb.getId());

		assertNull(deleted);
	}
}