package com.macasaet.google.conversation;

import java.util.List;

public class ConversationRequest {

    private User user;
    private Device device;
    private Conversation conversation;
    private List<Input> inputs;

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

}