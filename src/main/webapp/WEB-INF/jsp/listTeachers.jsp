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
    <c:forEach items="${allTeachers}" var="teacher">
        <tr>
            <td>${teacher.id}</td>
            <td> ${teacher.name} </td>
            <td>${teacher.subject}</td>
            <td>
                <a href='<c:url value="removeTeacher?toRemoveId=${teacher.id}"/>'>Usuń</a>
                <a href='<c:url value="addTeacher?idToEdit=${teacher.id}"/>'>Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</div>
</div>
</div>