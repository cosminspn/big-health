/**
 * 
 */
package ro.bighealth.commons.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ro.bighealth.commons.core.BaseEntity;
import ro.bighealth.commons.entity.adapter.DoctorAdapter;
import ro.bighealth.commons.entity.adapter.PatientAdapter;

/**
 * {@link DoctorPatient} entity for mapping the <code>doctors_patients</code> table.
 * 
 * @author CosminS
 * @since Mar 6, 2014
 */
@Entity
@Table(name = "doctors_patients", uniqueConstraints = { @UniqueConstraint(columnNames = { "doctor_id", "patient_id" }) })
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DoctorPatient extends BaseEntity {

	/**
	 * The corresponding doctor.
	 */
	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	@XmlJavaTypeAdapter(value = DoctorAdapter.class)
	private Doctor doctor;

	/**
	 * The corresponding patient.
	 */
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	@XmlJavaTypeAdapter(value = PatientAdapter.class)
	private Patient patient;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((doctor == null) ? 0 : (int) (doctor.getId() ^ (doctor.getId() >>> 32)));
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
		if (!(obj instanceof DoctorPatient)) {
			return false;
		}
		DoctorPatient other = (DoctorPatient) obj;
		if (doctor == null) {
			if (other.doctor != null) {
				return false;
			}
		} else if (!doctor.equals(other.doctor)) {
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
		builder.append("DoctorPatient [doctor=");
		builder.append(doctor.getId());
		builder.append(", patient=");
		builder.append(patient.getId());
		builder.append("]");
		return builder.toString();
	}
}