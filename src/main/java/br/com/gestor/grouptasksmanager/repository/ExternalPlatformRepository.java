package br.com.gestor.grouptasksmanager.repository;

import br.com.gestor.grouptasksmanager.model.externalplatform.ExternalPlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExternalPlatformRepository extends JpaRepository<ExternalPlatform, UUID> {

}
