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
import ro.bighealth.commons.entity.PatientDoctorEvaluationForm;
import ro.bighealth.commons.repository.PatientDoctorEvaluationFormRepository;

/**
 * Service for {@link PatientDoctorEvaluationForm} entity.
 * 
 * @author CosminS
 * @since Mar 7, 2014
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PatientDoctorEvaluationFormService extends BaseService<PatientDoctorEvaluationForm> {

	/**
	 * Injected {@link PatientDoctorEvaluationFormRepository} repository.
	 */
	@Autowired
	private PatientDoctorEvaluationFormRepository patientDoctorEvaluationFormRepository;

	@Override
	protected BaseRepository<PatientDoctorEvaluationForm> getRepository() {
		return patientDoctorEvaluationFormRepository;
	}
}