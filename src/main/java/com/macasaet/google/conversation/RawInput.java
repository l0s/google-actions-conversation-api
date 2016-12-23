package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Raw input transcription from each turn of conversation in the dialog that resulted from the previous expected input.
 *
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @see <a href="https://developers.google.com/actions/reference/conversation#RawInputs">https://developers.google.com/actions/reference/conversation#RawInputs</a>
 * @author Carlos Macasaet
 */
public class RawInput {

    @XmlElement(name="create_time")
    private CreateTime createTime;
    @XmlAttribute(name="input_type")
    private Integer inputType;
    private String query;

    public static class CreateTime {

        private int seconds;
        private int nanos;

        /**
         * Represents seconds of UTC time since Unix epoch 1970-01-01T00:00:00Z.
         * Must be from 0001-01-01T00:00:00Z to 9999-12-31T23:59:59Z inclusive.
         * 
         * @return seconds of UTC time since the epoch
         */
        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        /**
         * Non-negative fractions of a second at nanosecond resolution. Negative
         * second values with fractions must still have non-negative nanos
         * values that count forward in time. Must be from 0 to 999,999,999
         * inclusive.
         * 
         * @return fractions of a second at nanosecond resolution
         */
        public int getNanos() {
            return nanos;
        }
        
        public void setNanos(int nanos) {
            this.nanos = nanos;
        }
    }

    public static enum InputType {
        UNSPECIFIC_INPUT_TYPE,
        TOUCH,
        VOICE
    }

    public CreateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(CreateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * Indicates the kind of input: a typed query, a voice query, or
     * unspecified.
     * 
     * NOTE: According to the documentation, this returns be an enum that looks
     * like: Enum[ 'UNSPECIFIC_INPUT_TYPE', 'TOUCH', 'VOICE' ]. However, in
     * testing against the Assistant Platform, integers were provided instead.
     * 
     * @return the kind of input
     */
    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    /**
     * Keyboard input or spoken input from end user.
     *
     * @return the raw input text
     */
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

}