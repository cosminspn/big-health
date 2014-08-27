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
import ro.bighealth.commons.entity.EmergencyContact;
import ro.bighealth.commons.repository.EmergencyContactRepository;

/**
 * Service for {@link EmergencyContact} entity.
 * 
 * @author CosminS
 * @since Mar 7, 2014
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmergencyContactService extends BaseService<EmergencyContact> {

	/**
	 * Injected {@link EmergencyContactRepository} repository.
	 */
	@Autowired
	private EmergencyContactRepository emergencyContactRepository;

	@Override
	protected BaseRepository<EmergencyContact> getRepository() {
		return emergencyContactRepository;
	}
}