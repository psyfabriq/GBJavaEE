<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>	
	<ul>
		<%
			ArrayList<String> navigate = (ArrayList<String>) request.getAttribute("navigatemenu");
			for (String link : navigate) {
		%>
		    <li><%=link%></li>
		    
		<%}%>
	</ul>