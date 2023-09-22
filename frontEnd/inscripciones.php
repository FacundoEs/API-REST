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

//
    // URL del endpoint de la API de Spring Boot
    $apiUrlJugador = "http://localhost:8080/jugador/mostrar";

    // Inicializar una nueva instancia de cURL
    $chJugador = curl_init();

    // Configurar las opciones de cURL para una petición GET
    curl_setopt($chJugador, CURLOPT_URL, $apiUrlJugador);
    curl_setopt($chJugador, CURLOPT_RETURNTRANSFER, true);

    // Ejecutar la petición y obtener la respuesta
    $responseJugador = curl_exec($chJugador);

    // Verificar si hubo un error en la petición
    if (curl_errno($chJugador)) {
        echo "Error al realizar la petición: " . curl_error($chJugador);
    } else {
        // Procesar la respuesta de la API (generalmente en formato JSON)
        $decodedResponseJugador = json_decode($responseJugador, true);
    }

    // Cerrar la instancia de cURL
    curl_close($chJugador);

//
// URL del endpoint de la API de Spring Boot
$apiUrlInscripcion = "http://localhost:8080/inscripcion/mostrar";

// Inicializar una nueva instancia de cURL
$chInscripcion = curl_init();

// Configurar las opciones de cURL para una petición GET
curl_setopt($chInscripcion, CURLOPT_URL, $apiUrlInscripcion);
curl_setopt($chInscripcion, CURLOPT_RETURNTRANSFER, true);

// Ejecutar la petición y obtener la respuesta
$responseInscripcion = curl_exec($chInscripcion);

// Verificar si hubo un error en la petición
if (curl_errno($chInscripcion)) {
    echo "Error al realizar la petición: " . curl_error($chInscripcion);
} else {
    // Procesar la respuesta de la API (generalmente en formato JSON)
    $decodedResponseInscripcion = json_decode($responseInscripcion, true);
}

// Cerrar la instancia de cURL
curl_close($chInscripcion);
        
?>
<?php require_once('requires/head.php') ?>
<section id="container">
        <?php require_once('requires/header.php') ?>
        <div id="ABMNav">
            <ul>
                <li><a href="#agregar"><i class="fa fa-plus" aria-hidden="true"></i> Inscribir</a></li>
                <li><a href="#mostrar"><i class="fa fa-list" aria-hidden="true"></i> Mostrar</a></li>
            </ul>
        </div>
        <div class="separador"></div>
        <div id="agregar">
            <form class="pure-form" action="validates/validar-inscripciones.php" method="POST">
                <legend>Inscribir</legend>
                <fieldset class="pure-group">
                <label for="">Equipo: </label>
                <select name="equipoSeleccionado">
                <?php foreach ($decodedResponseEquipos as $equipo) { ?>
                    <option value="<?=$equipo['id']?>"><?=$equipo['nombre']?> - ID: <?=$equipo['id']?></option>
                <?php } ?>
                </select>
                <label for="">Jugador: </label>
                <select name="jugadorSeleccionado">
                    <?php foreach ($decodedResponseJugador as $jugador) { ?>
                        <option value="<?=$jugador['id']?>"><?=$jugador['nombre']?> - ID: <?=$jugador['id']?></option>
                    <?php } ?>
                </select>
                <br><br>
                    <input type="text" class="pure-input-1-2" autocomplete="off" placeholder="Id Jugador" name="jugador_id" required/>
                    <input type="text" class="pure-input-1-2" autocomplete="off" placeholder="Id Equipo" name="equipo_id" required/>
                </fieldset>
                <button type="submit" class="pure-button pure-input-1-2 pure-button-primary" style="background: rgb(28, 184, 65);">Inscribir</button>
            </form>
        </div>
        <hr>
        <div id="eliminar">
            <form class="pure-form" action="validates/validar-inscripciones.php" method="POST">
                <legend>Eliminar</legend>
                <label for="">Inscripciones: </label>
                <select name="InscripcionSeleccionado">
                    <?php foreach ($decodedResponseInscripcion as $insc) { ?>
                        <option value="<?=$insc['id']?>">
                            [<?=$insc['equipo']['nombre']?> - <?=$insc['jugador']['nombre']?>] - ID: <?=$insc['id']?>
                        </option>
                    <?php } ?>
                </select>
                <fieldset class="pure-group">
                    <input type="text" class="pure-input-1-2" autocomplete="off" placeholder="ID inscripcion" name="id_eliminar" required/>
                </fieldset>
                <button type="submit" class="pure-button pure-input-1-2 pure-button-primary" style="background: rgb(202, 60, 60);">Eliminar</button>
            </form>
        </div>
        <hr>
        <div id="mostrar">
            <form class="pure-form" action="validates/validar-inscripciones.php" method="GET">
                <legend>Mostrar todos</legend>
                <input type="hidden" name="mostrar_todo" value="1">
                <button type="submit" class="pure-button pure-input-1-2 pure-button-primary" style="background: rgb(66, 184, 221);">Mostrar</button>
            </form>
        </div>
    </section>
<?php require_once('requires/footer.php') ?>