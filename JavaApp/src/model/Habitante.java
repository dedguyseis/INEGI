package model;

public class Habitante {
    private int idHabitante;
    private String nombre;
    private int edad;
    private String sexo;
    private String actividadEconomica;

    // Constructor sin argumentos
    public Habitante() {
    }

    // Constructor con parámetros
    public Habitante(int idHabitante, String nombre, int edad, String sexo, String actividadEconomica) {
        this.idHabitante = idHabitante;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.actividadEconomica = actividadEconomica;
    }

    // Getters y Setters
    public int getIdHabitante() {
        return idHabitante;
    }

    public void setIdHabitante(int idHabitante) {
        this.idHabitante = idHabitante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }
}
