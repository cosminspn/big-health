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

import org.hibernate.validator.constraints.Range;

import ro.bighealth.commons.core.BaseEntity;
import ro.bighealth.commons.entity.adapter.PatientAdapter;

/**
 * {@link PatientSelfEvaluationForm} entity for mapping the <code>patient_self_evaluation_form</code> table.
 * 
 * @author CosminS
 * @since Mar 7, 2014
 */
@Entity
@Table(name = "patient_self_evaluation_form")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PatientSelfEvaluationForm extends BaseEntity {

	/**
	 * The patient who is evaluated by the doctor.
	 */
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	@XmlJavaTypeAdapter(value = PatientAdapter.class)
	private Patient patient;

	/**
	 * General patient mark.
	 */
	@Column(name = "general_mark", nullable = false)
	@Range(min = 1, max = 10)
	private Integer generalMark;

	/**
	 * The mark for the treatment response.
	 */
	@Column(name = "treatment_mark", nullable = false)
	@Range(min = 1, max = 10)
	private Integer treatmentMark;

	/**
	 * The response date.
	 */
	@Column(name = "response_date", nullable = false)
	private Date responseDate;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getGeneralMark() {
		return generalMark;
	}

	public void setGeneralMark(Integer generalMark) {
		this.generalMark = generalMark;
	}

	public Integer getTreatmentMark() {
		return treatmentMark;
	}

	public void setTreatmentMark(Integer treatmentMark) {
		this.treatmentMark = treatmentMark;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((generalMark == null) ? 0 : generalMark.hashCode());
		result = prime * result + ((patient == null) ? 0 : (int) (patient.getId() ^ (patient.getId() >>> 32)));
		result = prime * result + ((responseDate == null) ? 0 : responseDate.hashCode());
		result = prime * result + ((treatmentMark == null) ? 0 : treatmentMark.hashCode());
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
		if (!(obj instanceof PatientSelfEvaluationForm)) {
			return false;
		}
		PatientSelfEvaluationForm other = (PatientSelfEvaluationForm) obj;
		if (generalMark == null) {
			if (other.generalMark != null) {
				return false;
			}
		} else if (!generalMark.equals(other.generalMark)) {
			return false;
		}
		if (patient == null) {
			if (other.patient != null) {
				return false;
			}
		} else if (!patient.equals(other.patient)) {
			return false;
		}
		if (responseDate == null) {
			if (other.responseDate != null) {
				return false;
			}
		} else if (!responseDate.equals(other.responseDate)) {
			return false;
		}
		if (treatmentMark == null) {
			if (other.treatmentMark != null) {
				return false;
			}
		} else if (!treatmentMark.equals(other.treatmentMark)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PatientSelfEvaluationForm [patient=");
		builder.append(patient.getId());
		builder.append(", generalMark=");
		builder.append(generalMark);
		builder.append(", treatmentMark=");
		builder.append(treatmentMark);
		builder.append(", responseDate=");
		builder.append(responseDate);
		builder.append("]");
		return builder.toString();
	}
}