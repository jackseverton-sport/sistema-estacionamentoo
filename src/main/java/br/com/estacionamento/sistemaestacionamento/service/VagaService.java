
package br.com.estacionamento.sistemaestacionamento.service;

import br.com.estacionamento.sistemaestacionamento.model.Vaga;
import br.com.estacionamento.sistemaestacionamento.repository.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    public Vaga cadastrar(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    public List<Vaga> listarTodas() {
        return vagaRepository.findAll();
    }

    public Vaga buscarPorId(Long id) {
        return vagaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
    }

    public void excluir(Long id) {
        vagaRepository.deleteById(id);
    }
}
