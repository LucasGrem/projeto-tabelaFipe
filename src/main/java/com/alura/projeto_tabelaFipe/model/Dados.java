package com.alura.projeto_tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Dados(@JsonAlias("codigo") String codigoDados,
                    @JsonAlias("nome") String nomeDados) {
}
