package org.fiap.com.br.repositories;

import org.fiap.com.br.connection.OracleDbConfiguration;
import org.fiap.com.br.entities.Card;
import org.fiap.com.br.utils.Log4jLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CardRepository {
    public static final String TB_NAME = "CP_CARD";
    OracleDbConfiguration oracleDbConfiguration = new OracleDbConfiguration();
    Log4jLogger logger = new Log4jLogger();

    public void create(Card card){
        try(var conn = oracleDbConfiguration.getConnection()){
            logger.logCreate(card);
            var stmt = conn.prepareStatement("INSERT INTO " + TB_NAME + " (COD_CARTA, NOME, VELOCIDADE, CILINDRADAS, ZEROCEM, POTENCIA, COMPRIMENTO, PESO, IS_SUPERTRUNFO, COD_COLECAO) VALUES (?,?,?,?,?,?,?,?,?,?)");
            {
                stmt.setString(1, card.getCod_carta());
                stmt.setString(2, card.getNome());
                stmt.setInt(3, card.getVelocidade());
                stmt.setInt(4, card.getCilindradas());
                stmt.setDouble(5, card.getZeroCem());
                stmt.setInt(6, card.getPotencia());
                stmt.setDouble(7, card.getComprimento());
                stmt.setInt(8, card.getPeso());
                stmt.setString(9, card.isSuperTrunfo() ? "1" : "0");
                stmt.setInt(10, card.getCod_colecao());

                stmt.executeUpdate();
                conn.close();
                stmt.close();
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        logger.logCreate(card);
    }

    public List<Card> read() {
        List<Card> cards = new ArrayList<>();
        logger.logReadAll(cards);
        try (var conn = oracleDbConfiguration.getConnection()) {
            var stmt = conn.prepareStatement("SELECT * FROM " + TB_NAME + " ORDER BY COD_CARTA");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Card card = new Card();
                card.setCod_carta(rs.getString("COD_CARTA"));
                card.setNome(rs.getString("NOME"));
                card.setVelocidade(rs.getInt("VELOCIDADE"));
                card.setCilindradas(rs.getInt("CILINDRADAS"));
                card.setZeroCem(rs.getDouble("ZEROCEM"));
                card.setPotencia(rs.getInt("POTENCIA"));
                card.setComprimento(rs.getDouble("COMPRIMENTO"));
                card.setPeso(rs.getInt("PESO"));
                card.setSuperTrunfo(rs.getString("IS_SUPERTRUNFO").equals("1"));
                card.setCod_colecao(rs.getInt("COD_COLECAO"));
                cards.add(card);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.logReadAll(cards);
        return cards;
    }

    public void update(String cod_carta, Card card) {
        logger.logUpdateByCodCard(card);
        try (var conn = oracleDbConfiguration.getConnection()) {
            var stmt = conn.prepareStatement("UPDATE " + TB_NAME + " SET NOME = ?, VELOCIDADE = ?, CILINDRADAS = ?, ZEROCEM = ?, POTENCIA = ?, COMPRIMENTO = ?, PESO = ?, IS_SUPERTRUNFO = ?, COD_COLECAO = ? WHERE COD_CARTA = ?");

            stmt.setString(1, card.getNome());
            stmt.setInt(2, card.getVelocidade());
            stmt.setInt(3, card.getCilindradas());
            stmt.setDouble(4, card.getZeroCem());
            stmt.setInt(5, card.getPotencia());
            stmt.setDouble(6, card.getComprimento());
            stmt.setInt(7, card.getPeso());
            stmt.setString(8, card.isSuperTrunfo() ? "1" : "0");
            stmt.setInt(9, card.getCod_colecao());
            stmt.setString(10, cod_carta);

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.logUpdateByCodCard(card);
    }


    public void delete(String cod_carta) {
        logger.logDeleteByCodCard(cod_carta);
        try (var conn = oracleDbConfiguration.getConnection()) {
            var stmt = conn.prepareStatement("DELETE FROM " + TB_NAME + " WHERE COD_CARTA = ?");
            stmt.setString(1, cod_carta);

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.logDeleteByCodCard(cod_carta);
    }

    public boolean VerificarApenasUmST(Card card) {
        try (var conn = oracleDbConfiguration.getConnection()) {
            var stmt = conn.prepareStatement("SELECT COUNT(*) FROM " + TB_NAME + " WHERE IS_SUPERTRUNFO = 1 AND COD_COLECAO = " + card.getCod_colecao());
            var rs = stmt.executeQuery();
            if(rs.next() && card.isSuperTrunfo() == true){
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
