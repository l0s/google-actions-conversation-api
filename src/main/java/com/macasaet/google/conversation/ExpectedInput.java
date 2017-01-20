package com.macasaet.google.conversation;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * The expected_inputs object enables the action to request input from the user
 * by matching one of a set of specified possible_intents.
 *
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @see <a href=
 *      "https://developers.google.com/actions/reference/conversation#ExpectedInputs">
 *      https://developers.google.com/actions/reference/conversation#
 *      ExpectedInputs</a>
 * @author Carlos Macasaet
 */
public class ExpectedInput {

    @XmlElement(name="input_prompt")
    private InputPrompt inputPrompt;
    @XmlElement(name="possible_intents")
    private List<ExpectedIntent> possibleIntents;

    public ExpectedInput() {
    }

    public ExpectedInput(final InputPrompt inputPrompt, final List<ExpectedIntent> possibleIntents) {
        setInputPrompt(inputPrompt);
        setPossibleIntents(possibleIntents);
    }

    /**
     * The customized prompt that asks the user for input.
     *
     * @return customized prompt that asks the user for input
     */
    public InputPrompt getInputPrompt() {
        return inputPrompt;
    }

    /**
     * @param inputPrompt The customized prompt that asks the user for input.
     */
    public void setInputPrompt(final InputPrompt inputPrompt) {
        this.inputPrompt = inputPrompt;
    }

    /**
     * A list of intents that can be used to fulfill the input.
     *
     * @return intents that can be used to fulfill the input
     */
    public List<ExpectedIntent> getPossibleIntents() {
        return possibleIntents;
    }

    /**
     * @param possibleIntents intents that can be used to fulfill the input
     */
    public void setPossibleIntents(final List<ExpectedIntent> possibleIntents) {
        this.possibleIntents = possibleIntents;
    }

}