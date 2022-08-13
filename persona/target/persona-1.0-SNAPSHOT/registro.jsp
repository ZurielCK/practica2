<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>

<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="bg-secondary">
    <section class="d-flex justify-content-center">
        <div class="card col-sm-6 p-3">

       
        <div class="mb-3">
            <h4>Registro</h4>
        </div>
        <div class="mb-2">
            <form action="ServletPersona" method="post">
                <div class="mb-2">
                    <label >*Nombre</label>
                    <input type="text" class="form-control" name="nombre"  placeholder="Nombre">
                </div>
                <div class="mb-2">
                    <label >*Apellidos </label>
                    <input type="text" class="form-control" name="surname" placeholder="Primer apellido">
                </div>
                <div class="mb-2">
                    <label >*Curp</label>
                    <input type="text" class="form-control" name="curp"  placeholder="Contraseña">
                </div>
                <div class="mb-2">
                    <label >*Nacimiento</label>
                    <input type="text" class="form-control" name="cumple"  placeholder="Telefono">
                </div>

                <div class="mb-2">
                    <input type="hidden" value="registrar" name="accion">
                <button type="submit"  class="btn btn-primary">Enviar</button>
                </div>
            </div>
            </form>
        </div>

    </section>
    
</body>
</html>