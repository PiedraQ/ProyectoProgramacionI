package com.mycompany.proyectoprogramacioni;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AlumnoCursoTabla extends javax.swing.JFrame {

    public AlumnoCursoTabla() {
        initComponents();
        ActualizarTabla();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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

        jButton1.setText("Desasignar");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jButton1)
                        .addGap(72, 72, 72)
                        .addComponent(jButton2)))
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
                    .addComponent(jButton2))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Alumno alumnoLogeado = ProyectoProgramacionI.alumnoLogeado;

        if (alumnoLogeado != null) {
            int cursoAsignadoIndex = jTable1.getSelectedRow();
            if (cursoAsignadoIndex == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un curso para desasignarte", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String nombreCurso = jTable1.getValueAt(cursoAsignadoIndex, 0).toString();
                String Seccioncurso = jTable1.getValueAt(cursoAsignadoIndex, 1).toString();
                String Profesorcurso = jTable1.getValueAt(cursoAsignadoIndex, 2).toString();
                Curso cursoSeleccionado = null;
                for (Curso c : ProyectoProgramacionI.cursos) {
                    if (c.getNombre().equals(nombreCurso)&& c.getSeccion().equals(Seccioncurso)&& c.getProfesor().equals(Profesorcurso)) {
                        cursoSeleccionado = c;
                        break;
                    }
                }
                if (cursoSeleccionado != null) {
                    boolean alumnoEncontrado = false;
                    for (Alumno a : cursoSeleccionado.getAlumnos()) {
                        if (a.getCarne().equals(alumnoLogeado.getCarne())) {
                            cursoSeleccionado.getAlumnos().remove(a);
                            alumnoEncontrado = true;
                            break;
                        }
                    }
                    if (alumnoEncontrado) {
                        JOptionPane.showMessageDialog(this, "Te desasignaste exitosamente");
                        ActualizarTabla(); // Actualizar la tabla después de desasignar el curso
                    } else {
                        JOptionPane.showMessageDialog(this, "El alumno no está asignado a este curso", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HomePageAlumno c = new HomePageAlumno();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ActualizarTabla() {
        Alumno alumnoLogeado = ProyectoProgramacionI.alumnoLogeado;

        if (alumnoLogeado != null) {
            DefaultTableModel data = new DefaultTableModel(new String[]{"Nombre", "Sección", "Profesor", "Nota"}, 0);

            for (Curso c : ProyectoProgramacionI.cursos) {
                for (Alumno a : c.getAlumnos()) {
                    if (a.getNombre().equals(alumnoLogeado.getNombre())) {
                        data.addRow(new Object[]{c.getNombre(), c.getSeccion(), c.getProfesor(), a.getNota()});
                        break;
                    }
                }
            }
            jTable1.setModel(data);
        } else {
            System.out.println("No se encontró el alumno");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
