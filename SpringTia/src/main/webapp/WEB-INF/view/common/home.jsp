<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 10/26/2016
  Time: 10:17 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Test</title>
</head>
<body>
<script src="https://gist.github.com/xalfonso/93e1faf2d81501e088f4edc32c41dc7d.js"></script>
<p>Testttttttttttttttttttt Module: Common</p>
<f:form modelAttribute="student">
    <f:select path="country">
        <f:options items="${countries}"/>
    </f:select>
</f:form>
</body>
</html>
