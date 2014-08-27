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
import ro.bighealth.commons.entity.MedicalCenter;
import ro.bighealth.commons.entity.Patient;
import ro.bighealth.commons.entity.User;
import ro.bighealth.commons.service.BloodTestService;
import ro.bighealth.commons.service.MedicalCenterService;
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
public class BloodTestServiceTest extends BaseTest {

	/**
	 * Injected {@link BloodTestService} service.
	 */
	@SpringBeanByName
	private BloodTestService bloodTestService;

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
	 * Injected {@link MedicalCenter} service.
	 */
	@SpringBeanByName
	private MedicalCenterService medicalCenterService;

	/**
	 * Test for create and find an {@link BloodTest}.
	 */
	@Test
	public void createAndFindBloodTest() {

		User dummyUser = userService.create(EntityBuilder.createUser());
		MedicalCenter dummyMedicalCenter = medicalCenterService.create(EntityBuilder.createMedicalCenter());
		Patient dummyPatient = EntityBuilder.createPatient();
		dummyPatient.setUser(dummyUser);

		Patient persistedPatient = patientService.create(dummyPatient);

		BloodTest dummy = EntityBuilder.createBloodTest();
		dummy.setPatient(persistedPatient);
		dummy.setMedicalCenter(dummyMedicalCenter);

		BloodTest dummyPersisted = bloodTestService.create(dummy);
		long expectedId = dummyPersisted.getId();
		BloodTest toSearch = bloodTestService.findById(expectedId);

		long actualId = toSearch.getId();

		assertNotNull(toSearch);
		assertEquals(expectedId, actualId);
	}

	/**
	 * Test for update and remove an {@link BloodTest}.
	 */
	@Test
	public void updateAndRemoveBloodTest() {
		
		User dummyUser = userService.create(EntityBuilder.createUser());
		MedicalCenter dummyMedicalCenter = medicalCenterService.create(EntityBuilder.createMedicalCenter());
		Patient dummyPatient = EntityBuilder.createPatient();
		dummyPatient.setUser(dummyUser);

		Patient persistedPatient = patientService.create(dummyPatient);

		BloodTest dummy = EntityBuilder.createBloodTest();
		dummy.setPatient(persistedPatient);
		dummy.setMedicalCenter(dummyMedicalCenter);

		BloodTest dummyPersisted = bloodTestService.create(dummy);

		String newTestsJson = "json1";
		dummyPersisted.setTestsJson(newTestsJson);

		BloodTest updated = bloodTestService.update(dummyPersisted);
		BloodTest fromDb = bloodTestService.findById(updated.getId());

		assertEquals(newTestsJson, fromDb.getTestsJson());

		bloodTestService.remove(fromDb.getId());
		BloodTest deleted = bloodTestService.findById(fromDb.getId());

		assertNull(deleted);
	}
}