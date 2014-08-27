/**
 * 
 */
package ro.bighealth.commons.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByName;

import ro.bighealth.commons.entity.Conversation;
import ro.bighealth.commons.entity.User;
import ro.bighealth.commons.service.ConversationService;
import ro.bighealth.commons.service.UserService;
import ro.bighealth.restloader.test.core.BaseTest;
import ro.bighealth.restloader.test.core.EntityBuilder;

/**
 * Unit test class for {@link Conversation}.
 * 
 * @author CosminS
 * @since Mar 11, 2014
 */
public class ConversationServiceTest extends BaseTest {

	/**
	 * Injected {@link ConversationService} service.
	 */
	@SpringBeanByName
	private ConversationService conversationService;

	/**
	 * Injected {@link UserService} service.
	 */
	@SpringBeanByName
	private UserService userService;

	/**
	 * Test for create and find an {@link Conversation}.
	 */
	@Test
	public void createAndFindConversation() {

		User userF = EntityBuilder.createUser();
		userF.setUsername("username1");
		User userFrom = userService.create(userF);
		User userTo = userService.create(EntityBuilder.createUser());

		Conversation dummyConversation = EntityBuilder.createConversation();
		dummyConversation.setFromUser(userFrom);
		dummyConversation.setToUser(userTo);

		Conversation persistedConversation = conversationService.create(dummyConversation);

		long expectedId = persistedConversation.getId();
		Conversation toSearch = conversationService.findById(expectedId);

		long actualId = toSearch.getId();

		assertNotNull(toSearch);
		assertEquals(expectedId, actualId);
	}

	/**
	 * Test for update and remove an {@link Conversation}.
	 */
	@Test
	public void updateAndRemoveConversation() {
		
		User userF = EntityBuilder.createUser();
		userF.setUsername("username1");
		User userFrom = userService.create(userF);
		User userTo = userService.create(EntityBuilder.createUser());

		Conversation dummyConversation = EntityBuilder.createConversation();
		dummyConversation.setFromUser(userFrom);
		dummyConversation.setToUser(userTo);

		Conversation persistedConversation = conversationService.create(dummyConversation);

		String newMessage = "message1";
		persistedConversation.setMessage(newMessage);

		Conversation updated = conversationService.update(persistedConversation);
		Conversation fromDb = conversationService.findById(updated.getId());

		assertEquals(newMessage, fromDb.getMessage());

		conversationService.remove(fromDb.getId());
		Conversation deleted = conversationService.findById(fromDb.getId());

		assertNull(deleted);
	}
}