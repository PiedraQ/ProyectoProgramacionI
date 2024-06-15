package com.mycompany.proyectoprogramacioni;
import java.util.ArrayList;
public class Alumno {
    public String carne;
    private String nombre;
    private String apellido;
    private String contracena; 
    private double nota;
    private String genero;
    private ArrayList<Curso> cursos = new ArrayList<>();
    
    public String toString() {
        return getNombre() + " " + getApellido()+" "+ getCarne();
    }
    public String getCarne() {
        return carne;
    }
    public void setCarne(String carne) {
        this.carne = carne;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getContracena() {
        return contracena;
    }
    public void setContracena(String contracena) {
        this.contracena = contracena;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return carne.equals(alumno.carne);
    }
    public int hashCode() {
        return carne.hashCode();
    }
}
