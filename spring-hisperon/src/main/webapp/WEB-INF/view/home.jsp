<!-- Header -->
<%@include file="/WEB-INF/view/common/header.jsp"%>

<!--Custom Content Page -->
${name}

jquery.js?v=0.8

<button type="button" id="idButtonListStudent">Mostrar Tabla por ajax</button>

<table class="tableTest" id="idTableStudentAjax">
</table>


<!-- Define custom JavaScript-->
<c:set var="specificsJS" value="insertStudent.js"/>

<!-- Footer -->
<%@include file="/WEB-INF/view/common/footer.jsp"%>