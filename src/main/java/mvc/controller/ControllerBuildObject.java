package mvc.controller;

import multiServer.RequestDataBase;
import multiServer.TypeOperation;

public class ControllerBuildObject
{
    private static RequestDataBase requestDataBase;

    public static void crearObjeto(Class entity, String sql, TypeOperation typeOperation){


        //modifica el sockets que ya tenemos, evita crear uno nuevo cada vez que hacemos una peticion
        if(requestDataBase == null){
            requestDataBase = new RequestDataBase(entity,sql,typeOperation);
        }
        else{
            requestDataBase.setEntity(entity);
            requestDataBase.setQuery(sql);
            requestDataBase.setOperation(typeOperation);
        }
    }

    public static RequestDataBase getObjetoCreado() {
        return requestDataBase;
    }

    public static void setObjeto(RequestDataBase requestDataBase) {
        ControllerBuildObject.requestDataBase = requestDataBase;
    }

}
