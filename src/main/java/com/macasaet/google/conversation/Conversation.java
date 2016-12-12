package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;

public class Conversation {

    @XmlAttribute(name="conversation_id")
    private String conversationId;
    private Integer type;
    @XmlAttribute(name="conversation_token")
    private String conversationToken;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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