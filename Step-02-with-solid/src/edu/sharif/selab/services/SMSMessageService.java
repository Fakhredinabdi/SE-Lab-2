package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.SMSMessage;

public class SMSMessageService implements MessageService, ValidationService {
    @Override
    public void send(Message message) {
        sendSMSMessage((SMSMessage) message);
    }

    public void sendSMSMessage(SMSMessage smsMessage) {
        if (validate(smsMessage.getSourceNumber()) && validate(smsMessage.getTargetNumber())) {
            System.out.println("Sending SMS from " + smsMessage.getSourceNumber() + " to " + smsMessage.getTargetNumber() + " with content: " + smsMessage.getContent());
        }
    }

    @Override
    public boolean validate(String phoneNumber) {
        return phoneNumber.matches("^\\+?[0-9]{10,13}$");
    }
}
