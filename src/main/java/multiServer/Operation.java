package multiServer;

import Container.LinkedQueue;
import mvc.model.client.Dto;
import mvc.server.dataBaseConnection.DataSource;
import mvc.server.dataBaseConnection.Entity;

import java.sql.ResultSet;

public class Operation {
    private TypeOperation typeOperation;

    public static Object doOperation(RequestDataBase requestDataBase, Entity entity){

        if(requestDataBase.getOperation().equals(TypeOperation.SELECT)){
            LinkedQueue<Dto> list =  entity.getMultipleRows(DataSource.getInstance().runQuery(requestDataBase.getQuery()));
            return list;
        }else if(requestDataBase.getOperation().equals(TypeOperation.FIND_ID)) {
            Dto object = entity.getSingleRow(DataSource.getInstance().runQuery(requestDataBase.getQuery()));
            return object;
        }
        else  if(requestDataBase.getOperation().equals(TypeOperation.BYE)) {
            return null;
        }
        else{
            ResultSet answer = DataSource.getInstance().runQuery(requestDataBase.getQuery());
            return  answer;
        }
    }
}
