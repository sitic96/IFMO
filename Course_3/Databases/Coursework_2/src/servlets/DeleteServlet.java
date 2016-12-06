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

//@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 6798036766148281767L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String clazz = request.getParameter("clazz");
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for delete operation");
        }
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
        dbObjectDAO.deleteMongoObject(mongoObject);
        System.out.println("Host deleted successfully with id=" + id);
        request.setAttribute("success", "Host deleted successfully");
        List<MongoObject> mongoObjects = dbObjectDAO.readAllMongoObjects(clazz);
        request.setAttribute(clazz+"s", mongoObjects);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/" + clazz.toLowerCase() + "s" + ".jsp");
        rd.forward(request, response);
    }
}
