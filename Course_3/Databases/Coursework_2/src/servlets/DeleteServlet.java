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

public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 6798036766148281767L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for delete operation");
        }
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        MongoDBObjectDAO dbObjectDAO = new MongoDBObjectDAO(mongo);
        BookingInfo mongoObject = null;
        mongoObject = new BookingInfo();

        mongoObject.setId(id);
        dbObjectDAO.deleteMongoObject(mongoObject);
        System.out.println("Host deleted successfully with id=" + id);
        request.setAttribute("success", "Host deleted successfully");
        Set<BookingInfo> mongoObjects = dbObjectDAO.readAllMongoObjects();
        request.setAttribute("bookinginfos", mongoObjects);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/" + "bookinginfos"+ ".jsp");
        rd.forward(request, response);
    }
}
