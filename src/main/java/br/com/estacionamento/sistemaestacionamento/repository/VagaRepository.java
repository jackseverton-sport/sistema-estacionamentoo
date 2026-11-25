package br.com.estacionamento.sistemaestacionamento.repository;

import br.com.estacionamento.sistemaestacionamento.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
