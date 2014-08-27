/**
 * 
 */
package ro.bighealth.commons.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByName;

import ro.bighealth.commons.entity.MedicalCenter;
import ro.bighealth.commons.service.MedicalCenterService;
import ro.bighealth.restloader.test.core.BaseTest;
import ro.bighealth.restloader.test.core.EntityBuilder;

/**
 * Unit test class for {@link MedicalCenter}.
 * @author CosminS
 * @since Mar 11, 2014
 */
public class MedicalCenterServiceTest extends BaseTest {
	
	/**
	 * Injected {@link MedicalCenter} service.
	 */
	@SpringBeanByName
	private MedicalCenterService medicalCenterService;

	/**
	 * Test for create and find an {@link MedicalCenter}.
	 */
	@Test
	public void createAndFindMedicalCenter() {

		MedicalCenter dummy = medicalCenterService.create(EntityBuilder.createMedicalCenter());
		long expectedId = dummy.getId();
		MedicalCenter toSearch = medicalCenterService.findById(expectedId);

		long actualId = toSearch.getId();

		assertNotNull(toSearch);
		assertEquals(expectedId, actualId);
	}

	/**
	 * Test for update and remove an {@link MedicalCenter}.
	 */
	@Test
	public void updateAndRemoveMedicalCenter() {
		MedicalCenter dummy = medicalCenterService.create(EntityBuilder.createMedicalCenter());

		String newName = "newname";
		dummy.setName(newName);

		MedicalCenter updated = medicalCenterService.update(dummy);
		MedicalCenter fromDb = medicalCenterService.findById(updated.getId());

		assertEquals(newName, fromDb.getName());

		medicalCenterService.remove(fromDb.getId());
		MedicalCenter deleted = medicalCenterService.findById(fromDb.getId());

		assertNull(deleted);
	}
}