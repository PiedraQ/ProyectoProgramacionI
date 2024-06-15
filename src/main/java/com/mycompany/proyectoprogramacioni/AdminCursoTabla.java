package com.mycompany.proyectoprogramacioni;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AdminCursoTabla extends javax.swing.JFrame {

    public AdminCursoTabla() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cargar JS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdminCursoModificar c = new AdminCursoModificar(jTable1.getSelectedRow());
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Actualizar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser archivo = new JFileChooser("");
        int seleccionado = archivo.showDialog(this, "Cargar");
        if (seleccionado == JFileChooser.APPROVE_OPTION) {
            leerArchivoCursos(archivo.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        HomePageAdmin c = new HomePageAdmin();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Actualizar() {
        DefaultTableModel data = new DefaultTableModel(new String[]{"ID", "Nombre", "Sección", "Fecha Inicial", "Fecha Final", "Hora Inicial", "Hora Final", "Profesor"}, ProyectoProgramacionI.cursos.size());
        jTable1.setModel(data);

        int row = 0;

        for (Curso a : ProyectoProgramacionI.cursos) {
            jTable1.setValueAt(a.getID(), row, 0);
            jTable1.setValueAt(a.getNombre(), row, 1);
            jTable1.setValueAt(a.getSeccion(), row, 2);
            jTable1.setValueAt(a.getFechainicio(), row, 3);
            jTable1.setValueAt(a.getFechafin(), row, 4);
            jTable1.setValueAt(a.getHorainicio(), row, 5);
            jTable1.setValueAt(a.getHorafinal(), row, 6);
            jTable1.setValueAt(a.getProfesor(), row, 7);
            row++;
        }
    }
    
    public void leerArchivoCursos(String rutaConNombre) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(rutaConNombre)) {
            Object obj = parser.parse(reader);
            JSONArray cursosList = (JSONArray) obj;

            for (Object c : cursosList) {
                JSONObject cursoObj = (JSONObject) c;

                if (cursoObj != null) {
                    Object idObject = cursoObj.get("id");
                    int idCurso = (idObject != null) ? ((Long) idObject).intValue() : 1;
                    String nombreCurso = (String) cursoObj.get("nombre");
                    String seccionCurso = (String) cursoObj.get("seccion");
                    String fechaInicioTexto = (String) cursoObj.get("fecha_inicio");
                    String fechaFinTexto = (String) cursoObj.get("fecha_fin");
                    String horaInicioCurso = (String) cursoObj.get("hora_inicio");
                    String horaFinCurso = (String) cursoObj.get("hora_fin");
                    String profesorSeleccionado = (String) cursoObj.get("profesor");

                    Curso curso = new Curso();
                    curso.setID(idCurso);
                    curso.setNombre(nombreCurso);
                    curso.setSeccion(seccionCurso);
                    curso.setFechainicio(fechaInicioTexto);
                    curso.setFechafin(fechaFinTexto);
                    curso.setHorainicio(horaInicioCurso);
                    curso.setHorafinal(horaFinCurso);
                    curso.setProfesor(profesorSeleccionado);

                    ProyectoProgramacionI.cursos.add(curso);
                }
            }
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
