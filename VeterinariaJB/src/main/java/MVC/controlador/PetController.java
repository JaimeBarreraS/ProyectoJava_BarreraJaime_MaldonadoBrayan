package MVC.controlador;

import MVC.modelo.Pet;
import MVC.modelo.People;
import MVC.modelo.dao.PetDAO;
import MVC.vista.vistaGestionMascotas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PetController {
    private vistaGestionMascotas view;
    private PetDAO petDAO;

    public PetController(vistaGestionMascotas view) {
        this.view = view;
        this.petDAO = new PetDAO(); 
        this.view.setController(this); 
        loadOwners(); 
    }

    private void loadOwners() {
        List<String> owners = petDAO.getAllOwners(); 
        for (String owner : owners) {
            view.getBtnOwner().addItem(owner); 
        }
    }

    public void addPet() {
        try {
            String ownerName = view.getBtnOwner().getSelectedItem().toString();
            int ownerId = petDAO.getOwnerIdByName(ownerName);

            Date fechaNacimiento = view.getTxtFechanacimiento().getDate();
            if (fechaNacimiento == null) {
                view.showMessage("Debe seleccionar una fecha de nacimiento válida");
                return;
            }

            Pet pet = new Pet(
                    0, 
                    view.getTxtName().getText(),
                    view.getTxtSpecie().getText(),
                    view.getTxtRace().getText(),
                    Integer.parseInt(view.getTxtAge().getText()),
                    fechaNacimiento,
                    view.getBtnSexo().getSelectedItem().toString(),
                    view.getTxtMicrochip_tattoo().getText(),
                    "ruta_de_la_foto", 
                    new People(ownerId, ownerName, null, null, null, null, null, null) // Dueño
            );

            petDAO.addPet(pet);
            view.showMessage("Mascota agregada correctamente.");
            view.limpiarCampos();
            listPets(); 
        } catch (Exception e) {
            view.showMessage("Error al agregar mascota: " + e.getMessage());
        }
    }

    public void updatePet() {
        try {
            String ownerName = view.getBtnOwner().getSelectedItem().toString();
            int ownerId = petDAO.getOwnerIdByName(ownerName);

            Date fechaNacimiento = view.getTxtFechanacimiento().getDate();
            if (fechaNacimiento == null) {
                view.showMessage("Debe seleccionar una fecha de nacimiento válida");
                return;
            }

            Pet pet = new Pet(
                    Integer.parseInt(view.getTxtID().getText()),
                    view.getTxtName().getText(),
                    view.getTxtSpecie().getText(),
                    view.getTxtRace().getText(),
                    Integer.parseInt(view.getTxtAge().getText()),
                    fechaNacimiento,
                    view.getBtnSexo().getSelectedItem().toString(),
                    view.getTxtMicrochip_tattoo().getText(),
                    "ruta_de_la_foto", 
                    new People(ownerId, ownerName, null, null, null, null, null, null) // Dueño
            );

            petDAO.updatePet(pet);
            view.showMessage("Mascota actualizada correctamente.");
            view.limpiarCampos();
            listPets(); 
        } catch (Exception e) {
            view.showMessage("Error al actualizar mascota: " + e.getMessage());
        }
    }

    public void deletePet() {
        try {
            int id = Integer.parseInt(view.getTxtID().getText());
            petDAO.deletePet(id);
            view.showMessage("Mascota eliminada correctamente.");
            view.limpiarCampos();
            listPets(); 
        } catch (Exception e) {
            view.showMessage("Error al eliminar mascota: " + e.getMessage());
        }
    }

    public void listPets() {
        try {
            List<Pet> pets = petDAO.getAllPets();
            DefaultTableModel model = (DefaultTableModel) view.getTablaPet().getModel();
            model.setRowCount(0);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            for (Pet pet : pets) {
                Object[] row = {
                    pet.getId(),
                    pet.getName(),
                    pet.getSpecie(),
                    pet.getRace(),
                    pet.getAge(), pet.getDateBirth() != null ? sdf.format(pet.getDateBirth()) : "N/A",
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

    public void searchPet() {
        try {
            int id = Integer.parseInt(view.getTxtID().getText());
            Pet pet = petDAO.getPetById(id);
            if (pet != null) {
                view.getTxtName().setText(pet.getName());
                view.getTxtSpecie().setText(pet.getSpecie());
                view.getTxtRace().setText(pet.getRace());
                view.getTxtAge().setText(String.valueOf(pet.getAge()));
                view.getTxtFechanacimiento().setDate(pet.getDateBirth());
                view.getBtnSexo().setSelectedItem(pet.getSex());
                view.getTxtMicrochip_tattoo().setText(pet.getMicrochipTattoo());
                view.getBtnOwner().setSelectedItem(pet.getCostumer().getName()); 
            }
            else {
                view.showMessage("No se encontró la mascota con ID: " + id);
                view.limpiarCampos();
            }
        } catch (Exception e) {
            view.showMessage("Error al buscar mascota: " + e.getMessage());
        }
    }
}