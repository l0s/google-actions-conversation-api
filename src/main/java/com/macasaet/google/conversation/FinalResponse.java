package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlElement;

public class FinalResponse {

    @XmlElement(name="speech_response")
    private SpeechResponse speechResponse;

    public SpeechResponse getSpeechResponse() {
        return speechResponse;
    }

    public void setSpeechResponse(SpeechResponse speechResponse) {
        this.speechResponse = speechResponse;
    }

    public String toString() {
        return "FinalResponse [speechResponse=" + getSpeechResponse() + "]";
    }

}