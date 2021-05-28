package mvc.server.dto;

import mvc.model.client.Dto;

import java.io.Serializable;

public class Supplier implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;
    private int nitProveedor;
    private String nombre;
    private int celularesAdquiridos;


    public Supplier(int nitProveedor, String nombre, int celularesAdquiridos) {
        nitProveedor = nitProveedor;
        this.nombre = nombre;
        this.celularesAdquiridos = celularesAdquiridos;
    }

    public Supplier() {
    }

    public int getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(int nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCelularesAdquiridos() {
        return celularesAdquiridos;
    }

    public void setCelularesAdquiridos(int celularesAdquiridos) {
        this.celularesAdquiridos = celularesAdquiridos;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "NitProveedor=" + nitProveedor +
                ", nombre='" + nombre + '\'' +
                ", celularesAdquiridos=" + celularesAdquiridos +
                '}';
    }

    @Override
    public String insert() {
        String sql = "INSERT INTO public.proveedor(nit_proveedor, nombre, celulares_adquiridos) VALUES ("
                + nitProveedor +", '"
                + nombre.trim() + "','"
                + celularesAdquiridos + "');";

        System.out.println(sql);
        return sql;
    }

    @Override
    public String read() {
        return "SELECT * FROM proveedor";
    }

    @Override
    public String update() {
        String sql = "UPDATE public.proveedor SET nit_proveedor= '"+nitProveedor
                +"', nombre='"+nombre.trim()
                +"', celulares_adquiridos='"+celularesAdquiridos+
                "' WHERE nit_proveedor = " + nitProveedor;
        System.out.println(sql);
        return sql;
    }

    @Override
    public String delete() {
        return "DELETE FROM proveedor WHERE nit_proveedor = " + nitProveedor;
    }

    @Override
    public String findById() {
        return "SELECT * FROM proveedor WHERE nit_proveedor = " + nitProveedor;
    }
}
