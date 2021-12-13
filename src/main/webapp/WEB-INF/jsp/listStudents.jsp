<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
    <tr>
        <th>Id</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Akcja</th>
    </tr>
    <c:forEach items="${allStudents}" var="student">
        <tr>
            <td>${student.id}</td>
            <td> ${student.name} </td>
            <td>${student.course}</td>
            <td>
                <a href='<c:url value="removeStudent?toRemoveId=${student.id}"/>'>Usuń</a>
                <a href='<c:url value="addStudent?idToEdit=${student.id}"/>'>Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</div>
</div>
</div>