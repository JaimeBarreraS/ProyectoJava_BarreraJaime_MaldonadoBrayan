package MVC.controlador;

import MVC.modelo.TypeProcedures;
import MVC.modelo.dao.TypeProceduresDAO;
import MVC.vista.vistaTypeProcedures;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CostumerTypeProcedimientosController {
    private vistaTypeProcedures view;
    private TypeProceduresDAO proceduresDAO;

    public CostumerTypeProcedimientosController(vistaTypeProcedures view) {
        this.view = view;
        proceduresDAO = new TypeProceduresDAO();
        this.view.setController(this);
        listTypeProcedures();
    }

    public void listTypeProcedures() {
        try {
            List<TypeProcedures> proceduress = proceduresDAO.getAllTypeProcedures();
            DefaultTableModel model = (DefaultTableModel) view.getTableType().getModel();
            model.setRowCount(0);

            for (TypeProcedures procedure : proceduress) {
                Object[] row = {
                    procedure.getId(),
                    procedure.getName(),
                    procedure.getPrice()
                };
                model.addRow(row);
            }
        }catch (Exception e){
            view.showMessage("Error al listar Tipo de Procedimientos: " + e.getMessage());
        }

    }

    
}
