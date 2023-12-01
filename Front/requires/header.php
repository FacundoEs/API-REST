<header>
    <h1><?php require('validates/obtener-nombreClub.php') ?></h1>
    <span><?php require('validates/obtener-descripcionClub.php') ?></span>
    <div class="separador"></div>
    <nav>
        <ul>
            <li><a href="/"><i class="fa fa-home" aria-hidden="true"></i> Inicio</a></li>
            <li><a href="equipos.php"><i class="fa fa-book" aria-hidden="true"></i> Equipos</a></li>
            <li><a href="jugadores.php"><i class="fa fa-address-book" aria-hidden="true"></i> Jugadores</a></li>
            <li><a href="inscripciones.php"><i class="fa fa-chain-broken" aria-hidden="true"></i> Inscripciones</a></li>
            <?php if (!isset($_SESSION['ingresado'])) : ?>
            <li><a href="ingresar.php"><i class="fa fa-user" aria-hidden="true"></i> Ingresar</a></li>
            <?php endif; ?>
        </ul>
    </nav>
    <div class="separador"></div>
</header>