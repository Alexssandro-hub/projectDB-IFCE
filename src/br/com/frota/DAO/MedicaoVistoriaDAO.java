package br.com.frota.DAO;

import br.com.frota.model.MedicaoVistoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicaoVistoriaDAO extends ConexaoDB {

    private static final String INSERT_MEDICAO_VISTORIA_SQL = "INSERT INTO medicao_vistoria (raio, perfil, largura, indice_carga, indice_velocidade, id_marca_pneu, id_vistoria) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_MEDICAO_VISTORIA_BY_ID = "SELECT id, raio, perfil, largura, indice_carga, indice_velocidade, id_marca_pneu, id_vistoria FROM medicao_vistoria WHERE id = ?";
    private static final String SELECT_ALL_MEDICAO_VISTORIA = "SELECT * FROM medicao_vistoria;";
    private static final String DELETE_MEDICAO_VISTORIA_SQL = "DELETE FROM medicao_vistoria WHERE id = ?;";
    private static final String UPDATE_MEDICAO_VISTORIA_SQL = "UPDATE medicao_vistoria SET raio = ?, perfil = ?, largura = ?, indice_carga = ?, indice_velocidade = ?, id_marca_pneu = ?, id_vistoria = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM medicao_vistoria;";

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

    public void insertMedicaoVistoria(MedicaoVistoria entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_MEDICAO_VISTORIA_SQL)) {
            preparedStatement.setInt(1, entidade.getRaio());
            preparedStatement.setString(2, entidade.getPerfil());
            preparedStatement.setString(3, entidade.getLargura());
            preparedStatement.setString(4, entidade.getIndice_carga());
            preparedStatement.setString(5, entidade.getIndice_velocidade());
            preparedStatement.setInt(6, entidade.getId_marca_pneu());
            preparedStatement.setInt(7, entidade.getId_vistoria());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public MedicaoVistoria selectMedicaoVistoria(int id) {
        MedicaoVistoria entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_MEDICAO_VISTORIA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer raio = rs.getInt("raio");
                String perfil = rs.getString("perfil");
                String largura = rs.getString("largura");
                String indice_carga = rs.getString("indice_carga");
                String indice_velocidade = rs.getString("indice_velocidade");
                Integer id_marca_pneu = rs.getInt("id_marca_pneu");
                Integer id_vistoria = rs.getInt("id_vistoria");

                entidade = new MedicaoVistoria(id, raio, perfil, largura, indice_carga, indice_velocidade, id_marca_pneu, id_vistoria);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<MedicaoVistoria> selectAllMedicaoVistoria() {
        List<MedicaoVistoria> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_MEDICAO_VISTORIA)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Integer raio = rs.getInt("raio");
                String perfil = rs.getString("perfil");
                String largura = rs.getString("largura");
                String indice_carga = rs.getString("indice_carga");
                String indice_velocidade = rs.getString("indice_velocidade");
                Integer id_marca_pneu = rs.getInt("id_marca_pneu");
                Integer id_vistoria = rs.getInt("id_vistoria");
                entidades.add(new MedicaoVistoria(id, raio, perfil, largura, indice_carga, indice_velocidade, id_marca_pneu, id_vistoria));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteMedicaoVistoria(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_MEDICAO_VISTORIA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateMedicaoVistoria(MedicaoVistoria entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_MEDICAO_VISTORIA_SQL)) {
            statement.setInt(1, entidade.getRaio());
            statement.setString(2, entidade.getPerfil());
            statement.setString(3, entidade.getLargura());
            statement.setString(4, entidade.getIndice_carga());
            statement.setString(5, entidade.getIndice_velocidade());
            statement.setInt(6, entidade.getId_marca_pneu());
            statement.setInt(7, entidade.getId_vistoria());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
