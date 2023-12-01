<?php 


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

    }

    // Cerrar la instancia de cURL
    curl_close($ch);


?>

<?php 
if (!empty($decodedResponse)) {
    echo '<table class="pure-table">';
    echo '<thead>';
    echo '<tr>';
    echo '<th>#</th>';
    echo '<th>Nombre</th>';
    echo '<th>Edad</th>';
    echo '</tr>';
    echo '</thead>';
    echo '<tbody>';

    $contador = 1; // Variable para contar las filas

    foreach ($decodedResponse as $jugador) {
        // Alternar clases para filas pares e impares para el estilo
        $clase_fila = ($contador % 2 == 0) ? 'pure-table-odd' : '';

        echo '<tr class="' . $clase_fila . '">';
        echo '<td>' . $contador . '</td>';
        echo '<td>' . htmlspecialchars($jugador['nombre']) . '</td>';
        echo '<td>' . htmlspecialchars($jugador['edad']) . '</td>';
        echo '</tr>';

        $contador++;
    }

    echo '</tbody>';
    echo '</table>';
}
?>
