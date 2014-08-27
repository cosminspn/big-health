/**
 * 
 */
package ro.bighealth.rest.services;

import java.util.ArrayList;
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

import ro.bighealth.commons.dto.DoctorDTO;
import ro.bighealth.commons.entity.Doctor;
import ro.bighealth.commons.service.DoctorService;
import ro.bighealth.commons.service.UserService;

/**
 * REST services for {@link Doctor}.
 * 
 * @author CosminS
 * @since Mar 13, 2014
 */
@Component
@Path("doctors")
public class DoctorRestService {

	/**
	 * Injected {@link DoctorService} service.
	 */
	@Autowired
	private DoctorService doctorService;
	
	/**
	 * Injected {@link UserService} service.
	 */
	@Autowired
	private UserService userService;

	/**
	 * REST service for creating a doctor.
	 * 
	 * @param doctor
	 *            doctor to be created.
	 * @return created doctor.
	 */
	@Path("createDoctor")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Doctor createDoctor(Doctor doctor) {
		Doctor persisted = doctorService.create(doctor);

		return persisted;
	}

	/**
	 * REST service for getting all doctors.
	 * 
	 * @return list with all doctors.
	 */
	@GET
	@Path("getDoctors")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DoctorDTO> getAllDoctors() {
		List<Doctor> doctorsList = doctorService.findAll();
		
		List<DoctorDTO> doctorsDTO = new ArrayList<DoctorDTO>();
		
		for (Doctor doctor : doctorsList) {
			DoctorDTO doctorDTO = DoctorDTO.createDoctorDtoMaximized(doctor);
			
			doctorsDTO.add(doctorDTO);
		}
		
		return doctorsDTO;
	}

	/**
	 * REST service for getting an doctor with a specified id.
	 * 
	 * @param doctorId
	 *            the specified doctor id
	 * @return the doctor with the specified id.
	 */
	@GET
	@Path("getDoctor/{doctorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Doctor getDoctorById(@PathParam(value = "doctorId") long doctorId) {
		Doctor doctor = doctorService.findById(doctorId);

		return doctor;
	}

	/**
	 * REST service for creating a doctor.
	 * 
	 * @param doctor
	 *            doctor to be created.
	 * @return created doctor.
	 */
	@Path("updateDoctor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Doctor updateDoctor(Doctor doctor) {
		Doctor updated = doctorService.update(doctor);

		return updated;
	}

	/**
	 * REST service for deleting a doctor.
	 * 
	 * @param doctorId
	 *            the doctor id
	 */
	@Path("deleteDoctor")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteDoctor(@QueryParam(value = "doctorId") long doctorId) {
		doctorService.remove(doctorId);
	}
}