<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/styles/default.css' />
    <title></title>
</head>
<body class="body">
<div class="container">
    <h1 style="display: flex; justify-content: center; color: rgb(0, 122, 255);">Simple Java Web App Demo</h1>
    <form action="${pageContext.request.contextPath}/MyServlet" method="get" style="display: flex; justify-content: center;">
        <button type="submit">Click here to see some servlet magic!</button>
    </form>
    <form action="${pageContext.request.contextPath}/MyServlet" method="post" style="display: flex; justify-content: center; margin-bottom: 15px">
        <input type="text" name="submit" placeholder="Type your name" style="width: 300px;" required>
        <button type="submit">And click here, nice guy!</button>
    </form>
</div>
</body>
</html>
