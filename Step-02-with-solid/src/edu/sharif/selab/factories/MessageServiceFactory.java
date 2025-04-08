// factories/MessageServiceFactory.java
package edu.sharif.selab.factories;

import edu.sharif.selab.services.EmailMessageService;
import edu.sharif.selab.services.SMSMessageService;
import edu.sharif.selab.services.TelegramMessageService;
import edu.sharif.selab.services.MessageService;
import java.util.HashMap;
import java.util.Map;

public class MessageServiceFactory {
    private final Map<String, MessageService<?>> services = new HashMap<>();

    public MessageServiceFactory() {
        registerServices();
    }

    private void registerServices() {
        services.put("email", new EmailMessageService());
        services.put("sms", new SMSMessageService());
        services.put("telegram", new TelegramMessageService());
    }

    public MessageService<?> getMessageService(String serviceType) {
        return services.get(serviceType.toLowerCase());
    }
}
