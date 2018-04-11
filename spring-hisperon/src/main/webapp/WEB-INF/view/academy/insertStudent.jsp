<!-- Header -->
<%@include file="/WEB-INF/view/common/header.jsp" %>

<!--Custom Content Page -->interests
<spring:url value="/student" var="urlListStudent"/>
<a href="${urlListStudent}">Listar Estudiantes</a>
<f:form modelAttribute="student" cssClass="formTest">
    <label>Nombre</label>
    <f:input path="name" placeholder="Nombres"/>
    <label>Apellidos</label>
    <f:input path="surname" placeholder="Apellidos"/>
    <label>Sexo</label>
    <input type="hidden"/>
    <div class="leftRow">
        <label>Masculino</label>
        <f:radiobutton path="sex" value="M"/>
    </div>
    <div class="leftRow">
        <label>Femenino</label>
        <f:radiobutton path="sex" value="F"/>
    </div>
    <label class="leftRow">Intereses</label>
    <div class="leftRow" id="listCheckbox">
        <f:checkboxes path="interest" items="${interests}" />
    </div>
    <div class="leftRow">
      <button type="submit">Enviar</button>
    </div>
</f:form>

<!-- Footer -->
<%@include file="/WEB-INF/view/common/footer.jsp" %>
