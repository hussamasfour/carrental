<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        Register User
    </title>
</head>
<style>
    .error {
        color: Red;
    }

</style>
<body>
<h2>User Registration</h2>

<form:form action="registerUser" method="POST"  modelAttribute="user">
        <pre>
            <form:label path="firstName">First Name:</form:label>
            <form:input path="firstName"/>
            <form:errors path="firstName" cssClass="error"/>

            <form:label path="lastName">Last Name:</form:label>
            <form:input path="lastName"/>
            <form:errors path="lastName" cssClass="eroor"/>

            <form:label path="email">Email:</form:label>
            <form:input path="email"/>
            <form:errors path="email" cssClass="error"/>

            <form:label path="password">Password:</form:label>
            <form:input path="password"/>
            <form:errors path ="password" cssClass="error"/>

            <input type="submit" value="register"/>
        </pre>

</form:form>
</body>
</html>