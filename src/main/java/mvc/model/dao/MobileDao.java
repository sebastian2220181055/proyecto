package mvc.model.dao;

import Container.LinkedQueue;
import mvc.model.client.Dto;
import mvc.model.client.Mobile;
import mvc.server.dataBaseConnection.DataSource;
import mvc.server.dataBaseConnection.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class MobileDao extends Dao<Mobile> {

    private Mobile mobile;

    public MobileDao() {
        super(DataSource.getInstance());
    }

    public LinkedQueue<Mobile> read() {
        DataSource dataSource = DataSource.getInstance();
        Mobile data = new Mobile();
        ResultSet resultSet = dataSource.runQuery(data.read());
        LinkedQueue<Mobile> mobileList = new LinkedQueue<>();
        try {
            while (resultSet.next()) {
                mobileList.enqueue(getData(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mobileList;
    }

    private Mobile getData(ResultSet resultSet) throws SQLException {


        return new Mobile(resultSet.getInt("idCelular"),
                resultSet.getString("marca"),
                resultSet.getString("modelo"),
                resultSet.getInt("precio"),
                resultSet.getString("stock"),
                resultSet.getString("descripcion"));


    }

    @Override
    public Mobile findById(Dto data) {
        DataSource dataSource = DataSource.getInstance();
        ResultSet resultSet = dataSource.runQuery(data.findById());
        Mobile mobile = null;
        try {
            while (resultSet.next()) {
                mobile = getData(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mobile;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }
    /*   public MobileDao() {
        super( DataSource.getInstance());
        Entity<Mobile> mobileEntity=new Entity<>(Mobile.class);
    }

    @Override
    public LinkedQueue<Mobile> read() {

        /*LinkedQueue<Mobile> personLinkedQueue= new LinkedQueue<>();
        DataSource         dataSource = DataSource.getInstance();
        Mobile             data       = new Mobile();
        ResultSet resultSet  = dataSource.runQuery(data.read());
        LinkedQueue<Mobile> mobileList = new LinkedQueue<>();
        try {
            while (resultSet.next()) {
                mobileList.enqueue(getData(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mobileList;*/

 /*       DataSource         dataSource = DataSource.getInstance();
        Mobile data       = new Mobile();
        ResultSet resultSet  = dataSource.runQuery(data.read());
        Entity<Mobile> queue=new Entity<>(Mobile.class);
        LinkedQueue mobileList;
        mobileList= queue.getMultipleRows(resultSet);
        return mobileList;



    }



    @Override
    public Mobile findById(Dto data) {
        /*DataSource dataSource = DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        Mobile     mobile     = null;
        try {
            while (resultSet.next()) {
                mobile = getData(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mobile;*/
  /*      DataSource dataSource = DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        Mobile     mobile;
        Entity<Mobile> supplierEntity=new Entity<>(Mobile.class);
        mobile=supplierEntity.getSingleRow(resultSet);

        return mobile;
    }

    private Mobile getData(ResultSet resultSet) throws SQLException {
        return new Mobile(resultSet.getInt("idCelular"),
                resultSet.getString("marca"),
                resultSet.getString("modelo"),
                resultSet.getInt("precio"),
                resultSet.getString("stock"),
                resultSet.getString("descripcion"));
    }

   */
}
