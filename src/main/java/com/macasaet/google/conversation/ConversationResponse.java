package com.macasaet.google.conversation;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ConversationResponse {

    @XmlAttribute(name="conversation_token")
    private String conversationToken;
    @XmlAttribute(name="expect_user_response")
    private boolean expectUserResponse;
    @XmlElement(name="expected_inputs")
    private List<ExpectedInput> expectedInputs = new LinkedList<>();
    @XmlElement(name="final_response")
    private FinalResponse finalResponse;

    public String getConversationToken() {
        return conversationToken;
    }

    public void setConversationToken(String conversationToken) {
        this.conversationToken = conversationToken;
    }

    public boolean isExpectUserResponse() {
        return expectUserResponse;
    }

    public void setExpectUserResponse(boolean expectUserResponse) {
        this.expectUserResponse = expectUserResponse;
    }

    public List<ExpectedInput> getExpectedInputs() {
        return expectedInputs;
    }

    public void setExpectedInputs(List<ExpectedInput> expectedInputs) {
        this.expectedInputs = expectedInputs;
    }

    public FinalResponse getFinalResponse() {
        return finalResponse;
    }

    public void setFinalResponse(FinalResponse finalResponse) {
        this.finalResponse = finalResponse;
    }

    public String toString() {
        return "ConversationResponse [conversationToken=" + getConversationToken() + ", expectUserResponse="
                + isExpectUserResponse() + ", finalResponse=" + getFinalResponse() + "]";
    }

}