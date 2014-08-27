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

import ro.bighealth.commons.entity.MedicalCenter;
import ro.bighealth.commons.service.MedicalCenterService;

/**
 * REST service for {@link MedicalCenter}.
 * 
 * @author CosminS
 * @since Mar 13, 2014
 */
@Component
@Path("medicalCenters")
public class MedicalCenterRestService {
	
	/**
	 * Injected {@link MedicalCenterService} service.
	 */
	@Autowired
	private MedicalCenterService medicalCenterService;

	/**
	 * REST service for creating a medical center.
	 * 
	 * @param medicalCenter
	 *            medical center to be created.
	 * @return created medical center.
	 */
	@Path("createMedicalCenter")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MedicalCenter createMedicalCenter(MedicalCenter medicalCenter) {
		MedicalCenter persisted = medicalCenterService.create(medicalCenter);

		return persisted;
	}

	/**
	 * REST service for getting all medical centers.
	 * 
	 * @return list with all medical centers.
	 */
	@GET
	@Path("getMedicalCenters")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MedicalCenter> getAllMedicalCenters() {
		List<MedicalCenter> medicalCenterList = medicalCenterService.findAll();

		return medicalCenterList;
	}

	/**
	 * REST service for getting a medical center with a specified id.
	 * 
	 * @param medicalCenterId
	 *            the specified medical center id
	 * @return the medical center with the specified id.
	 */
	@GET
	@Path("getMedicalCenter/{medicalCenterId}")
	@Produces(MediaType.APPLICATION_JSON)
	public MedicalCenter getMedicalCenterById(@PathParam(value = "medicalCenterId") long medicalCenterId) {
		MedicalCenter medicalCenter = medicalCenterService.findById(medicalCenterId);

		return medicalCenter;
	}

	/**
	 * REST service for creating a medical center.
	 * 
	 * @param medicalCenter
	 *            medical center to be created.
	 * @return created medical center.
	 */
	@Path("updateMedicalCenter")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MedicalCenter updateMedicalCenter(MedicalCenter medicalCenter) {
		MedicalCenter updated = medicalCenterService.update(medicalCenter);

		return updated;
	}

	/**
	 * REST service for deleting a medical center.
	 * 
	 * @param medicalCenterId
	 *            the medical center id
	 */
	@Path("deleteMedicalCenter")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteMedicalCenter(@QueryParam(value = "medicalCenterId") long medicalCenterId) {
		medicalCenterService.remove(medicalCenterId);
	}
}