package com.mycompany.proyectoprogramacioni;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProfesorCursoAlumnoTabla extends javax.swing.JFrame {

    public ProfesorCursoAlumnoTabla() {
        initComponents();
        this.setLocationRelativeTo(null);
        Profesor profesorLogeado = ProyectoProgramacionI.profesorLogeado;

        if (profesorLogeado != null) {
            this.setLocationRelativeTo(null);
            for (Curso curso : ProyectoProgramacionI.cursos) {
                if (curso.getProfesor().equals(profesorLogeado.usuario)) {
                    jComboBox1.addItem(curso.getNombre() + " - Sección: " + curso.getSeccion());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Curso");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

        jLabel2.setText("Nota");

        jButton3.setText("Agregar Nota");
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(90, 90, 90))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(72, 72, 72))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBox1, 0, 249, Short.MAX_VALUE)
                                .addComponent(jTextField1))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(55, 55, 55)
                .addComponent(jButton2)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombreCurso = jComboBox1.getSelectedItem().toString();
        Curso cursoSeleccionado = null;

        // Buscando el curso correspondiente en la lista de cursos
        for (Curso curso : ProyectoProgramacionI.cursos) {
            if ((curso.getNombre() + " - Sección: " + curso.getSeccion()).equals(nombreCurso)) {
                // Se encontró el curso correspondiente
                cursoSeleccionado = curso;
                break;
            }
        }

        // Verificando si se encontró el curso
        if (cursoSeleccionado != null) {
            // Llenando la tabla con la información de los alumnos inscritos en ese curso
            DefaultTableModel data = new DefaultTableModel(new String[]{"Carné", "Nombre", "Apellido", "Nota"}, cursoSeleccionado.getAlumnos().size());
            jTable1.setModel(data);

            int row = 0;

            for (Alumno alumno : cursoSeleccionado.getAlumnos()) {
                jTable1.setValueAt(alumno.getCarne(), row, 0);
                jTable1.setValueAt(alumno.getNombre(), row, 1);
                jTable1.setValueAt(alumno.getApellido(), row, 2);
                jTable1.setValueAt(alumno.getNota(), row, 3);
                row++;
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HomePageProfesor c = new HomePageProfesor();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String nombreCurso = jComboBox1.getSelectedItem().toString();
        Curso cursoSeleccionado = null;
        
        for (Curso curso : ProyectoProgramacionI.cursos) {
            if ((curso.getNombre() + " - Sección: " + curso.getSeccion()).equals(nombreCurso)) {
                cursoSeleccionado = curso;
                break;
            }
        }
        if (cursoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Curso no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String notaTexto = jTextField1.getText();
        int nota;
        try {
            nota = Integer.parseInt(notaTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La nota ingresada no es válida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String carne = jTable1.getModel().getValueAt(row, 0).toString();
        boolean alumnoEncontrado = false;
        for (Alumno s : cursoSeleccionado.getAlumnos()) {
            if (s.getCarne().equals(carne)) {
                s.setNota(nota);
                alumnoEncontrado = true;
                break;
            }
        }
        if (!alumnoEncontrado) {
            JOptionPane.showMessageDialog(this, "Alumno no encontrado en el curso", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Nota actualizada exitosamente");
            jTable1.setValueAt(nota, row, 3);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
