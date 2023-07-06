package biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inicializarRegistro();

        int op;

        do {
            menuPrincipal();
            try {
                op = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opcion invalida. Por favor, intente de nuevo.");
                scanner.nextLine();
                continue;
            }

            switch (op) {

                case 1 -> {
                    int op2;

                    do {
                        opcionesBuscarLibro();

                        try {
                            op2 = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Opcion invalida. Por favor, intente de nuevo.");
                            scanner.nextLine();
                            continue;
                        }

                        if (op2 == 1) {
                            buscarLibroPorTitulo();
                        } else if (op2 == 2){
                            buscarLibroPorAutor();
                        } else {
                            break;
                        }
                    } while (true);

                }

                case 2 -> registrarLibro();

                case 3 -> listarLibros();

                case 4 -> prestarLibro();

                case 5 -> devolverLibro();

                case 6 -> eliminarLibro();

                default -> {}

            }

            if (op == 7) {
                break;
            }
        } while (true);
    }

}
