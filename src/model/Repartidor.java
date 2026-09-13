package model;

/**
 * Clase que representa al repartidor al que se le asignan pedidos
 */
public class Repartidor implements Runnable {
    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    /**
     *
     * @param nombre Nombre del repartidor asignado
     * @param zonaDeCarga Z
     */
    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void run() {
        while (true) {
            Pedido pedido = zonaDeCarga.retirarPedido();
            if (pedido == null) {
                break;
            }

            try {
                pedido.setEstado(EstadoPedido.EN_REPARTO);
                System.out.println("[Repartidor - " + nombre + "] Retirando pedido #" + pedido.getIdPedido() + "...");
                System.out.println("[Repartidor - " + nombre + "] Estado: " + pedido.getEstado());


                System.out.println("[Repartidor - " + nombre + "] Entregando pedido #" + pedido.getIdPedido() + "...");
                Thread.sleep(1500);


                pedido.setEstado(EstadoPedido.ENTREGADO);
                System.out.println("[Repartidor - " + nombre + "] Estado: " + pedido.getEstado());

            } catch (InterruptedException e) {
                System.err.println("[Repartidor - " + nombre + "] Proceso interrumpido.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
