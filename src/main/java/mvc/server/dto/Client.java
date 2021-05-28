package mvc.server.dto;

import mvc.model.client.Dto;

import java.io.Serializable;

public class Client implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;
    private String cedula;
    private String nombre;
    private String apellido;
    private String email;
    private int telefono;
    private String tipoUsuario;
    private int comprasRealizadas;

    public Client(String cedula, String nombre, String apellido, String email, int telefono, String tipoUsuario, int comprasRealizadas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.comprasRealizadas = comprasRealizadas;
    }

    public Client() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void setComprasRealizadas(int comprasRealizadas) {
        this.comprasRealizadas = comprasRealizadas;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Email='" + email + '\'' +
                ", telefono=" + telefono +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", comprasRealizadas=" + comprasRealizadas +
                '}';
    }

    @Override
    public String insert() {
        String sql = "INSERT INTO public.cliente(cedula, nombre, apellido, email, telefono, tipoUsuario, comprasRealizadas) VALUES ("
                + cedula +", '"
                + nombre.trim() + "','"
                + apellido.trim()+ "','"
                + email.trim()+ "','"
                + telefono+ "','"
                + tipoUsuario.trim()+ "','"
                + comprasRealizadas
                + "');";
        System.out.println(sql);
        return sql;
    }

    @Override
    public String read() {
        return "SELECT * FROM cliente";
    }

    @Override
    public String update() {
        String sql = "UPDATE public.cliente SET cedula= '"+cedula.trim()
                +"', nombre='" + nombre.trim()
                +"', apellido='" + apellido.trim()
                +"', email= '"+email.trim()
                +"', telefono='"+ telefono
                +"', tipoUsuario='"+ tipoUsuario.trim()
                +"', comprasRealizadas='"+ comprasRealizadas+
                "' WHERE cedula = " + cedula;
        System.out.println(sql);
        return sql;
    }

    @Override
    public String delete() {
        return "DELETE FROM cliente WHERE cedula = " + cedula;
    }

    @Override
    public String findById() {
        return "SELECT * FROM cliente WHERE cedula = " + cedula;
    }
}

