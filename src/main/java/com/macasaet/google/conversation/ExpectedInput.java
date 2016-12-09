package com.macasaet.google.conversation;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class ExpectedInput {

    @XmlElement(name="input_prompt")
    private Object inputPrompt; // FIXME
    @XmlElement(name="possible_intents")
    private List<Object> possibleIntents; // FIXME

}
