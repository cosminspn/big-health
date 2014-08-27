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
import ro.bighealth.commons.entity.adapter.PatientAdapter;

/**
 * {@link PulseMeter} entity for mapping the <code>pulse_meters</code> table.
 * 
 * @author CosminS
 * @since Mar 7, 2014
 */
@Entity
@Table(name = "pulse_meters")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PulseMeter extends BaseEntity {

	/**
	 * Patient associated with the pulse meter.
	 */
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	@XmlJavaTypeAdapter(value = PatientAdapter.class)
	private Patient patient;

	/**
	 * Average value of the pulse.
	 */
	@Column(name = "average", nullable = false)
	private Integer average;

	/**
	 * The date when the value was registered.
	 */
	@Column(name = "registration_date", nullable = false)
	private Date registrationDate;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getAverage() {
		return average;
	}

	public void setAverage(Integer average) {
		this.average = average;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((average == null) ? 0 : average.hashCode());
		result = prime * result + ((patient == null) ? 0 : (int) (patient.getId() ^ (patient.getId() >>> 32)));
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
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
		if (!(obj instanceof PulseMeter)) {
			return false;
		}
		PulseMeter other = (PulseMeter) obj;
		if (average == null) {
			if (other.average != null) {
				return false;
			}
		} else if (!average.equals(other.average)) {
			return false;
		}
		if (patient == null) {
			if (other.patient != null) {
				return false;
			}
		} else if (!patient.equals(other.patient)) {
			return false;
		}
		if (registrationDate == null) {
			if (other.registrationDate != null) {
				return false;
			}
		} else if (!registrationDate.equals(other.registrationDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PulseMeter [patient=");
		builder.append(patient.getId());
		builder.append(", average=");
		builder.append(average);
		builder.append(", registrationDate=");
		builder.append(registrationDate);
		builder.append("]");
		return builder.toString();
	}
}