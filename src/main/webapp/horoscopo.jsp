<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Consulta Horóscopo Chino</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Consulta tu Horóscopo Chino</h2>
        <form action="ConsultarHoroscopo" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Usuario</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <button type="submit" class="btn btn-success w-100">Consultar</button>
        </form>
        <c:if test="${not empty horoscopo}">
            <div class="mt-4 alert alert-info">
                <strong>Tu signo es:</strong> ${horoscopo}
            </div>
        </c:if>
    </div>
</body>
</html>