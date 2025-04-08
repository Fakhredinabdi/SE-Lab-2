package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.TelegramMessage;

public class TelegramMessageService implements MessageService, ValidationService {
    @Override
    public void send(Message message) {
        sendTelegramMessage((TelegramMessage) message);
    }

    public void sendTelegramMessage(TelegramMessage telegramMessage) {
        if (validate(telegramMessage.getSourceId()) && validate(telegramMessage.getTargetId())) {
            System.out.println("Sending Telegram message from " + telegramMessage.getSourceId() + " to " + telegramMessage.getTargetId() + " with content: " + telegramMessage.getContent());
        }
    }

    @Override
    public boolean validate(String telegramId) {
        return telegramId.matches("^[a-zA-Z][a-zA-Z0-9_]{4,31}$");
    }
}
