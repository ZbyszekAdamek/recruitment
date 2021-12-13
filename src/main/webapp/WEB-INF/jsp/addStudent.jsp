<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form:form method="post" modelAttribute="student">

    <form:hidden path="id"/>

    Imię: <form:input path="name" /> <br />
    <form:errors path="name"/><br/>
    Nazwisko: <form:input path="surname" /> <br />
    <form:errors path="surname"/><br/>
    Email: <form:input path="email"/><br/>
    <form:errors path="email"/><br/>
    Kierunek: <form:input path="course"/> <br />
    <form:errors path="course"/><br/>
    <input type="submit">

</form:form>