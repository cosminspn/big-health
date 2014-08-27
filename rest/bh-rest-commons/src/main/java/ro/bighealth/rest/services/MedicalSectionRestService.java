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

import ro.bighealth.commons.entity.MedicalSection;
import ro.bighealth.commons.service.MedicalSectionService;

/**
 * REST services for {@link MedicalSection}.
 * 
 * @author CosminS
 * @since Mar 13, 2014
 */
@Component
@Path("medicalSections")
public class MedicalSectionRestService {
	
	/**
	 * Injected {@link MedicalSectionService} service.
	 */
	@Autowired
	private MedicalSectionService medicalSectionService;

	/**
	 * REST service for creating a medical section.
	 * 
	 * @param medicalSection
	 *            medical section to be created.
	 * @return created medical section.
	 */
	@Path("createMedicalSection")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MedicalSection createMedicalSection(MedicalSection medicalSection) {
		MedicalSection persisted = medicalSectionService.create(medicalSection);

		return persisted;
	}

	/**
	 * REST service for getting all medical sections.
	 * 
	 * @return list with all medical sections.
	 */
	@GET
	@Path("getMedicalSections")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MedicalSection> getAllMedicalSections() {
		List<MedicalSection> medicalSectionList = medicalSectionService.findAll();

		return medicalSectionList;
	}

	/**
	 * REST service for getting a medical section with a specified id.
	 * 
	 * @param medicalSectionId
	 *            the specified medical section id
	 * @return the medical section with the specified id.
	 */
	@GET
	@Path("getMedicalSection/{medicalSectionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public MedicalSection getMedicalSectionById(@PathParam(value = "medicalSectionId") long medicalSectionId) {
		MedicalSection medicalSection = medicalSectionService.findById(medicalSectionId);

		return medicalSection;
	}

	/**
	 * REST service for creating a medical section.
	 * 
	 * @param medicalSection
	 *            medical section to be created.
	 * @return created medical section.
	 */
	@Path("updateMedicalSection")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MedicalSection updateMedicalSection(MedicalSection medicalSection) {
		MedicalSection updated = medicalSectionService.update(medicalSection);

		return updated;
	}

	/**
	 * REST service for deleting a medical section.
	 * 
	 * @param medicalSectionId
	 *            the medical section id
	 */
	@Path("deleteMedicalSection")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteMedicalSection(@QueryParam(value = "medicalSectionId") long medicalSectionId) {
		medicalSectionService.remove(medicalSectionId);
	}
}