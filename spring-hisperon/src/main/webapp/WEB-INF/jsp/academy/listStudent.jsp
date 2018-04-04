<!-- Header -->
<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<body>
<!--Custom Content Page -->
<spring:url value="/student/insert" var="urlInsertStudent"/>
<a href="${urlInsertStudent}">Insertar Estudiantes</a>

<table class="tableTest">
    <tr>
        <td>Nombre</td>
        <td>Apellidos</td>
        <td>Sexo</td>
        <td>Intereses</td>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>${student.sex}</td>
            <td>${student.interestString}</td>
        </tr>
    </c:forEach>

</table>


<!-- Footer -->
<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>