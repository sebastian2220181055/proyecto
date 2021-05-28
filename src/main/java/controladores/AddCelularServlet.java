package controladores;

import mvc.model.dao.MobileDao;
import mvc.server.dto.Mobile;
import service.MobileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class AddCelularServlet {

  /*  public boolean insertarCelular(int idCelular, String marca, String modelo, int precio, String stock, String descripcion){
        MobileDao mobileDao = new MobileDao();
        Mobile mobile = new Mobile(idCelular,marca,modelo,precio,stock,descripcion);

        mobileDao.insert(mobile);
        if(mobileDao.insert(mobile)){
            return true;
        }
                return false;


    }*/
  private static MobileService todoService = new MobileService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newTodo = request.getParameter("newTodo");
        String category = request.getParameter("category");
        todoService.addTodos(new Todo(UUID.randomUUID().toString(), newTodo, category));
        response.sendRedirect("todo.do");
    }
}
