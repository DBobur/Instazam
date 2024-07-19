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

    public static User update(User u, User uu){
        if (uu.fullName != null && !uu.fullName.isBlank()) {
            u.setFullName(uu.getFullName());
        }
        if (uu.username != null && !uu.username.isBlank()) {
            u.setUsername(uu.getUsername());
        }
        if (uu.email != null && !uu.email.isBlank()) {
            u.setEmail(uu.getEmail());
        }
        if (uu.password != null && !uu.password.isBlank()) {
            u.setPassword(uu.getPassword());
        }
        return u;
    }

}
