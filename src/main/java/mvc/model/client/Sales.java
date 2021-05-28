package mvc.model.client;


import java.io.Serializable;

public class Sales implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;
    private int id;
    private int ventasMensuales;
    private String tipoComprador;

    public Sales(int id, int ventasMensuales, String tipoComprador) {
        id = id;
        this.ventasMensuales = ventasMensuales;
        this.tipoComprador = tipoComprador;
    }

    public Sales(int id) {
        this.id = id;
    }

    public Sales() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVentasMensuales() {
        return ventasMensuales;
    }

    public void setVentasMensuales(int ventasMensuales) {
        this.ventasMensuales = ventasMensuales;
    }

    public String getTipoComprador() {
        return tipoComprador;
    }

    public void setTipoComprador(String tipoComprador) {
        this.tipoComprador = tipoComprador;
    }

    @Override
    public String toString() {
        return "ventas{" +
                "id=" + id +
                ", ventasMensuales=" + ventasMensuales +
                ", tipoComprador='" + tipoComprador + '\'' +
                '}';
    }

    @Override
    public String insert() {
        String sql = "INSERT INTO public.ventas(id, ventasMensuales, tipoComprador) VALUES ("
                + id +", '"
                + ventasMensuales + "','"
                + tipoComprador.trim()
                + "');";
        System.out.println(sql);
        return sql;
    }

    @Override
    public String read() {
        return "SELECT * FROM ventas";
    }

    @Override
    public String update() {
        String sql = "UPDATE public.ventas SET id= '"+id
                +"', ventasMensuales='"+ventasMensuales
                +"', tipoComprador='"+tipoComprador.trim()+
                 "' WHERE id = " + id;
        System.out.println(sql);
        return sql;
    }

    @Override
    public String delete() {
        return "DELETE FROM ventas WHERE id = " + id;
    }

    @Override
    public String findById() {
        return "SELECT * FROM ventas WHERE id = " + id;
    }
}
