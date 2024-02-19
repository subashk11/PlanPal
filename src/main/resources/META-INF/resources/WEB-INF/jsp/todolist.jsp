<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.css" rel="stylesheet"/>
    <title>Title My First application</title>
</head>
<body>
    <%@include file="common/navbar.jspf" %>
    <div class="container">
    <h1>Welcome to your todo's</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Due Date</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todolist}" var="todo">
                    <tr>
                        <td>${todo.description}</td>
                        <td>${todo.lastDate}</td>
                        <td>${todo.completed}</td>
                        <td><a href="/deletetodo?id=${todo.id}" class="btn btn-danger">DELETE</a>
                        <a href="/updatetodo?id=${todo.id}" class="btn btn-info">UPDATE</a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/addtodo" class="btn">Add</a>
        <script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.js"></script>
    </div>
</body>
</html>