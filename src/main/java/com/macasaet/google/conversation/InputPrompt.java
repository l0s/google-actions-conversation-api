package com.macasaet.google.conversation;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * The customized prompt that asks the user for input.
 *
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @see <a href=
 *      "https://developers.google.com/actions/reference/conversation#InputPrompt">
 *      https://developers.google.com/actions/reference/conversation#InputPrompt
 *      </a>
 * @author Carlos Macasaet
 */
public class InputPrompt {

    @XmlElement(name="initial_prompts")
    private List<SpeechResponse> initialPrompts = new LinkedList<>();
    @XmlElement(name="no_input_prompts")
    private List<SpeechResponse> noInputPrompts = new LinkedList<>();

    public InputPrompt() {
    }

    public InputPrompt(final List<SpeechResponse> initialPrompts, final List<SpeechResponse> noInputPrompts) {
        setInitialPrompts(initialPrompts);
        setNoInputPrompts(initialPrompts);
    }

    public InputPrompt(final List<SpeechResponse> prompts) {
        this(prompts, prompts);
    }

    /**
     * A single prompt that asks the user to provide an input.
     *
     * @return prompts to ask the user for input when the response is presented
     */
    public List<SpeechResponse> getInitialPrompts() {
        return initialPrompts;
    }

    /**
     * @param initialPrompts prompts to ask the user for input when the response is presented
     */
    public void setInitialPrompts(List<SpeechResponse> initialPrompts) {
        this.initialPrompts = initialPrompts;
    }

    /**
     * Up to three prompts that are used to re-ask the user when there is no
     * input from user. For example,
     * "I'm sorry, I didn't hear you. Can you repeat that please?"
     * 
     * @return prompts to re-ask the user when no input is provided after some time.
     */
    public List<SpeechResponse> getNoInputPrompts() {
        return noInputPrompts;
    }

    /**
     * @param noInputPrompts prompts to re-ask the user when no input is provided after some time.
     */
    public void setNoInputPrompts(List<SpeechResponse> noInputPrompts) {
        this.noInputPrompts = noInputPrompts;
    }

}