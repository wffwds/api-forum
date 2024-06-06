package br.com.ffwds.api_forum.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtulizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        Boolean status) {

}
