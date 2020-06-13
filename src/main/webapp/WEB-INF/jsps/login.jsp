<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        User Login
    </title>
</head>
<style>
    .error {
        color: #ff0000;
    }

    .errorblock {
        color: #000;
        background-color: #ffEEEE;
        border: 3px solid #ff0000;
        padding: 8px;
        margin: 16px;
    }
</style>
<body>
<h2>Login</h2>
<form:form action="login" method="POST">
        <pre>
            <form:label path ="email"> User Name: </form:label>
            <form:input path="email"><input type="text" name="email"/></form:input>
            <form:errors path="email"  cssClass ="error" />
        Password: <input type="password" name="password"/>
        <input type="submit" value="login"/>
        </pre>

</form:form>
</body>
</html>