package modelo;

public class Habitante {
    private int id;
    private String nombre;
    private int edad;
    private int viviendaId;

    public Habitante(int id, String nombre, int edad, int viviendaId) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.viviendaId = viviendaId;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public int getViviendaId() { return viviendaId; }
    public void setViviendaId(int viviendaId) { this.viviendaId = viviendaId; }
}
