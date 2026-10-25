package com.alura.projeto_tabelaFipe.principal;

import com.alura.projeto_tabelaFipe.model.Dados;
import com.alura.projeto_tabelaFipe.service.ConsumoApi;
import com.alura.projeto_tabelaFipe.service.ConverterDados;

import java.util.List;
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
                "Caminhões\n" +
                "===Digite===");
        var opcao = leitura.nextLine().toLowerCase();
        var json = consumoApi.obterDados(ENDERECO + opcao + "/marcas");

        //lista as marcas
        List<Dados> marcas = conversor.obterLista(json, Dados.class);

        marcas.stream()
                .forEach(System.out::println);
    }
}
