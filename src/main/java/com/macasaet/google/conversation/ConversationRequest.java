package com.macasaet.google.conversation;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

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

    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Device getDevice() {
        return device;
    }
    
    public void setDevice(Device device) {
        this.device = device;
    }
    
    public Conversation getConversation() {
        return conversation;
    }
    
    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
    
    public List<Input> getInputs() {
        return inputs;
    }
    
    public void setInputs(List<Input> inputs) {
        this.inputs = inputs;
    }

    @Override
    public String toString() {
        return "ConversationRequest [user=" + getUser() + ", conversation=" + getConversation() + "]";
    }

}