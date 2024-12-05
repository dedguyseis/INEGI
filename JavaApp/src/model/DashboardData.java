package model;

public class DashboardData {
    private String municipio;
    private String localidad;
    private int poblacion;

    public DashboardData(String municipio, String localidad, int poblacion) {
        this.municipio = municipio;
        this.localidad = localidad;
        this.poblacion = poblacion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public int getPoblacion() {
        return poblacion;
    }
}
