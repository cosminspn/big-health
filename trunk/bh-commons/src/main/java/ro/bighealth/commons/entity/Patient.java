/**
 * 
 */
package ro.bighealth.commons.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.Check;

import ro.bighealth.commons.core.BaseEntity;
import ro.bighealth.commons.entity.adapter.UserAdapter;
import ro.bighealth.commons.enumeration.Gender;
import ro.bighealth.commons.enumeration.Occupation;

/**
 * {@link Patient} entity for mapping the <code>patients</code> table.
 * 
 * @author CosminS
 * @since Mar 4, 2014
 */
@Entity
@Table(name = "patients")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Check(constraints = "gender IN ('MALE','FEMALE') AND occupation IN ('EMPLOYEE','PENSIONER','STUDENT','UNEMPLOYED')")
public class Patient extends BaseEntity {

	/**
	 * The corresponding user of the patient.
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@XmlJavaTypeAdapter(value = UserAdapter.class)
	private User user;

	/**
	 * The gender of the patient.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = false, length = 10)
	private Gender gender;

	/**
	 * The occupation of the patient.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "occupation", length = 30)
	private Occupation occupation;

	/**
	 * The birth date of the patient.
	 */
	@Column(name = "birthdate", nullable = false)
	private Date birthdate;

	/**
	 * The address of the patient.
	 */
	@Column(name = "address", length = 200)
	private String address;

	/**
	 * The city of the patient.
	 */
	@Column(name = "city", length = 30)
	private String city;

	/**
	 * The country of the patient.
	 */
	@Column(name = "country", length = 30)
	private String country;

	/**
	 * The phone of the patient.
	 */
	@Column(name = "phone", nullable = false, length = 20)
	private String phone;

	/**
	 * The medication list for the patient.
	 */
	@OneToMany(mappedBy = "patient")
	@XmlTransient
	private List<Medication> medications;

	/**
	 * List of surgery consults of the patient.
	 */
	@OneToMany(mappedBy = "patient")
	@XmlTransient
	private List<SurgeryConsult> surgeryConsults;

	/**
	 * List of surgery consults of the patient.
	 */
	@OneToMany(mappedBy = "patient")
	@XmlTransient
	private List<PatientDoctorEvaluationForm> doctorForms;

	/**
	 * List of surgery consults of the patient.
	 */
	@OneToMany(mappedBy = "patient")
	@XmlTransient
	private List<PatientSelfEvaluationForm> patientForms;

	/**
	 * List of pulse meters of the patient.
	 */
	@OneToMany(mappedBy = "patient")
	@XmlTransient
	private List<PulseMeter> pulseMeters;

	/**
	 * List of pulse meters of the patient.
	 */
	@OneToMany(mappedBy = "patient")
	@XmlTransient
	private List<EmergencyContact> emergencyContacts;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Medication> getMedications() {
		return medications;
	}

	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}

	public List<SurgeryConsult> getSurgeryConsults() {
		return surgeryConsults;
	}

	public void setSurgeryConsults(List<SurgeryConsult> surgeryConsults) {
		this.surgeryConsults = surgeryConsults;
	}

	public List<PatientDoctorEvaluationForm> getDoctorForms() {
		return doctorForms;
	}

	public void setDoctorForms(List<PatientDoctorEvaluationForm> doctorForms) {
		this.doctorForms = doctorForms;
	}

	public List<PatientSelfEvaluationForm> getPatientForms() {
		return patientForms;
	}

	public void setPatientForms(List<PatientSelfEvaluationForm> patientForms) {
		this.patientForms = patientForms;
	}

	public List<PulseMeter> getPulseMeters() {
		return pulseMeters;
	}

	public void setPulseMeters(List<PulseMeter> pulseMeters) {
		this.pulseMeters = pulseMeters;
	}

	public List<EmergencyContact> getEmergencyContacts() {
		return emergencyContacts;
	}

	public void setEmergencyContacts(List<EmergencyContact> emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}

	/**
	 * Add a medication to the patient.
	 * 
	 * @param medication
	 *            medication to be added to the patient.
	 */
	public void addMedication(Medication medication) {
		if (medication == null) {
			return;
		}
		if (medications == null) {
			setMedications(new ArrayList<Medication>());
		}
		medication.setPatient(this);
		getMedications().add(medication);
	}

	/**
	 * Add a surgery consult to the patient.
	 * 
	 * @param surgeryConsult
	 *            surgery consult to be added to the patient.
	 */
	public void addSurgeryConsult(SurgeryConsult surgeryConsult) {
		if (surgeryConsult == null) {
			return;
		}
		if (surgeryConsults == null) {
			setSurgeryConsults(new ArrayList<SurgeryConsult>());
		}
		surgeryConsult.setPatient(this);
		getSurgeryConsults().add(surgeryConsult);
	}

	/**
	 * Add a doctor form to the patient.
	 * 
	 * @param form
	 *            doctor form to be added to the patient.
	 */
	public void addDoctorForm(PatientDoctorEvaluationForm form) {
		if (form == null) {
			return;
		}
		if (doctorForms == null) {
			setDoctorForms(new ArrayList<PatientDoctorEvaluationForm>());
		}
		form.setPatient(this);
		getDoctorForms().add(form);
	}

	/**
	 * Add a patient self form to the patient.
	 * 
	 * @param form
	 *            patient self form to be added to the patient.
	 */
	public void addPatientForm(PatientSelfEvaluationForm form) {
		if (form == null) {
			return;
		}
		if (patientForms == null) {
			setPatientForms(new ArrayList<PatientSelfEvaluationForm>());
		}
		form.setPatient(this);
		getPatientForms().add(form);
	}

	/**
	 * Add a pulse meter to the patient.
	 * 
	 * @param pulseMeter
	 *            pulse meter to be added to the patient.
	 */
	public void addPulseMeter(PulseMeter pulseMeter) {
		if (pulseMeter == null) {
			return;
		}
		if (pulseMeters == null) {
			setPulseMeters(new ArrayList<PulseMeter>());
		}
		pulseMeter.setPatient(this);
		getPulseMeters().add(pulseMeter);
	}

	/**
	 * Add an emergency contact to the patient.
	 * 
	 * @param emergencyContact
	 *            emergency contact to be added to the patient.
	 */
	public void addEmergencyConntact(EmergencyContact emergencyContact) {
		if (emergencyContact == null) {
			return;
		}
		if (emergencyContacts == null) {
			setEmergencyContacts(new ArrayList<EmergencyContact>());
		}
		emergencyContact.setPatient(this);
		getEmergencyContacts().add(emergencyContact);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((user == null) ? 0 : (int) (user.getId() ^ (user.getId() >>> 32)));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Patient)) {
			return false;
		}
		Patient other = (Patient) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (birthdate == null) {
			if (other.birthdate != null) {
				return false;
			}
		} else if (!birthdate.equals(other.birthdate)) {
			return false;
		}
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
		if (gender != other.gender) {
			return false;
		}
		if (occupation != other.occupation) {
			return false;
		}
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Patient [user=");
		builder.append(user.getId());
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", occupation=");
		builder.append(occupation);
		builder.append(", birtdate=");
		builder.append(birthdate);
		builder.append(", address=");
		builder.append(address);
		builder.append(", city=");
		builder.append(city);
		builder.append(", country=");
		builder.append(country);
		builder.append(", phone=");
		builder.append(phone);
		builder.append("]");
		return builder.toString();
	}
}