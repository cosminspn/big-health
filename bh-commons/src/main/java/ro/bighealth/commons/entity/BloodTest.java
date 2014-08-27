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
import ro.bighealth.commons.entity.adapter.MedicalCenterAdapter;
import ro.bighealth.commons.entity.adapter.PatientAdapter;

/**
 * {@link BloodTest} entity for mapping the <code>blood_tests</code> table.
 * 
 * @author CosminS
 * @since Mar 7, 2014
 */
@Entity
@Table(name = "blood_tests")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BloodTest extends BaseEntity {

	/**
	 * Patient associated with the blood test.
	 */
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	@XmlJavaTypeAdapter(value = PatientAdapter.class)
	private Patient patient;

	/**
	 * Medical center where the blood test was made.
	 */
	@ManyToOne
	@JoinColumn(name = "medical_center_id", nullable = false)
	@XmlJavaTypeAdapter(value = MedicalCenterAdapter.class)
	private MedicalCenter medicalCenter;

	/**
	 * The date when the blood test was taken.
	 */
	@Column(name = "test_date", nullable = false)
	private Date testDate;

	/**
	 * JSON String to store the tests.
	 */
	@Column(name = "tests_json", nullable = false, length = 2000)
	private String testsJson;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public MedicalCenter getMedicalCenter() {
		return medicalCenter;
	}

	public void setMedicalCenter(MedicalCenter medicalCenter) {
		this.medicalCenter = medicalCenter;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public String getTestsJson() {
		return testsJson;
	}

	public void setTestsJson(String testsJson) {
		this.testsJson = testsJson;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((medicalCenter == null) ? 0 : (int) (medicalCenter.getId() ^ (medicalCenter.getId() >>> 32)));
		result = prime * result + ((patient == null) ? 0 : (int) (patient.getId() ^ (patient.getId() >>> 32)));
		result = prime * result + ((testDate == null) ? 0 : testDate.hashCode());
		result = prime * result + ((testsJson == null) ? 0 : testsJson.hashCode());
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
		if (!(obj instanceof BloodTest)) {
			return false;
		}
		BloodTest other = (BloodTest) obj;
		if (medicalCenter == null) {
			if (other.medicalCenter != null) {
				return false;
			}
		} else if (!medicalCenter.equals(other.medicalCenter)) {
			return false;
		}
		if (medicalCenter == null) {
			if (other.medicalCenter != null) {
				return false;
			}
		} else if (!medicalCenter.equals(other.medicalCenter)) {
			return false;
		}
		if (testDate == null) {
			if (other.testDate != null) {
				return false;
			}
		} else if (!testDate.equals(other.testDate)) {
			return false;
		}
		if (testsJson == null) {
			if (other.testsJson != null) {
				return false;
			}
		} else if (!testsJson.equals(other.testsJson)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BloodTest [patient=");
		builder.append(medicalCenter.getId());
		builder.append(", medicalCenter=");
		builder.append(medicalCenter.getId());
		builder.append(", testDate=");
		builder.append(testDate);
		builder.append(", testsJson=");
		builder.append(testsJson);
		builder.append("]");
		return builder.toString();
	}
}