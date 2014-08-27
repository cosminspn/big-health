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
import ro.bighealth.commons.entity.adapter.DiseaseAdapter;
import ro.bighealth.commons.entity.adapter.MedicalCenterAdapter;
import ro.bighealth.commons.entity.adapter.PatientAdapter;

/**
 * {@link Hospitalization} entity for mapping the <code>hospitalizations</code> table.
 * 
 * @author CosminS
 * @since Mar 6, 2014
 */
@Entity
@Table(name = "hospitalizations")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Hospitalization extends BaseEntity {

	/**
	 * The corresponding medical center of the hospitalization.
	 */
	@ManyToOne
	@JoinColumn(name = "medical_center_id", nullable = false)
	@XmlJavaTypeAdapter(value = MedicalCenterAdapter.class)
	private MedicalCenter medicalCenter;

	/**
	 * The corresponding patient of the hospitalization.
	 */
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	@XmlJavaTypeAdapter(value = PatientAdapter.class)
	private Patient patient;

	/**
	 * The corresponding disease of the hospitalization.
	 */
	@ManyToOne
	@JoinColumn(name = "disease_id", nullable = false)
	@XmlJavaTypeAdapter(value = DiseaseAdapter.class)
	private Disease disease;

	/**
	 * Reason of the hospitalization.
	 */
	@Column(name = "reason", nullable = false, length = 1000)
	private String reason;

	/**
	 * The start date of the hospitalization.
	 */
	@Column(name = "from_date", nullable = false)
	private Date from;

	/**
	 * The end date of the hospitalization.
	 */
	@Column(name = "to_date")
	private Date to;

	public MedicalCenter getMedicalCenter() {
		return medicalCenter;
	}

	public void setMedicalCenter(MedicalCenter medicalCenter) {
		this.medicalCenter = medicalCenter;
	}

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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((disease == null) ? 0 : (int) (disease.getId() ^ (disease.getId() >>> 32)));
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result
				+ ((medicalCenter == null) ? 0 : (int) (medicalCenter.getId() ^ (medicalCenter.getId() >>> 32)));
		result = prime * result + ((patient == null) ? 0 : (int) (patient.getId() ^ (patient.getId() >>> 32)));
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
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
		if (!(obj instanceof Hospitalization)) {
			return false;
		}
		Hospitalization other = (Hospitalization) obj;
		if (disease == null) {
			if (other.disease != null) {
				return false;
			}
		} else if (!disease.equals(other.disease)) {
			return false;
		}
		if (from == null) {
			if (other.from != null) {
				return false;
			}
		} else if (!from.equals(other.from)) {
			return false;
		}
		if (medicalCenter == null) {
			if (other.medicalCenter != null) {
				return false;
			}
		} else if (!medicalCenter.equals(other.medicalCenter)) {
			return false;
		}
		if (patient == null) {
			if (other.patient != null) {
				return false;
			}
		} else if (!patient.equals(other.patient)) {
			return false;
		}
		if (reason == null) {
			if (other.reason != null) {
				return false;
			}
		} else if (!reason.equals(other.reason)) {
			return false;
		}
		if (to == null) {
			if (other.to != null) {
				return false;
			}
		} else if (!to.equals(other.to)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hospitalization [medicalCenter=");
		builder.append(medicalCenter.getId());
		builder.append(", patient=");
		builder.append(patient.getId());
		builder.append(", disease=");
		builder.append(disease.getId());
		builder.append(", reason=");
		builder.append(reason);
		builder.append(", from=");
		builder.append(from);
		builder.append(", to=");
		builder.append(to);
		builder.append("]");
		return builder.toString();
	}
}