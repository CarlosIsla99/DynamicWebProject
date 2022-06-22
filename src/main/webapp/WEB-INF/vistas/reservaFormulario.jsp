<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servlets.modelos.Coche"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h1 class="text-center my-3">${accion} reserva</h1>

<form class="text-center" autocomplete="off" method="POST" action="admin/reservaFormulario">
  <div class="form-row row justify-content-center">
  
    <div class="col-5 mt-2">
    <label>Nombre</label>
      <input type="text" name="nombre" value="${reserva.nombre}" class="form-control" required="required" placeholder="Nombre">
    </div>
    
	<div class="col-5 mt-2">
	<label>Email</label>
 		<input type="email" name="email" value="${sessionScope.usuario.email}" class="form-control" id="exampleInputEmail" readonly>
	</div>

    <div class="col-5 mt-2">
    <label>Fecha y hora</label>
      <input type="datetime-local" name="datetime" value="${reserva.fechaHora}" class="form-control" required="required">
    </div>
    
    <div class="col-5 mt-2">
    <label>Nº de personas</label>
      <input type="number" name="numPersonas" min="1" max="5" value="${reserva.numeroPersonas}" class="form-control" required="required" placeholder="Número de personas">
    </div>
    
    <div class="col-5 mt-2">
    <label>Comentario</label>
      <textarea name="comentario" class="form-control" maxlength="75" required="required" placeholder="Comentario">${reserva.comentario}</textarea>
    </div>
    
  </div>
  <button type="submit" name="id" value="${reserva.id}" class="btn btn-primary mt-3">Enviar</button>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>