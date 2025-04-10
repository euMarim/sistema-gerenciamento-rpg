package com.example.sistema_gerenciamento_rpg.controlador;


import com.example.sistema_gerenciamento_rpg.servico.ServicoPersonagem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistema_gerenciamento_rpg.modelo.Personagem;
import com.example.sistema_gerenciamento_rpg.modelo.ItemMagico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class ControladorPersonagem {
    @Autowired
    private ServicoPersonagem servico;

    @PostMapping
    public ResponseEntity<Personagem> criar(@RequestBody Personagem personagem) {
        return ResponseEntity.ok(servico.criarPersonagem(personagem));
    }

    @GetMapping
    public ResponseEntity<List<Personagem>> listar() {
        return ResponseEntity.ok(servico.listarPersonagens());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personagem> buscarPorId(@PathVariable Long id) {
        return servico.buscarPersonagemPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/nome-aventureiro")
    public ResponseEntity<Personagem> atualizarNomeAventureiro(@PathVariable Long id, @RequestBody String nomeAventureiro) {
        return ResponseEntity.ok(servico.atualizarNomeAventureiro(id, nomeAventureiro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        servico.removerPersonagem(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idPersonagem}/itens-magicos/{idItem}")
    public ResponseEntity<Void> adicionarItemMagico(@PathVariable Long idPersonagem, @PathVariable Long idItem) {
        servico.adicionarItemMagicoAoPersonagem(idPersonagem, idItem);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idPersonagem}/itens-magicos/{idItem}")
    public ResponseEntity<Void> removerItemMagico(@PathVariable Long idPersonagem, @PathVariable Long idItem) {
        servico.removerItemMagicoDoPersonagem(idPersonagem, idItem);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idPersonagem}/itens-magicos")
    public ResponseEntity<List<ItemMagico>> listarItensMagicos(@PathVariable Long idPersonagem) {
        return ResponseEntity.ok(servico.listarItensMagicosPorPersonagem(idPersonagem));
    }

    @GetMapping("/{idPersonagem}/amuleto")
    public ResponseEntity<ItemMagico> buscarAmuleto(@PathVariable Long idPersonagem) {
        return servico.buscarAmuletoDoPersonagem(idPersonagem)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
