package com.example.sistema_gerenciamento_rpg.modelo;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nomeAventureiro;
    @Enumerated(EnumType.STRING)
    private ClassePersonagem classe;
    private int nivel;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemMagico> itensMagicos = new ArrayList<>();
    private int forcaBase; // Força base (sem itens)
    private int defesaBase; // Defesa base (sem itens)

    // Construtor padrão exigido pelo JPA
    public Personagem() {}

    public Personagem(String nome, String nomeAventureiro, ClassePersonagem classe, int nivel, int forca, int defesa) {
        if (forca + defesa > 10 || forca < 0 || defesa < 0) {
            throw new IllegalArgumentException("A soma de força e defesa não pode exceder 10 pontos.");
        }
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.nivel = nivel;
        this.forcaBase = forca;
        this.defesaBase = defesa;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getNomeAventureiro() { return nomeAventureiro; }
    public void setNomeAventureiro(String nomeAventureiro) { this.nomeAventureiro = nomeAventureiro; }
    public ClassePersonagem getClasse() { return classe; }
    public int getNivel() { return nivel; }
    public List<ItemMagico> getItensMagicos() { return itensMagicos; }
    public int getForcaTotal() {
        return forcaBase + itensMagicos.stream().mapToInt(ItemMagico::getForca).sum();
    }
    public int getDefesaTotal() {
        return defesaBase + itensMagicos.stream().mapToInt(ItemMagico::getDefesa).sum();
    }

    public void adicionarItemMagico(ItemMagico item) {
        if (item.getTipo() == TipoItem.AMULETO && itensMagicos.stream().anyMatch(i -> i.getTipo() == TipoItem.AMULETO)) {
            throw new IllegalStateException("Personagem já possui um amuleto.");
        }
        itensMagicos.add(item);
    }

    public void removerItemMagico(ItemMagico item) {
        itensMagicos.remove(item);
    }
}

