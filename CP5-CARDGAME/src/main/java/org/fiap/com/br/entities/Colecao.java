package org.fiap.com.br.entities;

import java.util.*;

public class Colecao {
    private int cod_colecao;
    private String nome;
    private List<Card> cards = new ArrayList<>();

    public Colecao() {
    }

    public Colecao(int cod_colecao, String nome, List<Card> cards) {
        this.cod_colecao = cod_colecao;
        this.nome = nome;
        this.cards = cards;
    }

    public int getCod_colecao() {
        return cod_colecao;
    }

    public void setCod_colecao(int cod_colecao) {
        this.cod_colecao = cod_colecao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Colecao addCard(Card card) {
        this.cards.add(card);
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Colecao.class.getSimpleName() + "[", "]")
                .add("cod_colecao='" + cod_colecao + "'")
                .add("nome='" + nome + "'")
                .add("cards=" + cards)
                .toString();
    }

    public Map<Boolean, String> validate() {
        Map<Boolean, String> validation = new HashMap<>();
        if (cod_colecao <= 0) {
            validation.put(false, "O campo Código da Coleção deve ser maior que zero");
        }
        if (nome == null || nome.isEmpty()) {
            validation.put(false, "O campo Nome não pode ser vazio");
        }
        return validation;
    }
}
