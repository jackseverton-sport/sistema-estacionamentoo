package br.com.estacionamento.sistemaestacionamento.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class CalculoEstacionamentoService {


    private static final BigDecimal VALOR_PRIMEIRA_HORA =
            new BigDecimal("10.00");

    private static final BigDecimal VALOR_HORA_EXCEDENTE =
            new BigDecimal("2.50");

    public BigDecimal calcular(LocalDateTime entrada,
                               LocalDateTime saida) {

        long minutos = Duration.between(entrada, saida).toMinutes();


        if (minutos <= 60) {
            return VALOR_PRIMEIRA_HORA;
        }

        long horasExcedentes =
                (long) Math.ceil((minutos - 60) / 60.0);

        return VALOR_PRIMEIRA_HORA.add(
                VALOR_HORA_EXCEDENTE.multiply(
                        BigDecimal.valueOf(horasExcedentes)
                )
        );
    }
}
