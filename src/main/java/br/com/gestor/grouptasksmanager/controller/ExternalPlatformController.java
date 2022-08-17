package br.com.gestor.grouptasksmanager.controller;

import br.com.gestor.grouptasksmanager.model.externalplatform.dto.ExternalPlatformDto;
import br.com.gestor.grouptasksmanager.service.externalPlatform.ExternalPlatformService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/externalPlatform")
@RestController
@AllArgsConstructor
public class ExternalPlatformController {

    private ExternalPlatformService platformService;

    @PostMapping("newExternalPlatform")
    public ResponseEntity<ExternalPlatformDto> registerNewExternalPlatform(@RequestBody ExternalPlatformDto dto) {
        dto = platformService.registerNewExternalPlatform(dto);
        return new ResponseEntity(dto, HttpStatus.CREATED);
    }

}
