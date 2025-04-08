// services/TelegramMessageService.java
package edu.sharif.selab.services;

import edu.sharif.selab.models.TelegramMessage;

public class TelegramMessageService implements MessageService<TelegramMessage>, ValidationService {
    @Override
    public void send(TelegramMessage message) {
        System.out.println("Sending Telegram message from " + message.getSourceId()
                + " to " + message.getTargetId());
    }

    @Override
    public boolean validate(String telegramId) {
        return telegramId.matches("^@[a-zA-Z0-9_]{5,32}$");
    }
}
