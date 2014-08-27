/**
 * 
 */
package ro.bighealth.commons.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import ro.bighealth.commons.core.BaseEntity;

/**
 * {@link MedicalSection} entity for mapping the <code>medical_sections</code> table.
 * 
 * @author CosminS
 * @since Mar 4, 2014
 */
@Entity
@Table(name = "medical_sections")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MedicalSection extends BaseEntity {

	/**
	 * Name of the medical section.
	 */
	@Column(name = "name", nullable = false, length = 100)
	private String name;

	/**
	 * The description of the medical section.
	 */
	@Column(name = "description", length = 200)
	private String description;

	/**
	 * Doctors list associated with the specified medical section.
	 */
	@OneToMany(mappedBy = "medicalSection")
	@XmlTransient
	private List<Doctor> doctors;

	/**
	 * Diseases list associated with the specified medical section.
	 */
	@OneToMany(mappedBy = "medicalSection")
	@XmlTransient
	private List<Disease> diseases;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Disease> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	/**
	 * Add a doctor to the medical section.
	 * 
	 * @param doctor
	 *            doctor to be added to the medical section.
	 */
	public void addDoctor(Doctor doctor) {
		if (doctor == null) {
			return;
		}
		if (doctors == null) {
			setDoctors(new ArrayList<Doctor>());
		}
		doctor.setMedicalSection(this);
		getDoctors().add(doctor);
	}

	/**
	 * Add a disease to the medical section.
	 * 
	 * @param disease
	 *            disease to be added to the medical section.
	 */
	public void addDisease(Disease disease) {
		if (disease == null) {
			return;
		}
		if (diseases == null) {
			setDiseases(new ArrayList<Disease>());
		}
		disease.setMedicalSection(this);
		getDiseases().add(disease);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof MedicalSection)) {
			return false;
		}
		MedicalSection other = (MedicalSection) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MedicalSection [name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
}