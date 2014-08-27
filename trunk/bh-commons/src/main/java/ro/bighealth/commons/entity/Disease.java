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
import ro.bighealth.commons.entity.adapter.MedicalSectionAdapter;

/**
 * {@link Disease} entity for mapping the <code>diseases</code> table.
 * 
 * @author CosminS
 * @since Mar 6, 2014
 */
@Entity
@Table(name = "diseases")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Disease extends BaseEntity {

	/**
	 * The corresponding medical section of the disease.
	 */
	@ManyToOne
	@JoinColumn(name = "medical_section_id", nullable = false)
	@XmlJavaTypeAdapter(value = MedicalSectionAdapter.class)
	private MedicalSection medicalSection;

	/**
	 * The name of the disease.
	 */
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	public MedicalSection getMedicalSection() {
		return medicalSection;
	}

	public void setMedicalSection(MedicalSection medicalSection) {
		this.medicalSection = medicalSection;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((medicalSection == null) ? 0 : (int) (medicalSection.getId() ^ (medicalSection.getId() >>> 32)));
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
		if (!(obj instanceof Disease)) {
			return false;
		}
		Disease other = (Disease) obj;
		if (medicalSection == null) {
			if (other.medicalSection != null) {
				return false;
			}
		} else if (!medicalSection.equals(other.medicalSection)) {
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
		builder.append("Disease [medicalSection=");
		builder.append(medicalSection.getId());
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
}