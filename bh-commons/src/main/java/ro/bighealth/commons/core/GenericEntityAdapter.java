/**
 * 
 */
package ro.bighealth.commons.core;

import java.lang.reflect.ParameterizedType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Generic adapter for entities.
 * 
 * @param <T>
 *            generic type.
 * @author CosminS
 * @since Mar 12, 2014
 */
public abstract class GenericEntityAdapter<T extends BaseEntity> extends XmlAdapter<Long, T> {

	/**
	 * Zero (0) int.
	 */
	private static final int ZERO = 0;

	/**
	 * Get the concrete type of the generic type.
	 * 
	 * @return type of the generic in a particular case.
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getType() {
		ParameterizedType type = ((ParameterizedType) getClass().getGenericSuperclass());
		return (Class<T>) type.getActualTypeArguments()[ZERO];
	}

	/**
	 * Create a new instance of the generic type.
	 * 
	 * @return a new instance of the generic in a particular case.
	 * @throws InstantiationException
	 *             instantiation exception.
	 * @throws IllegalAccessException
	 *             illegal access exception.
	 */
	private T newInstance() throws InstantiationException, IllegalAccessException {
		return getType().newInstance();
	}

	@Override
	public T unmarshal(Long id) throws Exception {

		T entity = newInstance();
		entity.setId(id);

		return entity;
	}

	@Override
	public Long marshal(T entity) throws Exception {
		return entity.getId();
	}
}