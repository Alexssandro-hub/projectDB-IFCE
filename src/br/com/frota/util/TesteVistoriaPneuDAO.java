package br.com.frota.util;

import br.com.frota.DAO.VistoriaPneuDAO;
import br.com.frota.model.VistoriaPneu;

import java.sql.SQLException;
import java.util.List;

public class TesteVistoriaPneuDAO {
    static VistoriaPneuDAO vistoriaPneuDAO = new VistoriaPneuDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(vistoriaPneuDAO.count());

        //salvar
        VistoriaPneu vistoriaPneu = new VistoriaPneu("teste");
        vistoriaPneuDAO.insertVistoriaPneu(vistoriaPneu);

        //buscar por ID
        vistoriaPneu = vistoriaPneuDAO.selectVistoriaPneu(2);
        System.out.println(vistoriaPneu);

        //Update
        vistoriaPneu.setDescricao("teste2");
        vistoriaPneuDAO.updateVistoriaPneu(vistoriaPneu);
        vistoriaPneu = vistoriaPneuDAO.selectVistoriaPneu(2);
        System.out.println(vistoriaPneu);

        //Select all
        List<VistoriaPneu> VistoriaPneus = vistoriaPneuDAO.selectAllVistoriaPneus();
        VistoriaPneus.forEach(System.out::println);

        //Delete
        vistoriaPneuDAO.deleteVistoriaPneu(2);
        vistoriaPneuDAO.selectAllVistoriaPneus().forEach(System.out::println);
    }
}
