package com.mycompany.proyectoprogramacioni;

import javax.swing.JOptionPane;

public class AlumnoCursoAsignar extends javax.swing.JFrame {

    public AlumnoCursoAsignar() {
        initComponents();
        this.setLocationRelativeTo(null);
        jLabel1.setText("Bienvenido Alumno: " + ProyectoProgramacionI.alumnoLogeado.getNombre() + " " + ProyectoProgramacionI.alumnoLogeado.getApellido() + " " + ProyectoProgramacionI.alumnoLogeado.getCarne());

        for (Curso e : ProyectoProgramacionI.cursos) {
            jComboBox1.addItem(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("a");

        jLabel2.setText("Curso");

        jButton1.setText("Asignar");
        jButton1.setToolTipText("");
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
                        .addGap(73, 73, 73)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jButton1)
                        .addGap(67, 67, 67)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1)))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombreCurso = jComboBox1.getSelectedItem().toString();
        if (nombreCurso.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un curso", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Alumno alumnoLogeado = ProyectoProgramacionI.alumnoLogeado;
        if (alumnoLogeado == null) {
            JOptionPane.showMessageDialog(this, "No hay ningún alumno logeado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Curso cursoSeleccionado = null;
        for (Curso curso : ProyectoProgramacionI.cursos) {
            if (curso.toString().equals(nombreCurso)) {
                cursoSeleccionado = curso;
                break;
            }
        }
        if (cursoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "El curso seleccionado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (Alumno alumno : cursoSeleccionado.getAlumnos()) {
            if (alumno.getCarne().equals(alumnoLogeado.getCarne())) {
                JOptionPane.showMessageDialog(this, "El alumno ya está asignado a este curso.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        int contarCursos = 0;
        for (Curso curso : ProyectoProgramacionI.cursos) {
            for (Alumno alumno : curso.getAlumnos()) {
                if (alumno.getCarne().equals(alumnoLogeado.getCarne())) {
                    contarCursos++;
                }
            }
        }

        if (contarCursos >= 5) {
            JOptionPane.showMessageDialog(this, "El alumno ya está asignado a 5 cursos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setNombre(alumnoLogeado.getNombre());
        nuevoAlumno.setApellido(alumnoLogeado.getApellido());
        nuevoAlumno.setCarne(alumnoLogeado.getCarne());
        nuevoAlumno.setContracena(alumnoLogeado.getContracena());
        nuevoAlumno.setNota(alumnoLogeado.getNota());
        cursoSeleccionado.getAlumnos().add(nuevoAlumno);
        
        JOptionPane.showMessageDialog(this, "La asignación de cursos fue exitosa");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HomePageAlumno c = new HomePageAlumno();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
