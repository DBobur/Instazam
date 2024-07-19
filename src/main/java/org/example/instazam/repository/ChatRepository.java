package org.example.instazam.repository;

import org.example.instazam.model.Chat;

public class ChatRepository extends BaseRepository<Chat>{
    private ChatRepository() {
        path += "/chats.json";
    }
    private static ChatRepository chatRepository = new ChatRepository();
    public static ChatRepository getInstance(){
        return chatRepository;
    }


    @Override
    protected boolean hasModel(Chat chat) {
        return false;
    }

    @Override
    protected Class<Chat> getTypeClass() {
        return Chat.class;
    }
}
