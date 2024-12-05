package model;

public class Vivienda {
    private int idVivienda;
    private String tipoVivienda;
    private String direccion;
    private int idLocalidad;
    private String nombreLocalidad; // Para mostrar el nombre de la localidad
    private int idMunicipio;
    private String nombreMunicipio; // Para mostrar el nombre del municipio

    // Constructor con todos los campos
    public Vivienda(int idVivienda, String direccion, String tipoVivienda, String nombreLocalidad, String nombreMunicipio) {
        this.idVivienda = idVivienda;
        this.direccion = direccion;
        this.tipoVivienda = tipoVivienda;
        this.nombreLocalidad = nombreLocalidad;
        this.nombreMunicipio = nombreMunicipio;
    }

    // Constructor vacío
    public Vivienda() {
    }

    // Getters y Setters
    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }
}
