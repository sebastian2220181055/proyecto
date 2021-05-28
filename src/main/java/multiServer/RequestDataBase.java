package multiServer;

import mvc.model.client.Dto;

import java.io.Serializable;

public class RequestDataBase <T extends Dto> implements Serializable {
    private static final long       serialVersionUID = 916582397570182364L;

    private  Class entity;
    private  String query;
    private  TypeOperation operation;

    public RequestDataBase(Class entity, String query, TypeOperation operation) {
        this.entity = entity;
        this.query = query;
        this.operation = operation;
    }

    public void setEntity(Class entity) {
        this.entity = entity;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setOperation(TypeOperation operation) {
        this.operation = operation;
    }

    public Class<Dto> getEntity() {
        return entity;
    }

    public TypeOperation getOperation() {
        return operation;
    }

    public String getQuery() {
        return query;
    }

    @Override
    public String toString() {
        return "RequestDataBase{" +
                "entity=" + entity +
                ", query='" + query + '\'' +
                ", operation=" + operation +
                '}';
    }
}
