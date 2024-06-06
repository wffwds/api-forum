package br.com.ffwds.api_forum.controller;

import br.com.ffwds.api_forum.dto.DadosAtulizarTopico;
import br.com.ffwds.api_forum.dto.DadosCriarTopico;
import br.com.ffwds.api_forum.dto.DadosListagemTopicos;
import br.com.ffwds.api_forum.model.Topico;
import br.com.ffwds.api_forum.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")

public class TopicoController {
    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity criarTopico(@RequestBody @Valid DadosCriarTopico dados) {
        repository.save(new Topico(dados));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<Topico>> listarTopicos(@PageableDefault(size = 10, sort = {"curso"})Pageable paginacao){
        var page = repository.findAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Topico>> detalharTopico(@PathVariable Long id){
        var topico = repository.findById(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtulizarTopico dados){
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
        return ResponseEntity.ok(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

}
