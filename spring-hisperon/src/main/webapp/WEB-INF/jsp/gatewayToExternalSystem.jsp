<!-- Header -->
<%@include file="/WEB-INF/jsp/common/header.jsp"%>

<body>
 <a onclick="gotoExternalSystem()">Enlace a Sistema Externo</a>

 <form action="http://localhost:8080/spring-crios-1.0-SNAPSHOT/login" method="post" id="formExternalSystem">
     <input type="hidden" id="username" name="username" value="user111"/>
     <input type="hidden" id="password" name="password" value="password"/>
 </form>

<script>
 function gotoExternalSystem() {
      document.getElementById("formExternalSystem").submit();
 }
</script>
</body>

