<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
<style>
	div {
		display: grid;
		grid-template-columns: repeat(4, minmax(0, 1fr));
		width: 400px;
	}
	
	ul {
	  list-style-type: none;
	}
</style>
</head>
<body>
	<jsp:useBean id="gugudan" class="reportone.kimgwansik.GuGuDan" />
	<div class="container">
	<%
		for (int i = 2; i <= 9; i++) {
			out.println("<ul>");
			for (int j = 1; j <= 9; j++) {
				int result = gugudan.process(i, j);
				out.print("<li>" + i + "*" + j + "=" + result + "</li>");
			}
			out.println("</ul>");
		}
	%>
	</div>
</body>
</html>