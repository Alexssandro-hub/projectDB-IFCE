package br.com.frota.util;

import br.com.frota.DAO.PneuReservaDAO;
import br.com.frota.model.PneuReserva;

import java.sql.SQLException;
import java.util.List;

public class TestePneuReservaDAO {
    static PneuReservaDAO pneuReservaDAO = new PneuReservaDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(pneuReservaDAO.count());

        //salvar
        PneuReserva pneuReserva = new PneuReserva("teste");
        pneuReservaDAO.insertPneuReserva(pneuReserva);

        //buscar por ID
        pneuReserva = pneuReservaDAO.selectPneuReserva(2);
        System.out.println(pneuReserva);

        //Update
        pneuReserva.setDescricao("teste2");
        pneuReservaDAO.updatePneuReserva(pneuReserva);
        pneuReserva = pneuReservaDAO.selectPneuReserva(2);
        System.out.println(pneuReserva);

        //Select all
        List<PneuReserva> PneuReservas = pneuReservaDAO.selectAllPneuReservas();
        PneuReservas.forEach(System.out::println);

        //Delete
        pneuReservaDAO.deletePneuReserva(2);
        pneuReservaDAO.selectAllPneuReservas().forEach(System.out::println);
    }
}
