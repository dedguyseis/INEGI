package modelo;

public class Vivienda {
    private int id;
    private String tipo;
    private String localidad;
    private String municipio;

    public Vivienda(int id, String tipo, String localidad, String municipio) {
        this.id = id;
        this.tipo = tipo;
        this.localidad = localidad;
        this.municipio = municipio;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getLocalidad() { return localidad; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }

    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }
}
