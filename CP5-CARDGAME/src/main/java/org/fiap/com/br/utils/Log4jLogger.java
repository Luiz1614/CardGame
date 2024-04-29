package org.fiap.com.br.utils;

import org.apache.logging.log4j.LogManager;
import org.fiap.com.br.entities.Card;
import org.fiap.com.br.entities.Colecao;

import java.util.Collections;
import java.util.List;

public class Log4jLogger{


    private final org.apache.logging.log4j.Logger cardLogger;
    private final org.apache.logging.log4j.Logger collectionsLogger;
    public Log4jLogger() {
        this.cardLogger = LogManager.getLogger(Card.class);
        this.collectionsLogger = LogManager.getLogger(Collections.class);
    }


    public void logCreate(Card card){
        cardLogger.info("Create: "+card);
    }

    public void logReadAll(List<Card> entity) {
        cardLogger.info("ReadAll: " + entity);
    }

    public void logUpdateByCodCard(Card entity){
        cardLogger.info("Update: "+entity);
    }

    public void logDeleteByCodCard(String cod_carta){
        cardLogger.info("Delete: "+ cod_carta);
    }

    public void logCreateCollections(Colecao colecao){
        collectionsLogger.info("Create: "+colecao);
    }

    public void logReadCollectionsById(int cod_colecao){
        collectionsLogger.info("Read: " + cod_colecao);
    }

    public void logReadAllCollections(List<Colecao> colecoes) {
        collectionsLogger.info("ReadAll: " + colecoes);
    }

    public void logUpdateCollectionsById(Colecao entity){
        collectionsLogger.info("Update: "+entity);
    }

    public void logDeleteCollectionsById(int cod_colecao){
        collectionsLogger.info("Delete: "+cod_colecao);
    }
}
