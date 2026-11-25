
package br.com.estacionamento.sistemaestacionamento.service;

import br.com.estacionamento.sistemaestacionamento.repository.VeiculoRepository;
import br.com.estacionamento.sistemaestacionamento.repository.VagaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import br.com.estacionamento.sistemaestacionamento.model.RegistroEstacionamento;
import br.com.estacionamento.sistemaestacionamento.repository.RegistroEstacionamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import br.com.estacionamento.sistemaestacionamento.model.Veiculo;
import br.com.estacionamento.sistemaestacionamento.model.Vaga;

import java.util.List;

@Service
public class RegistroEstacionamentoService {

    private final RegistroEstacionamentoRepository registroRepository;
    private final VeiculoRepository veiculoRepository;
    private final VagaRepository vagaRepository;
    private final CalculoEstacionamentoService calculoService;

    public RegistroEstacionamentoService(
            RegistroEstacionamentoRepository registroRepository,
            VeiculoRepository veiculoRepository,
            VagaRepository vagaRepository,
            CalculoEstacionamentoService calculoService) {

        this.registroRepository = registroRepository;
        this.veiculoRepository = veiculoRepository;
        this.vagaRepository = vagaRepository;
        this.calculoService = calculoService;
    }

    @Transactional
    public RegistroEstacionamento registrarEntrada(Long veiculoId, Long vagaId) {

        Veiculo veiculo = veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        Vaga vaga = vagaRepository.findById(vagaId)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

        if (vaga.isOcupada()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Esta vaga já está ocupada"
            );
        }

        if (registroRepository.existsByVeiculoIdAndDataSaidaIsNull(veiculoId)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Este veículo já está estacionado"
            );
        }

        RegistroEstacionamento registro = new RegistroEstacionamento();

        registro.setVeiculo(veiculo);
        registro.setVaga(vaga);
        registro.setDataEntrada(LocalDateTime.now());

        vaga.setOcupada(true);
        vagaRepository.save(vaga);

        return registroRepository.save(registro);
    }

    public RegistroEstacionamento cadastrar(RegistroEstacionamento registro) {
        return registroRepository.save(registro);
    }

    public List<RegistroEstacionamento> listarTodos() {
        return registroRepository.findAll();
    }

    public RegistroEstacionamento buscarPorId(Long id) {
        return registroRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Registro não encontrado"));
    }
    @Transactional
    public RegistroEstacionamento registrarSaida(Long registroId) {

        RegistroEstacionamento registro = registroRepository
                .findByIdAndDataSaidaIsNull(registroId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Registro ativo não encontrado"
                ));

        LocalDateTime dataSaida = LocalDateTime.now();

        registro.setDataSaida(dataSaida);

        registro.setValor(
                calculoService.calcular(
                        registro.getDataEntrada(),
                        dataSaida
                )
        );

        Vaga vaga = registro.getVaga();
        vaga.setOcupada(false);

        vagaRepository.save(vaga);

        return registroRepository.save(registro);
    }
}
