package org.fiap.com.br.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Card {
    private String cod_carta;
    private String nome;
    private int velocidade;
    private int cilindradas;
    private double zeroCem;
    private int potencia;
    private double comprimento;
    private int peso;
    private int cod_colecao;
    private boolean isSuperTrunfo;

    public Card() {
    }

    public Card(String cod_carta, String nome, int velocidade, int cilindradas, double zeroCem, int potencia, double comprimento, int peso, int cod_colecao, boolean isSuperTrunfo) {
        this.cod_carta = cod_carta;
        this.nome = nome;
        this.velocidade = velocidade;
        this.cilindradas = cilindradas;
        this.zeroCem = zeroCem;
        this.potencia = potencia;
        this.comprimento = comprimento;
        this.peso = peso;
        this.cod_colecao = cod_colecao;
        this.isSuperTrunfo = isSuperTrunfo;
    }

    public String getCod_carta() {
        return cod_carta;
    }

    public void setCod_carta(String cod_carta) {
        this.cod_carta = cod_carta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public double getZeroCem() {
        return zeroCem;
    }

    public void setZeroCem(double zeroCem) {
        this.zeroCem = zeroCem;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCod_colecao() {
        return cod_colecao;
    }

    public void setCod_colecao(int cod_colecao) {
        this.cod_colecao = cod_colecao;
    }

    public boolean isSuperTrunfo() {
        return isSuperTrunfo;
    }

    public void setSuperTrunfo(boolean superTrunfo) {
        isSuperTrunfo = superTrunfo;
    }





    @Override
    public String toString() {
        return new StringJoiner(", ", "\r\n" + Card.class.getSimpleName() + "[", "]")
                .add("Codigo: " + cod_carta)
                .add("Nome: " + nome)
                .add("Velocidade: " + velocidade)
                .add("Cilindradas: " + cilindradas)
                .add("Zero a Cem: " + zeroCem)
                .add("Potencia: " + potencia)
                .add("Comprimento: " + comprimento)
                .add("Peso: " + peso)
                .add("Colecao: " + cod_colecao)
                .add("Super Trunfo: " + isSuperTrunfo)
                .toString();
    }

    public Map<Boolean, String> validate(){
        Map<Boolean, String> validation = new HashMap<>();
        if (nome == null || nome.isEmpty()) {
            validation.put(false, "O campo Nome não pode ser vazio");
        }
        if (velocidade <= 0) {
            validation.put(false, "O campo Velocidade deve ser maior que zero");
        }
        if (cilindradas <= 0) {
            validation.put(false, "O campo Cilindradas deve ser maior que zero");
        }
        if (zeroCem <= 0) {
            validation.put(false, "O campo Zero a Cem deve ser maior que zero");
        }
        if (potencia <= 0) {
            validation.put(false, "O campo Potencia deve ser maior que zero");
        }
        if (comprimento <= 0) {
            validation.put(false, "O campo Comprimento deve ser maior que zero");
        }
        if (peso <= 0) {
            validation.put(false, "O campo Peso deve ser maior que zero");
        }
        return validation;
    }
}
