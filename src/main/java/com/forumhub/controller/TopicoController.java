package com.forumhub.controller;

import com.forumhub.model.Topico;
import com.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    // Criar um novo tópico
    @PostMapping
    public ResponseEntity<Topico> criar(@RequestBody @Valid Topico topico) {
        Topico criado = topicoService.criarTopico(topico);
        URI uri = URI.create("/topics/" + criado.getId());
        return ResponseEntity.created(uri).body(criado);
    }

    // Listar todos os tópicos
    @GetMapping
    public ResponseEntity<Page<Topico>> listarTodos(Pageable pageable) {
        Page<Topico> topicos = topicoService.listarTodos(pageable);
        return ResponseEntity.ok(topicos);
    }

    // Buscar um tópico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalhar(@PathVariable Long id) {
        Topico topico = topicoService.buscarPorId(id);
        return ResponseEntity.ok(topico);
    }

    // Atualizar um tópico
    @PutMapping("/{id}")
    public ResponseEntity<Topico> atualizar(@PathVariable Long id, @RequestBody @Valid Topico novosDados) {
        Topico atualizado = topicoService.atualizarTopico(id, novosDados);
        return ResponseEntity.ok(atualizado);
    }

    // Excluir um tópico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        topicoService.excluirTopico(id);
        return ResponseEntity.noContent().build();
    }
}
