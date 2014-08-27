/**
 * 
 */
package ro.bighealth.commons.entity;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ro.bighealth.commons.core.BaseEntity;
import ro.bighealth.commons.entity.adapter.PatientAdapter;
import ro.bighealth.commons.entity.adapter.UserAdapter;

/**
 * {@link UploadedData} entity for mapping the <code>uploaded_data</code> table.
 * 
 * @author CosminS
 * @since Mar 7, 2014
 */
@Entity
@Table(name = "uploaded_data")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UploadedData extends BaseEntity {

	/**
	 * User who uploaded the data.
	 */
	@ManyToOne
	@JoinColumn(name = "uploaded_by_user_id", nullable = false)
	@XmlJavaTypeAdapter(value = UserAdapter.class)
	private User uploadedByUser;

	/**
	 * Patient for who the data is uploaded.
	 */
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	@XmlJavaTypeAdapter(value = PatientAdapter.class)
	private Patient patient;

	/**
	 * The name of the document.
	 */
	@Column(name = "document_name", nullable = false, length = 50)
	private String documentName;

	/**
	 * Archived file content.
	 */
	@Lob
	@Column(name = "source", nullable = false)
	private byte[] source;

	/**
	 * When the document was uploaded.
	 */
	@Column(name = "upload_date", nullable = false)
	private Timestamp uploadDate;

	public User getUploadedByUser() {
		return uploadedByUser;
	}

	public void setUploadedByUser(User uploadedByUser) {
		this.uploadedByUser = uploadedByUser;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public byte[] getSource() {
		return source;
	}

	public void setSource(byte[] source) {
		this.source = source;
	}

	public Timestamp getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Timestamp uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((documentName == null) ? 0 : documentName.hashCode());
		result = prime * result + ((patient == null) ? 0 : (int) (patient.getId() ^ (patient.getId() >>> 32)));
		result = prime * result + Arrays.hashCode(source);
		result = prime * result + ((uploadDate == null) ? 0 : uploadDate.hashCode());
		result = prime * result
				+ ((uploadedByUser == null) ? 0 : (int) (uploadedByUser.getId() ^ (uploadedByUser.getId() >>> 32)));
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
		if (!(obj instanceof UploadedData)) {
			return false;
		}
		UploadedData other = (UploadedData) obj;
		if (documentName == null) {
			if (other.documentName != null) {
				return false;
			}
		} else if (!documentName.equals(other.documentName)) {
			return false;
		}
		if (patient == null) {
			if (other.patient != null) {
				return false;
			}
		} else if (!patient.equals(other.patient)) {
			return false;
		}
		if (!Arrays.equals(source, other.source)) {
			return false;
		}
		if (uploadDate == null) {
			if (other.uploadDate != null) {
				return false;
			}
		} else if (!uploadDate.equals(other.uploadDate)) {
			return false;
		}
		if (uploadedByUser == null) {
			if (other.uploadedByUser != null) {
				return false;
			}
		} else if (!uploadedByUser.equals(other.uploadedByUser)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UploadedData [uploadedByUser=");
		builder.append(uploadedByUser.getId());
		builder.append(", patient=");
		builder.append(patient.getId());
		builder.append(", documentName=");
		builder.append(documentName);
		builder.append(", source=");
		builder.append(Arrays.toString(source));
		builder.append(", uploadDate=");
		builder.append(uploadDate);
		builder.append("]");
		return builder.toString();
	}
}