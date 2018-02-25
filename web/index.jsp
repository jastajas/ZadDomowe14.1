<%--
  Created by IntelliJ IDEA.
  User: Madi_i_Jack
  Date: 2018-02-23
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Konwerter</title>
  </head>
  <body>
  <h1>Przelicznik metryczny</h1><br/>
  <form class="metric" method="get" action="http://localhost:8080/ConverterServlet">
    <input type="text" placeholder="Metry" name="metry"><br/><br/>
    <input type="text" placeholder="Centymetry" name="centymetry"><br/><br/>
    <input type="text" placeholder="Milimetry" name="milimetry"><br/><br/>
    <input type="submit" value="Przelicz">
  </form><br/>
  <hr/>
  <h1>Przelicznik wag</h1>
  <form class="height" method="post" action="http://localhost:8080/ConverterServlet">
    <input type="text" placeholder="Kilogramy" name="kilogramy"><br/><br/>
    <input type="text" placeholder="Gramy" name="gramy"><br/><br/>
    <input type="text" placeholder="Miligramy" name="miligramy"><br/><br/>
    <input type="submit" value="Przelicz">
  </form><br/>
  </body>
</html>
