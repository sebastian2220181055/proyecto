package mvc.server.dto;

import mvc.model.client.Dto;

import java.io.Serializable;

public class Invoice implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;
    private int IdFactura;
    private String nombreEmpleado;
    private int IdEmpleado;
    private int precio;

    public Invoice(int idFactura, String nombreEmpleado, int idEmpleado, int precio) {
        IdFactura = idFactura;
        this.nombreEmpleado = nombreEmpleado;
        IdEmpleado = idEmpleado;
        this.precio = precio;
    }

    public Invoice() {
    }

    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int idFactura) {
        IdFactura = idFactura;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        IdEmpleado = idEmpleado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "IdFactura=" + IdFactura +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", IdEmpleado=" + IdEmpleado +
                ", precio=" + precio +
                '}';
    }

    @Override
    public String insert() {
        String sql = "INSERT INTO public.factura(id_factura, nombre_empleado, id_empleado,precio) VALUES ("
                + IdFactura +", '"
                + nombreEmpleado.trim() + "','"
                + IdEmpleado +"','"+
                + precio+"');";

        System.out.println(sql);
        return sql;
    }

    @Override
    public String read() {
        return "SELECT * FROM factura";
    }

    @Override
    public String update() {
        String sql = "UPDATE public.factura SET id_factura= '"+IdFactura
                +"', nombre_empleado='"+nombreEmpleado.trim()
                +"', id_empleado='"+IdEmpleado+"', precio='"+precio+
                "' WHERE id_factura = " + IdFactura;
        System.out.println(sql);
        return sql;
    }

    @Override
    public String delete() {
        return "DELETE FROM factura WHERE id_factura = " + IdFactura;
    }

    @Override
    public String findById() {
        return "SELECT * FROM factura WHERE id_factura = " + IdFactura;
    }
}
