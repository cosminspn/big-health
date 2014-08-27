/**
 * 
 */
package ro.bighealth.commons.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ro.bighealth.commons.core.BaseEntity;
import ro.bighealth.commons.entity.adapter.DoctorAdapter;
import ro.bighealth.commons.entity.adapter.MedicationAdapter;
import ro.bighealth.commons.entity.adapter.PatientAdapter;

/**
 * {@link SurgeryConsult} entity for mapping the <code>sugery_consults</code> table.
 * 
 * @author CosminS
 * @since Mar 6, 2014
 */
@Entity
@Table(name = "surgery_consults")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SurgeryConsult extends BaseEntity {

	/**
	 * The doctor who make the consult.
	 */
	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	@XmlJavaTypeAdapter(value = DoctorAdapter.class)
	private Doctor doctor;

	/**
	 * The patient who was consulted.
	 */
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	@XmlJavaTypeAdapter(value = PatientAdapter.class)
	private Patient patient;

	/**
	 * The medication for the patient.
	 */
	@ManyToOne
	@JoinColumn(name = "medication_id", nullable = false)
	@XmlJavaTypeAdapter(value = MedicationAdapter.class)
	private Medication medication;

	/**
	 * The date of the consult.
	 */
	@Column(name = "consult_date", nullable = false)
	private Date consultDate;

	/**
	 * Reason of the consult.
	 */
	@Column(name = "reason", nullable = false, length = 200)
	private String reason;

	/**
	 * Known allergies of the patient.
	 */
	@Column(name = "allergies", length = 300)
	private String allergies;

	/**
	 * Vital signs of the patient.
	 */
	@Column(name = "vital_signs", length = 1000)
	private String vitalSigns;

	/**
	 * Height of the patient.
	 */
	@Column(name = "height")
	private Double height;

	/**
	 * Weight of the patient.
	 */
	@Column(name = "weight")
	private Double weight;

	/**
	 * Observations for the surgery consult.
	 */
	@Column(name = "observations", length = 1000)
	private String observations;

	/**
	 * List of surgery consults of the patient.
	 */
	@OneToMany(mappedBy = "surgeryConsult")
	@XmlTransient
	private List<PatientDoctorEvaluationForm> doctorForms;

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

	public Medication getMedication() {
		return medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
	}

	public Date getConsultDate() {
		return consultDate;
	}

	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getVitalSigns() {
		return vitalSigns;
	}

	public void setVitalSigns(String vitalSigns) {
		this.vitalSigns = vitalSigns;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public List<PatientDoctorEvaluationForm> getDoctorForms() {
		return doctorForms;
	}

	public void setDoctorForms(List<PatientDoctorEvaluationForm> doctorForms) {
		this.doctorForms = doctorForms;
	}

	/**
	 * Add a doctor form to the surgery consult.
	 * 
	 * @param form
	 *            doctor form to be added to the surgery consult.
	 */
	public void addDoctorForm(PatientDoctorEvaluationForm form) {
		if (form == null) {
			return;
		}
		if (doctorForms == null) {
			setDoctorForms(new ArrayList<PatientDoctorEvaluationForm>());
		}
		form.setSurgeryConsult(this);
		getDoctorForms().add(form);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((allergies == null) ? 0 : allergies.hashCode());
		result = prime * result + ((consultDate == null) ? 0 : consultDate.hashCode());
		result = prime * result + ((doctor == null) ? 0 : (int) (doctor.getId() ^ (doctor.getId() >>> 32)));
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((medication == null) ? 0 : (int) (medication.getId() ^ (medication.getId() >>> 32)));
		result = prime * result + ((observations == null) ? 0 : observations.hashCode());
		result = prime * result + ((patient == null) ? 0 : (int) (patient.getId() ^ (patient.getId() >>> 32)));
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((vitalSigns == null) ? 0 : vitalSigns.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		if (!(obj instanceof SurgeryConsult)) {
			return false;
		}
		SurgeryConsult other = (SurgeryConsult) obj;
		if (allergies == null) {
			if (other.allergies != null) {
				return false;
			}
		} else if (!allergies.equals(other.allergies)) {
			return false;
		}
		if (consultDate == null) {
			if (other.consultDate != null) {
				return false;
			}
		} else if (!consultDate.equals(other.consultDate)) {
			return false;
		}
		if (doctor == null) {
			if (other.doctor != null) {
				return false;
			}
		} else if (!doctor.equals(other.doctor)) {
			return false;
		}
		if (height == null) {
			if (other.height != null) {
				return false;
			}
		} else if (!height.equals(other.height)) {
			return false;
		}
		if (medication == null) {
			if (other.medication != null) {
				return false;
			}
		} else if (!medication.equals(other.medication)) {
			return false;
		}
		if (observations == null) {
			if (other.observations != null) {
				return false;
			}
		} else if (!observations.equals(other.observations)) {
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
		if (vitalSigns == null) {
			if (other.vitalSigns != null) {
				return false;
			}
		} else if (!vitalSigns.equals(other.vitalSigns)) {
			return false;
		}
		if (weight == null) {
			if (other.weight != null) {
				return false;
			}
		} else if (!weight.equals(other.weight)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SurgeryConsult [doctor=");
		builder.append(doctor.getId());
		builder.append(", patient=");
		builder.append(patient.getId());
		builder.append(", medication=");
		builder.append(medication.getId());
		builder.append(", consultDate=");
		builder.append(consultDate);
		builder.append(", reason=");
		builder.append(reason);
		builder.append(", allergies=");
		builder.append(allergies);
		builder.append(", vitalSigns=");
		builder.append(vitalSigns);
		builder.append(", height=");
		builder.append(height);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", observations=");
		builder.append(observations);
		builder.append("]");
		return builder.toString();
	}
}