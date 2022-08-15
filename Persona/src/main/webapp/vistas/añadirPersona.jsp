<%--
  Created by IntelliJ IDEA.
  User: Brayan
  Date: 12/08/2022
  Time: 01:37 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Añadir Persona</title>
    <jsp:include page="../templates/head.jsp"/>
</head>
<body>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-header"> Añadir Persona
                    <div class="card-body">
                        <form action="add-persona"  method="post" class="form">
                            <div class="form-group mb-3">
                                <div class="row">
                                    <div class="col">
                                        <label for="name">Nombre</label>
                                        <input type="text" id="name" name="name" class="form-control" required/>

                                    </div>
                                    <div class="col">
                                        <label for="surname">Surname</label>
                                        <input type="text" id="surname" name="surname" class="form-control"
                                               required/>
                                    </div>
                                    <div class="col">
                                        <label for="curp">Curp</label>
                                        <input type="text" id="curp" name="curp" class="form-control" required/>
                                    </div>
                                    <div class="col">
                                        <label for="cumple">Nacimiento</label>
                                        <input type="date" id="cumple" name="cumple" class="form-control"
                                               required/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mb-3 text-end" >
                                <button type="submit" class="btn btn-danger btn-sm">
                                    Cancelar
                                </button>
                                <button type="submit" class="btn btn-success btn-sm">
                                    Guardar
                                </button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>

        </div>

    </div>

</div>
<script>

</script>
<jsp:include page="../templates/footer.jsp"/>
</body>
</html>
