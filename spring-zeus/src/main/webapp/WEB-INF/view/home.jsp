<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="urlHome" value="${pageContext.request.contextPath}"/>
<input type="hidden" id="inp_url_home" value="${urlHome}"/>


<script src="${urlHome}/webjars/jquery/3.3.1/dist/jquery.min.js" type="text/javascript"></script>
Hello!!!!

<script>
    $(document).ready(function () {
        console.log("The body was loaded OK!");
    });
</script>