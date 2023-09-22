<?php 

if (!empty($_POST['nombre']) && !empty($_POST['edad'])) {
    // URL del endpoint de la API de Spring Boot
    $apiUrl = "http://localhost:8080/jugador/insertar";

    // Datos del objeto que deseas enviar (puede ser un arreglo asociativo)
    $data = array(
        "nombre" => $_POST['nombre'],
        "edad" => $_POST['edad']
        // Agrega más campos según sea necesario
    );

    // Convertir los datos en formato JSON
    $jsonData = json_encode($data);

    // Inicializar una nueva instancia de cURL
    $ch = curl_init();

    // Configurar las opciones de cURL para una petición POST
    curl_setopt($ch, CURLOPT_URL, $apiUrl);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $jsonData);
    curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        'Content-Type: application/json',
        'Content-Length: ' . strlen($jsonData)
    ));

    // Ejecutar la petición y obtener la respuesta
    $response = curl_exec($ch);

    // Verificar si hubo un error en la petición
    if (curl_errno($ch)) {
        echo "Error al realizar la petición: " . curl_error($ch);
    } else {
        // Procesar la respuesta de la API (generalmente en formato JSON)
        $decodedResponse = json_decode($response, true);

        // Hacer lo que necesites con los datos obtenidos
        print_r($decodedResponse);
    }

    // Cerrar la instancia de cURL
    curl_close($ch);
}

if (!empty($_POST['id_eliminar'])) {
    // ID del equipo que deseas eliminar
    $id = $_POST['id_eliminar']; // Cambia esto al ID correcto

    // URL del endpoint de la API de Spring Boot, incluyendo el ID en la URL
    $apiUrl = "http://localhost:8080/jugador/eliminar/" . urlencode($id);

    // Inicializar una nueva instancia de cURL
    $ch = curl_init();

    // Configurar las opciones de cURL para una petición DELETE
    curl_setopt($ch, CURLOPT_URL, $apiUrl);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE"); // Indicar que es una solicitud DELETE
    curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        'Content-Type: application/json'
    ));

    // Ejecutar la petición y obtener la respuesta
    $response = curl_exec($ch);

    // Verificar si hubo un error en la petición
    if (curl_errno($ch)) {
        echo "Error al realizar la petición: " . curl_error($ch);
    } else {
        // Procesar la respuesta de la API (generalmente en formato JSON)
        $decodedResponse = json_decode($response, true);

        // Hacer lo que necesites con los datos obtenidos
        //print_r($decodedResponse);
        echo 'Eliminaste correctamente el equipo con la ID: '.$id;
    }

    // Cerrar la instancia de cURL
    curl_close($ch);
}

if(!empty($_GET['id_buscar'])){
    // ID del equipo que deseas buscar
    $id = $_GET['id_buscar']; // Cambia esto al ID correcto

    // URL del endpoint de la API de Spring Boot, incluyendo el ID en la URL
    $apiUrl = "http://localhost:8080/jugador/buscar/" . urlencode($id);

    // Inicializar una nueva instancia de cURL
    $ch = curl_init();

    // Configurar las opciones de cURL para una petición GET
    curl_setopt($ch, CURLOPT_URL, $apiUrl);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    // Ejecutar la petición y obtener la respuesta
    $response = curl_exec($ch);

    // Verificar si hubo un error en la petición
    if (curl_errno($ch)) {
        echo "Error al realizar la petición: " . curl_error($ch);
    } else {
        // Procesar la respuesta de la API (generalmente en formato JSON)
        $decodedResponse = json_decode($response, true);

        // Hacer lo que necesites con los datos obtenidos
        print_r($decodedResponse);
    }

    // Cerrar la instancia de cURL
    curl_close($ch);
}

if(!empty($_GET['mostrar_todo'])){
    // URL del endpoint de la API de Spring Boot
    $apiUrl = "http://localhost:8080/jugador/mostrar";

    // Inicializar una nueva instancia de cURL
    $ch = curl_init();

    // Configurar las opciones de cURL para una petición GET
    curl_setopt($ch, CURLOPT_URL, $apiUrl);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    // Ejecutar la petición y obtener la respuesta
    $response = curl_exec($ch);

    // Verificar si hubo un error en la petición
    if (curl_errno($ch)) {
        echo "Error al realizar la petición: " . curl_error($ch);
    } else {
        // Procesar la respuesta de la API (generalmente en formato JSON)
        $decodedResponse = json_decode($response, true);

        // Hacer lo que necesites con los datos obtenidos
        print_r($decodedResponse);
    }

    // Cerrar la instancia de cURL
    curl_close($ch);
}

if(!empty($_POST['modificar_id']) && !empty($_POST['modificar_nombre'] && !empty($_POST['modificar_edad']))){
    // ID del equipo que deseas modificar
    $id = $_POST['modificar_id']; // Cambia esto al ID correcto

    // Nueva edad y nombre para el equipo
    $nuevoNombre = $_POST['modificar_nombre']; // Cambia esto al nuevo nombre
    $nuevaEdad = $_POST['modificar_edad'];

    // URL del endpoint de la API de Spring Boot, incluyendo los parámetros en la URL
    $apiUrl = "http://localhost:8080/jugador/modificar/{$id}/" . urlencode($nuevoNombre) ."/". urlencode($nuevaEdad);

    // Inicializar una nueva instancia de cURL
    $ch = curl_init();

    // Configurar las opciones de cURL para una petición PATCH
    curl_setopt($ch, CURLOPT_URL, $apiUrl);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "PATCH"); // Indicar que es una solicitud PATCH
    curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        'Content-Type: application/json'
    ));

    // Ejecutar la petición y obtener la respuesta
    $response = curl_exec($ch);

    // Verificar si hubo un error en la petición
    if (curl_errno($ch)) {
        echo "Error al realizar la petición: " . curl_error($ch);
    } else {
        // Procesar la respuesta de la API (generalmente en formato JSON)
        $decodedResponse = json_decode($response, true);

        // Hacer lo que necesites con los datos obtenidos
        //print_r($decodedResponse);
        echo 'Modificaste el equipo con la ID: '.$id.' le pusiste como nombre: '.$nuevoNombre. ' y edad:'. $nuevaEdad;
    }

    // Cerrar la instancia de cURL
    curl_close($ch);
    }

?>