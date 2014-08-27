/**
 * 
 */
package ro.bighealth.restloader.test.core;

import java.sql.Date;
import java.sql.Timestamp;

import ro.bighealth.commons.entity.BloodTest;
import ro.bighealth.commons.entity.Conversation;
import ro.bighealth.commons.entity.Disease;
import ro.bighealth.commons.entity.Doctor;
import ro.bighealth.commons.entity.MedicalCenter;
import ro.bighealth.commons.entity.MedicalSection;
import ro.bighealth.commons.entity.Patient;
import ro.bighealth.commons.entity.User;
import ro.bighealth.commons.enumeration.Gender;
import ro.bighealth.commons.enumeration.Occupation;
import ro.bighealth.commons.enumeration.Priority;

/**
 * Entity builder class.
 * 
 * @author CosminS
 * @since Mar 11, 2014
 */
public final class EntityBuilder {

	/**
	 * Private constructor.
	 */
	private EntityBuilder() {
	}

	/**
	 * Creates dummy {@link User}.
	 * 
	 * @return dummy user
	 */
	public static User createUser() {
		User user = new User();

		user.setFirstName("fname");
		user.setLastName("lname");
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("email");

		return user;
	}

	/**
	 * Creates dummy {@link MedicalSection}.
	 * 
	 * @return dummy medical section.
	 */
	public static MedicalSection createMedicalSection() {
		MedicalSection medicalSection = new MedicalSection();

		medicalSection.setName("name");

		return medicalSection;
	}

	/**
	 * Creates dummy {@link MedicalCenter}.
	 * 
	 * @return dummy medical section.
	 */
	public static MedicalCenter createMedicalCenter() {
		MedicalCenter medicalCenter = new MedicalCenter();

		medicalCenter.setName("name");
		medicalCenter.setAddress("address");
		medicalCenter.setCity("city");
		medicalCenter.setCountry("country");
		medicalCenter.setEmail("email");
		medicalCenter.setPhone("phone");

		return medicalCenter;
	}

	/**
	 * Creates a dummy {@link Patient}.
	 * 
	 * @return dummy patient
	 */
	public static Patient createPatient() {
		Patient patient = new Patient();

		patient.setAddress("address");
		patient.setBirthdate(new Date(System.currentTimeMillis()));
		patient.setCity("city");
		patient.setCountry("country");
		patient.setGender(Gender.MALE);
		patient.setOccupation(Occupation.EMPLOYEE);
		patient.setPhone("phone");

		return patient;
	}

	/**
	 * Creates dummy {@link BloodTest}.
	 * 
	 * @return dummy blood test
	 */
	public static BloodTest createBloodTest() {
		BloodTest bloodTest = new BloodTest();

		bloodTest.setTestDate(new Date(System.currentTimeMillis()));
		bloodTest.setTestsJson("json");
		return bloodTest;
	}

	/**
	 * Creates dummy {@link Conversation}.
	 * 
	 * @return dummy conversation
	 */
	public static Conversation createConversation() {
		Conversation conversation = new Conversation();

		conversation.setMessage("message");
		conversation.setPriority(Priority.LOW);
		conversation.setWhen(new Timestamp(System.currentTimeMillis()));

		return conversation;
	}

	/**
	 * Creates dummy {@link Disease}.
	 * 
	 * @return dummy disease
	 */
	public static Disease createDisease() {
		Disease disease = new Disease();

		disease.setName("name");

		return disease;
	}

	/**
	 * Creates dummy {@link Doctor}.
	 * 
	 * @return dummy doctor
	 */
	public static Doctor createDoctor() {
		Doctor doctor = new Doctor();

		return doctor;
	}
}