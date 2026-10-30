# 🚗 Tabela FIPE - Consulta de Veículos

**Aplicação CLI em Java e Spring Boot para consulta de preços de veículos na Tabela FIPE**  
*Criado durante a formação Java da Alura*

---

## 📋 Sobre o Projeto

O **projeto-tabelaFipe** é uma aplicação de linha de comando (CLI) desenvolvida para realizar consultas dinâmicas de preços e avaliações de veículos (carros, motos e caminhões) diretamente da API FIPE. A aplicação permite filtrar por tipo de veículo, marca, modelo e trechos do nome do automóvel, trazendo informações detalhadas sobre os valores aplicados em cada ano de fabricação.

---

## ✨ Funcionalidades

### ✅ **Consumo de API Assíncrono e HTTP**
- Comunicação web dinâmica via `HttpClient` e `HttpRequest` nativos do Java
- Tratamento de exceções e requisições dinâmicas estruturadas por endpoints REST
- Isolação do consumo de rede dentro de uma classe de serviço reusável (`ConsumoApi`)

### ✅ **Desserialização Genérica (JSON)**
- Mapeamento dinâmico de JSON para objetos Java com **Jackson** (`ObjectMapper`)
- Implementação de contrato desacoplado via interface `IConverteDados` e generics (`<T>`)
- Suporte para desserialização de listas (`List<T>`) e objetos com coleções aninhadas

### ✅ **Navegação e Filtros em Terminal**
- Menu interativo com validação contínua de opções do usuário
- Listagem completa e ordenada de marcas e modelos
- Filtro inteligente por nome do veículo utilizando **Java Streams** e `filter`
- Consolidação do histórico de preços por ano de modelo

---

## 🛠️ Tecnologias Utilizadas

### **Linguagem & Framework**
- **Java 17+** — Linguagem principal fortemente tipada e orientada a objetos
- **Spring Boot 4.1.1<** — Bootstrapping e gerenciamento da execução via `CommandLineRunner`

### **Bibliotecas & Ferramentas**
- **Jackson Databind** — Manipulação, conversão e anotações JSON (`@JsonAlias`, `@JsonIgnoreProperties`)
- **Maven** — Gerenciador de dependências e automação de build
- **IntelliJ IDEA** — Ambiente de desenvolvimento integrado (IDE)
- **Git & GitHub** — Versionamento de código e hospedagem de repositório

---

## 📁 Estrutura do Projeto

```text
src/main/java/com/alura/projeto_tabelaFipe
├── model
│   ├── Dados.java          # Record para mapear código e descrição (marcas/anos)
│   ├── Modelos.java        # Record wrapper para a lista de modelos da marca
│   └── Veiculo.java        # Record para mapear os detalhes finais do preço FIPE
├── principal
│   └── Principal.java      # Fluxo do menu interativo e manipulação das Streams
└── service
    ├── ConsumoApi.java     # Responsável pelas requisições HTTP na web
    ├── ConverteDados.java  # Implementação da conversão JSON com ObjectMapper
    └── IConverteDados.java # Interface genérica para conversão de dados
```

## 🎓 Contexto Educacional

Este projeto foi desenvolvido durante a formação Java da Alura, aplicando conceitos práticos como:

- Modelagem leve de dados imutáveis utilizando Record
- Processamento declarativo de coleções com a Stream API e expressões Lambda
- Arquitetura de código limpo com separação de responsabilidades (Service, Model e Principal)
- Manipulação avançada do ecossistema Jackson em respostas heterogêneas de APIs REST

---

## 👨‍💻 Desenvolvido por

**Lucas Grem**  
Estudante de Engenharia de Software