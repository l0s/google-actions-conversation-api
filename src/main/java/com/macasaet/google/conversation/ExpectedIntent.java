package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlElement;

public class ExpectedIntent {

    private String intent;
    @XmlElement(name="input_value_spec")
    private Object inputValueSpec; // FIXME

}