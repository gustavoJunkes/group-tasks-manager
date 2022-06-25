package br.com.gestor.grouptasksmanager.model.externalplatform.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
public class ExternalPlatformDto {

    public UUID id;
    public String name;
    public String url;
    public String login;
    public String password;

}
