<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 10/26/2016
  Time: 10:17 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weather Info</title>
</head>
<body>
 <p>Request URL:    ${result.urlRequest}</p>
 <p>Response Status:    ${result.headerResponse.codInfo}</p>
 <p>Response Code:      ${result.headerResponse.cod}</p>
 <p>Response Message:   ${result.headerResponse.message}</p>
 <p>Response Data:      ${result.data}</p>
</body>
</html>
