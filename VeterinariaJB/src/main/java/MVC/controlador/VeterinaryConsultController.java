package MVC.controlador;

import MVC.modelo.MedicalConsult;
import MVC.modelo.dao.MedicalConsultDAO;
import MVC.vista.vistaVeterinaryConsult;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VeterinaryConsultController {
    private vistaVeterinaryConsult view;
    private MedicalConsultDAO medicalConsultDAO;
    
    public VeterinaryConsultController(vistaVeterinaryConsult view) {
        this.view = view;
        this.medicalConsultDAO = new MedicalConsultDAO();
        this.view.setController(this);
        listConsults();
    }
    
    public void listConsults() {
        try {
            List<MedicalConsult> consults = medicalConsultDAO.getAllMedicalConsults();
            DefaultTableModel model = (DefaultTableModel) view.getTablaPet().getModel();
            model.setRowCount(0);

            for (MedicalConsult consult : consults) {
                Object[] row = {
                    consult.getId(),
                    consult.getPet() != null ? consult.getPet().getName() : "N/A",
                    consult.getDate(),
                    consult.getTime(),
                    consult.getReason(),
                    consult.getDiagnostic(),
                    consult.getRecommendations(),
                    consult.getState(),
                    consult.getVeterinary() != null ? consult.getVeterinary().getName() : "N/A"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            view.showMessage("Error al listar consultas: " + e.getMessage());
        }
    }
}