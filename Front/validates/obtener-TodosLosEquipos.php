<?php 

    // URL del endpoint de la API de Spring Boot
    $apiUrlEquipo = "http://localhost:8080/equipo/mostrar";

    // Inicializar una nueva instancia de cURL
    $chEquipo = curl_init();

    // Configurar las opciones de cURL para una petición GET
    curl_setopt($chEquipo, CURLOPT_URL, $apiUrlEquipo);
    curl_setopt($chEquipo, CURLOPT_RETURNTRANSFER, true);

    // Ejecutar la petición y obtener la respuesta
    $responseEquipo = curl_exec($chEquipo);

    // Verificar si hubo un error en la petición
    if (curl_errno($chEquipo)) {
        echo "Error al realizar la petición: " . curl_error($ch);
    } else {
        // Procesar la respuesta de la API (generalmente en formato JSON)
        $decodedResponseEquipos = json_decode($responseEquipo, true);
    }

    // Cerrar la instancia de cURL
    curl_close($chEquipo);

?>


<?php 
if (!empty($decodedResponseEquipos)) {
    echo '<table class="pure-table">';
    echo '<thead>';
    echo '<tr>';
    echo '<th>#</th>';
    echo '<th>Nombre</th>';
    echo '<th>Descripción</th>';
    echo '</tr>';
    echo '</thead>';
    echo '<tbody>';

    $contador = 1; // Variable para contar las filas

    foreach ($decodedResponseEquipos as $equipo) {
        // Alternar clases para filas pares e impares para el estilo
        $clase_fila = ($contador % 2 == 0) ? 'pure-table-odd' : '';

        echo '<tr class="' . $clase_fila . '">';
        echo '<td>' . $contador . '</td>';
        echo '<td>' . htmlspecialchars($equipo['nombre']) . '</td>';
        echo '<td>' . htmlspecialchars($equipo['descripcion']) . '</td>';
        echo '</tr>';

        $contador++;
    }

    echo '</tbody>';
    echo '</table>';
}
?>
