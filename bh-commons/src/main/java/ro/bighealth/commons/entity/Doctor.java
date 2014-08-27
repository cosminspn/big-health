/**
 * 
 */
package ro.bighealth.commons.entity;

import java.util.ArrayList;
import java.util.List;

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
import ro.bighealth.commons.entity.adapter.MedicalCenterAdapter;
import ro.bighealth.commons.entity.adapter.MedicalSectionAdapter;
import ro.bighealth.commons.entity.adapter.UserAdapter;

/**
 * {@link Doctor} entity for mapping the <code>doctors</code> table.
 * 
 * @author CosminS
 * @since Mar 6, 2014
 */
@Entity
@Table(name = "doctors")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Doctor extends BaseEntity {

	/**
	 * The corresponding user of the doctor.
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@XmlJavaTypeAdapter(value = UserAdapter.class)
	private User user;

	/**
	 * The corresponding medical center of the doctor.
	 */
	@ManyToOne
	@JoinColumn(name = "medical_center_id", nullable = false)
	@XmlJavaTypeAdapter(value = MedicalCenterAdapter.class)
	private MedicalCenter medicalCenter;

	/**
	 * The corresponding medical section of the doctor.
	 */
	@ManyToOne
	@JoinColumn(name = "medical_section_id", nullable = false)
	@XmlJavaTypeAdapter(value = MedicalSectionAdapter.class)
	private MedicalSection medicalSection;

	/**
	 * The medication list of the doctor.
	 */
	@OneToMany(mappedBy = "doctor")
	@XmlTransient
	private List<Medication> medications;

	/**
	 * List of surgery consults of the doctor.
	 */
	@OneToMany(mappedBy = "doctor")
	@XmlTransient
	private List<SurgeryConsult> surgeryConsults;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MedicalCenter getMedicalCenter() {
		return medicalCenter;
	}

	public void setMedicalCenter(MedicalCenter medicalCenter) {
		this.medicalCenter = medicalCenter;
	}

	public MedicalSection getMedicalSection() {
		return medicalSection;
	}

	public void setMedicalSection(MedicalSection medicalSection) {
		this.medicalSection = medicalSection;
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

	/**
	 * Add a medication to the doctor.
	 * 
	 * @param medication
	 *            medication to be added to the doctor.
	 */
	public void addMedication(Medication medication) {
		if (medication == null) {
			return;
		}
		if (medications == null) {
			setMedications(new ArrayList<Medication>());
		}
		medication.setDoctor(this);
		getMedications().add(medication);
	}

	/**
	 * Add a surgery consult to the doctor.
	 * 
	 * @param surgeryConsult
	 *            surgery consult to be added to the doctor.
	 */
	public void addSurgeryConsult(SurgeryConsult surgeryConsult) {
		if (surgeryConsult == null) {
			return;
		}
		if (surgeryConsults == null) {
			setSurgeryConsults(new ArrayList<SurgeryConsult>());
		}
		surgeryConsult.setDoctor(this);
		getSurgeryConsults().add(surgeryConsult);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((medicalCenter == null) ? 0 : (int) (medicalCenter.getId() ^ (medicalCenter.getId() >>> 32)));
		result = prime * result
				+ ((medicalSection == null) ? 0 : (int) (medicalSection.getId() ^ (medicalSection.getId() >>> 32)));
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
		if (!(obj instanceof Doctor)) {
			return false;
		}
		Doctor other = (Doctor) obj;
		if (medicalCenter == null) {
			if (other.medicalCenter != null) {
				return false;
			}
		} else if (!medicalCenter.equals(other.medicalCenter)) {
			return false;
		}
		if (medicalSection == null) {
			if (other.medicalSection != null) {
				return false;
			}
		} else if (!medicalSection.equals(other.medicalSection)) {
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
		builder.append("Doctor [user=");
		builder.append(user.getId());
		builder.append(", medicalCenter=");
		builder.append(medicalCenter.getId());
		builder.append(", medicalSection=");
		builder.append(medicalSection.getId());
		builder.append("]");
		return builder.toString();
	}
}