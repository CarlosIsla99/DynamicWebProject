<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servlets.modelos.Coche"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coches</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1 class="text-center my-3">Todos los coches</h1>
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
      	<a href="coche?id=${coche.id}" type="button" class="btn btn-secondary">Ver</a>
     	<a href="formulario?id=${coche.id}" type="button" class="btn btn-primary">Editar</a>
      	<a href="borrar?id=${coche.id}" type="button" class="btn btn-danger">Borrar</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<div class="text-center">
	<a href="formulario" type="button" class="btn btn-success text-center">Añadir</a>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>
</html>