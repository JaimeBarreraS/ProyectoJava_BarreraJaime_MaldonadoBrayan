package MVC.controlador;

import MVC.modelo.MedicalHistory;
import MVC.modelo.Pet;
import MVC.modelo.dao.MedicalHistoryDAO;
import MVC.modelo.dao.PetDAO;
import MVC.vista.vistaAdminMedicalHistory;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MedicalHistoryAdminController {
    private vistaAdminMedicalHistory view;
    private MedicalHistoryDAO medicalhistoryDAO;
    private PetDAO petDAO;

    public MedicalHistoryAdminController(vistaAdminMedicalHistory view) {
        this.view = view;
        this.medicalhistoryDAO = new MedicalHistoryDAO();
        this.petDAO = new PetDAO();
        this.view.setController(this);
        loadPets();
    }
    
    private void loadPets() {
        List<Pet> pets = petDAO.getAllPets();
        for (Pet pet : pets) {
            view.jComboBox1().addItem(pet.getName());
        }
    }
    
    public void addMedicalHistory() {
        try {
            String petName = view.jComboBox1.getSelectedItem().toString(); 
            Pet pet = petDAO.getPetByName(petName);
            
            MedicalHistory medicalhistory = new MedicalHistory(
                0, 
                pet,
                view.txtAlergias.getText(),
                view.txtPreCondiciones.getText(),
                view.txtIPeso.getText()
            );

            medicalhistoryDAO.addMedicalHistory(medicalhistory);
            view.showMessage("Historia Medica agregada correctamente");
            view.clearFields();
            listMedicalHistory();
        } catch (Exception e) {
            view.showMessage("Error al Historia Medica: " + e.getMessage());
        }
    }
    
    public void updateMedicalHistory() {
        try {
            String petName = view.jComboBox1.getSelectedItem().toString(); 
            Pet pet = petDAO.getPetByName(petName);
            
            MedicalHistory medicalhistory = new MedicalHistory(
                0, 
                pet,
                view.txtAlergias.getText(),
                view.txtPreCondiciones.getText(),
                view.txtIPeso.getText()
            );

            medicalhistoryDAO.updateMedicalHistory(medicalhistory);
            view.showMessage("Historia Medica actualizada correctamente");
            view.clearFields();
            listMedicalHistory();
        } catch (Exception e) {
            view.showMessage("Error al actualizar Historia Medica: " + e.getMessage());
        }
    }
    
    public void deleteMedicalHistory() {
        try {
            
            int id = Integer.parseInt(view.txtID.getText());
            medicalhistoryDAO.deleteMedicalHistory(id);
            view.showMessage("Historia Medica eliminada correctamente");
            view.clearFields();
            listMedicalHistory();
        } catch (Exception e) {
            view.showMessage("Error al eliminar vacuna: " + e.getMessage());
        }
    }
    
    public void listMedicalHistory() {
        try {
            List<MedicalHistory> medicalhistorys = medicalhistoryDAO.getAllMedicalHistories();
            DefaultTableModel model = (DefaultTableModel) view.TableCustomer.getModel();
            model.setRowCount(0);

            for (MedicalHistory medicalhistory : medicalhistorys) {
                model.addRow(new Object[]{
                    medicalhistory.getId(),
                    medicalhistory.getPet().getName(), 
                    medicalhistory.getAllergies(),
                    medicalhistory.getPreConditions(),
                    medicalhistory.getWeight()
                });
            }
        } catch (Exception e) {
            view.showMessage("Error al listar Historia Medica: " + e.getMessage());
        }
    }
    
    public void searchMedicalHistory() {
        try {
            int id = Integer.parseInt(view.txtID.getText());
            MedicalHistory medicalhistory = medicalhistoryDAO.getMedicalHistoryById(id);
            
            if (medicalhistory != null) {
                view.jComboBox1.setSelectedItem(medicalhistory.getPet().getName());
                view.txtAlergias.setText(medicalhistory.getAllergies());
                view.txtPreCondiciones.setText(medicalhistory.getPreConditions());
                view.txtIPeso.setText(medicalhistory.getWeight());
            } else {
                view.showMessage("No se encontró la historia Medica con ID: " + id);
                view.clearFields();
            }
        } catch (Exception e) {
            view.showMessage("Error al buscar Historia Medica: " + e.getMessage());
        }
    }
    
}
