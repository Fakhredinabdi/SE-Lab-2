package edu.sharif.selab.models;

import edu.sharif.selab.services.MessageService;
import edu.sharif.selab.services.SMSMessageService;
import edu.sharif.selab.services.ValidationService;

public class SMSMessage extends Message {
    private String sourceNumber;
    private String targetNumber;

    public String getSourceNumber() { return sourceNumber; }
    public void setSourceNumber(String sourceNumber) { this.sourceNumber = sourceNumber; }
    public String getTargetNumber() { return targetNumber; }
    public void setTargetNumber(String targetNumber) { this.targetNumber = targetNumber; }

    @Override
    public void send(MessageService service) {
        ((SMSMessageService) service).sendSMSMessage(this);
    }

    @Override
    public boolean validate(ValidationService validator) {
        return validator.validate(sourceNumber) && validator.validate(targetNumber);
    }

}
