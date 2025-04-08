// models/EmailMessage.java
package edu.sharif.selab.models;

public class EmailMessage extends Message {
    private String sourceEmail;
    private String targetEmail;

    public String getSourceEmail() { return sourceEmail; }
    public void setSourceEmail(String sourceEmail) { this.sourceEmail = sourceEmail; }
    public String getTargetEmail() { return targetEmail; }
    public void setTargetEmail(String targetEmail) { this.targetEmail = targetEmail; }
}
