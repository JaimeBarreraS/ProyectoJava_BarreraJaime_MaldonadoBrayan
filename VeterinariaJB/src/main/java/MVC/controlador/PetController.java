package MVC.controlador;

import MVC.modelo.Pet;
import MVC.modelo.People;
import MVC.modelo.dao.PetDAO;
import MVC.vista.vistaGestionMascotas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PetController {
    private vistaGestionMascotas view;
    private PetDAO petDAO;

    // Constructor
    public PetController(vistaGestionMascotas view) {
        this.view = view;
        this.petDAO = new PetDAO(); // Inicializa el DAO
        this.view.setController(this); // Pasa el controlador a la vista
        loadOwners(); // Carga los dueños en el combo box
    }

    // Método para cargar los dueños en el combo box
    private void loadOwners() {
        List<String> owners = petDAO.getAllOwners(); // Obtiene los dueños de la base de datos
        for (String owner : owners) {
            view.getBtnOwner().addItem(owner); // Añade cada dueño al combo box
        }
    }

    // Método para agregar una mascota
    public void addPet() {
        try {
            String ownerName = view.getBtnOwner().getSelectedItem().toString();
            int ownerId = petDAO.getOwnerIdByName(ownerName);

            Pet pet = new Pet(
                    0, // El ID se genera automáticamente en la base de datos
                    view.getTxtName().getText(),
                    view.getTxtSpecie().getText(),
                    view.getTxtRace().getText(),
                    Integer.parseInt(view.getTxtAge().getText()),
                    view.getTxtFechanacimiento().getText(),
                    view.getBtnSexo().getSelectedItem().toString(),
                    view.getTxtMicrochip_tattoo().getText(),
                    "ruta_de_la_foto", // Placeholder para la ruta de la foto
                    new People(ownerId, ownerName, null, null, null, null, null, null) // Dueño
            );

            petDAO.addPet(pet);
            view.showMessage("Mascota agregada correctamente.");
            view.limpiarCampos();
            listPets(); // Actualiza la lista de mascotas
        } catch (Exception e) {
            view.showMessage("Error al agregar mascota: " + e.getMessage());
        }
    }

    // Método para actualizar una mascota
    public void updatePet() {
        try {
            String ownerName = view.getBtnOwner().getSelectedItem().toString();
            int ownerId = petDAO.getOwnerIdByName(ownerName);

            Pet pet = new Pet(
                    Integer.parseInt(view.getTxtID().getText()),
                    view.getTxtName().getText(),
                    view.getTxtSpecie().getText(),
                    view.getTxtRace().getText(),
                    Integer.parseInt(view.getTxtAge().getText()),
                    view.getTxtFechanacimiento().getText(),
                    view.getBtnSexo().getSelectedItem().toString(),
                    view.getTxtMicrochip_tattoo().getText(),
                    "ruta_de_la_foto", // Placeholder para la ruta de la foto
                    new People(ownerId, ownerName, null, null, null, null, null, null) // Dueño
            );

            petDAO.updatePet(pet);
            view.showMessage("Mascota actualizada correctamente.");
            view.limpiarCampos();
            listPets(); // Actualiza la lista de mascotas
        } catch (Exception e) {
            view.showMessage("Error al actualizar mascota: " + e.getMessage());
        }
    }

    // Método para eliminar una mascota
    public void deletePet() {
        try {
            int id = Integer.parseInt(view.getTxtID().getText());
            petDAO.deletePet(id);
            view.showMessage("Mascota eliminada correctamente.");
            view.limpiarCampos();
            listPets(); // Actualiza la lista de mascotas
        } catch (Exception e) {
            view.showMessage("Error al eliminar mascota: " + e.getMessage());
        }
    }

    // Método para listar todas las mascotas
    public void listPets() {
        try {
            List<Pet> pets = petDAO.getAllPets();
            DefaultTableModel model = (DefaultTableModel) view.getTablaPet().getModel();
            model.setRowCount(0); // Limpia la tabla antes de añadir nuevos datos

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
                    pet.getCostumer() != null ? pet.getCostumer().getName() : "N/A" // Nombre del dueño
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            view.showMessage("Error al listar mascotas: " + e.getMessage());
        }
    }

    // Método para buscar una mascota por ID
    public void searchPet() {
        try {
            int id = Integer.parseInt(view.getTxtID().getText());
            Pet pet = petDAO.getPetById(id);
            if (pet != null) {
                view.getTxtName().setText(pet.getName());
                view.getTxtSpecie().setText(pet.getSpecie());
                view.getTxtRace().setText(pet.getRace());
                view.getTxtAge().setText(String.valueOf(pet.getAge()));
                view.getTxtFechanacimiento().setText(pet.getDateBirth());
                view.getBtnSexo().setSelectedItem(pet.getSex());
                view.getTxtMicrochip_tattoo().setText(pet.getMicrochipTattoo());
                view.getBtnOwner().setSelectedItem(pet.getCostumer().getName()); // Establece el dueño
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