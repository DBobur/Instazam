package org.example.instazam.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlockedInfo extends BaseModel{
    private UUID blockerId;
    private UUID blockedId;
    private String info;
}
