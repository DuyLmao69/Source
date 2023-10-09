<%@ page language="java" 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Calendar" %>
<%
	GregorianCalendar currentDate = new GregorianCalendar();
	int currentYear = currentDate.get(Calendar.YEAR);
%>
<p> © Copyright ${currentYear} Mike Murach & Associates </p>
            </nav>        
        </div>
	</body>
</html>
