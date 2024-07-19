package org.example.instazam.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Follower extends BaseModel{
    private UUID followerId;
    private UUID followedId;
}
