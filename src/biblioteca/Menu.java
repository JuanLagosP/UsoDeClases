package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static List<Libro> registroDeLibros;

    public List<Libro> getRegistroDeLibros() {
        return registroDeLibros;
    }

    public void setRegistroDeLibros(List<Libro> registroDeLibros) {
        Menu.registroDeLibros = registroDeLibros;
    }

    public static void inicializarRegistro() {
        registroDeLibros = new ArrayList<>();
    }

    public static void registrarLibro() {

        System.out.println("Por favor, ingrese la informacion solicitada.");
        System.out.println("Titulo: ");
        String nombre = new Scanner(System.in).nextLine();
        System.out.println("Autor: ");
        String autor = new Scanner(System.in).nextLine();
        System.out.println("Año de publicacion: ");
        int publicacion = new Scanner(System.in).nextInt();

        Libro libro = new Libro(nombre, autor, publicacion);
        registroDeLibros.add(libro);
    }

    public static void eliminarLibro() {
        System.out.println("Por favor, ingrese el titulo del libro: ");

        do {
            Libro libro = buscarPorTitulo(new Scanner(System.in).nextLine());

            if (libro == null) {
                System.out.println("Libro no encontrado. Por favor, intente de nuevo.");
            } else {
                System.out.println("El libro ha sido eliminado del sistema");
                break;
            }
        } while (true);

    }

    public static void consultarInfo(Libro libro) {
        System.out.printf("%s%n -%s%n -%s%n -%s%n %n",
                "Titulo: " + libro.getTitulo(),
                "Autor: " + libro.getAutor(),
                "Año de publicacion: " + libro.getPublicacion(),
                "Prestado: " + libro.isPrestado());
    }

    public static void listarLibros() {
        if (registroDeLibros.isEmpty()) {
            System.out.println("No existe ningun registro en el sistema");
        } else {
            for (Libro lib : registroDeLibros) {
                consultarInfo(lib);
            }
        }
    }

    public static void prestarLibro() {
        System.out.println("Por favor, ingrese el titulo del libro: ");

        do {
            Libro libro = buscarPorTitulo(new Scanner(System.in).nextLine());

            if (libro == null) {
                System.out.println("Libro no encontrado. Por favor, intente de nuevo.");
            } else if (!libro.isPrestado()) {
                Libro.prestamo(libro);
                System.out.println("Proceso realizado con exito");
                break;
            } else {
                System.out.println("El libro se encuentra actualmente en prestamo. " + "\n" +
                        "Por favor, intente mas tarde.");
                break;
            }
        } while (true);

    }

    public static void devolverLibro() {
        System.out.println("Por favor, ingrese el titulo del libro: ");

        do {
            Libro libro = buscarPorTitulo(new Scanner(System.in).nextLine());

            if (libro == null) {
                System.out.println("Libro no encontrado. Por favor, intente de nuevo.");
            } else if (libro.isPrestado()) {
                Libro.devolucion(libro);
                System.out.println("Proceso realizado con exito");
                 break;
            } else {
                System.out.println("El libro ya fue devuelto");
                break;
            }
        } while (true);
    }

    public static Libro buscarPorTitulo(String titulo) {
        for (Libro lib : registroDeLibros) {
            if (lib.getTitulo().equalsIgnoreCase(titulo)) {
                return lib;
            }
        }
        return null;
    }

    public static List<Libro> buscarPorAutor(String autor) {
        List<Libro> libros = new ArrayList<>();

        for (Libro lib : registroDeLibros) {
            if (lib.getAutor().equalsIgnoreCase(autor)) {
                libros.add(lib);
            }
        }
        return libros;
    }

    public static void buscarLibroPorTitulo() {
        System.out.println("Ingrese el titulo del libro: ");

        do {
            Libro libro = buscarPorTitulo(new Scanner(System.in).nextLine());

            if (libro == null) {
                System.out.println("Libro no encontrado. Por favor, intente de nuevo.");
            } else {
                consultarInfo(libro);
                break;
            }
        } while (true);
    }

    public static void buscarLibroPorAutor() {
        System.out.println("Ingrese el nombre del autor: ");

        do {
            List<Libro> libros = buscarPorAutor(new Scanner(System.in).nextLine());

            if (libros.isEmpty()) {
                System.out.println("Autor no encontrado. Por favor, intente de nuevo.");
            } else {
                for (Libro lib : libros) {
                    consultarInfo(lib);
                }
                break;
            }
        } while (true);
    }

    public static void menuPrincipal() {
        System.out.println("----- Menu Principal -----");
        System.out.println("1. Buscar libro");
        System.out.println("2. Registrar libro");
        System.out.println("3. Ver registro de libros");
        System.out.println("4. Prestamo");
        System.out.println("5. Devolucion");
        System.out.println("6. Eliminar libro");
        System.out.println("7. Salir");
    }

    public static void opcionesBuscarLibro() {
        System.out.println("1. Por titulo");
        System.out.println("2. Por autor");
        System.out.println("3. Regresar al menu anterior");
    }

    public Menu() {

    }

}
