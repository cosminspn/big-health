/**
 * 
 */
package ro.bighealth.commons.repository;

import java.util.List;

import ro.bighealth.commons.core.BaseRepository;
import ro.bighealth.commons.entity.User;

/**
 * {@link User} repository.
 * 
 * @author CosminS
 * @since Mar 3, 2014
 */
public interface UserRepository extends BaseRepository<User> {

	/**
	 * Find an {@link User} by e-mail.
	 * 
	 * @param email
	 *            the email to be searched for.
	 * @return the user.
	 */
	public List<User> findByEmail(String email);
}