package org.example.instazam.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message extends BaseModel{
    private UUID senderId;
    private UUID chatId;
    private String  message;
}
