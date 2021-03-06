package br.com.frota.DAO;

import br.com.frota.model.PneuBanda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PneuBandaDAO extends ConexaoDB {

    private static final String INSERT_PNEU_BANDA_SQL = "INSERT INTO pneu_banda (observacao, ordem, id_pneu, id_banda) VALUES (?, ?, ?, ?);";
    private static final String SELECT_PNEU_BANDA_BY_ID = "SELECT id, observacao, ordem, id_pneu, id_banda FROM pneu_banda WHERE id = ?";
    private static final String SELECT_ALL_PNEU_BANDA = "SELECT * FROM pneu_banda;";
    private static final String DELETE_PNEU_BANDA_SQL = "DELETE FROM pneu_banda WHERE id = ?;";
    private static final String UPDATE_PNEU_BANDA_SQL = "UPDATE pneu_banda SET observacao = ?, ordem = ?, id_pneu = ?, id_banda = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM pneu_banda;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prapararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void insertPneuBanda(PneuBanda entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_PNEU_BANDA_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setInt(2, entidade.getOrdem());
            preparedStatement.setInt(3, entidade.getId_pneu());
            preparedStatement.setInt(4, entidade.getId_banda());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public PneuBanda selectPneuBanda(int id) {
        PneuBanda entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_PNEU_BANDA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Integer ordem = rs.getInt("ordem");
                Integer id_pneu = rs.getInt("id_pneu");
                Integer id_banda = rs.getInt("id_banda");

                entidade = new PneuBanda(id, observacao, id_pneu, id_banda);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<PneuBanda> selectAllPneuBanda() {
        List<PneuBanda> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_PNEU_BANDA)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                Integer ordem = rs.getInt("ordem");
                Integer id_pneu = rs.getInt("id_pneu");
                Integer id_banda = rs.getInt("id_banda");

                entidades.add(new PneuBanda(id, observacao, id_pneu, id_banda));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deletePneuBanda(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_PNEU_BANDA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePneuBanda(PneuBanda entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_MEDICAO_VISTORIA_SQL)) {
            statement.setString(1, entidade.getObservacao());
            statement.setInt(2, entidade.getOrdem());
            statement.setInt(3, entidade.getId_pneu());
            statement.setInt(4, entidade.getId_banda());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
