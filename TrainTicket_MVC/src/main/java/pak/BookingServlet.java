package pak;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String train = request.getParameter("train");
		String cls = request.getParameter("class");
		String date = request.getParameter("date");
		String[] no = request.getParameterValues("no");
		String[] name = request.getParameterValues("nam");
		String[] age = request.getParameterValues("age");
		String[] gen = request.getParameterValues("gen");
		System.out.println(from + to);
		StationDAL sd = new StationDAL();
		sd.setData(no, name, age, gen, cls, date, from, to, train);
	}

}
