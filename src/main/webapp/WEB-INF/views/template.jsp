<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
    <header></header>
    <section>
        <jsp:include page="./${page}.jsp"></jsp:include>
    </section>
</body>
</html>