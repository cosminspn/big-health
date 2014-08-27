/**
 * 
 */
package ro.bighealth.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.bighealth.commons.core.BaseRepository;
import ro.bighealth.commons.core.BaseService;
import ro.bighealth.commons.entity.Patient;
import ro.bighealth.commons.repository.PatientRepository;

/**
 * Service for {@link Patient} entity.
 * 
 * @author CosminS
 * @since Mar 4, 2014
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PatientService extends BaseService<Patient> {

	/**
	 * Injected {@link PatientRepository} repository.
	 */
	@Autowired
	private PatientRepository patientRepository;

	@Override
	protected BaseRepository<Patient> getRepository() {
		return patientRepository;
	}
}