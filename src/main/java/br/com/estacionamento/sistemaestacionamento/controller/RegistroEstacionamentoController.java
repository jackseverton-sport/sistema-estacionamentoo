
package br.com.estacionamento.sistemaestacionamento.controller;

import br.com.estacionamento.sistemaestacionamento.model.RegistroEstacionamento;
import br.com.estacionamento.sistemaestacionamento.service.RegistroEstacionamentoService;
import org.springframework.web.bind.annotation.*;
import br.com.estacionamento.sistemaestacionamento.dto.EntradaRequest;

import java.util.List;



@RestController
@RequestMapping("/registros")
public class RegistroEstacionamentoController {

    private final RegistroEstacionamentoService registroService;

    public RegistroEstacionamentoController(
            RegistroEstacionamentoService registroService) {
        this.registroService = registroService;
    }

    @PostMapping
    public RegistroEstacionamento cadastrar(
            @RequestBody RegistroEstacionamento registro) {
        return registroService.cadastrar(registro);
    }

    @GetMapping
    public List<RegistroEstacionamento> listarTodos() {
        return registroService.listarTodos();
    }

    @GetMapping("/{id}")
    public RegistroEstacionamento buscarPorId(@PathVariable Long id) {
        return registroService.buscarPorId(id);
    }

    @PutMapping("/{id}/saida")
    public RegistroEstacionamento registrarSaida(@PathVariable Long id) {
        return registroService.registrarSaida(id);
    }

    @PostMapping("/entrada")
    public RegistroEstacionamento registrarEntrada(
            @RequestBody EntradaRequest request) {

        return registroService.registrarEntrada(
                request.getVeiculoId(),
                request.getVagaId()
        );
    }
}
