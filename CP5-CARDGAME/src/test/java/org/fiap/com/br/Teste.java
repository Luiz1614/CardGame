package org.fiap.com.br;
import org.fiap.com.br.entities.Card;
import org.fiap.com.br.entities.Colecao;
import org.fiap.com.br.repositories.CardRepository;
import org.fiap.com.br.repositories.ColecaoRepository;
import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        CardRepository cardRepository = new CardRepository();
        ColecaoRepository colecaoRepository = new ColecaoRepository();
        var colecao = new Colecao(1, "Carros", new ArrayList<>());
        colecaoRepository.create(colecao);

        var card1 = new Card("A1", "Fusca", 100, 1000, 10.0, 100, 100.0, 1000, 1,false);

        cardRepository.create(card1);

        var card2 = new Card("A2", "Saveiro", 100, 1000, 10.0, 100, 100.0, 1000, 1,false);
        colecao.getCards().add(card2);
        colecaoRepository.update(colecao);
        cardRepository.create(card2);

        var card3 = new Card("A3", "Jetta", 100, 1000, 10.0, 100, 100.0, 1000, 1,false);
        colecao.addCard(card3);
        colecaoRepository.update(colecao);
        cardRepository.create(card3);

        System.out.println(colecaoRepository.read());
        System.out.println(cardRepository.read());

    }
}


