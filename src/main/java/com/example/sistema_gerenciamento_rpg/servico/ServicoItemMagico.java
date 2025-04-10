package com.example.sistema_gerenciamento_rpg.servico;


import com.example.sistema_gerenciamento_rpg.modelo.ItemMagico;
import com.example.sistema_gerenciamento_rpg.repositorio.RepositorioItemMagico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoItemMagico {
    @Autowired
    private RepositorioItemMagico repositorio;

    public ItemMagico criarItemMagico(ItemMagico item) {
        return repositorio.save(item);
    }

    public List<ItemMagico> listarItensMagicos() {
        return repositorio.findAll();
    }

    public Optional<ItemMagico> buscarItemMagicoPorId(Long id) {
        return repositorio.findById(id);
    }
}
