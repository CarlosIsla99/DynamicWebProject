<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servlets.modelos.Coche"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h1 class="text-center my-3">${accion} coche</h1>

<form class="text-center" autocomplete="off" method="POST" action="formulario">
  <div class="form-row justify-content-center">
  
    <div class="col-5 mt-2">
    <label>Matricula</label>
      <input type="text" name="matricula" value="${coche.matricula}" class="form-control" required="required" placeholder="Matricula">
    </div>
    
    <div class="col-5 mt-2">
    <label>Marca</label>
      <input type="text" name="marca" value="${coche.marca}" class="form-control" required="required" placeholder="Marca">
    </div>
    
    <div class="col-5 mt-2">
    <label>Modelo</label>
      <input type="text" name="modelo" value="${coche.modelo}" class="form-control" required="required" placeholder="Modelo">
    </div>
    
    <div class="col-5 mt-2">
    <label>Color</label>
      <input type="text" name="color" value="${coche.color}" class="form-control" required="required" placeholder="Color">
    </div>
    
    <div class="col-5 mt-2">
    <label>Potencia</label>
      <input type="number" name="potencia" value="${coche.potencia}" class="form-control" required="required" placeholder="Potencia">
    </div>
    
    <div class="col-5 mt-2">
    <label>Cilindrada</label>
      <input type="number" name="cilindrada" value="${coche.cilindrada}" class="form-control" required="required" placeholder="Cilindrada">
    </div>
  </div>
  <button type="submit" name="id" value="${coche.id}" class="btn btn-primary mt-3">Enviar</button>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>