package org.example.instazam.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends BaseModel{
    private UUID commenterId;
    private UUID postId;
    private String comment;
}
