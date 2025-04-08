// models/SMSMessage.java
package edu.sharif.selab.models;

public class SMSMessage extends Message {
    private String sourceNumber;
    private String targetNumber;

    public String getSourceNumber() { return sourceNumber; }
    public void setSourceNumber(String sourceNumber) { this.sourceNumber = sourceNumber; }
    public String getTargetNumber() { return targetNumber; }
    public void setTargetNumber(String targetNumber) { this.targetNumber = targetNumber; }
}
