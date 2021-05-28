package mvc.controller;

import Container.LinkedQueue;
import multiServer.TypeOperation;
import mvc.model.client.Client;
import mvc.model.dao.ClientDao;
import mvc.view.cliente.ClienteInfoPanel;

public class ControllerForCliente
{
    private static ClienteInfoPanel clienteInfoPanel;

    public static void ControllerForDeleteClient(String cedula) {

        Client clientDto = new Client(cedula);

        ControllerBuildObject.crearObjeto(Client.class, clientDto.delete(), TypeOperation.DELETE);

        ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
        ControllerForClient.runClient();
    }

    public static void ControllerForAddClient(Client client) {

        ControllerBuildObject.crearObjeto(Client.class,client.insert(), TypeOperation.INSERT);

        ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
        ControllerForClient.runClient();

    }

    public static void ControllerForUpdateClient(Client client){

        ControllerBuildObject.crearObjeto(Client.class,client.update(), TypeOperation.UPDATE);

        ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
        ControllerForClient.runClient();
    }

    public static LinkedQueue<Client> ControllerForReadClient() {

        Client player = new Client();
        ClientDao playerDao = new ClientDao();

        return playerDao.read(player);
    }
}
