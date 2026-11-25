
package br.com.estacionamento.sistemaestacionamento.controller;

import br.com.estacionamento.sistemaestacionamento.model.Vaga;
import br.com.estacionamento.sistemaestacionamento.service.VagaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @PostMapping
    public Vaga cadastrar(@RequestBody Vaga vaga) {
        return vagaService.cadastrar(vaga);
    }

    @GetMapping
    public List<Vaga> listarTodas() {
        return vagaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Vaga buscarPorId(@PathVariable Long id) {
        return vagaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        vagaService.excluir(id);
    }
}
