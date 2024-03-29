package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlElement;

/**
 * An intent that can be used to fulfil a given input.
 *
 * <p>Copyright &copy; 2017 Carlos Macasaet.</p>
 *
 * @see <a href="https://developers.google.com/actions/reference/conversation#ExpectedIntent">https://developers.google.com/actions/reference/conversation#ExpectedIntent</a>
 * @author Carlos Macasaet
 */
public class ExpectedIntent {

    private String intent;
    @XmlElement(name="input_value_spec")
    private InputValueSpec inputValueSpec;

    public ExpectedIntent() {
    }

    /**
     * @param intentId the Assistant-provided intent
     */
    public ExpectedIntent(final String intentId) {
        setIntent(intentId);
    }

    /**
     * @param intentId the Assistant-provided intent
     * @param inputValueSpec description of the permissions required to fulfil the intent
     */
    public ExpectedIntent(final String intentId, final InputValueSpec inputValueSpec) {
        this(intentId);
        setInputValueSpec(inputValueSpec);
    }

    /**
     * @param intentId the Assistant-provided intent
     * @param optContext explanation of why permission is needed
     * @param permissions the permissions that are needed to fulfil the intent
     */
    public ExpectedIntent(final String intentId, final String optContext, final String... permissions) {
        this(intentId, new InputValueSpec(optContext, permissions));
    }

    /**
     * @return The ID of the assistant-provided intent.
     */
    public String getIntent() {
        return intent;
    }

    /**
     * @param intent The ID of the assistant-provided intent.
     */
    public void setIntent(String intent) {
        this.intent = intent;
    }

    /**
     * Specified in order to request the user's permission to access profile and device information.
     *
     * @return description of the input needed
     */
    public InputValueSpec getInputValueSpec() {
        return inputValueSpec;
    }

    /**
     * Specified in order to request the user's permission to access profile and device information.
     *
     * @param inputValueSpec description of the input needed
     */
    public void setInputValueSpec(InputValueSpec inputValueSpec) {
        this.inputValueSpec = inputValueSpec;
    }

}