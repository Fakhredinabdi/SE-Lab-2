package edu.sharif.selab.models;

import edu.sharif.selab.services.EmailMessageService;
import edu.sharif.selab.services.MessageService;
import edu.sharif.selab.services.ValidationService;

public class EmailMessage extends Message {
    private String sourceEmail;
    private String targetEmail;

    public String getSourceEmail() { return sourceEmail; }
    public void setSourceEmail(String sourceEmail) { this.sourceEmail = sourceEmail; }
    public String getTargetEmail() { return targetEmail; }
    public void setTargetEmail(String targetEmail) { this.targetEmail = targetEmail; }

    @Override
    public void send(MessageService service) {
        ((EmailMessageService) service).sendEmailMessage(this);
    }

    @Override
    public boolean validate(ValidationService validator) {
        return validator.validate(sourceEmail) && validator.validate(targetEmail);
    }


}
