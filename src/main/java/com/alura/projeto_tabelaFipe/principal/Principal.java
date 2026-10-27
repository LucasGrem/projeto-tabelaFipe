package com.alura.projeto_tabelaFipe.principal;

import com.alura.projeto_tabelaFipe.model.Dados;
import com.alura.projeto_tabelaFipe.model.Modelos;
import com.alura.projeto_tabelaFipe.service.ConsumoApi;
import com.alura.projeto_tabelaFipe.service.ConverterDados;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    //Instâncias
    private ConsumoApi consumoApi = new ConsumoApi();
    private Scanner leitura = new Scanner(System.in);
    private ConverterDados conversor = new ConverterDados();

    //Endereço da API
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {
        System.out.println("*** Opções ***\n" +
                "Carros\n" +
                "Motos\n" +
                "Caminhoes\n" +
                "\nDigite uma das opções para consultar:");
        var opcao = leitura.nextLine().toLowerCase();
        var json = consumoApi.obterDados(ENDERECO + opcao + "/marcas");

        // Lista as opções das marcas e seus códigos
        List<Dados> marcas = conversor.obterLista(json, Dados.class);

        marcas.stream()
                .forEach(System.out::println);

        // Lista os modelos e seus códigos
        System.out.println("Informe o código da marca:");
        var codMarca = leitura.nextLine();
        var json2 = consumoApi.obterDados(ENDERECO + opcao + "/marcas/" + codMarca + "/modelos");

        Modelos listaModelos = conversor.obterDados(json2, Modelos.class);

        listaModelos.modelos().stream()
                .forEach(System.out::println);

        // Filta o nome do veículo
        System.out.println("Digite o nome do veículo para consultar:");
        var trechoVeiculo = leitura.nextLine();

        listaModelos.modelos().stream()
                .filter(m -> m.nomeDados().toLowerCase().contains(trechoVeiculo.toLowerCase()))
                .forEach(System.out::println);
    }
}
