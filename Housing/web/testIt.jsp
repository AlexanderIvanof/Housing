<%-- 
    Document   : testIt
    Created on : Jan 27, 2013, 10:52:01 PM
    Author     : alexandr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <title>Count to 10 Example(using JSTL)</title>
  </head>

  <body>
    <c:forEach var="i" begin="1" end="10" step="1">
      <c:out value="i" />

      <br />
    </c:forEach>
      <fmt:formatDate value="${record.eventDate}" pattern="MMMM d, yyyy, H:mm:ss"/>
  </body>
</html>
