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
import ro.bighealth.commons.entity.MedicalCenter;
import ro.bighealth.commons.repository.MedicalCenterRepository;

/**
 * Service for {@link MedicalCenter} entity.
 * 
 * @author CosminS
 * @since Mar 4, 2014
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class MedicalCenterService extends BaseService<MedicalCenter> {

	/**
	 * Injected {@link MedicalCenterRepository} repository.
	 */
	@Autowired
	private MedicalCenterRepository medicalCenterRepository;

	@Override
	protected BaseRepository<MedicalCenter> getRepository() {
		return medicalCenterRepository;
	}
}