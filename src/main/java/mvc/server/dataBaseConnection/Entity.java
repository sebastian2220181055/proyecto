package mvc.server.dataBaseConnection;

import Container.LinkedQueue;
import mvc.model.client.Dto;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Entity<T extends Dto> {

    private final Class<? extends Dto> nameOfClass;
    private       Method[]             methodsOfClass;

    public Entity(Class<? extends Dto> nameOfClass) {
        this.nameOfClass = nameOfClass;
        this.methodsOfClass = nameOfClass.getMethods();
    }

    public LinkedQueue<T> getMultipleRows(ResultSet resultSet) {

        LinkedQueue<T> Queue = new LinkedQueue<T>();
        try {
           // methodsOfClass = nameOfClass.getMethods();
            while (resultSet.next()) {
                Queue.enqueue(getData(resultSet));
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return Queue;
    }

    public T getSingleRow(ResultSet resultSet) {

        T dataToReturn = null;
        try {
          //  methodsOfClass = nameOfClass.getMethods();
            while (resultSet.next()) {
                dataToReturn = getData(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataToReturn;
    }

    private T getData(ResultSet resultSet) {

        T dataToReturn = null;
        try {
            dataToReturn = (T) nameOfClass.getConstructor().newInstance();
            ResultSetMetaData metaDataOfClass = resultSet.getMetaData();
            int               numberOfColumns = metaDataOfClass.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++) {
                String methodName = convertToMethodName(metaDataOfClass.getColumnName(i));
                Method method     = searchMethod(methodName, methodsOfClass);
                if (method != null) {
                    setValueToData(dataToReturn, method, resultSet.getObject(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataToReturn;
    }

    private void setValueToData(Object dataTarget, Method method, Object sourceData) {
        try {
            method.invoke(dataTarget, sourceData.getClass().cast(sourceData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String convertToMethodName(String nameAttributeOfTable) {
        String[] words = nameAttributeOfTable.split("_");

        StringBuilder nameToReturn = new StringBuilder();
        nameToReturn.append("set");
        for (String word : words) {
            char[] wordInCharacters = word.toCharArray();
            wordInCharacters[0] = Character.toUpperCase(wordInCharacters[0]);
            nameToReturn.append(new String(wordInCharacters));
        }
        return nameToReturn.toString();
    }

    private Method searchMethod(String columnName, Method[] methodsOfClass) {

        Method methodToReturn = null;
        for (int i = 0; i < methodsOfClass.length && methodToReturn == null; i++) {
            if (methodsOfClass[i].getName().equals(columnName)) {
                methodToReturn = methodsOfClass[i];
            }
        }
        return methodToReturn;
    }

}
