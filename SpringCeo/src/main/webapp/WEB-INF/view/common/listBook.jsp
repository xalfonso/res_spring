<%@include file="/WEB-INF/view/sub/directives.jsp" %>

<%
    String name = "Hola mundo";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><%=name%></p>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Author</th>
        <th>Publishing</th>
        <th>Edition</th>
        <th>Editor</th>
        <th>Pages</th>
        <th>Code</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>Issue#${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publishing}</td>
            <td>${book.edition}</td>
            <td>${book.editor}</td>
            <td>${book.pages}</td>
            <td>${book.code}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
