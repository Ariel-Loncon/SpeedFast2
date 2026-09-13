package main;

import model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("[Zona de carga inicializada]");
        System.out.println();
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        zonaDeCarga.agregarPedido(new Pedido(1, "Santiago Centro"));
        zonaDeCarga.agregarPedido(new Pedido(2, "Providencia"));
        zonaDeCarga.agregarPedido(new Pedido(3, "Renca"));
        zonaDeCarga.agregarPedido(new Pedido(4, "Recoleta"));
        zonaDeCarga.agregarPedido(new Pedido(5, "Cerro Navia"));

        System.out.println();

        Thread r1 = new Thread(new Repartidor("Juan", zonaDeCarga));
        Thread r2 = new Thread(new Repartidor("Camila", zonaDeCarga));
        Thread r3 = new Thread(new Repartidor("Pedro", zonaDeCarga));

        r1.start();
        r2.start();
        r3.start();

        try {
            r1.join();
            r2.join();
            r3.join();
        } catch (InterruptedException e) {
            System.err.println("Error en la espera de hilos: " + e.getMessage());
        }
        System.out.println();
        System.out.println("Todos los pedidos han sido entregados correctamente.");
    }
}