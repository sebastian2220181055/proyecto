package mvc.server;

import mvc.model.client.*;
import mvc.model.dao.*;

public class Test {
    public static void main(String[] args) { new Test();}

    public Test() {

        Client client = new Client("1234641217","Duvan","Espinosa","duvanfelipe3@hotmail.com",316,"cliente",1);
        ClientDao clientDao = new ClientDao();
        clientDao.insert(client);

        ClientEmployee clientEmployee = new ClientEmployee(1,1,"Gerente",0.5);
        ClientEmployeeDao clientEmployeeDao = new ClientEmployeeDao();
        clientEmployeeDao.insert(clientEmployee);

        Invoice invoice = new Invoice(2,"Raul", 2,2);
        InvoiceDao invoiceDao = new InvoiceDao();
        invoiceDao.insert(invoice);

        Sales sales = new Sales(3,3,"clienteEmpleado");
        SalesDao salesDao = new SalesDao();
        salesDao.insert(sales);

        Supplier supplier = new Supplier(4,"Movistar",4);
        SupplierDao supplierDao = new SupplierDao();
        supplierDao.insert(supplier);



    }
}
