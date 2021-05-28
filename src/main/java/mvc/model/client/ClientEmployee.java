package mvc.model.client;

import java.io.Serializable;

public class ClientEmployee implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;
    private int cedulaCliente;
    private int idEmpleado;
    private String cargo;
    private double descuento;

    public ClientEmployee(int cedulaCliente, int idEmpleado, String cargo, double descuento) {
        this.cedulaCliente = cedulaCliente;
        idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.descuento = descuento;
    }

    public ClientEmployee() {
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "ClientEmployee{" +
                "cedulaCliente=" + cedulaCliente +
                ", IdEmpleado=" + idEmpleado +
                ", cargo='" + cargo + '\'' +
                ", descuento=" + descuento +
                '}';
    }

    @Override
    public String insert() {
        String sql = "INSERT INTO public.cliente_empleado(cedula_cliente, cargo, descuento) VALUES ("
                + cedulaCliente+", '"
                + idEmpleado + "','"
                + cargo.trim() +"','"+
                + descuento+"');";

        System.out.println(sql);
        return sql;
    }

    @Override
    public String read() {
        return "SELECT * FROM cliente_empleado";
    }

    @Override
    public String update() {
        String sql = "UPDATE public.cliente_empleado SET cedula_cliente= '"+cedulaCliente
                +"', ventasMensuales='"+idEmpleado
                +"', cargo='"+cargo.trim()+
                "', descuento='"+descuento+
                "' WHERE id_empleado = " + idEmpleado;
        System.out.println(sql);
        return sql;
    }

    @Override
    public String delete() {
        return "DELETE FROM cliente_empleado WHERE id_empleado = " + idEmpleado;
    }

    @Override
    public String findById() {
        return "SELECT * FROM cliente_empleado WHERE id_empleado = " + idEmpleado;
    }
}
