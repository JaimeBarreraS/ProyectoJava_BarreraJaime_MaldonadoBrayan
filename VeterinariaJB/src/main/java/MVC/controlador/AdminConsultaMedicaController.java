package MVC.controlador;

import MVC.modelo.MedicalConsult;
import MVC.modelo.People;
import MVC.modelo.Pet;
import MVC.modelo.dao.MedicalConsultDAO;
import MVC.modelo.dao.PetDAO;
import MVC.vista.vistaGestionConsultaMedica;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class AdminConsultaMedicaController {
    private vistaGestionConsultaMedica  view;
    private MedicalConsultDAO medicalConsultDAO;
    private PetDAO petDAO;
    
    public AdminConsultaMedicaController(vistaGestionConsultaMedica  view) {
        this.view = view;
        this.medicalConsultDAO = new MedicalConsultDAO();
        this.petDAO = new PetDAO();
        this.view.setController(this);
        loadPets();
        loadVeterinary();
    }
    
    private void loadPets() {
        List<Pet> pets = petDAO.getAllPets();
        for (Pet pet : pets) {
            view.btnPet().addItem(pet.getName());
        }
    }
    private void loadVeterinary() {
        List<String> veterinarys = petDAO.getAllVeterinarys();
        for (String veterinary : veterinarys) {
            view.btnVeterinario().addItem(veterinary);
        }
    }


    public void addMedicalConsult(){
        try {
            String veterinaryName = view.btnVeterinario().getSelectedItem().toString();
            int veterinaryId = petDAO.getVeterinaryIdByName(veterinaryName);
            String petName = view.btnPet().getSelectedItem().toString();
            Pet pet = petDAO.getPetByName(petName);

            MedicalConsult medicalConsult = new MedicalConsult(
                    0,
                    pet,
                    view.txtFecha().getText(),
                    view.txtHora().getText(),
                    view.txtRazon().getText(),
                    view.txtDiagnostico().getText(),
                    view.txtRecomendaciones().getText(),
                    view.btnEstado().getSelectedItem().toString(),
                    new People(veterinaryId, veterinaryName, null,null,null,null,null,null )
            );

            medicalConsultDAO.addMedicalConsult(medicalConsult);
            view.showMessage("Consulta medica agregada correctamente");
            view.clearFields();
            listConsults();
        } catch (Exception e) {
            view.showMessage("Error agregar consulta medica: " + e.getMessage());
        }
    }

    public void updateMedicalConsult(){
        try {
            String veterinaryName = view.btnVeterinario().getSelectedItem().toString();
            int veterinaryId = petDAO.getVeterinaryIdByName(veterinaryName);
            String petName = view.btnPet().getSelectedItem().toString();
            Pet pet = petDAO.getPetByName(petName);

            MedicalConsult medicalConsult = new MedicalConsult(
                    Integer.parseInt(view.txtID.getText()),
                    pet,
                    view.txtFecha().getText(),
                    view.txtHora().getText(),
                    view.txtRazon().getText(),
                    view.txtDiagnostico().getText(),
                    view.txtRecomendaciones().getText(),
                    view.btnEstado().getSelectedItem().toString(),
                    new People(veterinaryId, veterinaryName, null,null,null,null,null,null )
            );

            medicalConsultDAO.updateMedicalConsult(medicalConsult);
            view.showMessage("Consulta medica actualizada correctamente");
            view.clearFields();
            listConsults();
        } catch (Exception e) {
            view.showMessage("Error en actualizar consulta medica: " + e.getMessage());
        }
    }

    public void deleteMedicalConsult(){
        try {
            int id = Integer.parseInt(view.txtID.getText());
            medicalConsultDAO.deleteMedicalConsult(id);
            view.showMessage("Consulta medica eliminada correctamente");
            view.clearFields();
            listConsults();
        } catch (Exception e) {
            view.showMessage("Error al eliminar consulta medica: " + e.getMessage());
        }
    }


    public void SearchMedicalConsult() {
        try {
            int id = Integer.parseInt(view.txtID().getText());
            MedicalConsult consult = medicalConsultDAO.getMedicalConsultById(id);
            if (consult != null) {
                view.txtID().setText(String.valueOf(consult.getId()));
                view.txtFecha().setText(consult.getDate());
                view.txtHora().setText(consult.getTime());
                view.txtRazon().setText(consult.getReason());
                view.txtDiagnostico().setText(consult.getDiagnostic());
                view.txtRecomendaciones().setText(consult.getRecommendations());
                view.btnEstado() .setSelectedItem(consult.getState());
                view.btnPet() .setSelectedItem(consult.getPet().getName());
                view.btnVeterinario() .setSelectedItem(consult.getVeterinary().getName());
            } else {
                view.showMessage("No se encontró la Consulta medica con ID: " + id);
                view.clearFields();
            }
        }catch (Exception e) {
            view.showMessage("Error al buscar Consulta medica: " + e.getMessage());
        }
    }

    public void listConsults() {
        List<MedicalConsult> consults = medicalConsultDAO.getAllMedicalConsults();
        DefaultTableModel model = (DefaultTableModel) view.TablaConsultVeterinary().getModel();
        model.setRowCount(0);

        for (MedicalConsult consult : consults) {
            model.addRow(new Object[]{
                    consult.getId(),
                    consult.getPet().getName(),
                    consult.getDate(),
                    consult.getTime(),
                    consult.getReason(),
                    consult.getDiagnostic(),
                    consult.getRecommendations(),
                    consult.getState(),
                    consult.getVeterinary().getName(),

            });
        }
    }
}
