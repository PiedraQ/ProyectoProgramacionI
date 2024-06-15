package com.mycompany.proyectoprogramacioni;
import java.util.ArrayList;
public class ProyectoProgramacionI {
    public static ArrayList<Profesor> profesores = new ArrayList<>();
    public static Profesor profesorLogeado = new Profesor();
    public static ArrayList<Alumno> alumnos = new ArrayList<>();
    public static Alumno alumnoLogeado = new Alumno();
    public static ArrayList<Curso> cursos = new ArrayList<>();
    public static void main(String[] args) {
        Login l = new Login();
        l.setVisible(true);
    }
}
