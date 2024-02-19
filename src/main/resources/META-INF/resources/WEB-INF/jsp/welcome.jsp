<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.css" rel="stylesheet"/>
    <title>Login Page</title>
</head>
<body>
    <%@include file="common/navbar.jspf" %>
    <div class="container">
        <h2>Hello ${name}</h2>
        <h4>Welcome to your To-do list</h4>
        <a href="todolist">view-to-do</a>
    </div>
</body>
</html>
