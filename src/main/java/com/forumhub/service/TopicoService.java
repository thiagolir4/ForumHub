package com.forumhub.service;

import com.forumhub.model.Topico;
import com.forumhub.repository.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    // Criar um novo tópico
    @Transactional
    public Topico criarTopico(@Valid Topico topico) {
        // Verificar se já existe um tópico com o mesmo título e mensagem
        Optional<Topico> existente = topicoRepository.findAll().stream()
                .filter(t -> t.getTitulo().equals(topico.getTitulo()) && t.getMensagem().equals(topico.getMensagem()))
                .findFirst();

        if (existente.isPresent()) {
            throw new IllegalArgumentException("Tópico já existe com o mesmo título e mensagem.");
        }

        return topicoRepository.save(topico);
    }

    // Listar todos os tópicos com paginação
    public Page<Topico> listarTodos(Pageable pageable) {
        return topicoRepository.findAll(pageable);
    }

    // Buscar um tópico por ID
    public Topico buscarPorId(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado com o ID: " + id));
    }

    // Atualizar um tópico
    @Transactional
    public Topico atualizarTopico(Long id, @Valid Topico novosDados) {
        Topico topico = buscarPorId(id);
        topico.setTitulo(novosDados.getTitulo());
        topico.setMensagem(novosDados.getMensagem());
        topico.setEstado(novosDados.getEstado());
        return topicoRepository.save(topico);
    }

    // Excluir um tópico
    @Transactional
    public void excluirTopico(Long id) {
        Topico topico = buscarPorId(id);
        topicoRepository.delete(topico);
    }
}
