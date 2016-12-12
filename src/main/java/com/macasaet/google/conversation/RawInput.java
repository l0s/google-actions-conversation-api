package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class RawInput {

    @XmlElement(name="create_time")
    private CreateTime createTime;
    @XmlAttribute(name="input_type")
    private Integer inputType;
    private String query;

    public static class CreateTime {
        private int seconds;
        private int nanos;

        public int getSeconds() {
            return seconds;
        }
        
        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }
        
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

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

}