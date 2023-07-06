package biblioteca;

public class Libro {

    private String titulo;
    private String autor;
    private int publicacion;
    private boolean prestado;

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    // Metodos
    public static void prestamo(Libro libro) {
        libro.prestado = true;
    }

    public static void devolucion(Libro libro) {
        libro.prestado = false;
    }

    // Constructor predeterminado
    public Libro() {
        this.titulo = null;
        this.autor = null;
        this.publicacion = 0;
        this.prestado = false;
    }

    // Constructor
    public Libro(String titulo, String autor, int publicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.prestado = false;
    }
}