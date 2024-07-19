package org.example.instazam.repository;

import org.example.instazam.model.Chat;

public class ChatRepository extends BaseRepository<Chat>{
    private ChatRepository() {
        path += "/chats.json";
    }
    private ChatRepository chatRepository = new ChatRepository();
    public ChatRepository getInstance(){
        return chatRepository;
    }

    @Override
    protected boolean hasModel() {
        return false;
    }

    @Override
    protected Class<Chat> getTypeClass() {
        return Chat.class;
    }
}
