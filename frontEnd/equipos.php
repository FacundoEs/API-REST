<?php require_once('requires/head.php') ?>
<section id="container">
        <?php require_once('requires/header.php') ?>
        <?php require_once('requires/nav.php') ?>
        <div id="agregar">
            <form class="pure-form" action="validates/validar-equipo.php" method="POST">
                <legend>Agregar</legend>
                <fieldset class="pure-group">
                    <input type="text" class="pure-input-1-2" autocomplete="off" placeholder="Nombre del equipo" name="nombre" required/>
                </fieldset>
                <button type="submit" class="pure-button pure-input-1-2 pure-button-primary" style="background: rgb(28, 184, 65);">Agregar</button>
            </form>
        </div>
        <hr>
        <div id="modificar">
            <form class="pure-form" action="validates/validar-equipo.php" method="POST">
                <legend>Modificar</legend>
                <fieldset class="pure-group">
                <input type="text" class="pure-input-1-2" autocomplete="off" placeholder="ID equipo" name="modificar_id" required/>
                <input type="text" class="pure-input-1-2" autocomplete="off" placeholder="Nuevo nombre" name="modificar_nombre" required/>
                </fieldset>
                <button type="submit" class="pure-button pure-input-1-2 pure-button-primary" style="background: rgb(223, 117, 20);">Modificar</button>
            </form>
        </div>
        <hr>
        <div id="eliminar">
            <form class="pure-form" action="validates/validar-equipo.php" method="POST">
                <legend>Eliminar</legend>
                <fieldset class="pure-group">
                    <input type="text" class="pure-input-1-2" autocomplete="off" placeholder="ID equipo" name="id_eliminar" required/>
                </fieldset>
                <button type="submit" class="pure-button pure-input-1-2 pure-button-primary" style="background: rgb(202, 60, 60);">Eliminar</button>
            </form>
        </div>
        <hr>
        <div id="buscar">
            <form class="pure-form" action="validates/validar-equipo.php" method="GET">
                <legend>Buscar por ID</legend>
                <fieldset class="pure-group">
                <input type="text" class="pure-input-1-2" autocomplete="off" placeholder="ID equipo" name="id_buscar" required/>
                </fieldset>
                <button type="submit" class="pure-button pure-input-1-2 pure-button-primary">Buscar</button>
            </form>
        </div>
        <hr>
        <div id="mostrar">
            <form class="pure-form" action="validates/validar-equipo.php" method="GET">
                <legend>Mostrar todos</legend>
                <input type="hidden" name="mostrar_todo" value="1">
                <button type="submit" class="pure-button pure-input-1-2 pure-button-primary" style="background: rgb(66, 184, 221);">Mostrar</button>
            </form>
        </div>
    </section>
<?php require_once('requires/footer.php') ?>