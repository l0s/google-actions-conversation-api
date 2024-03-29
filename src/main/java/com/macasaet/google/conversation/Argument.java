package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Semantically annotated value extracted from the user's input.
 *
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @see <a href="https://developers.google.com/actions/reference/conversation#Arguments">https://developers.google.com/actions/reference/conversation#Arguments</a>
 * @author Carlos Macasaet
 */
public class Argument {

    private String name;
    @XmlAttribute(name="raw_text")
    private String rawText;
    @XmlAttribute(name="int_value")
    private Integer intValue;
    @XmlAttribute(name="bool_value")
    private Boolean boolValue;
    @XmlAttribute(name="text_value")
    private String textValue;
    @XmlElement(name="date_value")
    private DateValue dateValue;
    @XmlElement(name="time_value")
    private TimeValue timeValue;
    @XmlElement(name="location_value")
    private Location locationValue;

    public static class DateValue {

        private int year;
        private int month;
        private int day;
        
        public int getYear() {
            return year;
        }
        
        public void setYear(int year) {
            this.year = year;
        }
        
        public int getMonth() {
            return month;
        }
        
        public void setMonth(int month) {
            this.month = month;
        }
        
        public int getDay() {
            return day;
        }
        
        public void setDay(int day) {
            this.day = day;
        }
    }

    public static class TimeValue {

        private int hours;
        private int minutes;
        private int seconds;
        private int nanos;
        
        public int getHours() {
            return hours;
        }
        
        public void setHours(int hours) {
            this.hours = hours;
        }
        
        public int getMinutes() {
            return minutes;
        }
        
        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }
        
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

    /**
     * Name of the payload in the query.
     *
     * @return Name of the payload in the query.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * raw text value for the argument.
     *
     * @return raw text value
     */
    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    /**
     * Specified when the user input had a $SchemaOrg_Number argument.
     */
    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    /**
     * Specified when the user input had a $SchemaOrg_YesNo argument.
     */
    public Boolean getBoolValue() {
        return boolValue;
    }

    public void setBoolValue(Boolean boolValue) {
        this.boolValue = boolValue;
    }

    /**
     * Specified when the user input had a $SchemaOrg_Text argument.
     */
    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    /**
     * Specified when the user input had a $SchemaOrg_Date argument
     */
    public DateValue getDateValue() {
        return dateValue;
    }

    public void setDateValue(DateValue dateValue) {
        this.dateValue = dateValue;
    }

    /**
     * Specified when the user input had a $SchemaOrg_Time argument.
     */
    public TimeValue getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(TimeValue timeValue) {
        this.timeValue = timeValue;
    }

    /**
     * Specified when the user input had a $SchemaOrg_Place argument.
     */
    public Location getLocationValue() {
        return locationValue;
    }

    public void setLocationValue(Location locationValue) {
        this.locationValue = locationValue;
    }

}