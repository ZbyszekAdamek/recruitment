<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form:form method="post" modelAttribute="teacher">

    <form:hidden path="id"/>

    Imię: <form:input path="name" /> <br />
    <form:errors path="name"/><br/>
    Nazwisko: <form:input path="surname" /> <br />
    <form:errors path="surname"/><br/>
    Wiek <form:input path="age"/> <br />
    <form:errors path="age"/><br/>
    Email: <form:input path="email"/><br/>
    <form:errors path="email"/><br/>
    Przedmiot: <form:input path="subject"/> <br />
    <form:errors path="subject"/><br/>
    <input type="submit">

</form:form>