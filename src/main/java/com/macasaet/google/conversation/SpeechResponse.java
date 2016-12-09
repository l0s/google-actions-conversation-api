package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class SpeechResponse {

    @XmlAttribute(name="text_to_speech")
    private String textToSpeech;
    @XmlElement(name="ssml")
    private String ssml;

    public String getTextToSpeech() {
        return textToSpeech;
    }

    public void setTextToSpeech(String textToSpeech) {
        this.textToSpeech = textToSpeech;
    }

    public String getSsml() {
        return ssml;
    }

    public void setSsml(String ssml) {
        this.ssml = ssml;
    }

}