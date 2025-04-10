package com.example.sistema_gerenciamento_rpg.repositorio;

import com.example.sistema_gerenciamento_rpg.modelo.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPersonagem extends JpaRepository<Personagem, Long> {
}
