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
 * {@link MedicalCenter} entity for mapping the <code>medical_centers</code> table.
 * 
 * @author CosminS
 * @since Mar 4, 2014
 */
@Entity
@Table(name = "medical_centers")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MedicalCenter extends BaseEntity {

	/**
	 * The name of the medical center.
	 */
	@Column(name = "name", nullable = false, length = 100)
	private String name;

	/**
	 * The phone number of the medical center.
	 */
	@Column(name = "phone", nullable = false, length = 20)
	private String phone;

	/**
	 * The e-mail of the medical center.
	 */
	@Column(name = "email", nullable = false, length = 100)
	private String email;

	/**
	 * The address of the medical center.
	 */
	@Column(name = "address", nullable = false, length = 200)
	private String address;

	/**
	 * The city where the medical center is located.
	 */
	@Column(name = "city", nullable = false, length = 30)
	private String city;

	/**
	 * The country where the medical center is located.
	 */
	@Column(name = "country", nullable = false, length = 30)
	private String country;

	/**
	 * Doctors list associated with the specified medical center.
	 */
	@OneToMany(mappedBy = "medicalCenter")
	@XmlTransient
	private List<Doctor> doctors;

	/**
	 * Hospitalizations list associated with the specified medical center.
	 */
	@OneToMany(mappedBy = "medicalCenter")
	@XmlTransient
	private List<Hospitalization> hospitalizations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Hospitalization> getHospitalizations() {
		return hospitalizations;
	}

	public void setHospitalizations(List<Hospitalization> hospitalizations) {
		this.hospitalizations = hospitalizations;
	}

	/**
	 * Add a doctor to the medical center.
	 * 
	 * @param doctor
	 *            doctor to be added to the medical center.
	 */
	public void addDoctor(Doctor doctor) {
		if (doctor == null) {
			return;
		}
		if (doctors == null) {
			setDoctors(new ArrayList<Doctor>());
		}
		doctor.setMedicalCenter(this);
		getDoctors().add(doctor);
	}

	/**
	 * Add a hospitalization to the medical center.
	 * 
	 * @param hospitalization
	 *            hospitalization to be added to the medical center.
	 */
	public void addHospitalization(Hospitalization hospitalization) {
		if (hospitalization == null) {
			return;
		}
		if (hospitalizations == null) {
			setHospitalizations(new ArrayList<Hospitalization>());
		}
		hospitalization.setMedicalCenter(this);
		getHospitalizations().add(hospitalization);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		if (!(obj instanceof MedicalCenter)) {
			return false;
		}
		MedicalCenter other = (MedicalCenter) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MedicalCenter [name=");
		builder.append(name);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", address=");
		builder.append(address);
		builder.append(", city=");
		builder.append(city);
		builder.append(", country=");
		builder.append(country);
		builder.append("]");
		return builder.toString();
	}
}