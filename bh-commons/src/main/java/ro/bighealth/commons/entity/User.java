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
 * {@link User} entity for mapping the <code>users</code> table.
 * 
 * @author CosminS
 * @since Feb 28, 2014
 */
@Entity
@Table(name = "users")
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class User extends BaseEntity {

	/**
	 * First name of the user.
	 */
	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;

	/**
	 * Last name of the user.
	 */
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;

	/**
	 * Username of the user.
	 */
	@Column(name = "username", nullable = false, length = 20, unique = true)
	private String username;

	/**
	 * Password for the account.
	 */
	@Column(name = "password", nullable = false, length = 1000)
	private String password;

	/**
	 * E-mail of the user.
	 */
	@Column(name = "email", nullable = false, length = 100)
	private String email;

	/**
	 * Patients list associated with the specified user.
	 */
	@OneToMany(mappedBy = "user")
	private List<Patient> patients;

	/**
	 * Doctors list associated with the specified user.
	 */
	@OneToMany(mappedBy = "user")
	private List<Doctor> doctors;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlTransient
	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	@XmlTransient
	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	/**
	 * Add a patient to the user.
	 * 
	 * @param patient
	 *            patient to be added to the user.
	 */
	public void addPatient(Patient patient) {
		if (patient == null) {
			return;
		}
		if (patients == null) {
			setPatients(new ArrayList<Patient>());
		}
		patient.setUser(this);
		getPatients().add(patient);
	}

	/**
	 * Add a doctor to the user.
	 * 
	 * @param doctor
	 *            doctor to be added to the user.
	 */
	public void addDoctor(Doctor doctor) {
		if (doctor == null) {
			return;
		}
		if (doctors == null) {
			setDoctors(new ArrayList<Doctor>());
		}
		doctor.setUser(this);
		getDoctors().add(doctor);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
}