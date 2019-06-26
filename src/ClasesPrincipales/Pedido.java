package ClasesPrincipales;

public class Pedido {
    private int idpedido;
    private String fecha;
    private int cantidad;
    private String observacion;
    private String producto;
    private String sede;

    public Pedido(int idpedido, String fecha, int cantidad, String observacion, String producto, String sede) {
        this.idpedido = idpedido;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.observacion = observacion;
        this.producto = producto;
        this.sede = sede;
    }
    
    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
    
    
}
