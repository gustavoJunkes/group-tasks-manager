package br.com.gestor.grouptasksmanager.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private UUID id;

    private String nickname;

    private String login;

   private String password;

    @Enumerated(EnumType.STRING)
    private PermissionEnum permissionEnum;

    public User(String nickname, String login, String password) {
        this.login = login;
        this.nickname = nickname;
        this.password = password;
    }


}
