// models/TelegramMessage.java
package edu.sharif.selab.models;

import edu.sharif.selab.services.MessageService;
import edu.sharif.selab.services.TelegramMessageService;
import edu.sharif.selab.services.ValidationService;

public class TelegramMessage extends Message {
    private String sourceId;
    private String targetId;

    public String getSourceId() { return sourceId; }
    public void setSourceId(String sourceId) { this.sourceId = sourceId; }
    public String getTargetId() { return targetId; }
    public void setTargetId(String targetId) { this.targetId = targetId; }

    @Override
    public void send(MessageService service) {
        ((TelegramMessageService) service).sendTelegramMessage(this);
    }

    @Override
    public boolean validate(ValidationService validator) {
        return validator.validate(sourceId) && validator.validate(targetId);
    }
}
