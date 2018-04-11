<head>
    <%@include file="/WEB-INF/view/common/directives.jsp" %>
    <spring:url value="/resources/" var="resourcesUrl"/>
   <%--<link href="${resourcesUrl}css/style.css" rel="stylesheet" type="text/css"/>--%>

    <spring:url var="urlHome" value="/" scope="request" />
    <input type="hidden" id="inp_url_home" value="${urlHome}" />
</head>