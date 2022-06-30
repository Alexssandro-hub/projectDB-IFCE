package br.com.frota.util;

import br.com.frota.DAO.PneuBandaDAO;
import br.com.frota.model.PneuBanda;

import java.sql.SQLException;
import java.util.List;

public class TestePneuBandaDAO {
    static PneuBandaDAO pneuBandaDAO = new PneuBandaDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(pneuBandaDAO.count());

        //salvar
        PneuBanda pneuBanda = new PneuBanda("teste");
        pneuBandaDAO.insertPneuBanda(pneuBanda);

        //buscar por ID
        pneuBanda = pneuBandaDAO.selectPneuBanda(2);
        System.out.println(pneuBanda);

        //Update
        pneuBanda.setDescricao("teste2");
        pneuBandaDAO.updatePneuBanda(pneuBanda);
        pneuBanda = pneuBandaDAO.selectPneuBanda(2);
        System.out.println(pneuBanda);

        //Select all
        List<PneuBanda> PneuBandas = pneuBandaDAO.selectAllPneuBandas();
        PneuBandas.forEach(System.out::println);

        //Delete
        pneuBandaDAO.deletePneuBanda(2);
        pneuBandaDAO.selectAllPneuBandas().forEach(System.out::println);
    }
}
