<?php 

if (!empty($_POST['jugador_id']) && !empty($_POST['equipo_id'])) {
    // URL del endpoint de la API de Spring Boot
    $apiUrl = "http://localhost:8080/inscripcion/insertar";

    // Datos del objeto que deseas enviar (puede ser un arreglo asociativo)
    $data = array(
        "jugador" => array("id" => $_POST['jugador_id']),
        "equipo" => array("id" => $_POST['equipo_id'])
        // Agrega más campos según sea necesario
    );
    echo var_dump($data);
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

if(!empty($_GET['mostrar_todo'])){
    // URL del endpoint de la API de Spring Boot
    $apiUrl = "http://localhost:8080/inscripcion/mostrar";

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

if (!empty($_POST['id_eliminar'])) {
    // ID del equipo que deseas eliminar
    $id = $_POST['id_eliminar']; // Cambia esto al ID correcto

    // URL del endpoint de la API de Spring Boot, incluyendo el ID en la URL
    $apiUrl = "http://localhost:8080/inscripcion/eliminar/" . urlencode($id);

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
        echo 'Eliminaste correctamente la inscripción con la ID: '.$id;
    }

    // Cerrar la instancia de cURL
    curl_close($ch);
}

?>