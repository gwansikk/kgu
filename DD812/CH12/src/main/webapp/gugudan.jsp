<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>구구단</title>
</head>
<body>
<table>
    <c:forEach var="i" begin="1" end="9">
        <tr>
        <c:forEach var="j" begin="2" end="5">
            <c:set var="result" value="${i * j}" />
            <td style="width: 100px"><c:out value="${j} * ${i} = ${result}" /></td>
            <c:if test="${j == 5}">
                </tr><tr>
            </c:if>
        </c:forEach>
        </tr>
    </c:forEach>
</table>
<br>
<table>
    <c:forEach var="i" begin="1" end="9">
        <tr>
        <c:forEach var="j" begin="6" end="9">
            <c:set var="result" value="${i * j}" />
            <td style="width: 100px;"><c:out value="${j} * ${i} = ${result}" /></td>
            <c:if test="${j == 9}">
                </tr><tr>
            </c:if>
        </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
