package org.example.instazam.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Like extends BaseModel{
    private UUID liker;
    private UUID postId;
}
