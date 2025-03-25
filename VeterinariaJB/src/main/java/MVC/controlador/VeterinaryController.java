package MVC.controlador;

import MVC.modelo.Pet;
import MVC.modelo.dao.PetDAO;
import MVC.vista.vistaMascotas;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VeterinaryController {
    private vistaMascotas view;
    private PetDAO petDAO;
    
    public VeterinaryController(vistaMascotas view) {
        this.view = view;
        this.petDAO = new PetDAO(); 
        this.view.setController(this);
        listPets();
    }
    
    public void listPets() {
        try {
            List<Pet> pets = petDAO.getAllPets();
            DefaultTableModel model = (DefaultTableModel) view.getTablaPet().getModel();
            model.setRowCount(0); 

            for (Pet pet : pets) {
                Object[] row = {
                    pet.getId(),
                    pet.getName(),
                    pet.getSpecie(),
                    pet.getRace(),
                    pet.getAge(),
                    pet.getDateBirth(),
                    pet.getSex(),
                    pet.getMicrochipTattoo(),
                    pet.getPhoto(),
                    pet.getCostumer() != null ? pet.getCostumer().getName() : "N/A" 
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            view.showMessage("Error al listar mascotas: " + e.getMessage());
        }
    }
}
