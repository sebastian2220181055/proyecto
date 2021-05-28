package mvc.server.dto;

import mvc.model.client.Dto;

import java.io.Serializable;

public class Mobile implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;
    private int idCelular;
    private String marca;
    private String modelo;
    private int precio;
    private String stock;
    private String descripcion;

    public Mobile(int idCelular, String marca, String modelo, int precio, String stock, String descripcion) {
        this.idCelular = idCelular;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    public Mobile() {
    }

    public int getIdCelular() {
        return idCelular;
    }

    public void setIdCelular(int idCelular) {
        this.idCelular = idCelular;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "idCelular='" + idCelular + '\'' +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", stock='" + stock + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public String insert() {
        String sql = "INSERT INTO public.celular(Id_celular, marca, modelo, precio, stock, descripcion) VALUES ("
                + idCelular +", '"
                + marca.trim() + "','"
                + modelo.trim() + "','" + descripcion.trim() + "','" + stock.trim() + "','" + precio
                + "');";
        System.out.println(sql);
        return sql;
    }

    @Override
    public String read() {
        return "SELECT * FROM celular";
    }

    @Override
    public String update() {
        String sql = "UPDATE public.celular SET id_celular= '"+idCelular
                +"', precio='"+precio
                +"', marca='"+marca.trim()
                +"', modelo='"+modelo.trim()
                +"', descripcion='"+descripcion.trim()
                +"', stock='"+stock.trim()+
                "' WHERE Id_celular = " + idCelular;
        System.out.println(sql);
        return sql;
    }

    @Override
    public String delete() {
        return "DELETE FROM celular WHERE id_celular = " + idCelular;
    }

    @Override
    public String findById() {
        return "SELECT * FROM celular WHERE id_celular = " + idCelular;
    }
}
