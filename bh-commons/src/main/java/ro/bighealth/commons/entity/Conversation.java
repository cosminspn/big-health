/**
 * 
 */
package ro.bighealth.commons.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.Check;

import ro.bighealth.commons.core.BaseEntity;
import ro.bighealth.commons.entity.adapter.UserAdapter;
import ro.bighealth.commons.enumeration.Priority;

/**
 * {@link Conversation} entity for mapping the <code>conversations</code> table.
 * 
 * @author CosminS
 * @since Mar 7, 2014
 */
@Entity
@Table(name = "conversations")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Check(constraints = "priority IN ('LOW','HIGH','MEDIUM')")
public class Conversation extends BaseEntity {

	/**
	 * From user associated with the conversation.
	 */
	@ManyToOne
	@JoinColumn(name = "from_user_id", nullable = false)
	@XmlJavaTypeAdapter(value = UserAdapter.class)
	private User fromUser;

	/**
	 * To user associated with the conversation.
	 */
	@ManyToOne
	@JoinColumn(name = "to_user_id", nullable = false)
	@XmlJavaTypeAdapter(value = UserAdapter.class)
	private User toUser;

	/**
	 * Priority of the message.
	 */
	@Column(name = "priority", length = 10)
	private Priority priority;

	/**
	 * Message of the conversation.
	 */
	@Column(name = "message", nullable = false, length = 2000)
	private String message;

	/**
	 * When the message was sent.
	 */
	@Column(name = "when", nullable = false)
	private Timestamp when;

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getWhen() {
		return when;
	}

	public void setWhen(Timestamp when) {
		this.when = when;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fromUser == null) ? 0 : (int) (fromUser.getId() ^ (fromUser.getId() >>> 32)));
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((toUser == null) ? 0 : (int) (toUser.getId() ^ (toUser.getId() >>> 32)));
		result = prime * result + ((when == null) ? 0 : when.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Conversation)) {
			return false;
		}
		Conversation other = (Conversation) obj;
		if (fromUser == null) {
			if (other.fromUser != null) {
				return false;
			}
		} else if (!fromUser.equals(other.fromUser)) {
			return false;
		}
		if (message == null) {
			if (other.message != null) {
				return false;
			}
		} else if (!message.equals(other.message)) {
			return false;
		}
		if (priority != other.priority) {
			return false;
		}
		if (toUser == null) {
			if (other.toUser != null) {
				return false;
			}
		} else if (!toUser.equals(other.toUser)) {
			return false;
		}
		if (when == null) {
			if (other.when != null) {
				return false;
			}
		} else if (!when.equals(other.when)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conversation [fromUser=");
		builder.append(fromUser.getId());
		builder.append(", toUser=");
		builder.append(toUser.getId());
		builder.append(", priority=");
		builder.append(priority);
		builder.append(", message=");
		builder.append(message);
		builder.append(", when=");
		builder.append(when);
		builder.append("]");
		return builder.toString();
	}
}