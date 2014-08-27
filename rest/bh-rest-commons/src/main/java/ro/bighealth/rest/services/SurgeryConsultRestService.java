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

import ro.bighealth.commons.entity.SurgeryConsult;
import ro.bighealth.commons.service.SurgeryConsultService;

/**
 * REST services for {@link SurgeryConsult}.
 * 
 * @author CosminS
 * @since Mar 13, 2014
 */
@Component
@Path("surgeryConsults")
public class SurgeryConsultRestService {

	/**
	 * Injected {@link SurgeryConsultService} service.
	 */
	@Autowired
	private SurgeryConsultService surgeryConsultService;

	/**
	 * REST service for creating a surgeryConsult.
	 * 
	 * @param surgeryConsult
	 *            surgeryConsult to be created.
	 * @return created surgeryConsult.
	 */
	@Path("createSurgeryConsult")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SurgeryConsult createSurgeryConsult(SurgeryConsult surgeryConsult) {
		SurgeryConsult persisted = surgeryConsultService.create(surgeryConsult);

		return persisted;
	}

	/**
	 * REST service for getting all surgery consults.
	 * 
	 * @return list with all surgery consults.
	 */
	@GET
	@Path("getSurgeryConsults")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SurgeryConsult> getAllSurgeryConsults() {
		List<SurgeryConsult> surgeryConsultsList = surgeryConsultService.findAll();

		return surgeryConsultsList;
	}

	/**
	 * REST service for getting an surgery consult with a specified id.
	 * 
	 * @param surgeryConsultId
	 *            the specified surgery consult id
	 * @return the surgery consult with the specified id.
	 */
	@GET
	@Path("getSurgeryConsult/{surgeryConsultId}")
	@Produces(MediaType.APPLICATION_JSON)
	public SurgeryConsult getSurgeryConsultById(@PathParam(value = "surgeryConsultId") long surgeryConsultId) {
		SurgeryConsult surgeryConsult = surgeryConsultService.findById(surgeryConsultId);

		return surgeryConsult;
	}

	/**
	 * REST service for creating a surgery consult.
	 * 
	 * @param surgeryConsult
	 *            surgery consult to be created.
	 * @return created surgery consult.
	 */
	@Path("updateSurgeryConsult")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SurgeryConsult updateSurgeryConsult(SurgeryConsult surgeryConsult) {
		SurgeryConsult updated = surgeryConsultService.update(surgeryConsult);

		return updated;
	}

	/**
	 * REST service for deleting a surgery consult.
	 * 
	 * @param surgeryConsultId
	 *            the surgery consult id
	 */
	@Path("deleteSurgeryConsult")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteSurgeryConsult(@QueryParam(value = "surgeryConsultId") long surgeryConsultId) {
		surgeryConsultService.remove(surgeryConsultId);
	}
}