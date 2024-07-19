package org.example.instazam.model;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public abstract class BaseModel {
    {
        id = UUID.randomUUID();
        createdDate = LocalDateTime.now();
        active = true;
    }

    protected UUID id;
    protected LocalDateTime createdDate;
    protected boolean active;
}
