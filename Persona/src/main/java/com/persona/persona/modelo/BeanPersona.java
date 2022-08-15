package com.persona.persona.modelo;


public class BeanPersona {
    private long id;
    private String name;
    private String surname;
    private String curp;

    private String cumple;

    public BeanPersona() {
    }

    public BeanPersona(long id, String name, String surname, String curp, String cumple) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.curp=curp;
        this.cumple = cumple;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
