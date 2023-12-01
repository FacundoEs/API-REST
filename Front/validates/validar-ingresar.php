<?php require_once('iniciar_sesion.php') ?>
<?php

if (!empty($_POST['nombreUsuario']) && !empty($_POST['contrasena'])) {
    // Datos del formulario
    $nombreUsuario = $_POST['nombreUsuario'];
    $contrasena = $_POST['contrasena'];

    // URL del endpoint en Spring Boot
    $url = 'http://localhost:8080/usuario/ingresar';

    // Datos a enviar en la petición POST
    $data = http_build_query(array(
        'nombreUsuario' => $nombreUsuario,
        'contrasena' => $contrasena
    ));

    // Configuración de la petición
    $options = array(
        'http' => array(
            'header' => "Content-type: application/x-www-form-urlencoded\r\n",
            'method' => 'POST',
            'content' => $data
        )
    );

    // Realizar la petición HTTP
    $context = stream_context_create($options);
    $response = file_get_contents($url, false, $context);

    // Manejar la respuesta
    if ($response !== false) {
        // Decodificar la respuesta JSON
        $usuarioAutenticado = json_decode($response, true);

        // Guardar los datos en la sesión si la autenticación fue exitosa
        if ($usuarioAutenticado && isset($usuarioAutenticado['id'])) {
            $_SESSION['ingresado'] = $usuarioAutenticado;
            echo 'Usuario ingresado correctamente.';
            header("refresh:2;url=../index.php");
        } else {
            echo 'Error al autenticar.';
        }
    } else {
        echo 'El usuario no existe o la contraseña es incorrecta.';
        header("refresh:2;url=../ingresar.php");
    }
}

?>
