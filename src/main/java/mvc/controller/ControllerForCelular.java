package mvc.controller;

import Container.LinkedQueue;
import multiServer.TypeOperation;
import mvc.model.client.Client;
import mvc.model.client.Mobile;
import mvc.model.dao.MobileDao;

public class ControllerForCelular
{
    public static void ControllerForDeleteCelular(int id) {

        Mobile faculty = new Mobile();
        faculty.setIdCelular(id);

        ControllerBuildObject.crearObjeto(Mobile.class, faculty.delete(), TypeOperation.DELETE);
        ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
        ControllerForClient.runClient();
    }

    public static void ControllerForAddCelular(Mobile celular) {

        ControllerBuildObject.crearObjeto(Mobile.class, celular.insert(), TypeOperation.INSERT);
        ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
        ControllerForClient.runClient();

    }

    public static void ControllerForUpdateCelular(Mobile celular){
        ControllerBuildObject.crearObjeto(Client.class, celular.update(), TypeOperation.UPDATE);

        ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
        ControllerForClient.runClient();
    }

    public static LinkedQueue<Mobile> ControllerForReadCelular() {

        Mobile mobileDto = new Mobile();
        MobileDao mobileDao = new MobileDao();

        return mobileDao.read(mobileDto);
    }
}
