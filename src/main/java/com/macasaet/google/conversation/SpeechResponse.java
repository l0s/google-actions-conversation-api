package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * The initial and no-input prompts are defined by either a text_to_speech object
 * or an ssml object. The final_response object wraps these in a speech_response
 * object.
 *
 * <p>Copyright &copy; 2016 Edmunds.com.</p>
 * 
 * @see <a href=
 *      "https://developers.google.com/actions/reference/conversation#SpeechResponse">
 *      https://developers.google.com/actions/reference/conversation#
 *      SpeechResponse</a>
 * @author Carlos Macasaet &lt;cmacasaet@edmunds.com&gt;
 */
public class SpeechResponse {

    @XmlElement(name="ssml")
    private String ssml;
    @XmlAttribute(name="text_to_speech")
    private String textToSpeech;

    /**
     * Structured spoken response to the user (can include SSML markup). If this is specified, then
     * {@link #getTextToSpeech()} must not.
     * 
     * NOTE: The value of this property can contain only ASCII characters.
     *
     * @see <a href="https://developers.google.com/actions/reference/ssml">https
     *      ://developers.google.com/actions/reference/ssml</a>
     * @return Structured spoken response to the user
     */
    public String getSsml() {
        return ssml;
    }

    /**
     * Plain text of the speech output; for example, "where do you want to go?".
     * If this is specified, then {@link #getSsml()} must not.
     *
     * NOTE: The value of this property can contain only ASCII characters.
     *
     * @return plain text output speech.
     */
    public String getTextToSpeech() {
        return textToSpeech;
    }

    /**
     * Structured spoken response to the user (can include SSML markup). If this is specified, then
     * {@link #setTextToSpeech(String)} must not.
     *
     * NOTE: The value of this property can contain only ASCII characters.
     *
     * @see <a href="https://developers.google.com/actions/reference/ssml">https
     *      ://developers.google.com/actions/reference/ssml</a>
     * @param ssml Structured spoken response to the user
     */
    public void setSsml(String ssml) {
        this.ssml = ssml;
    }

    /**
     * Plain text of the speech output; for example, "where do you want to go?".
     * If this is specified, then {@link #getSsml()} must not.
     *
     * NOTE: The value of this property can contain only ASCII characters.
     *
     * @param textToSpeech plain text output speech.
     */
    public void setTextToSpeech(String textToSpeech) {
        this.textToSpeech = textToSpeech;
    }

    public String toString() {
        return "SpeechResponse [textToSpeech=" + getTextToSpeech() + ", ssml=" + getSsml() + "]";
    }

}