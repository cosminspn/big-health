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
import ro.bighealth.commons.entity.adapter.DiseaseAdapter;
import ro.bighealth.commons.entity.adapter.PatientAdapter;

/**
 * {@link DiseasePatient} entity for mapping the <code>diseases_patients</code> table.
 * 
 * @author CosminS
 * @since Mar 7, 2014
 */
@Entity
@Table(name = "diseases_patients", uniqueConstraints = { @UniqueConstraint(columnNames = { "patient_id", "disease_id" }) })
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DiseasePatient extends BaseEntity {

	/**
	 * The patient.
	 */
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	@XmlJavaTypeAdapter(value = PatientAdapter.class)
	private Patient patient;

	/**
	 * The disease.
	 */
	@ManyToOne
	@JoinColumn(name = "disease_id", nullable = false)
	@XmlJavaTypeAdapter(value = DiseaseAdapter.class)
	private Disease disease;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((disease == null) ? 0 : (int) (disease.getId() ^ (disease.getId() >>> 32)));
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
		if (!(obj instanceof DiseasePatient)) {
			return false;
		}
		DiseasePatient other = (DiseasePatient) obj;
		if (disease == null) {
			if (other.disease != null) {
				return false;
			}
		} else if (!disease.equals(other.disease)) {
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
		builder.append("DiseasePatient [patient=");
		builder.append(patient.getId());
		builder.append(", disease=");
		builder.append(disease.getId());
		builder.append("]");
		return builder.toString();
	}
}