package mvc.model.dao;


import Container.LinkedQueue;
import mvc.model.client.Dto;
import mvc.server.dataBaseConnection.DataSource;
import mvc.server.dataBaseConnection.Entity;

import java.sql.ResultSet;


public abstract class Dao<T extends Dto> {

    private final DataSource dataSource;

    protected Dao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int insert(Dto data) {
        return dataSource.runUpdateQuery(data.insert());
    }

   public LinkedQueue<T> read(Dto data){
       Entity<T> entity = new Entity<T>(data.getClass());
       ResultSet resultSet = dataSource.runQuery(data.read());
       return entity.getMultipleRows(resultSet);
   }

   // public abstract LinkedQueue<T> read();

    public int update(Dto data) {
        return dataSource.runUpdateQuery(data.update());
    }

    public int delete(Dto data) {
        return dataSource.runUpdateQuery(data.delete());
    }

    public  T findById(Dto data){
        Entity<T> entity = new Entity<T>(data.getClass());
        ResultSet resultSet = dataSource.runQuery(data.findById());
        return entity.getSingleRow(resultSet);
    }

}
