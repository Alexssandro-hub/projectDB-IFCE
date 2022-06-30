package br.com.frota.util;

import br.com.frota.DAO.MedicaoVistoria;
import br.com.frota.model.MedicaoVistoria;

import java.sql.SQLException;
import java.util.List;

public class TesteMedicaoVistoriaDAO {
    static MedicaoVistoria medicaoVistoriaDAO = new MedicaoVistoria();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(medicaoVistoriaDAO.count());

        //salvar
        MedicaoVistoria medicaoVistoria = new MedicaoVistoria("teste");
        medicaoVistoriaDAO.insertMedicaoVistoria(medicaoVistoria);

        //buscar por ID
        medicaoVistoria = medicaoVistoriaDAO.selectMedicaoVistoria(2);
        System.out.println(medicaoVistoria);

        //Update
        medicaoVistoria.setDescricao("teste2");
        medicaoVistoriaDAO.updateMedicaoVistoria(medicaoVistoria);
        medicaoVistoria = medicaoVistoriaDAO.selectMedicaoVistoria(2);
        System.out.println(medicaoVistoria);

        //Select all
        List<MedicaoVistoria> medicaoVistorias = medicaoVistoriaDAO.selectAllMedicaoVistorias();
        medicaoVistorias.forEach(System.out::println);

        //Delete
        medicaoVistoriaDAO.deleteMedicaoVistoria(2);
        medicaoVistoriaDAO.selectAllMedicaoVistorias().forEach(System.out::println);
    }
}
