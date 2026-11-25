package br.com.estacionamento.sistemaestacionamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

    @Entity
    public class Veiculo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank(message = "A placa é obrigatória")
        @Size(min = 7, max = 8, message = "A placa deve ter entre 7 e 8 caracteres")
        private String placa;

        @NotBlank(message = "O modelo é obrigatório")
        private String modelo;

        @NotBlank(message = "A cor é obrigatória")
        private String cor;

        public Veiculo() {
        }

        public Veiculo(String placa, String modelo, String cor) {
            this.placa = placa;
            this.modelo = modelo;
            this.cor = cor;
        }

        public Long getId() {
            return id;
        }

        public String getPlaca() {
            return placa;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public String getCor() {
            return cor;
        }

        public void setCor(String cor) {
            this.cor = cor;
        }
    }