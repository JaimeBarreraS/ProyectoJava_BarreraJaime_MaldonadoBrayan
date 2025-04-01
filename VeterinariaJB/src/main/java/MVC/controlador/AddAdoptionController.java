package MVC.controlador;

import MVC.modelo.Adoption;
import MVC.modelo.dao.AdoptionDAO;
import MVC.vista.vistaAddAdoption;

public class AddAdoptionController {
    private vistaAddAdoption view;
    private AdoptionDAO adoptionDAO;

    public AddAdoptionController(vistaAddAdoption view) {
        this.view = view;
        this.adoptionDAO = new AdoptionDAO();
        this.view.setController(this);
    }
    
    
    public void addPet() {
        try {           
            Adoption adoption = new Adoption( 
                    view.getTxtName().getText(),
                    view.getTxtSpecie().getText(),
                    view.getTxtRace().getText(),
                    Integer.parseInt(view.getTxtAge().getText()),
                    view.getBtnSexo().getSelectedItem().toString(),
                    "adopcion"
            );

            adoptionDAO.addPet(adoption);
            view.showMessage("Mascota agregada correctamente.");
            view.limpiarCampos(); 
        } catch (Exception e) {
            view.showMessage("Error al agregar mascota: " + e.getMessage());
        }
    }
}
