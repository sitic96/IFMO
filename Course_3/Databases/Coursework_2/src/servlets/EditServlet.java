package servlets;

import com.mongodb.MongoClient;
import dao.MongoDBObjectDAO;
import model.MongoObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    private static final long serialVersionUID = -6554920927964049383L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String clazz = request.getParameter("clazz");
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for edit operation");
        }
        System.out.println("Host edit requested with id=" + id);
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        MongoDBObjectDAO dbObjectDAO = new MongoDBObjectDAO(mongo, clazz);
        MongoObject mongoObject = null;
        try {
            mongoObject = ((Class<? extends MongoObject>) Class.forName("model." + clazz)).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        mongoObject.setId(id);
        mongoObject = dbObjectDAO.readMongoObject(mongoObject, clazz);
        request.setAttribute(clazz, mongoObject);
        List<MongoObject> mongoObjects = dbObjectDAO.readAllMongoObjects(clazz);
        request.setAttribute(clazz + "s", mongoObjects);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/" + clazz.toLowerCase() + "s" + ".jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String clazz = request.getParameter("clazz");
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for edit operation");
        }
        System.out.println("Host edit requested with id=" + id);
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        MongoDBObjectDAO dbObjectDAO = new MongoDBObjectDAO(mongo, clazz);
        MongoObject mongoObject = null;
        try {
            mongoObject = ((Class<? extends MongoObject>) Class.forName("model." + clazz)).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        mongoObject.setId(id);
        mongoObject = dbObjectDAO.readMongoObject(mongoObject, clazz);
        request.setAttribute(clazz, mongoObject);
        List<MongoObject> mongoObjects = dbObjectDAO.readAllMongoObjects(clazz);
        request.setAttribute(clazz + "s", mongoObjects);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/" + clazz.toLowerCase() + "s" + ".jsp");
        rd.forward(request, response);
    }
}