package org.example.instazam.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseModel{
    private String fullName;
    private String username;
    private String email;
    private String password;
}
