/**
 * 
 */
package ro.bighealth.commons.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;

/**
 * Abstract class for entity services.
 * 
 * @param <T>
 *            entity type.
 * @author CosminS
 * @since Mar 3, 2014
 */
public abstract class BaseService<T extends BaseEntity> {

	/**
	 * Entity repository.
	 * 
	 * @return Repository instance
	 */
	protected abstract BaseRepository<T> getRepository();

	/**
	 * Create new entity.
	 * 
	 * @param entity
	 *            The entity to create
	 * @return persisted entity
	 */
	public T create(T entity) {
		return getRepository().save(entity);
	}

	/**
	 * Update entity.
	 * 
	 * @param entity
	 *            The entity to update
	 * @return Updated entity
	 */
	public T update(T entity) {
		return getRepository().save(entity);
	}

	/**
	 * Remove entity.
	 * 
	 * @param entityId
	 *            The entity id
	 */
	public void remove(Long entityId) {
		getRepository().delete(entityId);
	}

	/**
	 * Find entity by ID.
	 * 
	 * @param entityId
	 *            The entity id
	 * @return Entity from database with the specified id.
	 */
	public T findById(Long entityId) {
		return getRepository().findById(entityId);
	}

	/**
	 * Find all.
	 * 
	 * @return All entities
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Iterable<T> iterable = getRepository().findAll();

		if (iterable == null) {
			return new ArrayList<>();
		}
		return IteratorUtils.toList(iterable.iterator());
	}
}