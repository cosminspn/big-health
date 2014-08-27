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

import org.hibernate.validator.constraints.Range;

import ro.bighealth.commons.core.BaseEntity;
import ro.bighealth.commons.entity.adapter.PatientAdapter;
import ro.bighealth.commons.entity.adapter.SurgeryConsultAdapter;

/**
 * {@link PatientDoctorEvaluationForm} entity for mapping the <code>patient_doctor_evaluation_form</code> table.
 * 
 * @author CosminS
 * @since Mar 7, 2014
 */
@Entity
@Table(name = "patient_doctor_evaluation_form")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PatientDoctorEvaluationForm extends BaseEntity {

	/**
	 * The patient who is evaluated by the doctor.
	 */
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	@XmlJavaTypeAdapter(value = PatientAdapter.class)
	private Patient patient;

	/**
	 * The surgery consult on which the evaluation is based.
	 */
	@ManyToOne
	@JoinColumn(name = "surgery_consult_id", nullable = false)
	@XmlJavaTypeAdapter(value = SurgeryConsultAdapter.class)
	private SurgeryConsult surgeryConsult;

	/**
	 * General patient mark.
	 */
	@Column(name = "general_mark", nullable = false)
	@Range(min = 1, max = 10)
	private Integer generalMark;

	/**
	 * The mark for the treatment response.
	 */
	@Column(name = "treatment_reponse_mark", nullable = false)
	@Range(min = 1, max = 10)
	private Integer treatmentResponseMark;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public SurgeryConsult getSurgeryConsult() {
		return surgeryConsult;
	}

	public void setSurgeryConsult(SurgeryConsult surgeryConsult) {
		this.surgeryConsult = surgeryConsult;
	}

	public Integer getGeneralMark() {
		return generalMark;
	}

	public void setGeneralMark(Integer generalMark) {
		this.generalMark = generalMark;
	}

	public Integer getTreatmentResponseMark() {
		return treatmentResponseMark;
	}

	public void setTreatmentResponseMark(Integer treatmentResponseMark) {
		this.treatmentResponseMark = treatmentResponseMark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((generalMark == null) ? 0 : generalMark.hashCode());
		result = prime * result + ((patient == null) ? 0 : (int) (patient.getId() ^ (patient.getId() >>> 32)));
		result = prime * result
				+ ((surgeryConsult == null) ? 0 : (int) (surgeryConsult.getId() ^ (surgeryConsult.getId() >>> 32)));
		result = prime * result + ((treatmentResponseMark == null) ? 0 : treatmentResponseMark.hashCode());
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
		if (!(obj instanceof PatientDoctorEvaluationForm)) {
			return false;
		}
		PatientDoctorEvaluationForm other = (PatientDoctorEvaluationForm) obj;
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
		if (surgeryConsult == null) {
			if (other.surgeryConsult != null) {
				return false;
			}
		} else if (!surgeryConsult.equals(other.surgeryConsult)) {
			return false;
		}
		if (treatmentResponseMark == null) {
			if (other.treatmentResponseMark != null) {
				return false;
			}
		} else if (!treatmentResponseMark.equals(other.treatmentResponseMark)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PatientDoctorEvaluationForm [patient=");
		builder.append(patient.getId());
		builder.append(", surgeryConsult=");
		builder.append(surgeryConsult.getId());
		builder.append(", generalMark=");
		builder.append(generalMark);
		builder.append(", treatmentResponseMark=");
		builder.append(treatmentResponseMark);
		builder.append("]");
		return builder.toString();
	}
}