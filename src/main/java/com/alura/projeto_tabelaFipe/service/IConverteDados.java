package com.alura.projeto_tabelaFipe.service;

import java.util.List;

public interface IConverteDados {
    // Conversor quando o json for um objeto {...}
    <T> T obterDados(String json, Class<T> classe);

    // Conversor quando o json for uma lista [...]
    <T> List<T> obterLista(String json, Class<T> classe);
}
