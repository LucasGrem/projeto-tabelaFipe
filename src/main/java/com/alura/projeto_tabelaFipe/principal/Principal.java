package com.alura.projeto_tabelaFipe.principal;

import com.alura.projeto_tabelaFipe.model.Dados;
import com.alura.projeto_tabelaFipe.model.Modelos;
import com.alura.projeto_tabelaFipe.model.Veiculo;
import com.alura.projeto_tabelaFipe.service.ConsumoApi;
import com.alura.projeto_tabelaFipe.service.ConverterDados;

import java.util.*;

public class Principal {
    //Instâncias
    private ConsumoApi consumoApi = new ConsumoApi();
    private Scanner leitura = new Scanner(System.in);
    private ConverterDados conversor = new ConverterDados();

    //Endereço da API
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {
        String opcao = "";

        do {
            System.out.println("*** Opções ***\n" +
                    "Carros\n" +
                    "Motos\n" +
                    "Caminhoes\n" +
                    "\nDigite uma das opções para consultar:");
            opcao = leitura.nextLine().toLowerCase();

            if (opcao.contains("car")) {
                opcao = "carros";
            } else if (opcao.contains("mot")) {
                opcao = "motos";
            } else if (opcao.contains("cam")) {
                opcao = "caminhoes";
            } else {
                System.out.println("Opção inválida! Digite carros, motos ou caminhoes.\n");
            }
        } while (!opcao.equals("carros") && !opcao.equals("motos") && !opcao.equals("caminhoes"));
        var url = ENDERECO + opcao + "/marcas";
        var json = consumoApi.obterDados(url);

        // Lista as opções das marcas e seus códigos
        List<Dados> marcas = conversor.obterLista(json, Dados.class);

        marcas.stream()
                .forEach(System.out::println);

        // Lista os modelos e seus códigos
        System.out.println("Informe o código da marca:");
        var codMarca = leitura.nextLine();
        url = url + "/" + codMarca + "/modelos";
        json = consumoApi.obterDados(url);

        Modelos listaModelos = conversor.obterDados(json, Modelos.class);

        listaModelos.modelos().stream()
                .forEach(System.out::println);

        // Filta o nome do veículo
        System.out.println("Digite o nome do veículo para consultar:");
        var trechoVeiculo = leitura.nextLine();

        listaModelos.modelos().stream()
                .filter(m -> m.nomeDados().toLowerCase().contains(trechoVeiculo.toLowerCase()))
                .forEach(System.out::println);

        //Mostra a Fipe
        System.out.println("Digite o código do modelo para consultar:");
        var codModelo = leitura.nextLine();

        url = url + "/" + codModelo + "/anos";
        json = consumoApi.obterDados(url);
        List<Dados> anos = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = url + "/" + anos.get(i).codigoDados();
            json = consumoApi.obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("Todos os veículos filtrados:");
        veiculos.forEach(System.out::println);
    }
}