package br.com.estacionamento.sistemaestacionamento.dto;

public class EntradaRequest {

    private Long veiculoId;
    private Long vagaId;

    public Long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }

    public Long getVagaId() {
        return vagaId;
    }

    public void setVagaId(Long vagaId) {
        this.vagaId = vagaId;
    }
}