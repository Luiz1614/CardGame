package org.fiap.com.br.repositories;

import org.fiap.com.br.connection.OracleDbConfiguration;
import org.fiap.com.br.entities.Card;
import org.fiap.com.br.entities.Colecao;
import org.fiap.com.br.utils.Log4jLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColecaoRepository {
    public static final String TB_NAME = "CP_COLECAO";

    OracleDbConfiguration oracleDbConfiguration = new OracleDbConfiguration();
    Log4jLogger logger = new Log4jLogger();

    public void create(Colecao colecao) {
        logger.logCreateCollections(colecao);
        try (var conn = oracleDbConfiguration.getConnection()) {
            var stmt = conn.prepareStatement("INSERT INTO " + TB_NAME + " (NOME) VALUES (?)");
            stmt.setString(1, colecao.getNome());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Colecao> read(){
        List<Colecao> colecoes = new ArrayList<>();
        logger.logReadAllCollections(colecoes);
        try (var conn = oracleDbConfiguration.getConnection()) {
            var stmt = conn.prepareStatement("SELECT * FROM CP_COLECAO  ORDER BY COD_COLECAO");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Colecao colecao = new Colecao();
                colecao.setCod_colecao(rs.getInt("COD_COLECAO"));
                colecao.setNome(rs.getString("NOME"));
                colecoes.add(colecao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.logReadAllCollections(colecoes);
        return colecoes;
    }

    public void update(Colecao colecao) {
        logger.logUpdateCollectionsById(colecao);
        try (var conn = oracleDbConfiguration.getConnection()) {
            var stmt = conn.prepareStatement("UPDATE " + TB_NAME + " SET NOME = ? WHERE COD_COLECAO = ?");
            stmt.setString(1, colecao.getNome());
            stmt.setInt(2, colecao.getCod_colecao());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.logUpdateCollectionsById(colecao);
    }

    public void delete(int cod_colecao) {
        logger.logDeleteCollectionsById(cod_colecao);
        try (var conn = oracleDbConfiguration.getConnection()) {
            var stmt = conn.prepareStatement("DELETE FROM " + TB_NAME + " WHERE COD_COLECAO = ?");
            stmt.setInt(1, cod_colecao);

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Card> ReadCardsFromCollectioById(int cod_colecao) {
        List<Card> cards = new ArrayList<>();
        logger.logReadCollectionsById(cod_colecao);
        try (var conn = oracleDbConfiguration.getConnection()) {
            var stmt = conn.prepareStatement("SELECT * FROM CP_CARD WHERE COD_COLECAO = "+ cod_colecao);
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
        return cards;
    }
}
