<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.css" rel="stylesheet"/>
    <link href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.standalone.css" rel="stylesheet"/>
    <title>Login Page</title>
</head>
<body>
    <%@include file="common/navbar.jspf" %>
    <div class="container">
        <h2>Login</h2>
        <form:form action="#" method="post" modelAttribute="toDo">
            <fieldset class="m-lg-2">
                <form:label path="description">Enter Description :</form:label>
                <form:input type="text" path="description" required="required"/>
                <form:errors path="description"/>
            </fieldset>
            <fieldset class="m-lg-2">
                <form:label path="lastDate">Due Date :</form:label>
                <form:input type="text" path="lastDate" required="required"/>
                <form:errors path="lastDate"/>
            </fieldset>
            <form:input type="hidden" path="id" />
            <form:input type="hidden" path="completed"/>
            <button type="submit" class="btn btn-outline-secondary">submit</button>
        </form:form>
    </div>
    <script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.js"></script>
    <script src="webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" >
        $(document).ready(function () {
            $('#lastDate').datepicker({
                format: 'yyyy-mm-dd',
                startDate: '-3d'
            });
        });
    </script>
</body>
</html>
