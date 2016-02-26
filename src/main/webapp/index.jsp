<%@ page import="java.lang.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="org.snoopdesigns.smarthome.data.*" %>
<html>
<head><title>webapp</title></head>
<body>
  <%
    ServletContext sc = request.getServletContext();
    DBUtils dbUtils = (DBUtils)sc.getAttribute(DBUtils.class.getName());
  %>
  <table border="1">
    <tr>
      <td><b>Timestamp</b></td>
      <td><b>Voltage 1</b></td>
      <td><b>Voltage 2</b></td>
      <td><b>Temperature</b></td>
      <td><b>Humidity</b></td>
    </tr>
    <%
      for(Data data : dbUtils.getData())
      {
    %>
    <tr>
      <td><%=data.getTimestamp()%></td>
      <td><%=data.getVoltage1()%></td>
      <td><%=data.getVoltage2()%></td>
      <td><%=data.getTemperature()%></td>
      <td><%=data.getHumidity()%></td>
    </tr>
    <%
      }
    %>
  </table>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
</body>
</html>