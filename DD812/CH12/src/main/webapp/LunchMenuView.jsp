<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>점심 메뉴</title>
</head>
<body>
<h2>오늘의 점심 메뉴입니다.</h2>
<ul>
    <c:forEach var="menu" items="${MENU}">
        <li>${menu}</li>
    </c:forEach>
</ul>
</body>
</html>
