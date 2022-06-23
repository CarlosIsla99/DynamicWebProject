<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servlets.modelos.Coche"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h1 class="text-center mb-5">Todos los coches</h1>
<table class="table table-dark table-hover text-center">
  <thead>
    <tr>
    <c:if test="${sessionScope.usuario.rol == 'ADMIN'}">
    <th scope="col">ID</th>
    </c:if>
      <th scope="col">MATRÍCULA</th>
      <th scope="col">MARCA</th>
      <th scope="col">MODELO</th>
      <th scope="col">COLOR</th>
      <th scope="col">POTENCIA</th>
      <th scope="col">CILINDRADA</th>
      <th scope="col">OPCIONES</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${coches}" var="coche">
    <tr>
    <c:if test="${sessionScope.usuario.rol == 'ADMIN'}">
      <td>${coche.id}</td>
    </c:if>
      <td>${coche.matricula}</td>
      <td>${coche.marca}</td>
      <td>${coche.modelo}</td>
      <td>${coche.color}</td>
      <td>${coche.potencia}</td>
      <td>${coche.cilindrada}</td>
		<td>
		<c:choose>
         <c:when test="${sessionScope.usuario.rol == 'ADMIN'}">
         	<a href="admin/coche?id=${coche.id}" type="button" class="btn btn-secondary">Ver</a>
            <a href="admin/formulario?id=${coche.id}" type="button" class="btn btn-primary">Editar</a>
      		<a href="admin/borrar?id=${coche.id}" type="button" class="btn btn-danger">Borrar</a>
         </c:when>
         <c:otherwise>
           <a href="admin/coche?id=${coche.id}" type="button" class="btn btn-secondary">Ver</a>
           <a href="admin/reservaFormulario?email=${sessionScope.usuario.email}&idCoche=${coche.id}" type="button" class="btn btn-success">Reservar</a>
         </c:otherwise>
      	</c:choose>
      	</td>
    </tr>
  </c:forEach>
  </tbody>
</table>

      <c:if test="${sessionScope.usuario.rol == 'ADMIN'}">
		<td>
      		<div class="text-center">
				<a href="admin/formulario" type="button" class="btn btn-success text-center mt-3">Añadir</a>
			</div>
      	</td>
	  </c:if>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>