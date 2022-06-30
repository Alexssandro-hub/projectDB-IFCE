package br.com.frota.util;

import br.com.frota.DAO.MedicaoBandaVistoriaDAO;
import br.com.frota.model.MedicaoBandaVistoria;

import java.sql.SQLException;
import java.util.List;

public class TesteMedicaoBandaVistoriaDAO {
    static MedicaoBandaVistoriaDAO medicaoBandaVistoriaDAO = new MedicaoBandaVistoriaDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(medicaoBandaVistoriaDAO.count());

        //salvar
        MedicaoBandaVistoria medicaoBandaVistoria = new MedicaoBandaVistoria("teste");
        medicaoBandaVistoriaDAO.insertMedicaoBandaVistoria(medicaoBandaVistoria);

        //buscar por ID
        medicaoBandaVistoria = medicaoBandaVistoriaDAO.selectMedicaoBandaVistoria(2);
        System.out.println(medicaoBandaVistoria);

        //Update
        medicaoBandaVistoria.setDescricao("teste2");
        medicaoBandaVistoriaDAO.updateMedicaoBandaVistoria(medicaoBandaVistoria);
        medicaoBandaVistoria = medicaoBandaVistoriaDAO.selectMedicaoBandaVistoria(2);
        System.out.println(medicaoBandaVistoria);

        //Select all
        List<MedicaoBandaVistoria> medicaoBandaVistorias = medicaoBandaVistoriaDAO.selectAllMedicaoBandaVistorias();
        medicaoBandaVistorias.forEach(System.out::println);

        //Delete
        medicaoBandaVistoriaDAO.deleteMedicaoBandaVistoria(2);
        medicaoBandaVistoriaDAO.selectAllMedicaoBandaVistorias().forEach(System.out::println);
    }
}
