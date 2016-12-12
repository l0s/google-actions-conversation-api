package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class SpeechResponse {

    @XmlElement(name="ssml")
    private String ssml;
    @XmlAttribute(name="text_to_speech")
    private String textToSpeech;

    public String getSsml() {
        return ssml;
    }

    public String getTextToSpeech() {
        return textToSpeech;
    }

    public void setSsml(String ssml) {
        this.ssml = ssml;
    }

    public void setTextToSpeech(String textToSpeech) {
        this.textToSpeech = textToSpeech;
    }

    public String toString() {
        return "SpeechResponse [textToSpeech=" + getTextToSpeech() + ", ssml=" + getSsml() + "]";
    }

}