// services/EmailMessageService.java
package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;

public class EmailMessageService implements MessageService<EmailMessage>, ValidationService {
    @Override
    public void send(EmailMessage message) {
        System.out.println("Sending email from " + message.getSourceEmail()
                + " to " + message.getTargetEmail());
    }

    @Override
    public boolean validate(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
