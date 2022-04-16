package br.com.gestor.grouptasksmanager.model.user.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public class SingupDto {

    public UUID id;

    public String firstName;

    public String lastName;

    public String nickname;
    public String login;
    public String password;
}
