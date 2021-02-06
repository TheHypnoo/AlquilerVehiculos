import Clases.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);
    ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public static void main(String[] args) {
        Main Start = new Main();
        Start.menuPrincipal();
    }

    public void menuPrincipal() {
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println(Ansi.CYAN + "+---------------------------------------+");
            System.out.println(Ansi.GREEN + "+-------    Alquiler de Vehiculos  --------+");
            System.out.println(Ansi.HIGH_INTENSITY+Ansi.YELLOW + "1."+Ansi.WHITE+"Añadir un vehiculo");
            System.out.println(Ansi.YELLOW +"2."+Ansi.WHITE+"Obtener precio de alquiler de un vehiculo concreto");
            System.out.println(Ansi.YELLOW +"3."+Ansi.WHITE+"Salir");
            System.out.println(Ansi.CYAN + "+---------------------------------------+");
            try {
                System.out.println(Ansi.WHITE + "Escribe una de las opciones");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> creaVehiculo();
                    case 2 -> alquilaVehiculos();
                    case 3 -> {
                        salir = true;
                        System.out.println("Te has salido.");
                        return;
                    }
                    default -> System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Error, vuelve a introducir el modo nuevamente.");

                }
            } catch (InputMismatchException e) {
                System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Debes insertar un número correspondiente al que se te indica.");
                sc.next();
            }
        }
    }

    public String generarMatricula() {
        StringBuilder matricula = new StringBuilder();
        int a;
        String CaracteresNoDeseados = "AEIOU";
        for (int i = 0; i < 7; i++) {
            if (i < 4) {    // 0,1,2,3 posiciones de numeros
                matricula.insert(0, (int) (Math.random() * 9) + "");

            } else {       // 4,5,6 posiciones de letras
                do {
                    a = (int) (Math.random() * 26 + 65);///
                } while (CaracteresNoDeseados.indexOf(a) >= 0);

                char letra = (char) a;
                if (i == 4) {
                    matricula.append("-").append(letra);
                } else {
                    matricula.append(letra);
                }
            }
        }
        return matricula.toString();
    }

    public void creaVehiculo(){
        String matricula;
        int PMAorPlazas;
        String tipoVehiculo;
        //Hago que introduzca numeros para mayor facilidad al usuario
        System.out.println("Que tipo de vehiculo quieres crear?");
        System.out.println("1.Coche");
        System.out.println("2.Microbus");
        System.out.println("3.Furgoneta");
        System.out.println("4.Camion");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> {
                matricula = generarMatricula();
                tipoVehiculo = "Coche";
                System.out.println("Introduce el numero de plazas del vehiculo");
                PMAorPlazas = sc.nextInt();
                Coche ferrari = new Coche(matricula,tipoVehiculo,0,50,PMAorPlazas);
                vehiculos.add(ferrari);
                System.out.println("Se ha añadido el vehiculo con matricula: "+matricula + " y plazas: " +PMAorPlazas);
            }
            case 2 -> {
                matricula = generarMatricula();
                tipoVehiculo = "Microbus";
                System.out.println("Introduce el numero de plazas del vehiculo");
                PMAorPlazas = sc.nextInt();
                Microbus juampyBus = new Microbus(matricula,tipoVehiculo,0,50,PMAorPlazas);
                vehiculos.add(juampyBus);
                System.out.println("Se ha añadido el vehiculo con matricula: "+matricula + " y plazas: " +PMAorPlazas);
            }
            case 3 -> {
                matricula = generarMatricula();
                tipoVehiculo = "Furgoneta";
                System.out.println("Introduce el PMA del vehiculo");
                PMAorPlazas = sc.nextInt();
                Furgonetas furgoTour = new Furgonetas(matricula,tipoVehiculo,0,50,PMAorPlazas);
                vehiculos.add(furgoTour);
                System.out.println("Se ha añadido el vehiculo con matricula: "+matricula + " y plazas: " +PMAorPlazas);
            }
            case 4 -> {
                matricula = generarMatricula();
                tipoVehiculo = "Camion";
                System.out.println("Introduce el PMA del vehiculo");
                PMAorPlazas = sc.nextInt();
                Camiones camionTrail = new Camiones(matricula,tipoVehiculo,0,50,PMAorPlazas);
                vehiculos.add(camionTrail);
                System.out.println("Se ha añadido el vehiculo con matricula: "+matricula + " y plazas: " +PMAorPlazas);
            }
        }
    }

    public void alquilaVehiculos(){
        System.out.println("Introduce la matricula del vehiculo que quiere alquilar");
        String matricula = sc.next();
        for (Vehiculo vehiculo : vehiculos) {
            if (matricula.equalsIgnoreCase(vehiculo.getMatricula())) {
                System.out.println("Introduce el numero de dias de Alquiler:");
                int dias = sc.nextInt();
                vehiculo.setDia(dias);
                System.out.println("Matricula: "+
                        vehiculo.getMatricula()+
                        "\n Tipo de vehiculo: "+
                        vehiculo.getTipoVehiculo()+
                        "\n Dias de alquiler: "+
                        vehiculo.getDia()+
                        "\n Plazas o PMA asignado: "+
                        vehiculo.getPMAorPlazas()+
                        "\n Calculo del Alquiler completo: "+
                        vehiculo.calculaAlquier()
                );
            }
        }
    }

}
