package ticketBooking;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/StationsServlet")
public class StationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONArray jsonArray = new JSONArray();
		try {
			JDBC con = new JDBC();
			ArrayList<Stations> ass = con.connection();
			for (Stations st : ass) {
				JSONObject js = new JSONObject();
				js.put("From", st.getFrom());
				js.put("to", st.getTo());
				jsonArray.put(js);
			}
		} catch (Exception e) {
		}
		response.getWriter().write(jsonArray.toString());
	}
}