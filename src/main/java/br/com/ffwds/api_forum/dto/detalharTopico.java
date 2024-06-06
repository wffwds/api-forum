package br.com.ffwds.api_forum.dto;

import jakarta.validation.constraints.NotNull;

public record detalharTopico(
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        String nomeAutor,
        String curso) {
}
