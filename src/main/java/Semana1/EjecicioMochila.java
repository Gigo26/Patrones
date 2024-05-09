package Semana1;

//Núñez Chávez José Gerardo - 0202214022

import java.util.Random;
import java.util.Scanner;

public class EjecicioMochila {

    static class Elemento {

        String nombre;
        double peso;
        double precio;
        String forma;

        public Elemento(String nombre, double peso, double precio, String forma) {
            this.nombre = nombre;
            this.peso = peso;
            this.precio = precio;
            this.forma = forma;
        }

        public void mostrarInformacion() {
            System.out.println("Nombre: " + nombre + ", Peso: " + peso + "kg, Precio: S/." + precio + ", Forma: " + forma);
        }
    }

    public static void main(String[] args) {
        Elemento[] elementos = {
            new Elemento("Laptop", 2, 3400, "Rectangular"),
            new Elemento("Plumones", 0.2, 50, "Cilíndrica"),
            new Elemento("Cuadernos", 0.5, 100, "Rectangular"),
            new Elemento("Regla", 0.1, 20, "Rectangular"),
            new Elemento("Botella de agua", 0.3, 30, "Cilíndrica"),
            new Elemento("Estuche de lápices", 0.4, 80, "Rectangular"),
            new Elemento("Cargador portátil", 0.3, 150, "Rectangular"),
            new Elemento("Libro", 0.7, 200, "Rectangular"),
            new Elemento("Agenda", 0.3, 80, "Rectangular"),
            new Elemento("Paraguas", 0.6, 120, "Redonda"),
            new Elemento("Auriculares", 0.1, 100, "Rectangular"),
            new Elemento("Gafas de sol", 0.2, 150, "Ovalada"),
            new Elemento("Bocadillos", 0.4, 50, "Rectangular"),
            new Elemento("Botiquín de primeros auxilios", 0.5, 120, "Rectangular"),
            new Elemento("Llaves", 0.1, 10, "Irregular"),
            new Elemento("Pañuelos de papel", 0.2, 15, "Rectangular"),
            new Elemento("Portafolio", 0.6, 180, "Rectangular"),
            new Elemento("Tarjeta de transporte", 0.01, 5, "Rectangular"),
            new Elemento("Cámara fotográfica", 0.8, 600, "Rectangular"),
            new Elemento("Lámpara portátil", 0.5, 200, "Cilíndrica")
        };
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        System.out.print("Ingrese el peso máximo a soportar la mochila (kg): ");
        double pesoMaximo = sc.nextDouble();

        int cantidadElementos;
        do {
            System.out.print("Ingrese la cantidad de elementos a agregar a la mochila (debe ser 15 o más): ");
            cantidadElementos = sc.nextInt();
        } while (cantidadElementos < 15);

        double pesoTotal = 0;
        double precioTotal = 0;
        boolean pesoExcedido = false;

        System.out.println("Agregando a la mochila de forma aleatoria...");
        for (int i = 0; i < cantidadElementos; i++) {
            int indice = rd.nextInt(elementos.length);
            Elemento elementoSeleccionado = elementos[indice];
            if (!pesoExcedido && pesoTotal + elementoSeleccionado.peso <= pesoMaximo) {
                elementoSeleccionado.mostrarInformacion();
                pesoTotal += elementoSeleccionado.peso;
                precioTotal += elementoSeleccionado.precio;
            } else {
                pesoExcedido = true;
                System.out.println("El peso sobrepasa la capacidad máxima que puede soportar la mochila");
                break; 
            }
        }

        if (!pesoExcedido) {
            System.out.println("Peso total en la mochila: " + pesoTotal + " kg");
            System.out.println("Precio total en la mochila: S/." + precioTotal);
        }
    }
}
