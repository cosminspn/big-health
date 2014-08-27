/**
 * 
 */
package ro.bighealth.commons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.bighealth.commons.core.BaseRepository;
import ro.bighealth.commons.core.BaseService;
import ro.bighealth.commons.entity.User;
import ro.bighealth.commons.repository.UserRepository;

/**
 * Service for {@link User} entity.
 * 
 * @author CosminS
 * @since Mar 3, 2014
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserService extends BaseService<User> {

	/**
	 * Injected {@link UserRepository} repository.
	 */
	@Autowired
	private UserRepository userRepository;

	@Override
	protected BaseRepository<User> getRepository() {
		return userRepository;
	}
	
	/**
	 * Find ab {@link User} by e-mail.
	 * 
	 * @param email
	 *            the email to be searched for.
	 * @return the user.
	 */
	public List<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}