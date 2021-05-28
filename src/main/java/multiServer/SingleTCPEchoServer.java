package multiServer;

import Container.LinkedQueue;
import mvc.model.client.Dto;
import mvc.server.dataBaseConnection.DataSource;
import mvc.server.dataBaseConnection.Entity;

//import javax.sql.DataSource;
import java.io.*;
import java.net.Socket;

public class SingleTCPEchoServer extends Thread
{

    public static final int PORT = 1234;
    private Socket socket = null;
    private DataSource dataSource = null;
    private ObjectInputStream in;
    private ObjectOutputStream out;
   // private ServerSocket servSock;

    public SingleTCPEchoServer(Socket sock, mvc.server.dataBaseConnection.DataSource dataSource)
    {
        this.socket = sock;
        this.dataSource = dataSource;
        try
        {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        start();
    }


    @Override
    public void run(){

        RequestDataBase sql = null;

        try
        {
            do{
                sql = (RequestDataBase) in.readObject();

                System.out.println("Message recived" +" "+sql.toString());

                if(sql.getOperation() != TypeOperation.BYE) {

                    Entity<Dto> entity = new Entity<>(sql.getEntity());
                    LinkedQueue<?> linkedQueue = (LinkedQueue<?>) Operation.doOperation(sql, entity);
                    out.writeObject( linkedQueue);
                }
            }while(sql.getOperation() != TypeOperation.BYE);


            System.out.println("Client disconnected...");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());

        }
        finally
        {
            try
            {
                this.socket.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}





