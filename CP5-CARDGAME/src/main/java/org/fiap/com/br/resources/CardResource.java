package org.fiap.com.br.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.com.br.entities.Card;
import org.fiap.com.br.repositories.CardRepository;
import org.fiap.com.br.services.CardService;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Path("card")
public class CardResource {

    private CardRepository cardRepository = new CardRepository();
    private CardService cardService = new CardService(cardRepository);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> Read() {
        return cardRepository.read();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Create(Card card) {
        try{
            cardService.create(card);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{cod_carta}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Update(@PathParam("cod_carta") String cod_carta, Card card) {
        try{
            cardService.update(card);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }


    @DELETE
    @Path("{cod_carta}")
    public Response Delete(@PathParam("cod_carta") String cod_carta) {
        cardRepository.delete(cod_carta);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
