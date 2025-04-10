package com.example.sistema_gerenciamento_rpg.repositorio;

import com.example.sistema_gerenciamento_rpg.modelo.ItemMagico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioItemMagico extends JpaRepository<ItemMagico, Long> {
}
