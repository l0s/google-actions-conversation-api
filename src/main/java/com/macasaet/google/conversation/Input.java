package com.macasaet.google.conversation;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Input {

    private String intent;
    @XmlElement(name="raw_inputs")
    private List<RawInput> rawInputs;
    private List<Argument> arguments;
    
    public String getIntent() {
        return intent;
    }
    
    public void setIntent(String intent) {
        this.intent = intent;
    }
    
    public List<RawInput> getRawInputs() {
        return rawInputs;
    }
    
    public void setRawInputs(List<RawInput> rawInputs) {
        this.rawInputs = rawInputs;
    }
    
    public List<Argument> getArguments() {
        return arguments;
    }
    
    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

}