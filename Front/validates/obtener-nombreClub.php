<?php 

    // URL del endpoint de la API de Spring Boot
    $apiUrlClub = "http://localhost:8080/datos-del-club";

    // Inicializar una nueva instancia de cURL
    $chClub = curl_init();

    // Configurar las opciones de cURL para una petición GET
    curl_setopt($chClub, CURLOPT_URL, $apiUrlClub);
    curl_setopt($chClub, CURLOPT_RETURNTRANSFER, true);

    // Ejecutar la petición y obtener la respuesta
    $responseClub = curl_exec($chClub);

    // Verificar si hubo un error en la petición
    if (curl_errno($chClub)) {
        echo "Error al realizar la petición: " . curl_error($ch);
    } else {
        // Procesar la respuesta de la API (generalmente en formato JSON)
        $decodedResponseClub = json_decode($responseClub, true);
    }

    // Cerrar la instancia de cURL
    curl_close($chClub);

?>
<?php if (!empty($decodedResponseClub)) : ?>
<?php foreach ($decodedResponseClub as $club) { ?>
    <?=$club['nombreDelClub']?>
<?php } ?>
<?php endif; ?>