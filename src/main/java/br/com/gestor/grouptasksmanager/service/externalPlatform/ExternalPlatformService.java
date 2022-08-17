package br.com.gestor.grouptasksmanager.service.externalPlatform;

import br.com.gestor.grouptasksmanager.model.externalplatform.ExternalPlatform;
import br.com.gestor.grouptasksmanager.model.externalplatform.dto.ExternalPlatformDto;
import br.com.gestor.grouptasksmanager.repository.ExternalPlatformRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExternalPlatformService {

    private ExternalPlatformRepository platformRepository;

    public ExternalPlatformDto registerNewExternalPlatform(ExternalPlatformDto dto) {
        ExternalPlatform platform = ExternalPlatform.builder()
                .name(dto.name)
                .url(dto.url)
                .login(dto.login)
                .password(dto.password)
                .build();

        platform = platformRepository.save(platform);
        dto.id = platform.getId();
        return dto;
    }
}
