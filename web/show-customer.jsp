<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customers</title>
  </head>
  <body>
    <h1>Customers</h1>
    <hr/>
    <p>${customerId}</p>
    <table>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Total</th>
      </tr>
      <c:forEach var="customer" items="${customers}">
        <tr>
          <td>${customer.id}</td>
          <td>${customer.name}</td>
          <td>${customer.total}</td>
        </tr>
      </c:forEach>
    </table>
    <hr/>
    <a href="create-customer.jsp">Create a new customer</a>
  </body>
</html>
