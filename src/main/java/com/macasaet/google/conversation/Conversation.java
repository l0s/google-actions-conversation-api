package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * The conversation object defines session data about the ongoing conversation.
 *
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @see <a href=
 *      "https://developers.google.com/actions/reference/conversation#Conversation">
 *      https://developers.google.com/actions/reference/conversation#
 *      Conversation</a>
 * @author Carlos Macasaet
 */
public class Conversation {

    @XmlAttribute(name="conversation_id")
    private String conversationId;
    private Integer type;
    @XmlAttribute(name="conversation_token")
    private String conversationToken;

    /**
     * Unique ID for the multi-step conversation, it's assigned for the first
     * step, after that it remains the same for subsequent user's queries until
     * the conversation is terminated.
     * 
     * @return a unique ID for the multi-step conversation
     */
    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    /**
     * Indicates the current stage of the dialog's life cycle, such as whether
     * it's a new dialog, or an active dialog.
     * 
     * NOTE: according to the documentation, this should be an enum with the
     * possible values: TYPE_UNSPECIFIED, NEW, ACTIVE, EXPIRED, or ARCHIVED.
     * However, the Assistant Platform seems to return an Integer rather than a
     * string.
     * 
     * @return the current stage of the dialog's life cycle
     */
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return Opaque token specified by the action endpoint in a previous
     *         response; mainly used by the agent to maintain the current
     *         conversation state.
     */
    public String getConversationToken() {
        return conversationToken;
    }

    public void setConversationToken(String conversationToken) {
        this.conversationToken = conversationToken;
    }

    public String toString() {
        return "Conversation [conversationToken=" + getConversationToken() + ", type=" + getType() + "]";
    }

}