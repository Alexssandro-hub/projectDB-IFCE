package br.com.frota.util;

import br.com.frota.DAO.TipoEixoDAO;
import br.com.frota.model.TipoEixo;

import java.sql.SQLException;
import java.util.List;

public class TesteTipoEixoDAO {
    static TipoEixoDAO tipoEixoDAO = new TipoEixoDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(tipoEixoDAO.count());

        //salvar
        TipoEixo tipoEixoDAO = new TipoEixo("teste");
        tipoEixoDAO.insertTipoEixo(tipoEixoDAO);

        //buscar por ID
        tipoEixoDAO = tipoEixoDAO.selectTipoEixo(2);
        System.out.println(tipoEixoDAO);

        //Update
        tipoEixoDAO.setDescricao("teste2");
        tipoEixoDAO.updateTipoEixo(tipoEixoDAO);
        tipoEixoDAO = tipoEixoDAO.selectTipoEixo(2);
        System.out.println(tipoEixoDAO);

        //Select all
        List<TipoEixo> tipoEixos = tipoEixoDAO.selectAllTipoEixos();
        tipoEixos.forEach(System.out::println);

        //Delete
        tipoEixoDAO.deleteTipoEixo(2);
        tipoEixoDAO.selectAllTipoEixos().forEach(System.out::println);
    }
}
