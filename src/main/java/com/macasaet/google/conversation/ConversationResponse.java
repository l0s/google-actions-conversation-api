package com.macasaet.google.conversation;

import static java.util.Collections.singletonList;
import static java.util.Collections.unmodifiableList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * A response sent from an action agent (endpoint) to the Assistant Platform.
 *
 * <p>Copyright &copy; 2017 Carlos Macasaet.</p>
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
     * @return the only expected input if one is expected, otherwise null.
     */
    @XmlTransient
    public ExpectedInput getExpectedInput() {
        final Iterator<ExpectedInput> iterator = getExpectedInputs().iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
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

    /**
     * Convenience object to simplify the creation of standard
     * {@link ConversationResponse ConversationResponses}. Use one of the
     * concrete-implementations to avoid creating invalid
     * {@link ConversationResponse} objects.
     *
     * <p>Copyright &copy; Carlos Macasaet.</p>
     *
     * @see TellResponseBuilder
     * @see AskResponseBuilder
     * @author Carlos Macasaet
     */
    public static abstract class Builder {

        private String conversationToken;

        /**
         * @return a valid {@link ConversationResponse}
         */
        public ConversationResponse build() {
            final ConversationResponse retval = createResponse();
            retval.setConversationToken(getConversationToken());
            return retval;
        }

        /**
         * Instantiate a new {@link ConversationResponse}.
         *
         * @return an instance with all of the properties set by the implementor.
         */
        protected abstract ConversationResponse createResponse();

        /**
         * Specify a conversation token. If invoked multiple times, each
         * subsequent invocation will overwrite the previous value.
         * 
         * @param conversationToken
         *            the new conversation token for Assistant to circulate back
         * @return a builder with this conversation token set.
         */
        public abstract Builder withConversationToken(final String conversationToken);

        protected String getConversationToken() {
            return conversationToken;
        }

        protected void setConversationToken(String conversationToken) {
            this.conversationToken = conversationToken;
        }

    }

    /**
     * {@link Builder} to generate a valid response that expects no further interaction from the end user.
     *
     * <p>Copyright &copy; 2017 Carlos Macasaet.</p>
     *
     * @see ConversationResponse#tell()
     * @author Carlos Macasaet
     */
    public static class TellResponseBuilder extends Builder {

        private String textToSpeech = null;
        private String ssml = null;

        /**
         * Set the final plain text to be spoken, overwriting any previously specified text or SSML.
         *
         * @param textToSpeech the final text to speak 
         * @return a builder with the final text to speak set
         */
        public TellResponseBuilder withTextToSpeech(final String textToSpeech) {
            setTextToSpeech(textToSpeech);
            setSsml(null);
            return this;
        }

        /**
         * Set the final Speech Synthesis Markup Language (SSML) to be spoken,
         * overwriting any previously specified SSML or text to speech.
         * 
         * @param ssml the final SSML to speak
         * @return a builder with the final SSML set
         */
        public TellResponseBuilder withSsml(final String ssml) {
            setSsml(ssml);
            setTextToSpeech(null);
            return this;
        }

        public TellResponseBuilder withConversationToken(final String conversationToken) {
            setConversationToken(conversationToken);
            return this;
        }

        protected ConversationResponse createResponse() {
            final SpeechResponse speechResponse = new SpeechResponse();
            speechResponse.setSsml(getSsml());
            speechResponse.setTextToSpeech(getTextToSpeech());
            final ConversationResponse retval = new ConversationResponse();
            retval.setFinalResponse(speechResponse);
            retval.setExpectUserResponse(false);
            return retval;
        }

        protected String getTextToSpeech() {
            return textToSpeech;
        }

        protected void setTextToSpeech(final String textToSpeech) {
            this.textToSpeech = textToSpeech;
        }

        protected String getSsml() {
            return ssml;
        }

        protected void setSsml(final String ssml) {
            this.ssml = ssml;
        }

    }

    /**
     * {@link Builder} that generates a valid, non-terminal, {@link ConversationResponse}.
     *
     * <p>Copyright &copy; 2017 Carlos Macasaet.</p>
     *
     * @author Carlos Macasaet
     */
    public static class AskResponseBuilder extends Builder {

        private final List<SpeechResponse> initialPrompts = new LinkedList<>();
        private final List<SpeechResponse> noInputPrompts = new LinkedList<>();
        private final List<ExpectedIntent> possibleIntents = new LinkedList<>();

        public AskResponseBuilder withPrompt(final SpeechResponse prompt) {
            return withInitialPrompt(prompt).withNoInputPrompt(prompt);
        }

        public AskResponseBuilder withTextToSpeechPrompt(final String textToSpeech) {
            return withInitialTextToSpeech(textToSpeech).withNoInputTextToSpeech(textToSpeech);
        }

        public AskResponseBuilder withSsmlPrompt(final String ssml) {
            return withInitialSsml(ssml).withNoInputSsml(ssml);
        }

        public AskResponseBuilder withInitialPrompt(final SpeechResponse prompt) {
            getInitialPrompts().add(prompt);
            return this;
        }

        public AskResponseBuilder withInitialTextToSpeech(final String textToSpeech) {
            final SpeechResponse initialPrompt = new SpeechResponse();
            initialPrompt.setTextToSpeech(textToSpeech);
            return withInitialPrompt(initialPrompt);
        }

        public AskResponseBuilder withInitialSsml(final String ssml) {
            final SpeechResponse initialPrompt = new SpeechResponse();
            initialPrompt.setSsml(ssml);
            return withInitialPrompt(initialPrompt);
        }

        public AskResponseBuilder withNoInputPrompt(final SpeechResponse prompt) {
            getNoInputPrompts().add(prompt);
            return this;
        }

        public AskResponseBuilder withNoInputTextToSpeech(final String textToSpeech) {
            final SpeechResponse noInputPrompt = new SpeechResponse();
            noInputPrompt.setTextToSpeech(textToSpeech);
            return withNoInputPrompt(noInputPrompt);
        }

        public AskResponseBuilder withNoInputSsml(final String ssml) {
            final SpeechResponse noInputPrompt = new SpeechResponse();
            noInputPrompt.setSsml(ssml);
            return withNoInputPrompt(noInputPrompt);
        }

        /**
         * Add a possible followup intent.
         *
         * @param possibleIntent a user intent that logically follows from the current intent.
         * @return a builder with the additional intent specified.
         */
        public AskResponseBuilder withExpectedIntent(final ExpectedIntent possibleIntent) {
            getPossibleIntents().add(possibleIntent);
            return this;
        }

        /**
         * Add a possible followup intent ID that requires no additional permissions.
         *
         * @param expectedIntentId a user intent that logically follows from the current intent.
         * @return a builder with the additional intent specified
         */
        public AskResponseBuilder withExpectedIntentId(final String expectedIntentId) {
            return withExpectedIntent(new ExpectedIntent(expectedIntentId));
        }

        /**
         * Add a possible followup intent that requires special permissions.
         *
         * @param expectedIntentId a user intent that logically follows from the current intent.
         * @param optContext explanation of why additional permissions are needed.
         * @param permissions additional permissions that are needed to perform the subsequent action
         * @return a builder with the additional intent specified
         */
        public AskResponseBuilder withExpectedIntent(final String expectedIntentId, final String optContext, final String... permissions) {
            return withExpectedIntent(new ExpectedIntent(expectedIntentId, optContext, permissions));
        }

        public AskResponseBuilder withConversationToken(final String conversationToken) {
            setConversationToken(conversationToken);
            return this;
        }

        protected ConversationResponse createResponse() {
            final InputPrompt inputPrompt =
                    new InputPrompt(unmodifiableList(getInitialPrompts()), unmodifiableList(getNoInputPrompts()));

            final ConversationResponse retval = new ConversationResponse();
            retval.setExpectUserResponse(true);
            retval.setExpectedInput(new ExpectedInput(inputPrompt, unmodifiableList(getPossibleIntents())));
            return retval;
        }

        protected List<SpeechResponse> getInitialPrompts() {
            return initialPrompts;
        }

        protected List<SpeechResponse> getNoInputPrompts() {
            return noInputPrompts;
        }

        protected List<ExpectedIntent> getPossibleIntents() {
            return possibleIntents;
        }

    }

    /**
     * Convenience method to guide the developer through the construction of a valid terminal response.
     *
     * @return builder for a terminal response.
     */
    public static TellResponseBuilder tell() {
        return new TellResponseBuilder();
    }

    /**
     * Convenience method to guide the developer through the construction of a non-terminal response.
     *
     * @return builder for a non-terminal response.
     */
    public static AskResponseBuilder ask() {
        return new AskResponseBuilder();
    }

    public String toString() {
        return "ConversationResponse [conversationToken=" + getConversationToken() + ", expectUserResponse="
                + isExpectUserResponse() + ", finalResponse=" + getFinalResponse() + "]";
    }

}