package mvc.model.dao;

import mvc.model.client.Client;
import mvc.server.dataBaseConnection.DataSource;

public class ClientDao extends Dao<Client>
{

    public ClientDao(){
        super(DataSource.getInstance());
    }

  /*  public ClientDao() {
        super( DataSource.getInstance());
        Entity<Client> clientEntity=new Entity<>(Client.class);

    }

    @Override
    public LinkedQueue<Client> read() {

        /*DataSource         dataSource = DataSource.getInstance();
        Client             data       = new Client();
        ResultSet resultSet  = dataSource.runQuery(data.read());
        LinkedQueue<Client> clientList = new LinkedQueue<>();
        try {
            while (resultSet.next()) {
                clientList.enqueue(getData(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clientList;*/
   /*     DataSource         dataSource = DataSource.getInstance();
        Client data       = new Client();
        ResultSet resultSet  = dataSource.runQuery(data.read());
        Entity<Client> queue=new Entity<>(Client.class);
        LinkedQueue clientList;
        clientList= queue.getMultipleRows(resultSet);
        return clientList;





    }

    @Override
    public Client findById(Dto data) {
        /*DataSource dataSource = DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        Client     client     = null;
        try {
            while (resultSet.next()) {
                client = getData(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return client;*/
    /*    DataSource dataSource = DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        Client client;
        Entity<Client> supplierEntity=new Entity<>(Client.class);
        client=supplierEntity.getSingleRow(resultSet);

        return client;
    }

    private Client getData(ResultSet resultSet) throws SQLException {
        return new Client(resultSet.getString("cedula"),
                resultSet.getString("nombre"),
                resultSet.getString("apellido"),
                resultSet.getString("email"),
                resultSet.getInt("telefono"),
                resultSet.getString("tipoUsuario"),
                resultSet.getInt("comprasRealizadas"));
    }

     */
}
