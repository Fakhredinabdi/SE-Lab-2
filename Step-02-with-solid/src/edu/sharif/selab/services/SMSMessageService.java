// services/SMSMessageService.java
package edu.sharif.selab.services;

import edu.sharif.selab.models.SMSMessage;

public class SMSMessageService implements MessageService<SMSMessage>, ValidationService {
    @Override
    public void send(SMSMessage message) {
        System.out.println("Sending SMS from " + message.getSourceNumber()
                + " to " + message.getTargetNumber());
    }

    @Override
    public boolean validate(String phoneNumber) {
        return phoneNumber.matches("^\\+?[0-9]{10,13}$");
    }
}
