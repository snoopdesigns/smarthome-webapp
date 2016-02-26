<%@ page import="java.lang.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="org.snoopdesigns.webapp.DBUtils" %>
<html>
<head><title>webapp</title></head>
<body>
  <%
    ServletContext sc = request.getServletContext();
    DBUtils dbUtils = (DBUtils)sc.getAttribute(DBUtils.class.getName());
  %>
  <table>
    <tr>
      <td><b>Data</b></td>
    </tr>
    <%
      for(String data : dbUtils.getData())
      {
    %>
    <tr>
      <td><%=data%></td>
    </tr>
    <%
      }
    %>
  </table>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
</body>
</html>