package mvc.controller;

import multiServer.RequestDataBase;
import multiServer.TCPEchoClient;

public class    ControllerForClient
{
    private static ControllerForClient controllerForClient = null;
    private static TCPEchoClient tcpEchoClient = null;

    private ControllerForClient(RequestDataBase requestDataBase)
    {

        //inicializa el socket del cliente y manda la peticion al builObject
        tcpEchoClient = new TCPEchoClient();
        tcpEchoClient.setRequestDataBase(requestDataBase);
    }

    public static ControllerForClient getInstance(RequestDataBase requestDataBase)
    {
        if(controllerForClient != null)
        {
            tcpEchoClient.setRequestDataBase(requestDataBase);
            return controllerForClient;
        }
        else
        {
            return new ControllerForClient(requestDataBase);
        }
    }

    public static void runClient()
    {
        tcpEchoClient.run();
    }

}
