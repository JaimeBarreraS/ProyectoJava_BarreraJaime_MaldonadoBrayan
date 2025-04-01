package MVC.controlador;

import MVC.modelo.Adoption;
import MVC.modelo.People;
import MVC.modelo.Pet;
import MVC.modelo.dao.AdoptionDAO;
import MVC.modelo.dao.PetDAO;
import MVC.vista.vistaAdoption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class AdoptionController {
    private vistaAdoption view;
    private AdoptionDAO adoptionDAO;
    private PetDAO petDAO;

    public AdoptionController(vistaAdoption view) {
        this.view = view;
        this.adoptionDAO = new AdoptionDAO();
        this.petDAO = new PetDAO();
        this.view.setController(this);
        loadOwners();
        loadPets();
    }
    
    private void loadOwners() {
        List<String> owners = petDAO.getAllOwners(); 
        for (String owner : owners) {
            view.getBtnOwner().addItem(owner); 
        }
    }
        
    private void loadPets(){
        List<String> pets = adoptionDAO.getAllPets();
        for(String pet : pets){
            view.getBtnPet().addItem(pet);
        }
    }
    
    public void loadTable(){
        try {
            List<Adoption> adoption = adoptionDAO.getPets();
            DefaultTableModel model = (DefaultTableModel) view.getjTable1().getModel();
            model.setRowCount(0);

            for (Adoption a : adoption) {
                Object[] row = {
                    a.getName(),
                    a.getSpecie(),
                    a.getRace(),
                    a.getSex(),
                    a.getAge()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            view.showMessage("Error al listar mascotas: " + e.getMessage());
        }    
    }
    
    public void RegisterAdoption(){
        try {
            String ownerName = view.getBtnOwner().getSelectedItem().toString();
            int ownerId = petDAO.getOwnerIdByName(ownerName);
            
            String petName = view.getBtnPet().getSelectedItem().toString();
            
            List<Adoption> adoption = adoptionDAO.getPets();
            int PetId = view.getBtnPet().getSelectedIndex()-1;
            System.out.println(PetId);

            Pet pet = new Pet(
                    adoption.get(PetId).getName(),
                    adoption.get(PetId).getSpecie(),
                    adoption.get(PetId).getRace(),
                    adoption.get(PetId).getAge(),
                    adoption.get(PetId).getSex(),
                    new People(ownerId, ownerName, null, null, null, null, null, null) // Dueño
            );
            petDAO.addAdoption(pet);
            
            int idPet = adoptionDAO.getIdPet(petName);
            adoptionDAO.deletePet(idPet);
            view.showMessage("Mascota agregada correctamente.");
            view.limpiarCampos(); 
        } catch (Exception e) {
            view.showMessage("Error al agregar mascota: " + e.getMessage());
        }
    }
}
