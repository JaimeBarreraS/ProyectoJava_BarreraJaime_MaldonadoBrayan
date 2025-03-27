package MVC.controlador;


import MVC.modelo.Vaccine;
import MVC.modelo.Pet;
import MVC.modelo.dao.VaccineDAO;
import MVC.modelo.dao.PetDAO;
import MVC.vista.vistaVacunneAdmin;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VacunneAdminController {
    private vistaVacunneAdmin view;
    private VaccineDAO vaccineDAO;
    private PetDAO petDAO;

    public VacunneAdminController(vistaVacunneAdmin view) {
        this.view = view;
        this.vaccineDAO = new VaccineDAO();
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

    public void addVaccine() {
        try {
            String petName = view.jComboBox1.getSelectedItem().toString(); 
            Pet pet = petDAO.getPetByName(petName);
            
            Vaccine vaccine = new Vaccine(
                0, 
                pet,
                view.txtNombreVacuna.getText(),
                view.txtILote.getText(),
                view.txtFabricante.getText(),
                Date.valueOf(view.txtFechaAplicacion.getText()),
                view.txtIProximaDosis.getText().isEmpty() ? null : Date.valueOf(view.txtIProximaDosis.getText())
            );

            vaccineDAO.addVaccine(vaccine);
            view.showMessage("Vacuna agregada correctamente");
            view.clearFields();
            listVaccines();
        } catch (Exception e) {
            view.showMessage("Error al agregar vacuna: " + e.getMessage());
        }
    }

    public void updateVaccine() {
        try {
            String petName = view.jComboBox1.getSelectedItem().toString(); 
            Pet pet = petDAO.getPetByName(petName);
            
         
            Vaccine vaccine = new Vaccine(
                Integer.parseInt(view.txtID.getText()),
                pet,
                view.txtNombreVacuna.getText(),
                view.txtILote.getText(),
                view.txtFabricante.getText(),
                Date.valueOf(view.txtFechaAplicacion.getText()),
                view.txtIProximaDosis.getText().isEmpty() ? null : Date.valueOf(view.txtIProximaDosis.getText())
            );

            
            vaccineDAO.updateVaccine(vaccine);
            view.showMessage("Vacuna actualizada correctamente");
            view.clearFields();
            listVaccines();
        } catch (Exception e) {
            view.showMessage("Error al actualizar vacuna: " + e.getMessage());
        }
    }

    public void deleteVaccine() {
        try {
            
            int id = Integer.parseInt(view.txtID.getText());
            vaccineDAO.deleteVaccine(id);
            view.showMessage("Vacuna eliminada correctamente");
            view.clearFields();
            listVaccines();
        } catch (Exception e) {
            view.showMessage("Error al eliminar vacuna: " + e.getMessage());
        }
    }

    public void listVaccines() {
        try {
            List<Vaccine> vaccines = vaccineDAO.getAllVaccines();
            DefaultTableModel model = (DefaultTableModel) view.TableVacunner.getModel();
            model.setRowCount(0);

            for (Vaccine vaccine : vaccines) {
                model.addRow(new Object[]{
                    vaccine.getId(),
                    vaccine.getPet().getName(), 
                    vaccine.getName(),
                    vaccine.getLot(),
                    vaccine.getManufacturer(),
                    vaccine.getDateApplication(),
                    vaccine.getNextDose() != null ? vaccine.getNextDose() : "N/A"
                });
            }
        } catch (Exception e) {
            view.showMessage("Error al listar vacunas: " + e.getMessage());
        }
    }

    public void searchVaccine() {
        try {
            int id = Integer.parseInt(view.txtID.getText());
            Vaccine vaccine = vaccineDAO.getVaccineById(id);
            
            if (vaccine != null) {
                view.jComboBox1.setSelectedItem(vaccine.getPet().getName());
                view.txtNombreVacuna.setText(vaccine.getName());
                view.txtILote.setText(vaccine.getLot());
                view.txtFabricante.setText(vaccine.getManufacturer());
                view.txtFechaAplicacion.setText(vaccine.getDateApplication().toString());
                view.txtIProximaDosis.setText(
                    vaccine.getNextDose() != null ? vaccine.getNextDose().toString() : ""
                );
            } else {
                view.showMessage("No se encontró la vacuna con ID: " + id);
                view.clearFields();
            }
        } catch (Exception e) {
            view.showMessage("Error al buscar vacuna: " + e.getMessage());
        }
    }    
}
