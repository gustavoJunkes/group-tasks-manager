package br.com.gestor.grouptasksmanager.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "usu")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String firstName;

    private String lastName;

    private String nickname;
    @Column(unique = true, nullable = false)
    private String login;

   private String password;

    public User(String nickname, String login, String password) {
        this.login = login;
        this.nickname = nickname;
        this.password = password;
    }


}
