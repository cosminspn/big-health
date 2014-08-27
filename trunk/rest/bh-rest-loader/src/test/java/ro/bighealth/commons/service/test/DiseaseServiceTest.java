/**
 * 
 */
package ro.bighealth.commons.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByName;

import ro.bighealth.commons.entity.Conversation;
import ro.bighealth.commons.entity.Disease;
import ro.bighealth.commons.entity.MedicalSection;
import ro.bighealth.commons.service.DiseaseService;
import ro.bighealth.commons.service.MedicalSectionService;
import ro.bighealth.restloader.test.core.BaseTest;
import ro.bighealth.restloader.test.core.EntityBuilder;

/**
 * Unit test class for {@link Conversation}.
 * 
 * @author CosminS
 * @since Mar 11, 2014
 */
public class DiseaseServiceTest extends BaseTest {

	/**
	 * Injected {@link DiseaseService} service.
	 */
	@SpringBeanByName
	private DiseaseService diseaseService;

	/**
	 * Injected {@link MedicalSectionService} service.
	 */
	@SpringBeanByName
	private MedicalSectionService medicalSectionService;

	/**
	 * Test for create and find a {@link Disease}.
	 */
	@Test
	public void createAndFindDisease() {

		MedicalSection medicalSection = medicalSectionService.create(EntityBuilder.createMedicalSection());

		Disease dummyDisease = EntityBuilder.createDisease();
		dummyDisease.setMedicalSection(medicalSection);

		Disease persistedDisease = diseaseService.create(dummyDisease);

		long expectedId = persistedDisease.getId();
		Disease toSearch = diseaseService.findById(expectedId);

		long actualId = toSearch.getId();

		assertNotNull(toSearch);
		assertEquals(expectedId, actualId);
	}

	/**
	 * Test for update and remove an {@link Conversation}.
	 */
	@Test
	public void updateAndRemoveConversation() {

		MedicalSection medicalSection = medicalSectionService.create(EntityBuilder.createMedicalSection());

		Disease dummyDisease = EntityBuilder.createDisease();
		dummyDisease.setMedicalSection(medicalSection);

		Disease persistedDisease = diseaseService.create(dummyDisease);

		String newName = "name1";
		persistedDisease.setName(newName);

		Disease updated = diseaseService.update(persistedDisease);
		Disease fromDb = diseaseService.findById(updated.getId());

		assertEquals(newName, fromDb.getName());

		diseaseService.remove(fromDb.getId());
		Disease deleted = diseaseService.findById(fromDb.getId());

		assertNull(deleted);
	}

}