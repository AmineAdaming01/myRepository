<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%> --%>
<%-- <%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%> --%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form   modelAttribute="etd"  action="Ajout" method="post">
		<table>


			<tr>
				<td><form:label path="idEtudiant">id Etudiant</form:label></td>
				<td><form:input path="idEtudiant" /></td>
			</tr>
			<tr>
				<td><form:label path="nomEtudiant">Nom de l'étudiant</form:label></td>
				<td><form:input path="nomEtudiant" /></td>
			</tr>
      <tr>
			<td><input type="submit" value="Ajouter Etudiant" /></td>

      </tr>

		</table>

	</form:form>


	<p>Ici la liste des Etudiants</p>

	<table class="table table-striped">
		<tr>
			<th>Id Etudiant</th>
			<th>Nom Etudiant</th>


		</tr>

		<c:forEach items="${listeDesEtudiants}" var="etd">
			<tr>
				<td>${etd.idEtudiant}</td>
				<td>${etd.nomEtudiant}</td>


			</tr>
		</c:forEach>
	</table>
</body>
</html>