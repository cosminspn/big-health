/**
 * 
 */
package ro.bighealth.commons.core;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Generic base repository.
 * 
 * @param <T>
 *            entity type.
 * @author CosminS
 * @since Mar 3, 2014
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends PagingAndSortingRepository<T, Long> {

	/**
	 * Search for a record with a specified id.
	 * 
	 * @param id
	 *            The id of the requested record
	 * @return The record with the specified id.
	 */
	public T findById(Long id);
}