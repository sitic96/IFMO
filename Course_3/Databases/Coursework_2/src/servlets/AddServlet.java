package servlets;

import com.mongodb.MongoClient;
import dao.MongoDBObjectDAO;
import model.BookingInfo;
import model.Cat;
import model.Host;
import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;

public class AddServlet extends HttpServlet {

    private static final long serialVersionUID = -7060758261496829905L;
    private final SimpleDateFormat sm = new SimpleDateFormat("yyyy-mm-dd");

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        BookingInfo bookingInfo;
        try {
            bookingInfo = new BookingInfo(getCat(request), getHost(request), getRoom(request));

            MongoClient mongo = (MongoClient) request.getServletContext()
                    .getAttribute("MONGO_CLIENT");
            MongoDBObjectDAO dbObjectDAO = new MongoDBObjectDAO(mongo);
            System.out.println("Object Added Successfully with id=" + bookingInfo.getId());
            request.setAttribute("success", "Object Added Successfully");
            Set<BookingInfo> mongoObjects = dbObjectDAO.readAllMongoObjects();
            request.setAttribute("bookinginfos", mongoObjects);

            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/bookinginfos.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("/start");
        }
    }

    private Cat getCat(HttpServletRequest request) {
        Cat cat = new Cat(request.getParameter("catName"),
                request.getParameter("chipNumber"),
                request.getParameter("hostName"),
                request.getParameter("passNumber"),
                request.getParameter("favoriteMeal"));
        return cat;
    }

    private Host getHost(HttpServletRequest request) {
        Host host = new Host(request.getParameter("hostName"),
                request.getParameter("phoneNumber"),
                request.getParameter("hostPass")
        );
        return host;
    }

    private Room getRoom(HttpServletRequest request) {
        Room room = new Room(request.getParameter("roomCategory"),
                Double.parseDouble(request.getParameter("roomPricePerNight"))
        );
        return room;
    }
}
