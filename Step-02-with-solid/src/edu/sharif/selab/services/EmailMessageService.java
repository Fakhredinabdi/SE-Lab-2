package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.Message;

public class EmailMessageService implements MessageService, ValidationService {
    @Override
    public void send(Message message) {
        sendEmailMessage((EmailMessage) message);
    }

    public void sendEmailMessage(EmailMessage emailMessage) {
        if (validate(emailMessage.getTargetEmail())) {
            System.out.println("Sending email from " + emailMessage.getSourceEmail() + " to " + emailMessage.getTargetEmail() + " with content: " + emailMessage.getContent());
        }
    }

    @Override
    public boolean validate(String email) {
        return email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
    }
}
