<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servlets.modelos.Coche"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coches</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>
<h1 class="text-center my-3">Añadir coche</h1>

<form class="text-center" name="insertForm" method="POST" action="insertar">
  <div class="form-row justify-content-center">
  
    <div class="col-5 mt-2">
    <label>Matricula</label>
      <input type="text" name="matricula" value="${coche.matricula}" class="form-control" placeholder="Matricula">
    </div>
    
    <div class="col-5 mt-2">
    <label>Marca</label>
      <input type="text" name="marca" value="${coche.marca}" class="form-control" placeholder="Marca">
    </div>
    
    <div class="col-5 mt-2">
    <label>Modelo</label>
      <input type="text" name="modelo" value="${coche.modelo}" class="form-control" placeholder="Modelo">
    </div>
    
    <div class="col-5 mt-2">
    <label>Color</label>
      <input type="text" name="color" value="${coche.color}" class="form-control" placeholder="Color">
    </div>
    
    <div class="col-5 mt-2">
    <label>Potencia</label>
      <input type="number" name="potencia" value="${coche.potencia}" class="form-control" placeholder="Potencia">
    </div>
    
    <div class="col-5 mt-2">
    <label>Cilindrada</label>
      <input type="number" name="cilindrada" value="${coche.cilindrada}" class="form-control" placeholder="Cilindrada">
    </div>
  </div>
  <button type="submit" name="id" value="${coche.id}" class="btn btn-primary mt-3">Enviar</button>
</form>

</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>
</html>