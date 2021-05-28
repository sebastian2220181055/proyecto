package mvc.model.dao;

import Container.LinkedQueue;
import mvc.model.client.Dto;
import mvc.model.client.Sales;
import mvc.server.dataBaseConnection.DataSource;
import mvc.server.dataBaseConnection.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesDao extends Dao<Sales>
{
    public SalesDao() {
        super(DataSource.getInstance());
    }

 /*   public SalesDao() {
        super( DataSource.getInstance());
        Entity<Sales> salesEntityEntity=new Entity<>(Sales.class);
    }

    @Override
    public LinkedQueue<Sales> read() {
        /*LinkedQueue<Sales> personLinkedQueue= new LinkedQueue<>();
        DataSource         dataSource = DataSource.getInstance();
        Sales             data       = new Sales();
        ResultSet resultSet  = dataSource.runQuery(data.read());
        LinkedQueue<Sales> salesList = new LinkedQueue<>();
        try {
            while (resultSet.next()) {
                salesList.enqueue(getData(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return salesList;*/
 /*       DataSource         dataSource = DataSource.getInstance();
        Sales data       = new Sales();
        ResultSet resultSet  = dataSource.runQuery(data.read());
        Entity<Sales> queue=new Entity<>(Sales.class);
        LinkedQueue salesList= queue.getMultipleRows(resultSet);
        return salesList;
    }

    @Override
    public Sales findById(Dto data) {
        /*DataSource dataSource = DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        Sales     sales     = null;
        try {
            while (resultSet.next()) {
                sales = getData(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sales;*/
 /*       DataSource dataSource = DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        Sales     sale;
        Entity<Sales> supplierEntity=new Entity<>(Sales.class);
        sale=supplierEntity.getSingleRow(resultSet);

        return sale;
    }

    private Sales getData(ResultSet resultSet) throws SQLException {
        return new Sales(resultSet.getInt("id"),
                resultSet.getInt("ventasMensuales"),
                resultSet.getString("tipoComprador"));
    }

  */
}
