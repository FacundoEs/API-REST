<?php if (isset($_SESSION['ingresado'])) : ?>
<div id="ABMNav">
    <span><b>Administrar</b> - Ingresaste como: </span> <?php echo $_SESSION['ingresado']['username']; ?>
    <br><br>
    <ul>
        <li><a href="http://localhost:8080/swagger-ui/index.html#/equipo-controller"><i class="fa fa-book" aria-hidden="true"></i> Equipos</a></li>
        <li><a href="http://localhost:8080/swagger-ui/index.html#/jugador-controller"><i class="fa fa-address-book" aria-hidden="true"></i> Jugadores</a></li>
        <li><a href="http://localhost:8080/swagger-ui/index.html#/inscripcion-controller"><i class="fa fa-chain-broken" aria-hidden="true"></i> Inscripciones</a></li>
        <li><a href="http://localhost:8080/swagger-ui/index.html#/datos-del-club-controller"><i class="fa fa-info-circle" aria-hidden="true"></i> Datos del club</a></li>
        <li><a href="http://localhost:8080/swagger-ui/index.html#/usuario-controller"><i class="fa fa-users" aria-hidden="true"></i> Usuarios</a></li>
        <li><a href="http://localhost:8080/swagger-ui/index.html#/"><i class="fa fa-star" aria-hidden="true"></i> Swagger</a></li>
        <li><a href="desconectar.php"><i class="fa fa-times-circle " aria-hidden="true"></i> Desconectarme</a></li>
    </ul>
</div>
<div class="separador"></div>
<?php endif; ?>