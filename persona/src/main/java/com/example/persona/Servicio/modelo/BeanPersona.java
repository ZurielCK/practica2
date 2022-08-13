package com.example.persona.Servicio.modelo;

public class BeanPersona {
    private int id_persona;
    private String nombre;
    private String surname;

    private String curp;
    private String cumple;

    public BeanPersona() {
    }

    public BeanPersona(String nombre, String surname, String curp, String cumple) {
        this.nombre = nombre;
        this.surname = surname;
        this.curp = curp;
        this.cumple = cumple;
    }

    @Override
    public String toString() {
        return "BeanPersona{" +
                "id_persona=" + id_persona +
                ", nombre='" + nombre + '\'' +
                ", surname='" + surname + '\'' +
                ", curp='" + curp + '\'' +
                ", cumple='" + cumple + '\'' +
                '}';
    }

    public BeanPersona(int id_persona, String nombre, String surname, String curp, String cumple) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.surname = surname;
        this.curp = curp;
        this.cumple = cumple;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCumple() {
        return cumple;
    }

    public void setCumple(String cumple) {
        this.cumple = cumple;
    }
}
