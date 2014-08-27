/**
 * 
 */
package ro.bighealth.commons.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByName;

import ro.bighealth.commons.entity.MedicalSection;
import ro.bighealth.commons.service.MedicalSectionService;
import ro.bighealth.restloader.test.core.BaseTest;
import ro.bighealth.restloader.test.core.EntityBuilder;

/**
 * Unit test class for {@link MedicalSection}.
 * @author CosminS
 * @since Mar 11, 2014
 */
public class MedicalSectionServiceTest extends BaseTest {
	
	/**
	 * Injected {@link MedicalSection} service.
	 */
	@SpringBeanByName
	private MedicalSectionService medicalSectionService;

	/**
	 * Test for create and find an {@link MedicalSection}.
	 */
	@Test
	public void createAndFindMedicalSection() {

		MedicalSection dummy = medicalSectionService.create(EntityBuilder.createMedicalSection());
		long expectedId = dummy.getId();
		MedicalSection toSearch = medicalSectionService.findById(expectedId);

		long actualId = toSearch.getId();

		assertNotNull(toSearch);
		assertEquals(expectedId, actualId);
	}

	/**
	 * Test for update and remove an {@link MedicalSection}.
	 */
	@Test
	public void updateAndRemoveMedicalSection() {
		MedicalSection dummy = medicalSectionService.create(EntityBuilder.createMedicalSection());

		String newName = "newname";
		dummy.setName(newName);

		MedicalSection updated = medicalSectionService.update(dummy);
		MedicalSection fromDb = medicalSectionService.findById(updated.getId());

		assertEquals(newName, fromDb.getName());

		medicalSectionService.remove(fromDb.getId());
		MedicalSection deleted = medicalSectionService.findById(fromDb.getId());

		assertNull(deleted);
	}
}