package com.mycompany.proyectoprogramacioni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class AdminCursoAlumnoTabla extends javax.swing.JFrame {
    public AdminCursoAlumnoTabla() {
        initComponents();
        for(Curso e : ProyectoProgramacionI.cursos){
            jComboBox1.addItem(e.toString());
        }
        this.setLocationRelativeTo(null); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        jLabel1.setText("jLabel1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Carga Binarios");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton1)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HomePageAdmin c = new HomePageAdmin();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nombreCurso = jComboBox1.getSelectedItem().toString();
        Curso cursoSeleccionada = null;
        for (Curso e : ProyectoProgramacionI.cursos) {
            if (e.toString().equals(nombreCurso)) {
                cursoSeleccionada = e;
                break;
            }
        }

        if (cursoSeleccionada != null) {
            DefaultTableModel data = new DefaultTableModel(new String[]{"Carné", "Nombre", "Apellido"}, cursoSeleccionada.getAlumnos().size());
            jTable1.setModel(data);

            int row = 0;

            for (Alumno e : cursoSeleccionada.getAlumnos()) {
                jTable1.setValueAt(e.getCarne(), row, 0);
                jTable1.setValueAt(e.getNombre(), row, 1);
                jTable1.setValueAt(e.getApellido(), row, 2);
                row++;
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser archivo = new JFileChooser();
        int result = archivo.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            cargarbin(archivo.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cargarbin(String rutaConNombre) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaConNombre));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("#");
                if (partes.length == 2) {
                    String cursoID = partes[0];
                    String carnet = partes[1];

                    Alumno alumno = null;
                    for (Alumno a : ProyectoProgramacionI.alumnos) {
                        if (a.getCarne().equals(carnet)) {
                            alumno = a;
                            break;
                        }
                    }

                    Curso cursoAsignado = null;
                    for (Curso c : ProyectoProgramacionI.cursos) {
                        if (String.valueOf(c.getID()).equals(cursoID)) {
                            cursoAsignado = c;
                            break;
                        }
                    }
                    if (cursoAsignado != null && alumno != null) {
                        Alumno nuevoAlumno = new Alumno();
                        nuevoAlumno.setNombre(alumno.getNombre());
                        nuevoAlumno.setApellido(alumno.getApellido());
                        nuevoAlumno.setCarne(alumno.getCarne());
                        nuevoAlumno.setContracena(alumno.getContracena());
                        nuevoAlumno.setNota(alumno.getNota());
                        nuevoAlumno.setGenero(alumno.getGenero());
                        cursoAsignado.getAlumnos().add(nuevoAlumno);
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
