<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="addpost.jsp" method="post" enctype="multipart/form-data">
<tr>
    <tr><td>img:</td><td><input type="file" name="photo"/></td></tr><br>
    <tr><td>NAME:</td><td><input type="text" name="NAME" placeholder="선수 이름을 입력하세요."/></td></tr><br>
    <tr><td>TEAM:</td><td><input type="text" name="team" placeholder="선수가 속한 팀을 입력하세요."/></td></tr><br>
    <tr><td>GOAL:</td><td><input type="number" name="goal" placeholder="득점 수를 입력하세요."/></td></tr><br>
    <tr><td>ASSIST:</td><td><input type="number" name="assist" placeholder="어시스트 수를 입력하세요."/></td></tr><br>
    <tr><td>POINT:</td><td><input type="number" name="point" placeholder="공격 포인트를 입력하세요."/></td></tr><br>
    <tr><td>SHOOT:</td></tr><input type="number" name="shoot" placeholder="슛팅 갯수 입력하세요." /></td></tr><br>
    <tr><td>PLAY:</td><td><input type="number" name="play" placeholder="경기 수를 입력하세요"/></td></tr><br>
    <tr><td>POSITION:</td><td><input type="text" name="position" placeholder="포지션을 입력하세요"/></td></tr><br>
    <tr><td><a href="posts.jsp">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</form>

</body>
</html>