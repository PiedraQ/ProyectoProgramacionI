package com.mycompany.proyectoprogramacioni;

import javax.swing.JOptionPane;

public class AdminCursoAlumnoAsignar extends javax.swing.JFrame {

    public AdminCursoAlumnoAsignar() {
        initComponents();
        for (Curso e : ProyectoProgramacionI.cursos) {
            jComboBox2.addItem(e.toString());
        }
        for (Alumno e : ProyectoProgramacionI.alumnos) {
            jComboBox1.addItem(e.toString());
        }
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Alumno");

        jLabel2.setText("Curso");

        jButton1.setText("Asignar");
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
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 150, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButton1)
                        .addGap(31, 31, 31)
                        .addComponent(jButton2)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HomePageAdmin c = new HomePageAdmin();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombreCurso = jComboBox2.getSelectedItem().toString();
        String nombreAlumno = jComboBox1.getSelectedItem().toString();
        Alumno alumnoSeleccionado = null;
        Curso cursoSeleccionado = null;

        // Buscar el alumno seleccionado
        for (Alumno e : ProyectoProgramacionI.alumnos) {
            if (e.toString().equals(nombreAlumno)) {
                alumnoSeleccionado = e;
                break;
            }
        }

        // Buscar el curso seleccionado
        for (Curso e : ProyectoProgramacionI.cursos) {
            if (e.toString().equals(nombreCurso)) {
                cursoSeleccionado = e;
                break;
            }
        }

        if (alumnoSeleccionado != null && cursoSeleccionado != null) {
            // Verificar si el alumno ya está asignado a este curso
            if (cursoSeleccionado.getAlumnos().contains(alumnoSeleccionado)) {
                JOptionPane.showMessageDialog(this, "El alumno ya está asignado a este curso.");
                return;
            }

            // Verificar si el alumno ya está asignado a 5 cursos
            int countarCursos = 0;
            for (Curso curso : ProyectoProgramacionI.cursos) {
                if (curso.getAlumnos().contains(alumnoSeleccionado)) {
                    countarCursos++;
                }
            }

            if (countarCursos >= 5) {
                JOptionPane.showMessageDialog(this, "El alumno ya está asignado a 5 cursos.");
                return;
            }

            // Verificar si el curso ya tiene 10 alumnos
            if (cursoSeleccionado.getAlumnos().size() >= 10) {
                JOptionPane.showMessageDialog(this, "El curso ya tiene 10 alumnos.");
                return;
            }
            // Crear una nueva instancia de Alumno y copiar los datos del alumno logeado
            Alumno nuevoAlumno = new Alumno();
            nuevoAlumno.setNombre(alumnoSeleccionado.getNombre());
            nuevoAlumno.setApellido(alumnoSeleccionado.getApellido());
            nuevoAlumno.setCarne(alumnoSeleccionado.getCarne());
            nuevoAlumno.setContracena(alumnoSeleccionado.getContracena());
            nuevoAlumno.setNota(alumnoSeleccionado.getNota());
            // Agregar al nuevo alumno al curso
            cursoSeleccionado.getAlumnos().add(nuevoAlumno);
            JOptionPane.showMessageDialog(this, "El alumno fue asignado exitosamente.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
