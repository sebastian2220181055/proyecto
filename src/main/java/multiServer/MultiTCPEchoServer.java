package multiServer;

//import javax.sql.DataSource;
import mvc.server.dataBaseConnection.DataSource;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiTCPEchoServer
{
    private ServerSocket servSock;
    public static final int PORT = 1234;
    private Socket sock = null;
    DataSource dataSource;

    public static void main(String[] args)
    {
        new MultiTCPEchoServer();
    }

    public MultiTCPEchoServer()
    {

        dataSource = (DataSource) mvc.server.dataBaseConnection.DataSource.getInstance();

        System.out.println("Opening port");

        try
        {
            servSock = new ServerSocket(PORT);
        }
        catch (IOException e)
        {
            System.out.println("Port Error!!!!");
            System.exit(1);
        }

        try
        {
            do
            {
                sock = servSock.accept();
                System.out.println("Client connected");
                new SingleTCPEchoServer( sock, dataSource);
            }
            while (true);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
