/**
 * 
 */
package ro.bighealth.rest.core;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import ro.bighealth.rest.core.mixin.ListMixIn;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

/**
 * .
 * 
 * @author CosminS
 * @since Mar 24, 2014
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

	/**
	 * Object mapper.
	 */
	private final ObjectMapper objectMapper;

	/**
	 * Public constructor.
	 */
	public JacksonContextResolver() {
		objectMapper = new ObjectMapper();
		
		objectMapper.addMixInAnnotations(List.class, ListMixIn.class);
		objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		//objectMapper.enable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
		objectMapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector(
                TypeFactory.defaultInstance(), false));
	}

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return objectMapper;
	}
}