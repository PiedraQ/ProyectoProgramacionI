package com.mycompany.proyectoprogramacioni;
import java.util.ArrayList;
public class Curso {
    private int ID;
    private String nombre; 
    private String seccion;
    private String fechainicio; 
    private String fechafin;
    private String horainicio;
    private String horafinal;
    private String profesor;
    private ArrayList<Profesor> profesores = new ArrayList<>();
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    
    public String toString() {
        return getNombre() + " " + getSeccion()+" "+ getProfesor();
    }
    private static int cID = 1;
    public Curso(){
        this.ID = cID++;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getSeccion() {
        return seccion;
    }
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    public String getFechainicio() {
        return fechainicio;
    }
    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }
    public String getFechafin() {
        return fechafin;
    }
    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }
    public String getHorainicio() {
        return horainicio;
    }
    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }
    public String getHorafinal() {
        return horafinal;
    }
    public void setHorafinal(String horafinal) {
        this.horafinal = horafinal;
    }
    public String getProfesor() {
        return profesor;
    }
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }
    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    public static int getcID() {
        return cID;
    }
    public static void setcID(int acID) {
        cID = acID;
    }
}
