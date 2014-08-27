/**
 * 
 */
package ro.bighealth.commons.entity;

import java.sql.Date;

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
import ro.bighealth.commons.entity.adapter.DoctorAdapter;
import ro.bighealth.commons.entity.adapter.PatientAdapter;

/**
 * {@link Medication} entity for mapping the <code>medications</code> table.
 * 
 * @author CosminS
 * @since Mar 6, 2014
 */
@Entity
@Table(name = "medications")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Medication extends BaseEntity {

	/**
	 * Patient associated with the medication.
	 */
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	@XmlJavaTypeAdapter(value = PatientAdapter.class)
	private Patient patient;

	/**
	 * Doctor associated with the medication.
	 */
	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	@XmlJavaTypeAdapter(value = DoctorAdapter.class)
	private Doctor doctor;

	/**
	 * The name of the medication.
	 */
	@Column(name = "name", nullable = false, length = 20)
	private String name;

	/**
	 * A JSON string that contains the medication.
	 */
	@Column(name = "medication_json", nullable = false, length = 2000)
	private String medicationJson;

	/**
	 * The date when was the medication created.
	 */
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMedicationJson() {
		return medicationJson;
	}

	public void setMedicationJson(String medicationJson) {
		this.medicationJson = medicationJson;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((doctor == null) ? 0 : (int) (doctor.getId() ^ (doctor.getId() >>> 32)));
		result = prime * result + ((medicationJson == null) ? 0 : medicationJson.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((patient == null) ? 0 : (int) (patient.getId() ^ (patient.getId() >>> 32)));
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
		if (!(obj instanceof Medication)) {
			return false;
		}
		Medication other = (Medication) obj;
		if (createdAt == null) {
			if (other.createdAt != null) {
				return false;
			}
		} else if (!createdAt.equals(other.createdAt)) {
			return false;
		}
		if (doctor == null) {
			if (other.doctor != null) {
				return false;
			}
		} else if (!doctor.equals(other.doctor)) {
			return false;
		}
		if (medicationJson == null) {
			if (other.medicationJson != null) {
				return false;
			}
		} else if (!medicationJson.equals(other.medicationJson)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (patient == null) {
			if (other.patient != null) {
				return false;
			}
		} else if (!patient.equals(other.patient)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Medication [patient=");
		builder.append(patient.getId());
		builder.append(", doctor=");
		builder.append(doctor.getId());
		builder.append(", name=");
		builder.append(name);
		builder.append(", medicationJson=");
		builder.append(medicationJson);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append("]");
		return builder.toString();
	}
}