/**
 * 
 */
package ro.bighealth.commons.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import ro.bighealth.commons.entity.Doctor;
import ro.bighealth.commons.entity.User;

/**
 * DTO for Doctors.
 * 
 * @author CosminS
 * @since Mar 25, 2014
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class DoctorDTO implements Serializable {

	/**
	 * First name.
	 */
	private String firstName;

	/**
	 * Last name.
	 */
	private String lastName;

	/**
	 * Username.
	 */
	private String username;

	/**
	 * E-mail.
	 */
	private String email;

	/**
	 * Medical section.
	 */
	private String medicalSection;

	/**
	 * Medical center.
	 */
	private String medicalCenter;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMedicalSection() {
		return medicalSection;
	}

	public void setMedicalSection(String medicalSection) {
		this.medicalSection = medicalSection;
	}

	public String getMedicalCenter() {
		return medicalCenter;
	}

	public void setMedicalCenter(String medicalCenter) {
		this.medicalCenter = medicalCenter;
	}

	/**
	 * Creates a doctor DTO.
	 * 
	 * @param doctor
	 *            doctor to be transformed in DTO.
	 * @return the created DTO.
	 */
	public static DoctorDTO createDoctorDtoMaximized(Doctor doctor) {
		DoctorDTO doctorDTO = new DoctorDTO();

		User user = doctor.getUser();
		doctorDTO.setFirstName(user.getFirstName());
		doctorDTO.setLastName(user.getLastName());
		doctorDTO.setUsername(user.getUsername());
		doctorDTO.setEmail(user.getEmail());
		doctorDTO.setMedicalCenter(doctor.getMedicalCenter().getName());
		doctorDTO.setMedicalSection(doctor.getMedicalSection().getName());

		return doctorDTO;
	}
}