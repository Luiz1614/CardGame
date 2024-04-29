package org.fiap.com.br.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.com.br.entities.Card;
import org.fiap.com.br.entities.Colecao;
import org.fiap.com.br.repositories.CardRepository;
import org.fiap.com.br.repositories.ColecaoRepository;

import java.util.List;

@Path("colecao")
public class ColecaoResource {

    ColecaoRepository colecaoRepository = new ColecaoRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colecao> read() {
        return colecaoRepository.read();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Colecao colecao) {
        colecaoRepository.create(colecao);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{cod_colecao}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("cod_colecao") int cod_colecao, Colecao colecao) {
        colecao.setCod_colecao(cod_colecao);
        colecaoRepository.update(colecao);
    }

    @DELETE
    @Path("{cod_colecao}")
    public void delete(@PathParam("cod_colecao") int cod_colecao) {
        colecaoRepository.delete(cod_colecao);
    }

    @GET
    @Path("{cod_colecao}/cards")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> readCards(@PathParam("cod_colecao") int cod_colecao) {
        return colecaoRepository.ReadCardsFromCollectioById(cod_colecao);
    }

}
