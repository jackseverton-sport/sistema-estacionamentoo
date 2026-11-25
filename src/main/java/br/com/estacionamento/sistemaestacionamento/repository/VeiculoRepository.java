package br.com.estacionamento.sistemaestacionamento.repository;

import br.com.estacionamento.sistemaestacionamento.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    boolean existsByPlaca(String placa);

}