package br.com.estacionamento.sistemaestacionamento.repository;

import br.com.estacionamento.sistemaestacionamento.model.RegistroEstacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RegistroEstacionamentoRepository

        extends JpaRepository<RegistroEstacionamento, Long> {
    boolean existsByVeiculoIdAndDataSaidaIsNull(Long veiculoId);
    Optional<RegistroEstacionamento> findByIdAndDataSaidaIsNull(Long id);
}
