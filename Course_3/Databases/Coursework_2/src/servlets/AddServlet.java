package servlets;

import com.mongodb.MongoClient;
import dao.MongoDBObjectDAO;
import model.BookingInfo;
import model.MongoObject;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

//@WebServlet("/add")
public class AddServlet extends HttpServlet {

    private static final long serialVersionUID = -7060758261496829905L;
    private final SimpleDateFormat sm = new SimpleDateFormat("yyyy-mm-dd");

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String clazz = request.getParameter("clazz");
        MongoObject mongoObject = null;
        try {
            mongoObject = ((Class<? extends MongoObject>) Class.forName("model." + clazz)).newInstance();

            for (String s : ((Class<? extends MongoObject>) Class.forName("model." + clazz))
                    .newInstance().getParams()) {
                if (request.getParameter(s) != null && request.getParameter(s) != "") {
                    BeanUtils.setProperty(mongoObject, s, request.getParameter(s));
                } else if (!s.equals("id")) {
                    request.setAttribute("error", "Mandatory Parameters Missing");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher(
                            "/" + clazz.toLowerCase() + "s" + ".jsp");
                    rd.forward(request, response);
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        MongoDBObjectDAO dbObjectDAO = new MongoDBObjectDAO(mongo, clazz);
        if (mongoObject.getForeign_keys() != null) {
            HashMap<String, String> foreign_keys = mongoObject.getForeign_keys();
            for (String s : foreign_keys.keySet()) {
                MongoDBObjectDAO mongoDBObjectDAO = new MongoDBObjectDAO(mongo, foreign_keys.get(s));
//                    mongoDBObjectDAO.createReference(mongo, BeanUtils.getProperty(mongoObject, s), foreign_keys.get(s));
            }
        }
//        dbObjectDAO.createMongoObject(mongoObject);
        System.out.println("Object Added Successfully with id=" + mongoObject.getId());
        request.setAttribute("success", "Object Added Successfully");
        List<BookingInfo> mongoObjects = dbObjectDAO.readAllMongoObjects(clazz);
        request.setAttribute(clazz.toLowerCase() + "s", mongoObjects);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/" + clazz.toLowerCase() + "s" + ".jsp");
        rd.forward(request, response);
    }
}
