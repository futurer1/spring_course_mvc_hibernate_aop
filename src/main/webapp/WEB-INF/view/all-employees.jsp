<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>Employees: </h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>
    <tbody>
    <c:forEach var="emp" items="${allEmps}">

        <c:url var="editButton" value="/editEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/delEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <input type="button" value="edit" onclick="window.location.href = '${editButton}'"/>
                <input type="button" value="delete" onclick="window.location.href = '${deleteButton}'"/>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<input type="button" value="add" onclick="window.location.href = 'addNewEmployee'" />
</body>
</html>