package com.example.sistema_gerenciamento_rpg.servico;

import com.example.sistema_gerenciamento_rpg.modelo.Personagem;
import com.example.sistema_gerenciamento_rpg.modelo.ItemMagico;
import com.example.sistema_gerenciamento_rpg.repositorio.RepositorioPersonagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoPersonagem {

    @Autowired
    private RepositorioPersonagem repositorio;
    @Autowired
    private ServicoItemMagico servicoItemMagico;

    public Personagem criarPersonagem(Personagem personagem) {
        return repositorio.save(personagem);
    }

    public List<Personagem> listarPersonagens() {
        return repositorio.findAll();
    }

    public Optional<Personagem> buscarPersonagemPorId(Long id) {
        return repositorio.findById(id);
    }

    public Personagem atualizarNomeAventureiro(Long id, String nomeAventureiro) {
        Personagem personagem = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado."));
        personagem.setNomeAventureiro(nomeAventureiro);
        return repositorio.save(personagem);
    }

    public void removerPersonagem(Long id) {
        repositorio.deleteById(id);
    }

    public void adicionarItemMagicoAoPersonagem(Long idPersonagem, Long idItem) {
        Personagem personagem = buscarPersonagemPorId(idPersonagem)
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado."));
        ItemMagico item = servicoItemMagico.buscarItemMagicoPorId(idItem)
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado."));
        personagem.adicionarItemMagico(item);
        repositorio.save(personagem);
    }

    public void removerItemMagicoDoPersonagem(Long idPersonagem, Long idItem) {
        Personagem personagem = buscarPersonagemPorId(idPersonagem)
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado."));
        ItemMagico item = servicoItemMagico.buscarItemMagicoPorId(idItem)
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado."));
        personagem.removerItemMagico(item);
        repositorio.save(personagem);
    }

    public List<ItemMagico> listarItensMagicosPorPersonagem(Long idPersonagem) {
        Personagem personagem = buscarPersonagemPorId(idPersonagem)
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado."));
        return personagem.getItensMagicos();
    }

    public Optional<ItemMagico> buscarAmuletoDoPersonagem(Long idPersonagem) {
        Personagem personagem = buscarPersonagemPorId(idPersonagem)
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado."));
        return personagem.getItensMagicos().stream()
                .filter(item -> item.getTipo() == com.example.sistema_gerenciamento_rpg.modelo.TipoItem.AMULETO)
                .findFirst();
    }
}
