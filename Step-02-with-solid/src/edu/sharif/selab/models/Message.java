package edu.sharif.selab.models;

import edu.sharif.selab.services.ValidationService;
import edu.sharif.selab.services.MessageService;

public abstract class Message {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public abstract void send(MessageService service);
    public abstract boolean validate(ValidationService validator);
}