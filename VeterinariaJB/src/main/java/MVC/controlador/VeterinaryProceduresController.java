package MVC.controlador;

import MVC.modelo.Procedures;
import MVC.modelo.dao.ProceduresDAO;
import MVC.vista.vistaVeterinaryPrecedimientos;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class VeterinaryProceduresController {
    private vistaVeterinaryPrecedimientos view;
    private ProceduresDAO proceduresDAO;

    public VeterinaryProceduresController(vistaVeterinaryPrecedimientos view) {
        this.view = view;
        this.proceduresDAO = new ProceduresDAO();
        loadProceduresToTable();
    }

    private void loadProceduresToTable() {
        List<Object[]> procedures = proceduresDAO.getProceduresForDisplay();
        DefaultTableModel model = (DefaultTableModel) view.TablaProcedures().getModel();
        model.setRowCount(0);

        for (Object[] p : procedures) {
            Object[] row = {
                    p[0],
                    p[1] != null ? p[1] : "",
                    p[2],
                    p[3]
            };
            model.addRow(row);
        }
    }
}
