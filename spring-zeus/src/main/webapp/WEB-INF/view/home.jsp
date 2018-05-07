<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="urlHome" value="${pageContext.request.contextPath}"/>
<input type="hidden" id="inp_url_home" value="${urlHome}"/>

<link rel="stylesheet" type="text/css" href="${urlHome}/webjars/css/test.css"/>

<script src="${urlHome}/webjars/jquery/3.3.1/dist/jquery.min.js" type="text/javascript"></script>
Hello!!!!

<script src="${urlHome}/webjars/js/test.js" type="text/javascript"></script>
<script>
    $(document).ready(function () {
        console.log("The body was loaded OK!");
    });
</script>

<button onclick="fTest()">Probando JS desde JAR</button>