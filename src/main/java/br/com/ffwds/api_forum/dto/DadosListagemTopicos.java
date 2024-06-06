package br.com.ffwds.api_forum.dto;

import br.com.ffwds.api_forum.model.Topico;

import java.util.Date;
import java.util.List;

public record DadosListagemTopicos(String titulo,
                                   String mensagem,
                                   Date dataDeCriacao,
                                   Boolean status,
                                   String nomeAutor,
                                   String curso) {




}
