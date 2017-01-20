package com.macasaet.google.conversation;

import static java.util.Collections.singletonList;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * A response sent from an action agent (endpoint) to the Assistant Platform.
 *
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @see <a href="https://developers.google.com/actions/reference/conversation#http-response">https://developers.google.com/actions/reference/conversation#http-response</a>
 * @author Carlos Macasaet
 */
public class ConversationResponse {

    @XmlAttribute(name="conversation_token")
    private String conversationToken;
    @XmlAttribute(name="expect_user_response")
    private boolean expectUserResponse;
    @XmlElement(name="expected_inputs")
    private List<ExpectedInput> expectedInputs = new LinkedList<>();
    @XmlElement(name="final_response")
    private FinalResponse finalResponse;

    /**
     * A serialized opaque_token for any session object that your action wants Assistant to circulate back.
     *
     * @return an opaque token
     */
    public String getConversationToken() {
        return conversationToken;
    }

    /**
     * @param conversationToken
     *            an opaque token for any session object that your action wants
     *            Assistant to circulate back.
     */
    public void setConversationToken(String conversationToken) {
        this.conversationToken = conversationToken;
    }

    /**
     * Indicates whether the agent is expecting a response from the user. This
     * is true when the dialog is ongoing; false when the dialog is done.
     * 
     * @return true if and only if a dialog is ongoing.
     */
    public boolean isExpectUserResponse() {
        return expectUserResponse;
    }

    /**
     * @param expectUserResponse true if and only if a dialog is ongoing.
     */
    public void setExpectUserResponse(boolean expectUserResponse) {
        this.expectUserResponse = expectUserResponse;
    }

    /**
     * Lists inputs that the action requires in the next response.
     *
     * NOTE: Only 1 ExpectedInput is currently allowed.
     *
     * @return inputs that the action requires in the next response
     */
    public List<ExpectedInput> getExpectedInputs() {
        return expectedInputs;
    }

    protected void setExpectedInputs(List<ExpectedInput> expectedInputs) {
        this.expectedInputs = expectedInputs;
    }

    /**
     * @param expectedInput the input that the action requires in the next response
     */
    public void setExpectedInput(final ExpectedInput expectedInput) {
        setExpectedInputs(singletonList(expectedInput));
        setExpectUserResponse(true);
    }

    /**
     * The response only when there are no ExpectedInputs and
     * expect_user_response is false.
     *
     * NOTE: the documentation indicates that "finalResponse" is of type
     * {@link SpeechResponse}. However, the examples show it as a wrapper around
     * a {@link SpeechResponse}.
     *
     * @return the last response to send for this conversation
     */
    public FinalResponse getFinalResponse() {
        return finalResponse;
    }

    /**
     * @param finalResponse the response to send if this is the last response for the conversation
     */
    public void setFinalResponse(FinalResponse finalResponse) {
        this.finalResponse = finalResponse;
    }

    /**
     * Convenience method to set the final speech response.
     *
     * @param speechResponse final speech response
     */
    public void setFinalResponse(final SpeechResponse speechResponse) {
        final FinalResponse wrapper = new FinalResponse();
        wrapper.setSpeechResponse(speechResponse);
        setFinalResponse(wrapper);
    }

    public String toString() {
        return "ConversationResponse [conversationToken=" + getConversationToken() + ", expectUserResponse="
                + isExpectUserResponse() + ", finalResponse=" + getFinalResponse() + "]";
    }

}