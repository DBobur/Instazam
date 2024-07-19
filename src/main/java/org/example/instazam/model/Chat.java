package org.example.instazam.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chat extends BaseModel{
    private UUID starterId;
    private UUID joinerId;
}
