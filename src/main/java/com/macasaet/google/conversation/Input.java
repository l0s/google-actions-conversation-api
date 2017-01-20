package com.macasaet.google.conversation;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * The inputs object contains useful data about the request. The input could be
 * the query semantics for the initial query, or the assistant-provided response
 * for developer required input.
 *
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @see <a href=
 *      "https://developers.google.com/actions/reference/conversation#Inputs">
 *      https://developers.google.com/actions/reference/conversation#Inputs</a>
 * @author Carlos Macasaet
 */
public class Input {

    private String intent;
    @XmlElement(name="raw_inputs")
    private List<RawInput> rawInputs = new LinkedList<>();
    private List<Argument> arguments = new LinkedList<>();

    /**
     * Indicates the user's intent; will be one of the possible_intents specified in the developer request.
     *
     * @return one of the possible_intents specified in the developer request
     */
    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    /**
     * Raw input transcription from each turn of conversation in the dialog that
     * resulted from the previous expected input.
     *
     * @return raw transcriptions
     */
    public List<RawInput> getRawInputs() {
        return rawInputs;
    }

    public void setRawInputs(List<RawInput> rawInputs) {
        this.rawInputs = rawInputs;
    }

    /**
     * Semantically annotated values extracted from the user's inputs.
     *
     * @return extracted values
     */
    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

    public Argument getArgument(final String argumentName) {
        for (final Argument candidate : getArguments()) {
            if (candidate.getName().equalsIgnoreCase(argumentName)) {
                return candidate;
            }
        }
        return null;
    }

}