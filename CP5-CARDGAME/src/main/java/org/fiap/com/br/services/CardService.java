package org.fiap.com.br.services;

import org.fiap.com.br.entities.Card;
import org.fiap.com.br.repositories.CardRepository;

public class CardService {
    private CardRepository cardRepository = new CardRepository();

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public boolean create(Card card) {
        var validation = card.validate();
        try{
            if(validation.containsKey(false)){
                throw new IllegalArgumentException(validation.get(false).toString());
            } else if (cardRepository.VerificarApenasUmST(card)) {
                throw new IllegalArgumentException("Já existe uma carta Super Trunfo cadastrada");
            } else {
                cardRepository.create(card);
                return true;
            }
        } catch (Exception e){
            throw e;
        }
    }

    public boolean update (Card card) {
        var validation = card.validate();
        try{
            if(validation.containsKey(false)){
                throw new IllegalArgumentException(validation.get(false).toString());
            }
            else if (cardRepository.VerificarApenasUmST(card)) {
                throw new IllegalArgumentException("Já existe uma carta Super Trunfo cadastrada");
            }
            else {
                cardRepository.update(card.getCod_carta(), card);
                return true;
            }
        } catch (Exception e){
            throw e;
        }
    }
}
