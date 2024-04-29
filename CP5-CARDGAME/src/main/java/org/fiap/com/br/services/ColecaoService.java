package org.fiap.com.br.services;

import org.fiap.com.br.entities.Colecao;
import org.fiap.com.br.repositories.ColecaoRepository;

public class ColecaoService {

    private ColecaoRepository colecaoRepository = new ColecaoRepository();

    public ColecaoService(ColecaoRepository colecaoRepository) {
        this.colecaoRepository = colecaoRepository;
    }

    public boolean create(Colecao colecao) {
        var validation = colecao.validate();
        try{
            if(validation.containsKey(false)){
                throw new IllegalArgumentException(validation.get(false).toString());
            } else {
                colecaoRepository.create(colecao);
                return true;
            }
        } catch (Exception e){
            throw e;
        }
    }

    public boolean update (Colecao colecao) {
        var validation = colecao.validate();
        try{
            if(validation.containsKey(false)){
                throw new IllegalArgumentException(validation.get(false).toString());
            }
            else {
                colecaoRepository.update(colecao);
                return true;
            }
        } catch (Exception e){
            throw e;
        }
    }
}