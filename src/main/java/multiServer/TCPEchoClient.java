package multiServer;

import Container.LinkedQueue;
import mvc.model.client.ClientEmployee;
import mvc.model.client.Dto;
import multiServer.RequestDataBase;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

public class TCPEchoClient
{
    private InetAddress host;
    private static final int PORT = 1234;
    private Socket socket = null;
    ObjectInputStream in;
    ObjectOutputStream out;
    RequestDataBase requestDataBase;
    static LinkedQueue<Dto> lista;

    public RequestDataBase getRequestDataBase(){return requestDataBase;}
    public void setRequestDataBase(RequestDataBase requestDataBase){this.requestDataBase = requestDataBase;}

    /*public static void main(String[] args) {
        new TCPEchoClient();
    }

     */

    public TCPEchoClient() {



        System.out.println("Opening port");
        try
        {
            host = InetAddress.getLocalHost();

            socket = new Socket(host, PORT);

            out = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (UnknownHostException e)
        {
            System.out.println("Host not found!");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
       // run();
    }

    public void run() {

        try
        {

            out.writeObject(requestDataBase);

            in = new ObjectInputStream(socket.getInputStream());

            lista = (LinkedQueue<Dto>) in.readObject();


        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
    public LinkedQueue<Dto> getLista() {
        return lista;
    }

    public void setLista(LinkedQueue<Dto> lista) {
        this.lista = lista;
    }
}