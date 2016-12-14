package servlets;

import com.mongodb.MongoClient;
import dao.MongoDBObjectDAO;
import model.BookingInfo;
import model.Cat;
import model.Host;
import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Created by sitora on 04.12.16.
 */
@WebServlet("/addnewbooking")
public class AddNewBookingServlet extends HttpServlet {
    private BookingInfo bookingInfo;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bookingInfo = new BookingInfo(
                this.getCat(request),
                this.getHost(request),
                this.getRoom(request));
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        MongoDBObjectDAO dbObjectDAO = new MongoDBObjectDAO(mongo);
        try {
            dbObjectDAO.createMongoObject(bookingInfo);
        }   catch (Exception e) {
            request.setAttribute("error", "Error during insert operation!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/" + "bookinginfo" + "s" + ".jsp");
            rd.forward(request, response);
        }
        System.out.println("Object Added Successfully with id=" + bookingInfo.getId());
        request.setAttribute("success", "Object Added Successfully");
        Set<BookingInfo> mongoObjects = dbObjectDAO.readAllMongoObjects();
        request.setAttribute("bookinginfos", mongoObjects);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/" + "bookinginfo" + "s" + ".jsp");
        rd.forward(request, response);

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
