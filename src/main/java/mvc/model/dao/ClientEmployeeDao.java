package mvc.model.dao;

import Container.LinkedQueue;
import mvc.model.client.Dto;
import mvc.model.client.ClientEmployee;
import mvc.server.dataBaseConnection.DataSource;
import mvc.server.dataBaseConnection.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientEmployeeDao extends Dao<ClientEmployee>
{
    public ClientEmployeeDao() {
        super(DataSource.getInstance());
    }
    /*  public ClientEmployeeDao() {
        super( DataSource.getInstance());
        Entity<ClientEmployee> clientEmployeeEntityEntity=new Entity<>(ClientEmployee.class);
    }


    @Override
    public LinkedQueue<ClientEmployee> read() {

       /* DataSource         dataSource = DataSource.getInstance();
        ClientEmployee             data       = new ClientEmployee();
        ResultSet resultSet  = dataSource.runQuery(data.read());
        LinkedQueue<ClientEmployee> clientEmployeeList = new LinkedQueue<>();
        try {
            while (resultSet.next()) {
                clientEmployeeList.enqueue(getData(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clientEmployeeList;*/
  /*      DataSource         dataSource = DataSource.getInstance();
        ClientEmployee data       = new ClientEmployee();
        ResultSet resultSet  = dataSource.runQuery(data.read());
        Entity<ClientEmployee> queue=new Entity<>(ClientEmployee.class);
        LinkedQueue clientEmployeeList;
       clientEmployeeList= queue.getMultipleRows(resultSet);
        return clientEmployeeList;
    }

    @Override
    public ClientEmployee findById(Dto data) {
        /*DataSource dataSource = DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        ClientEmployee     clientEmployee     = null;
        try {
            while (resultSet.next()) {
                clientEmployee = getData(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clientEmployee;*/

   /*     DataSource dataSource = DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        ClientEmployee clientEmployee;
        Entity<ClientEmployee> supplierEntity=new Entity<>(ClientEmployee.class);
        clientEmployee=supplierEntity.getSingleRow(resultSet);

        return clientEmployee;

    }

    private ClientEmployee getData(ResultSet resultSet) throws SQLException {
        return new ClientEmployee(resultSet.getInt("cedulaCliente"),
                resultSet.getInt("idEmpleado"),
                resultSet.getString("cargo"),
                resultSet.getDouble("descuento"));
    }

    */

}
