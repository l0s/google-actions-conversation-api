package com.macasaet.google.conversation;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ConversationResponse {

    @XmlAttribute(name="conversation_token")
    private String conversationToken;
    @XmlAttribute(name="expect_user_response")
    private boolean expectUserResponse;
    @XmlElement(name="expected_inputs")
    private List<Object> expectedInputs; // FIXME
    @XmlElement(name="final_response")
    private Object finalResponse; // FIXME

}