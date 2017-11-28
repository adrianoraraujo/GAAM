<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<div class="page-header">
			<h1>Cadastrar Integrante</h1>
		</div>
		<form action="integrantes" method="post">
			Nome:<input type="text" name="nome" /><br>
			Cpf:<input type="text" name="cpf"/><br>
			Endereço:<input type="text" name="endereco"/><br>
			Telefone:<input type="text" name="telefone" /><br>
			E-mail:<input type="text"name="email" /><br>
			Idade:<input type="text"name="idade" /><br>
			Nome do Responsável:<input type="text" name="nomeresp" /><br>
Tipo Integrante: 
		<select name="tipo" >
			<option value="" selected>Selecione</option>
			<c:forEach var="tipo" items="${listaTipo}">
				<option value="${tipo.id}">${tipo.descricao}</option>
			</c:forEach>
</select>
			<input type="submit" value="Salvar" />

		</form>
	</div>

</body>
</html>