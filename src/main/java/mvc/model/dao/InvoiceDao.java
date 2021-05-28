package mvc.model.dao;

import Container.LinkedQueue;
import mvc.model.client.Dto;
import mvc.model.client.Invoice;
import mvc.server.dataBaseConnection.DataSource;
import mvc.server.dataBaseConnection.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceDao extends Dao<Invoice>
{
    public InvoiceDao() {
        super(DataSource.getInstance());
    }

 /*   public InvoiceDao() {
        super( DataSource.getInstance());
        Entity<Invoice> invoiceEntity=new Entity<>(Invoice.class);
    }

    @Override
    public LinkedQueue<Invoice> read() {

        /*DataSource         dataSource = DataSource.getInstance();
        Invoice             data       = new Invoice();
        ResultSet resultSet  = dataSource.runQuery(data.read());
        LinkedQueue<Invoice> invoiceList = new LinkedQueue<>();
        try {
            while (resultSet.next()) {
                invoiceList.enqueue(getData(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return invoiceList;*/
  /*      DataSource         dataSource = DataSource.getInstance();
        Invoice data       = new Invoice();
        ResultSet resultSet  = dataSource.runQuery(data.read());
        Entity<Invoice> queue=new Entity<>(Invoice.class);
        LinkedQueue invoiceList;
        invoiceList= queue.getMultipleRows(resultSet);
        return invoiceList;
    }

    @Override
    public Invoice findById(Dto data) {
        /*DataSource dataSource = DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        Invoice     invoice     = null;
        try {
            while (resultSet.next()) {
                invoice = getData(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return invoice;*/
  /*      DataSource dataSource = DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        Invoice     invoice;
        Entity<Invoice> supplierEntity=new Entity<>(Invoice.class);
        invoice=supplierEntity.getSingleRow(resultSet);

        return invoice;
    }

    private Invoice getData(ResultSet resultSet) throws SQLException {
        return new Invoice(resultSet.getInt("IdFactura"),
                resultSet.getString("nombreEmpleado"),
                resultSet.getInt("IdEmpleado"),
                resultSet.getInt("precio"));
    }

   */
}
