package br.com.ffwds.api_forum.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UniqueElements;

import java.sql.Timestamp;

public record DadosCriarTopico(

        @NotBlank
        String titulo,


        @NotBlank
        String mensagem,

        Timestamp dataDeCriacao,

        int status,


        @NotBlank
        String nomeAutor,


         @NotBlank
         String curso           ) {
}
