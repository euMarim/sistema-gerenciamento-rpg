package com.example.sistema_gerenciamento_rpg.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistema_gerenciamento_rpg.modelo.ItemMagico;
import com.example.sistema_gerenciamento_rpg.servico.ServicoItemMagico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ItensMagicos")
public class ControladorItemMagico {
    @Autowired
    private ServicoItemMagico servico;

    @PostMapping
    public ResponseEntity<ItemMagico> criar(@RequestBody ItemMagico item) {
        return ResponseEntity.ok(servico.criarItemMagico(item));
    }

    @GetMapping
    public ResponseEntity<List<ItemMagico>> listar() {
        return ResponseEntity.ok(servico.listarItensMagicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemMagico> buscarPorId(@PathVariable Long id) {
        return servico.buscarItemMagicoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
