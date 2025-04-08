import edu.sharif.selab.factories.MessageServiceFactory;
import edu.sharif.selab.models.*;
import edu.sharif.selab.services.*;

public class Main {
    private final MessageServiceFactory factory = new MessageServiceFactory();

    public void processMessage(String serviceType, Message message) {
        MessageService<?> service = factory.getMessageService(serviceType);
        if (service != null) {
            if (service instanceof ValidationService validator) {
                if (!validateMessage(validator, message)) {
                    System.out.println("Validation failed!");
                    return;
                }
            }
            // Type-safe dispatch using pattern matching
            switch (message) {
                case EmailMessage emailMsg ->
                        ((MessageService<EmailMessage>) service).send(emailMsg);
                case SMSMessage smsMsg ->
                        ((MessageService<SMSMessage>) service).send(smsMsg);
                case TelegramMessage tgMsg ->
                        ((MessageService<TelegramMessage>) service).send(tgMsg);
                default -> throw new IllegalArgumentException("Unsupported message type");
            }
        }
    }

    private boolean validateMessage(ValidationService validator, Message message) {
        return switch (message) {
            case EmailMessage emailMsg ->
                    validator.validate(emailMsg.getTargetEmail());
            case SMSMessage smsMsg ->
                    validator.validate(smsMsg.getTargetNumber());
            case TelegramMessage tgMsg ->
                    validator.validate(tgMsg.getTargetId());
            default -> false;
        };
    }

    public static void main(String[] args) {
        Main app = new Main();

        // Email Example
        EmailMessage email = new EmailMessage();
        email.setSourceEmail("sender@example.com");
        email.setTargetEmail("receiver@example.com");
        app.processMessage("email", email);

        // SMS Example
        SMSMessage sms = new SMSMessage();
        sms.setSourceNumber("+989121234567");
        sms.setTargetNumber("+989351234567");
        app.processMessage("sms", sms);

        // Telegram Example
        TelegramMessage telegram = new TelegramMessage();
        telegram.setSourceId("@sender123");
        telegram.setTargetId("@receiver456");
        app.processMessage("telegram", telegram);
    }
}
