package com.example.sistema_gerenciamento_rpg.modelo;

import jakarta.persistence.*;

@Entity
public class ItemMagico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoItem tipo;
    private int forca;
    private int defesa;

    // Construtor padrão exigido pelo JPA
    public ItemMagico() {}

    public ItemMagico(String nome, TipoItem tipo, int forca, int defesa) {
        validarItem(nome, tipo, forca, defesa);
        this.nome = nome;
        this.tipo = tipo;
        this.forca = forca;
        this.defesa = defesa;
    }

    private void validarItem(String nome, TipoItem tipo, int forca, int defesa) {
        if (forca < 0 || defesa < 0 || forca > 10 || defesa > 10) {
            throw new IllegalArgumentException("Força e defesa devem estar entre 0 e 10.");
        }
        if (forca == 0 && defesa == 0) {
            throw new IllegalArgumentException("Item não pode ter força e defesa zeradas.");
        }
        if (tipo == TipoItem.ARMA && defesa != 0) {
            throw new IllegalArgumentException("Armas não podem ter defesa.");
        }
        if (tipo == TipoItem.ARMADURA && forca != 0) {
            throw new IllegalArgumentException("Armaduras não podem ter força.");
        }
    }

    // Getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public TipoItem getTipo() { return tipo; }
    public int getForca() { return forca; }
    public int getDefesa() { return defesa; }
}

