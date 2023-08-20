package ticketBooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/TrainsServlet")
public class TrainsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			System.out.println(from + "" + to);
			JDBC J = new JDBC();
			ArrayList<Train> at = J.trainconnection(from, to);
			JSONArray jsonArray = new JSONArray();
			for (Train st : at) {
				JSONObject js = new JSONObject();
				js.put("TL", st.getName());
				jsonArray.put(js);
			}
			response.getWriter().write(jsonArray.toString());

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}