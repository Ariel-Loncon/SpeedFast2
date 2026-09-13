package model;

/**
 * Clase encargada de gestionar pedidos
 */
public class Pedido {
    private int idPedido;
    private String direccionEntrega;
    private EstadoPedido estado;

    /**
     *
     * @param idPedido Identificador numérico del pedido
     * @param direccionEntrega Dirección de destino
     */

    public Pedido(int idPedido, String direccionEntrega) {
        if (idPedido <= 0) {
            throw new IllegalArgumentException("El ID debe ser positivo.");
        }
        if (direccionEntrega == null || direccionEntrega.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.estado = EstadoPedido.PENDIENTE;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        return "Pedido #" + idPedido + " - Destino: " + direccionEntrega + " [" + estado + "]";
    }
}
