<?php 

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
    }

    // Cerrar la instancia de cURL
    curl_close($ch);
    
?>

<?php 
    // ... tu código de solicitud a la API y obtención de $decodedResponse ...

    // Comprobar si se recibieron datos
    if (!empty($decodedResponse)) {
        // Organizar los datos por equipo y contar la cantidad de jugadores por equipo
        $jugadoresPorEquipo = [];
        foreach ($decodedResponse as $data) {
            $equipoNombre = $data['equipo']['nombre'];
            $jugadorNombre = $data['jugador']['nombre'];
            $jugadoresPorEquipo[$equipoNombre]['jugadores'][] = $jugadorNombre;
        }

        echo '<table class="pure-table">';
        echo '<thead>';
        echo '<tr>';
        echo '<th>#</th>';
        echo '<th>Jugadores</th>';
        echo '<th>Equipo</th>';
        echo '<th>Descripción</th>';
        echo '<th>Total de Jugadores</th>';
        echo '</tr>';
        echo '</thead>';
        echo '<tbody>';

        // Iterar a través de los equipos y mostrar los jugadores en una fila por equipo
        $index = 1;
        foreach ($jugadoresPorEquipo as $equipoNombre => $equipoData) {
            $jugadores = $equipoData['jugadores'];
            $totalJugadores = count($jugadores);
            $jugadoresString = implode(', ', $jugadores);
            $descripcion = $decodedResponse[$index - 1]['equipo']['descripcion'];

            // Alternar clases para filas impares y pares
            $rowClass = $index % 2 === 0 ? '' : 'class="pure-table-odd"';

            echo "<tr $rowClass>";
            echo "<td>$index</td>";
            echo "<td>$jugadoresString</td>";
            echo "<td>$equipoNombre</td>";
            echo "<td>$descripcion</td>";
            echo "<td>$totalJugadores</td>";
            echo '</tr>';

            $index++;
        }

        echo '</tbody>';
        echo '</table>';
    } else {
        echo 'No se encontraron datos.';
    }
?>
