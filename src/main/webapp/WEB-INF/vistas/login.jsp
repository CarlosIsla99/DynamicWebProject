<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="servlets.modelos.Coche"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

	<form style="margin-left: 32rem" class="mt-5" action="login" method="POST">
		<div class="form-group col-4">
			<label for="exampleInputEmail1">Email</label>
			<input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"> 
		</div>
		<div class="form-group col-4">
			<label for="exampleInputPassword1">Comtraseña</label>
			<input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
		</div>
		<button type="submit" class="btn btn-primary ml-3">Entrar</button>
		<span class="text-danger">${error}</span>
	</form>
	
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>