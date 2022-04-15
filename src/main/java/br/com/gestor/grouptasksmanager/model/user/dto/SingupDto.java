package br.com.gestor.grouptasksmanager.model.user.dto;

import lombok.Builder;

@Builder
public class SingupDto {
    public String nickname;
    public String login;
    public String password;
}
