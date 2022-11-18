<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.crud.dao.BoardDAO, com.crud.bean.BoardVO, com.crud.File.FileUpload"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%
	BoardDAO boardDAO = new BoardDAO();
	String id=request.getParameter("id");	
	BoardVO user=boardDAO.getBoard(Integer.parseInt(id));
	request.setAttribute("u", user);
%>

<h1>Edit Form</h1>
<form action="editpost.jsp" method="post" enctype="multipart/form-data">
<input type="hidden" name="seq" value=${u.getSeq()}>
<table>
	<tr><td>img:</td><td><input type="file" name="photo" value=${u.getPhoto()}></td></tr>
	<tr><td>NAME:</td><td><input type="text" name="NAME" value=${u.getNAME()}></td></tr>
	<tr><td>TEAM:</td><td><input type="text" name="team" value=${u.getTeam()}></td></tr>
	<tr><td>GOAL:</td><td><input type="number" name="goal" value=${u.getGoal()}></td></tr>
	<tr><td>ASSIST:</td><td><input type="number" name="assist" value=${u.getAssist()}></td></tr>
	<tr><td>POINT:</td><td><input type="number" name="point" value=${u.getPoint()}></td></tr>
	<tr><td>SHOOT:</td><td><input type="number" name="shoot" value=${u.getShoot()}></td></tr>
	<tr><td>PLAY:</td><td><input type="number" name="play" value=${u.getPlay()}></td></tr>
	<tr><td>POSITION:</td><td><input type="text" name="position" value=${u.getPosition()}></td></tr>
	<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>

</body>
</html>