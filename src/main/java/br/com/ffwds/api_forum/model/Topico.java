package br.com.ffwds.api_forum.model;


import br.com.ffwds.api_forum.dto.DadosAtulizarTopico;
import br.com.ffwds.api_forum.dto.DadosCriarTopico;
import br.com.ffwds.api_forum.dto.DadosListagemTopicos;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of =" id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    @Column(name = "data_de_criacao")
    private Date dataDeCriacao;

    private Boolean status;

    @Column(name = "nome_autor")
    private String nomeAutor;
    private String curso;

    public Topico(DadosCriarTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataDeCriacao = new Date();
        this.status = true;
        this.nomeAutor = dados.nomeAutor();
        this.curso = dados.curso();
    }

    public Topico(DadosListagemTopicos dados){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataDeCriacao = dados.dataDeCriacao();
        this.status = dados.status();
        this.nomeAutor = dados.nomeAutor();
        this.curso = dados.curso();
    }

    public void atualizarInformacoes(DadosAtulizarTopico dados) {
        if(dados.titulo() != null)
            this.titulo = dados.titulo();
        if(dados.mensagem() != null)
            this.mensagem = dados.mensagem();
        if(dados.status() != null)
            this.status = dados.status();
    }
}
