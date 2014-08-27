/**
 * 
 */
package ro.bighealth.commons.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByName;

import ro.bighealth.commons.entity.Doctor;
import ro.bighealth.commons.entity.MedicalCenter;
import ro.bighealth.commons.entity.MedicalSection;
import ro.bighealth.commons.entity.User;
import ro.bighealth.commons.service.DoctorService;
import ro.bighealth.commons.service.MedicalCenterService;
import ro.bighealth.commons.service.MedicalSectionService;
import ro.bighealth.commons.service.UserService;
import ro.bighealth.restloader.test.core.BaseTest;
import ro.bighealth.restloader.test.core.EntityBuilder;

/**
 * Unit test class for {@link DoctorService}.
 * 
 * @author CosminS
 * @since Mar 12, 2014
 */
public class DoctorServiceTest extends BaseTest {
	
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
	 * Injected {@link MedicalSection} service.
	 */
	@SpringBeanByName
	private MedicalSectionService medicalSectionService;
	
	/**
	 * Injected {@link DoctorService} service.
	 */
	@SpringBeanByName
	private DoctorService doctorService;
	
	/**
	 * Test for create and find an {@link Doctor}.
	 */
	@Test
	public void createAndFindDoctor() {
		
		User dummyUser = userService.create(EntityBuilder.createUser());
		MedicalCenter dummyMedicalCenter = medicalCenterService.create(EntityBuilder.createMedicalCenter());
		MedicalSection dummyMedicalSection = medicalSectionService.create(EntityBuilder.createMedicalSection());
		
		Doctor dummyDoctor = EntityBuilder.createDoctor();
		dummyDoctor.setUser(dummyUser);
		dummyDoctor.setMedicalCenter(dummyMedicalCenter);
		dummyDoctor.setMedicalSection(dummyMedicalSection);

		Doctor persisted = doctorService.create(dummyDoctor);
		long expectedId = dummyDoctor.getId();
		
		Doctor toSearch = doctorService.findById(persisted.getId());
		long actualId = toSearch.getId();

		assertNotNull(toSearch);
		assertEquals(expectedId, actualId);
	}
	
	/**
	 * Test for update and remove a {@link Doctor}.
	 */
	@Test
	public void updateAndRemoveDoctor() {
		User dummyUser = userService.create(EntityBuilder.createUser());
		MedicalCenter dummyMedicalCenter = medicalCenterService.create(EntityBuilder.createMedicalCenter());
		MedicalSection dummyMedicalSection = medicalSectionService.create(EntityBuilder.createMedicalSection());
		
		Doctor dummyDoctor = EntityBuilder.createDoctor();
		dummyDoctor.setUser(dummyUser);
		dummyDoctor.setMedicalCenter(dummyMedicalCenter);
		dummyDoctor.setMedicalSection(dummyMedicalSection);

		Doctor persisted = doctorService.create(dummyDoctor);
		
		User userNew = EntityBuilder.createUser();
		userNew.setUsername("username1");
		
		User dummyUserNew = userService.create(userNew);
		persisted.setUser(dummyUserNew);

		Doctor updated = doctorService.update(persisted);
		Doctor fromDb = doctorService.findById(updated.getId());

		assertEquals(dummyUserNew.getId(), fromDb.getUser().getId());

		doctorService.remove(fromDb.getId());
		Doctor deleted = doctorService.findById(fromDb.getId());

		assertNull(deleted);
	}
}