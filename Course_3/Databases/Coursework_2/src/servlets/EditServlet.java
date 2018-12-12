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
import java.util.Set;

//@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    private static final long serialVersionUID = -6554920927964049383L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for edit operation");
        }
        System.out.println("Host edit requested with id=" + id);
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        MongoDBObjectDAO dbObjectDAO = new MongoDBObjectDAO(mongo);
        BookingInfo bookingInfo = new BookingInfo();

        bookingInfo.setId(id);
        bookingInfo = dbObjectDAO.readMongoObject(bookingInfo);
        request.setAttribute("bookinginfo", bookingInfo);
        Set<BookingInfo> mongoObjects = dbObjectDAO.readAllMongoObjects();
        request.setAttribute("bookinginfo" + "s", mongoObjects);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/" + "bookinginfos" + ".jsp");

        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            throw new ServletException("id missing for edit operation");
        }
        try {
            Cat cat = getCat(request);
            Host host = getHost(request);
            Room room = getRoom(request);
            MongoClient mongo = (MongoClient) request.getServletContext()
                    .getAttribute("MONGO_CLIENT");
            MongoDBObjectDAO mongoDBObjectDAO = new MongoDBObjectDAO(mongo);
            BookingInfo bookingInfo = new BookingInfo(cat, host, room);
            bookingInfo.setId(id);
            mongoDBObjectDAO.updateMongoObject(bookingInfo);
            System.out.println("Booking edited successfully with id=" + id);
            request.setAttribute("success", "Bokking edited successfully");
            Set<BookingInfo> bookingInfos = mongoDBObjectDAO.readAllMongoObjects();
            request.setAttribute("bookinginfos", bookingInfos);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/bookinginfos.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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

