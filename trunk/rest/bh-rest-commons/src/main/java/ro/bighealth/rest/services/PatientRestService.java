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

import ro.bighealth.commons.entity.Patient;
import ro.bighealth.commons.service.PatientService;

/**
 * REST services for {@link Patient}.
 * 
 * @author CosminS
 * @since Mar 13, 2014
 */
@Component
@Path("patients")
public class PatientRestService {
	
	/**
	 * Injected {@link PatientService} service.
	 */
	@Autowired
	private PatientService patientService;

	/**
	 * REST service for creating a patient.
	 * 
	 * @param patient
	 *            patient to be created.
	 * @return created patient.
	 */
	@Path("createPatient")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Patient createPatient(Patient patient) {
		Patient persisted = patientService.create(patient);

		return persisted;
	}

	/**
	 * REST service for getting all patients.
	 * 
	 * @return list with all patients.
	 */
	@GET
	@Path("getPatients")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient> getAllPatients() {
		List<Patient> patientsList = patientService.findAll();

		return patientsList;
	}

	/**
	 * REST service for getting an patient with a specified id.
	 * 
	 * @param patientId
	 *            the specified patient id
	 * @return the patient with the specified id.
	 */
	@GET
	@Path("getPatient/{patientId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatientById(@PathParam(value = "patientId") long patientId) {
		Patient patient = patientService.findById(patientId);

		return patient;
	}

	/**
	 * REST service for creating a patient.
	 * 
	 * @param patient
	 *            patient to be created.
	 * @return created patient.
	 */
	@Path("updatePatient")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Patient updatePatient(Patient patient) {
		Patient updated = patientService.update(patient);

		return updated;
	}

	/**
	 * REST service for deleting a patient.
	 * 
	 * @param patientId
	 *            the patient id
	 */
	@Path("deletePatient")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletePatient(@QueryParam(value = "patientId") long patientId) {
		patientService.remove(patientId);
	}
}