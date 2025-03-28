package MVC.controlador;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;

public class PdfGenerator {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser(); // Se crea un selector de archivos
        fileChooser.setDialogTitle("Guardar Factura"); // Este va a ser el título del cuadro de diálogo
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //Lo limita a solo seleccionar archivos

        fileChooser.setSelectedFile(new File("factura.pdf"));// Se le sugiere un nombre al archivo que va a guardar
        
        
        int userSelection = fileChooser.showSaveDialog(null);
        
        //Si el usuario presiona "guardar" procede a crear el archivo PDF
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();//Obtiene la ubicación y el nombre que escogió el usuario

            // Asegura que el archivo termine en ".pdf" para evitar inconvenientes
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                filePath += ".pdf"; // Y si no tiene la terminación ".pdf" se la agrega
            }

            //Finalmente crea el archivo PDF
            generateInvoice(filePath);
        }
    }

    public static void generateInvoice(String filePath) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Fuente personalizada
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font subTitleFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font textFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

            // ** ENCABEZADO **
            Paragraph title = new Paragraph("Veterinaria JB", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("Dirección: Calle 123, Tibú - Norte de Santander, Colombia", textFont));
            document.add(new Paragraph("Teléfono: +123 456 789", textFont));
            document.add(new Paragraph("Correo: contacto@campuslands.com", textFont));

            document.add(new Paragraph("\nFactura N°: 001", subTitleFont));
          
            document.add(new Paragraph("\n----------------------------------------", textFont));

            // ** DATOS DEL CLIENTE **
            document.add(new Paragraph("\nCliente: Juan Pérez", subTitleFont));
            document.add(new Paragraph("Teléfono: +987 654 321", textFont));
            document.add(new Paragraph("Dirección: Av. Mascotas 456, Ciudad", textFont));

            document.add(new Paragraph("\n----------------------------------------", textFont));

            // ** TABLA DE PRODUCTOS/SERVICIOS **
            PdfPTable table = new PdfPTable(4); // 4 columnas
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            float[] columnWidths = {3f, 1f, 1.5f, 1.5f}; // Ajusta el ancho de las columnas
            table.setWidths(columnWidths);

            // Encabezados de la tabla
            table.addCell(new PdfPCell(new Phrase("Descripción", subTitleFont)));
            table.addCell(new PdfPCell(new Phrase("Cantidad", subTitleFont)));
            table.addCell(new PdfPCell(new Phrase("Precio Unitario", subTitleFont)));
            table.addCell(new PdfPCell(new Phrase("Subtotal", subTitleFont)));

            // Productos/Servicios de ejemplo
            addTableRow(table, "Consulta General", "1", "20.00", "20.00");
            addTableRow(table, "Vacuna Rabia", "1", "15.00", "15.00");
            addTableRow(table, "Alimento Balanceado 5kg", "2", "25.00", "50.00");

            document.add(table);

            // ** TOTALES **
            document.add(new Paragraph("Subtotal: $85.00", subTitleFont));
            document.add(new Paragraph("IVA (10%): $8.50", subTitleFont));
            document.add(new Paragraph("TOTAL: $93.50", titleFont));

            document.add(new Paragraph("\n----------------------------------------", textFont));

            // ** MENSAJE FINAL **
            Paragraph message = new Paragraph("Gracias por su compra. Su mascota es nuestra prioridad.", textFont);
            message.setAlignment(Element.ALIGN_CENTER);
            document.add(message);

            document.close();
            JOptionPane.showMessageDialog(null, "Factura guardada en: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear la factura: " + e.getMessage());
        }
    }

    // Método para agregar filas a la tabla
    private static void addTableRow(PdfPTable table, String desc, String qty, String price, String subtotal) {
        table.addCell(new PdfPCell(new Phrase(desc)));
        table.addCell(new PdfPCell(new Phrase(qty)));
        table.addCell(new PdfPCell(new Phrase(price)));
        table.addCell(new PdfPCell(new Phrase(subtotal)));
    }
}