<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servlets.modelos.Coche"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h1 class="text-center mb-5">Todos los coches</h1>
<table class="table table-dark table-hover text-center">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">MATRÍCULA</th>
      <th scope="col">MARCA</th>
      <th scope="col">MODELO</th>
      <th scope="col">COLOR</th>
      <th scope="col">POTENCIA</th>
      <th scope="col">CILINDRADA</th>
      <th scope="col">OPERACIONES</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${coches}" var="coche">
    <tr>
      <td>${coche.id}</td>
      <td>${coche.matricula}</td>
      <td>${coche.marca}</td>
      <td>${coche.modelo}</td>
      <td>${coche.color}</td>
      <td>${coche.potencia}</td>
      <td>${coche.cilindrada}</td>
      <td>
      	<a href="admin/coche?id=${coche.id}" type="button" class="btn btn-secondary">Ver</a>
     	<a href="admin/formulario?id=${coche.id}" type="button" class="btn btn-primary">Editar</a>
      	<a href="admin/borrar?id=${coche.id}" type="button" class="btn btn-danger">Borrar</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<div class="text-center">
	<a href="admin/formulario" type="button" class="btn btn-success text-center mt-3">Añadir</a>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>