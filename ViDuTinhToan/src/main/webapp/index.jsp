<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// Lấy giá trị tham số từ Url
		// http:/localhost:8888/ViDuTinhToan/index.jsp/index.jsp?a=3&b=5
		int valueA = Integer.parseInt(request.getParameter("a"));
		int valueB = Integer.parseInt(request.getParameter("b"));
		out.print("Tổng của " + valueA + " và " + valueB + " = " + (valueA+valueB));
	%>
</body>
</html>