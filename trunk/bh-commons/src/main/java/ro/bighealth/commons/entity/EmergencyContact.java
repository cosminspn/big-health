/**
 * 
 */
package ro.bighealth.commons.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ro.bighealth.commons.core.BaseEntity;
import ro.bighealth.commons.entity.adapter.PatientAdapter;

/**
 * {@link EmergencyContact} entity for mapping the <code>emergency_contacts</code> table.
 * 
 * @author CosminS
 * @since Mar 7, 2014
 */
@Entity
@Table(name = "emergency_contacts")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyContact extends BaseEntity {

	/**
	 * Patient associated with the emergency contact.
	 */
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	@XmlJavaTypeAdapter(value = PatientAdapter.class)
	private Patient patient;

	/**
	 * First name of the contact.
	 */
	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;

	/**
	 * Last name of the contact.
	 */
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;

	/**
	 * Phone of the contact.
	 */
	@Column(name = "phone", nullable = false, length = 20)
	private String phone;

	/**
	 * E-mail of the contact.
	 */
	@Column(name = "email", nullable = false, length = 20)
	private String email;

	/**
	 * Relationship with patient of the contact.
	 */
	@Column(name = "relationship_with_patient", nullable = false, length = 20)
	private String relationshipWithPatient;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRelationshipWithPatient() {
		return relationshipWithPatient;
	}

	public void setRelationshipWithPatient(String relationshipWithPatient) {
		this.relationshipWithPatient = relationshipWithPatient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((patient == null) ? 0 : (int) (patient.getId() ^ (patient.getId() >>> 32)));
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((relationshipWithPatient == null) ? 0 : relationshipWithPatient.hashCode());
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
		if (!(obj instanceof EmergencyContact)) {
			return false;
		}
		EmergencyContact other = (EmergencyContact) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (patient == null) {
			if (other.patient != null) {
				return false;
			}
		} else if (!patient.equals(other.patient)) {
			return false;
		}
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		if (relationshipWithPatient == null) {
			if (other.relationshipWithPatient != null) {
				return false;
			}
		} else if (!relationshipWithPatient.equals(other.relationshipWithPatient)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmergencyContact [patient=");
		builder.append(patient.getId());
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", relationshipWithPatient=");
		builder.append(relationshipWithPatient);
		builder.append("]");
		return builder.toString();
	}

}