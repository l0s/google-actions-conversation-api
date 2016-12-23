package com.macasaet.google.conversation;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

/**
 * This is the request from the Assistant Platform for the agent (action endpoint) to process.
 *
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @see <a href=
 *      "https://developers.google.com/actions/reference/conversation#request">
 *      https://developers.google.com/actions/reference/conversation#request</a>
 * @author Carlos Macasaet
 */
public class ConversationRequest {

    private User user;
    private Device device;
    private Conversation conversation;
    private List<Input> inputs = new LinkedList<>();

    @XmlTransient
    public String getConversationToken() {
        final Conversation convo = getConversation();
        return convo != null ? convo.getConversationToken() : null;
    }

    /**
     * @return the user that initiated this conversation.
     */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return Information associated with the device from which the
     *         conversation was initiated.
     */
    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    /**
     * @return session data like the conversation ID and token
     */
    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    /**
     * List of inputs corresponding to developer-required expected input. The
     * input could be the query semantics for initial query, or
     * assistant-provided response for developer required input. We ensure 1:1
     * mapping for all the required inputs from developer. Note that currently
     * only one expected input is supported.
     *
     * @return inputs corresponding to developer-required expected input
     */
    public List<Input> getInputs() {
        return inputs;
    }

    public void setInputs(List<Input> inputs) {
        this.inputs = inputs;
    }

    public String toString() {
        return "ConversationRequest [user=" + getUser() + ", conversation=" + getConversation() + "]";
    }

}