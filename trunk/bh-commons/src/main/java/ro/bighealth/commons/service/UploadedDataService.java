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
import ro.bighealth.commons.entity.UploadedData;
import ro.bighealth.commons.repository.UploadedDataRepository;

/**
 * Service for {@link UploadedData} entity.
 * 
 * @author CosminS
 * @since Mar 7, 2014
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UploadedDataService extends BaseService<UploadedData> {

	/**
	 * Injected {@link UploadedDataRepository} repository.
	 */
	@Autowired
	private UploadedDataRepository uploadedDataRepository;

	@Override
	protected BaseRepository<UploadedData> getRepository() {
		return uploadedDataRepository;
	}
}