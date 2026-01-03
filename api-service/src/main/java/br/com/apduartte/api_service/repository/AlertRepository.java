package br.com.apduarte.apiservice.repository;

import br.com.apduarte.apiservice.domain.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlertRepository extends JpaRepository<Alert, UUID> {
}