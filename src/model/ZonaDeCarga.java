package model;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase donde se gestiona la sincronización de pedidos
 */
public class ZonaDeCarga {
    private final Queue<Pedido> colaPedidos = new LinkedList<>();

    public synchronized void agregarPedido(Pedido p) {
        if (p != null) {
            colaPedidos.add(p);
            System.out.println("Pedido #" + p.getIdPedido() + " agregado. Destino: " + p.getDireccionEntrega());
        }
    }

    public synchronized Pedido retirarPedido() {
        Pedido pedido = colaPedidos.poll();
        if (pedido != null) {
            pedido.setEstado(EstadoPedido.EN_REPARTO);
        }
        return pedido;
    }
}
