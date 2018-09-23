package app.upc.com.appsql;

public class Telefono {

    private int id;
    private String titulo;
    private String telefono;

    public Telefono(int id, String titulo, String telefono) {
        this.id = id;
        this.titulo = titulo;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
