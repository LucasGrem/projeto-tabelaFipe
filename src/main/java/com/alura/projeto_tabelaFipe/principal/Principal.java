package com.alura.projeto_tabelaFipe.principal;

import com.alura.projeto_tabelaFipe.service.ConsumoApi;

public class Principal {
    //Instâncias
    private ConsumoApi consumoApi = new ConsumoApi();

    //Endereço da API
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1";
}
