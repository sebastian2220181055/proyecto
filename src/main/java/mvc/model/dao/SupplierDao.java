package mvc.model.dao;

import Container.LinkedQueue;
import mvc.model.client.Dto;
import mvc.model.client.Supplier;
import mvc.server.dataBaseConnection.DataSource;
import mvc.server.dataBaseConnection.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierDao extends Dao<Supplier>
{
    public SupplierDao() {
        super(DataSource.getInstance());
    }

 /*   public SupplierDao() {
        super( DataSource.getInstance());
        //Entity<Supplier> supplierEntity=new Entity<>(Supplier.class);
    }


    @Override
    public LinkedQueue<Supplier> read() {

        /*DataSource         dataSource = DataSource.getInstance();
        Supplier             data       = new Supplier();
        ResultSet resultSet  = dataSource.runQuery(data.read());
        LinkedQueue<Supplier> supplierList = new LinkedQueue<>();
        try {
            while (resultSet.next()) {
                supplierList.enqueue(getData(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return supplierList;*/
 /*       DataSource         dataSource = DataSource.getInstance();
        Supplier             data       = new Supplier();
        ResultSet resultSet  = dataSource.runQuery(data.read());
        Entity<Supplier> queue=new Entity<>(Supplier.class);
        LinkedQueue supplierList;
        supplierList= queue.getMultipleRows(resultSet);
        return supplierList;
    }

    @Override
    public Supplier findById(Dto data) {
        /*DataSource dataSource = DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        Supplier     supplier     = null;
        try {
            while (resultSet.next()) {
                supplier = getData(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return supplier;*/
 /*       DataSource dataSource = DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        Supplier     supplier;
        Entity<Supplier> supplierEntity=new Entity<>(Supplier.class);
        supplier=supplierEntity.getSingleRow(resultSet);

        return supplier;

    }

    private Supplier getData(ResultSet resultSet) throws SQLException {
        return new Supplier(resultSet.getInt("nitProveedor"),
                resultSet.getString("nombre"),
                resultSet.getInt("celularesAdquiridos"));
    }

  */
}
