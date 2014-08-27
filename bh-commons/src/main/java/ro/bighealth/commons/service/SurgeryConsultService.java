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
import ro.bighealth.commons.entity.SurgeryConsult;
import ro.bighealth.commons.repository.SurgeryConsultRepository;

/**
 * Service for {@link SurgeryConsult} entity.
 * 
 * @author CosminS
 * @since Mar 6, 2014
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SurgeryConsultService extends BaseService<SurgeryConsult> {

	/**
	 * Injected {@link SurgeryConsultRepository} repository.
	 */
	@Autowired
	private SurgeryConsultRepository surgeryConsultRepository;

	@Override
	protected BaseRepository<SurgeryConsult> getRepository() {
		return surgeryConsultRepository;
	}
}