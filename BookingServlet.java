package ticketBooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from=request.getParameter("from");
		String to = request.getParameter("to");
		String train = request.getParameter("train");
		String cls = request.getParameter("cls");
		String dt = request.getParameter("date");
		String[] name = request.getParameterValues("name");
		String[] age = request.getParameterValues("age");
		String[] gender = request.getParameterValues("gender");
		BookingServletFunction bf = new BookingServletFunction();
		Ticket att=bf.tpassList(from,to,train,cls,dt,name,age,gender);
		request.setAttribute("tdata", att);
		RequestDispatcher rd = request.getRequestDispatcher("/Conformation.jsp");
		rd.forward(request, response);
	}
}
