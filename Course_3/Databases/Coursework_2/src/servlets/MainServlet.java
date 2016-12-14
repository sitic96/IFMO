package servlets;

import com.mongodb.MongoClient;
import dao.MongoDBObjectDAO;
import model.BookingInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Created by sitora on 13.12.16.
 */
public class MainServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        MongoDBObjectDAO dbObjectDAO = new MongoDBObjectDAO(mongo);
        Set<BookingInfo> mongoObjects = dbObjectDAO.readAllMongoObjects();
        request.setAttribute("bookinginfos", mongoObjects);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/" + "bookinginfos" + ".jsp");
        rd.forward(request, response);
    }

}
