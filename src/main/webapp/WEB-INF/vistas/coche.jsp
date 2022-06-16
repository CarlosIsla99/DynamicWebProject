<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servlets.modelos.Coche"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coches</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center my-3">Coche #${coche.id}</h1>
<table class="table table-dark table-hover text-center">
  <thead>
    <tr>
      <th scope="col">MATRÍCULA</th>
      <th scope="col">MARCA</th>
      <th scope="col">MODELO</th>
      <th scope="col">COLOR</th>
      <th scope="col">POTENCIA</th>
      <th scope="col">CILINDRADA</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>${coche.matricula}</td>
      <td>${coche.marca}</td>
      <td>${coche.modelo}</td>
      <td>${coche.color}</td>
      <td>${coche.potencia}</td>
      <td>${coche.cilindrada}</td>
    </tr>
  </tbody>
</table>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>