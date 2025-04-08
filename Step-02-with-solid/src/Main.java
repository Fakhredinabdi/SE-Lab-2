import edu.sharif.selab.factories.MessageServiceFactory;
import edu.sharif.selab.models.*;
import edu.sharif.selab.services.MessageService;
import edu.sharif.selab.services.ValidationService;

import java.util.Scanner;

public class Main {
    private final MessageServiceFactory factory = new MessageServiceFactory();
    public static final Scanner scanner = new Scanner(System.in);

    public void processMessage(String serviceType, Message message) {
        MessageService service = factory.getMessageService(serviceType);
        if (service != null) {
            if (service instanceof ValidationService) {
                ValidationService validator = (ValidationService) service;
                if (!message.validate(validator)) {
                    System.out.println("Validation failed!");
                    return;
                }
            }
            message.send(service);
        }
    }

    public static void main(String[] args) {
        Main app = new Main();
        System.out.println("Hello and Welcome to SE Lab Messenger.");

        while (true) {
            System.out.println("In order to send Sms message enter 1");
            System.out.println("In order to send Email message enter 2");
            System.out.println("In order to send Telegram message enter 3");
            System.out.println("In order to Exit, Enter 0");

            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            Message message = createMessage(choice);
            if (message != null) {
                String serviceType = getServiceType(choice);
                if (serviceType != null) {
                    app.processMessage(serviceType, message);
                }
            }
        }

        scanner.close();
    }

    private static Message createMessage(int choice) {
        scanner.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                SMSMessage sms = new SMSMessage();
                System.out.print("Enter source phone: ");
                sms.setSourceNumber(scanner.nextLine());
                System.out.print("Enter target phone: ");
                sms.setTargetNumber(scanner.nextLine());
                System.out.print("Enter message: ");
                sms.setContent(scanner.nextLine());
                return sms;

            case 2:
                EmailMessage email = new EmailMessage();
                System.out.print("Enter source email: ");
                email.setSourceEmail(scanner.nextLine());
                System.out.print("Enter target email: ");
                email.setTargetEmail(scanner.nextLine());
                System.out.print("Enter message: ");
                email.setContent(scanner.nextLine());
                return email;

            case 3:
                TelegramMessage telegram = new TelegramMessage();
                System.out.print("Enter source username: ");
                telegram.setSourceId(scanner.nextLine());
                System.out.print("Enter target username: ");
                telegram.setTargetId(scanner.nextLine());
                System.out.print("Enter message: ");
                telegram.setContent(scanner.nextLine());
                return telegram;

            default:
                System.out.println("Invalid choice!");
                return null;
        }
    }

    private static String getServiceType(int choice) {
        switch (choice) {
            case 1:
                return "sms";
            case 2:
                return "email";
            case 3:
                return "telegram";
            default:
                System.out.println("Invalid choice!");
                return null;
        }
    }
}