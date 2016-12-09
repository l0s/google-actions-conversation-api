package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

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

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getRawText() {
        return rawText;
    }

    
    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    
    public Integer getIntValue() {
        return intValue;
    }

    
    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    
    public Boolean getBoolValue() {
        return boolValue;
    }

    
    public void setBoolValue(Boolean boolValue) {
        this.boolValue = boolValue;
    }

    
    public String getTextValue() {
        return textValue;
    }

    
    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    
    public DateValue getDateValue() {
        return dateValue;
    }

    
    public void setDateValue(DateValue dateValue) {
        this.dateValue = dateValue;
    }

    
    public TimeValue getTimeValue() {
        return timeValue;
    }

    
    public void setTimeValue(TimeValue timeValue) {
        this.timeValue = timeValue;
    }

    
    public Location getLocationValue() {
        return locationValue;
    }

    
    public void setLocationValue(Location locationValue) {
        this.locationValue = locationValue;
    }

}