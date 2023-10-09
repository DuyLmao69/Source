package email;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import business.User;
import business.UserDB;

@WebServlet("/emailList")
public class EmailListServlet<Date> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    String url = "/index.jsp";
	    
	    
	    String action = request.getParameter("action");
	    if (action == null) url = "/index.jsp";
	    if (action.equals("add")) {
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String email = request.getParameter("email");
	        String date =request.getParameter("date");
	        String heardFrom = request.getParameter("heardFrom");
	        String wantsUpdates = request.getParameter("wantsUpdates");
	        String contactVia = request.getParameter("contactVia");
	        
	        // process parameters
	        if (heardFrom == null) {
	            heardFrom = "NA";
	        }
	        // Check if wantsUpdates is "Yes" or "No" based on the radio button value
	     // Check if wantsUpdates is "Yes" or "No" based on the radio button value
	        if ("Yes".equals(wantsUpdates)) {
	            wantsUpdates = "Yes";
	        } else if ("No".equals(wantsUpdates)) {
	            wantsUpdates = "No";
	            contactVia = null;
	        } 
	        
	        // store data in User object
	        User user = new User();
	        user.setFirstName(firstName);
	        user.setLastName(lastName);
	        user.setEmail(email);
	        user.getDate(date);
	        user.setHeardFrom(heardFrom);        
	        user.setWantsUpdates(wantsUpdates);
	        user.setContactVia(contactVia);

			// get current year and set it as an attribute of the request object
			GregorianCalendar currentDate = new GregorianCalendar();
			int currentYear = currentDate.get(Calendar.YEAR);
			request.setAttribute("currentYear", currentYear);
	        
	        // store User object in request
	        request.setAttribute("user", user);

		// forward request to JSP
		url = "/thanks.jsp";
	    }
	    getServletContext()
	            .getRequestDispatcher(url)
	            .forward(request, response);
	}
}
