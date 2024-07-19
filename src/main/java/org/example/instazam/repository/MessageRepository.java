package org.example.instazam.repository;

import org.example.instazam.model.Message;

public class MessageRepository extends BaseRepository<Message> {
    private MessageRepository() {
        path += "/messages.json";
    }
    private static MessageRepository messageRepository = new MessageRepository();
    public static MessageRepository getInstance(){
        return messageRepository;
    }
    @Override
    protected boolean hasModel() {
        return false;
    }

    @Override
    protected Class<Message> getTypeClass() {
        return Message.class;
    }
}
