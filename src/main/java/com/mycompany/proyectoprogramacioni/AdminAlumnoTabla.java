package com.mycompany.proyectoprogramacioni;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class AdminAlumnoTabla extends javax.swing.JFrame {
    public AdminAlumnoTabla() {
        initComponents();
        Actualizar();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cargar XML");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Crear Archivo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdminAlumnoModificar n = new AdminAlumnoModificar(jTable1.getSelectedRow());
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser archivo = new JFileChooser("");
        int seleccionado = archivo.showDialog(this,"Cargar");
        if(seleccionado==JFileChooser.APPROVE_OPTION) {
            leerArchivoXMLAlumnos(archivo.getSelectedFile());
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String contenido = "<alumnos>\n";
        
        for(Alumno e : ProyectoProgramacionI.alumnos){
            contenido+="\t<alumno>\n";
            contenido+="\t\t<carne>";
            contenido+=e.getCarne();
            contenido+="</carne>\n";
            contenido+="\t\t<nombre>";
            contenido+=e.getNombre();
            contenido+="</nombre>\n";
            contenido+="\t\t<apellido>";
            contenido+=e.getApellido();
            contenido+="</apellido>\n";
            contenido+="\t\t<password>";
            contenido+=e.getContracena();
            contenido+="</password>\n";
            contenido+="\t</alumno>\n";
        }
        contenido+="</alumnos>";
        
        JFileChooser archivo = new JFileChooser("");
        int seleccionado = archivo.showDialog(this,"Guardar");
        if(seleccionado==JFileChooser.APPROVE_OPTION){
            escribirArchivoTexto(archivo.getSelectedFile().toPath().toString(),contenido);
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Actualizar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        HomePageAdmin c = new HomePageAdmin();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Actualizar(){
        DefaultTableModel data = new DefaultTableModel(new String[]{"Carne","Nombre","Apellido","Password"},ProyectoProgramacionI.alumnos.size());
        jTable1.setModel(data);
   
        int row = 0;
   
        for(Alumno a : ProyectoProgramacionI.alumnos){
            jTable1.setValueAt(a.getCarne(), row, 0);
            jTable1.setValueAt(a.getNombre(), row, 1);
            jTable1.setValueAt(a.getApellido(), row, 2);
            jTable1.setValueAt(a.getContracena(),row,3);
            row ++;
        }  
    }
    public void ConsultarAlumno() {
        initComponents();
        Actualizar();   
        this.setLocationRelativeTo(null); 
    }
    public void escribirArchivoTexto(String rutaConNombre, String contenido) {
        try {

            FileWriter fw = new FileWriter(rutaConNombre);
            PrintWriter pw = new PrintWriter(fw);
            pw.write(contenido);
            pw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void leerArchivoXMLAlumnos(File archivo) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(archivo);

            doc.getDocumentElement().normalize();
            NodeList nodos = doc.getElementsByTagName("alumno");

            for (int i = 0; i < nodos.getLength(); i++) {
                Node n = nodos.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) n;
                    Alumno a = new Alumno();
                    a.setCarne(e.getElementsByTagName("carne").item(0).getTextContent());
                    a.setNombre(e.getElementsByTagName("nombre").item(0).getTextContent());
                    a.setApellido(e.getElementsByTagName("apellido").item(0).getTextContent());
                    a.setContracena(e.getElementsByTagName("password").item(0).getTextContent());
                    // Agregar el alumno a la lista de alumnos en LoginB
                    ProyectoProgramacionI.alumnos.add(a);
                }
            }
            // Actualizar la vista de alumnos si es necesario
            Actualizar();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
