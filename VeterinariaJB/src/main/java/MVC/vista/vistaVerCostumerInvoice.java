/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MVC.vista;

import MVC.controlador.CostumerInvoiceController;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jaime Barrera
 */
public class vistaVerCostumerInvoice extends javax.swing.JFrame {

    /**
     * Creates new form vistaVerCostumerInvoice
     */
    public vistaVerCostumerInvoice() {
        initComponents();
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
    }

    public void setTxtID(String id) {
        txtID.setText(id);
    }

    public void setTxtCliente(String cliente) {
        txtCliente.setText(cliente);
    }

    public void setTxtFecha(String fecha) {
        txtFecha.setText(fecha);
    }

    public void setTxtTotal(String total) {
        txtTotal.setText(total);
    }

    public void setTxtIva(String iva) {
        txtIva.setText(iva);
    }

    public void setTxtTotal2(String total) {
        txtTotal2.setText(total);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        LogoIcono = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtTotal2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("VETERINARY CLINIC");

        LogoIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("ID Factura ...................................................   ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nombre Cliente  ......................................... ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("IVA  .............................................................");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Descripcion ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Total  ..........................................................");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Total a Pagar    $ ");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel14.setText("NIT  1093925253");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel15.setText("Tibú Norte de Santander");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel16.setText("B/ Esperanza");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel17.setText("VeterinaryClinic@gmail.com");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel18.setText("+57312 370 2377");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/qr_1.png"))); // NOI18N

        jLabel21.setText(" Documento PDF que muestra de manera detalla lo realiazado");

        jLabel22.setText(" en la clínica veterinaria JS. La atencion brindada se realiza con ");

        jLabel23.setText(" profesionalismo y cuido espacial a las mascotas.");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText(" Firma ");

        btnVolver.setBackground(new java.awt.Color(2, 100, 100));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setBorderPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(255, 255, 102));
        btnImprimir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        txtID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtID.setForeground(new java.awt.Color(0, 0, 255));
        txtID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtID.setBorder(null);

        txtCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCliente.setForeground(new java.awt.Color(0, 0, 255));
        txtCliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCliente.setBorder(null);
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 0, 255));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setBorder(null);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        txtIva.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtIva.setForeground(new java.awt.Color(0, 0, 255));
        txtIva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIva.setBorder(null);

        txtFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(0, 0, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFecha.setBorder(null);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Fecha  ..........................................................");

        txtTotal2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTotal2.setForeground(new java.awt.Color(255, 51, 51));
        txtTotal2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal2.setBorder(null);
        txtTotal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotal2ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/firma.png"))); // NOI18N
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jLabel20))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVolver)
                                .addGap(18, 18, 18)
                                .addComponent(btnImprimir)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIva))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(352, 352, 352))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(79, 79, 79)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtTotal))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel25)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(LogoIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(79, 79, 79)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2))
                                            .addGap(2, 2, 2)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtID)
                                                .addComponent(txtCliente))))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel27))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogoIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(38, 38, 38)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnImprimir)
                                    .addComponent(btnVolver)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1)))
                        .addGap(33, 33, 33))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        vistaCostumerInvoice vli = new vistaCostumerInvoice ();
        CostumerInvoiceController controller = new CostumerInvoiceController (vli);
        vli.setController(controller);
        vli.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed
    
    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtTotal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotal2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal2ActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // 1. Configuración de rutas 
            String pdfSavePath = buildPdfSavePath();
            ensureDirectoryExists(pdfSavePath);

            // 2. Generar nombre de archivo único 
            String filePath = generateUniqueFilePath(pdfSavePath);

            // 3. Generar documento 
            generatePdfDocument(filePath,
                    txtID.getText(),
                    txtCliente.getText(),
                    txtFecha.getText(),
                    txtIva.getText(),
                    txtTotal.getText());

            // 4. Mostrar confirmación y abrir PDF 
            showSuccessAndOpenPdf(filePath);

        } catch (Exception ex) {
            handleError("Error al generar factura", ex);
        }
    }

    private String buildPdfSavePath() {
        return System.getProperty("user.dir") + File.separator + "ProyectoJava_BarreraJaime_MaldonadoBrayan" + File.separator + "VeterinariaJB" + File.separator +
                "src" + File.separator + "main" + File.separator + "java" + File.separator +
                "MVC" + File.separator + "util" +  File.separator  + "facturasGeneradas" +  File.separator;
    }

    private void ensureDirectoryExists(String path) throws IOException {
        File directory = new File(path);
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException("No se pudo crear el directorio: " + path);
        }
    }

    private String generateUniqueFilePath(String savePath) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return savePath + "Factura_" + dateFormat.format(new Date()) + ".pdf";
    }

    private void generatePdfDocument(String filePath, String id, String cliente,
                                     String fecha, String iva, String total)
            throws DocumentException, IOException {

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        try {
            FontStyles fonts = new FontStyles();

            addLogo(document);
            addClinicHeader(document, fonts.titleFont);
            addClinicInfo(document, fonts.normalFont);
            addSeparator(document);
            addInvoiceDetails(document, fonts, id, cliente, fecha, iva, total);
            addDescription(document, fonts.normalFont);
            addSignatureAndTotal(document, fonts.totalFont, total);
            addQrCode(document);


        } finally {
            document.close();
        }
    }

    private static class FontStyles {
        final Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.DARK_GRAY);
        final Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        final Font normalFont = new Font(Font.FontFamily.HELVETICA, 10);
        final Font totalFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE);
    }


    private void addLogo(Document document) throws DocumentException {
        try {
            Image logo = Image.getInstance(getClass().getResource("/media/logo.png"));
            logo.scaleToFit(100, 100);
            logo.setAlignment(Image.ALIGN_CENTER);
            document.add(logo);
        } catch (Exception e) {
            addAlternativeText(document, "Logo de la clínica");
        }
    }

    private void addClinicHeader(Document document, Font titleFont) throws DocumentException {
        Paragraph title = new Paragraph("VETERINARY CLINIC\n\n", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(15f);
        document.add(title);
    }

    private void addClinicInfo(Document document, Font font) throws DocumentException {
        Font boldFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);

        String[] clinicInfo = {
                "NIT 1093925253",
                "Tibú Norte de Santander",
                "B/ Esperanza",
                "VeterinaryClinic@gmail.com",
                "+57312 370 2377"
        };

        Paragraph info = new Paragraph();
        for (String line : clinicInfo) {
            info.add(new Paragraph(line, boldFont));
        }
        info.setAlignment(Element.ALIGN_CENTER);
        info.setSpacingAfter(15f);
        document.add(info);
    }

    private void addSeparator(Document document) throws DocumentException {
        document.add(new Paragraph("------------------------------------------------------------"));
    }

    private void addInvoiceDetails(Document document, FontStyles fonts,
                                   String id, String cliente,
                                   String fecha, String iva, String total)
            throws DocumentException {


        // Crear tabla con 2 columnas
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100); 
        table.setSpacingBefore(10f);
        table.setSpacingAfter(15f);

        table.setWidths(new float[]{4, 6});

        // Añadir filas con texto justificado
        addJustifiedTableRow(table, "ID Factura", id, fonts);
        addJustifiedTableRow(table, "Nombre Cliente", cliente, fonts);
        addJustifiedTableRow(table, "Fecha", fecha, fonts);
        addJustifiedTableRow(table, "IVA", iva, fonts);
        addJustifiedTableRow(table, "total", total, fonts);

        document.add(table);
        addSeparator(document);
    }

    private void addJustifiedTableRow(PdfPTable table, String label, String value, FontStyles fonts) {

        PdfPCell labelCell = new PdfPCell();
        labelCell.setBorder(PdfPCell.NO_BORDER);
        labelCell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        Paragraph labelParagraph = new Paragraph();
        labelParagraph.add(new Chunk(label, fonts.normalFont));
        labelParagraph.add(new Chunk(" :", new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.LIGHT_GRAY)));
        labelCell.addElement(labelParagraph);
        table.addCell(labelCell);

        PdfPCell valueCell = new PdfPCell(new Phrase(value, fonts.normalFont));
        valueCell.setBorder(PdfPCell.NO_BORDER);
        valueCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        valueCell.setPaddingLeft(5f); // Pequeño margen izquierdo
        table.addCell(valueCell);
    }

    private void addDescription(Document document, Font font) throws DocumentException {
        Paragraph desc = new Paragraph();
        desc.add(new Paragraph("Descripción", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
        desc.add(new Paragraph("\nDocumento PDF que muestra de manera detallada lo realizado en la clínica veterinaria JS. " +
                "La atención brindada se realiza con profesionalismo y cuidado especial a las mascotas.", font));
        desc.setSpacingAfter(15f);
        document.add(desc);
        addSeparator(document);
    }
    private void addQrCode(Document document) throws DocumentException {
        try {
            Image qr = Image.getInstance(getClass().getResource("/media/qr_1.png"));
            qr.scaleToFit(110, 110);

            document.add(qr);
        } catch (Exception e) {
            addAlternativeText(document, "Código QR");
        }
    }

    private void addSignatureAndTotal(Document document, Font font, String total)
            throws DocumentException {

        Paragraph signature = new Paragraph();
        signature.add(new Paragraph("\nTotal a Pagar $" + total, font));
        document.add(signature);
    }

    private void addAlternativeText(Document document, String altText) throws DocumentException {
        document.add(new Paragraph("[" + altText + " no disponible]",
                new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC)));
    }

    private void showSuccessAndOpenPdf(String filePath) {
        JOptionPane.showMessageDialog(this,
                "Factura generada exitosamente en:\n" + filePath,
                "Operación Exitosa",
                JOptionPane.INFORMATION_MESSAGE);

        try {
            Desktop.getDesktop().open(new File(filePath));
        } catch (IOException ex) {
            System.out.println("PDF generado pero no se pudo abrir: " + ex.getMessage());
        }
    }

    private void handleError(String message, Exception ex) {
        System.err.println(message + ": " + ex.getMessage());
        ex.printStackTrace();

        JOptionPane.showMessageDialog(this,
                message + ": " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaVerCostumerInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaVerCostumerInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaVerCostumerInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaVerCostumerInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaVerCostumerInvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoIcono;
    public javax.swing.JButton btnImprimir;
    public javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotal2;
    // End of variables declaration//GEN-END:variables
}
