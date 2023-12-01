<?php require_once('requires/head.php') ?>
<section id="container">
<h1><?php require('validates/obtener-nombreClub.php') ?></h1>
<div class="separador"></div>
<form class="pure-form pure-form-aligned" action="validates/validar-ingresar.php" method="POST">
    <fieldset>
            <label for="aligned-name">Usuario</label>
            <input type="text" name="nombreUsuario" placeholder="Usuario" required/>
            <label for="aligned-password">Contraseña</label>
            <input type="password" name="contrasena" placeholder="Contraseña" required/>
            <button type="submit" class="pure-button pure-button-primary">Ingresar</button>
    </fieldset>
</form>
<a href="index.php" class="regresar">Regresar</a>
</section>
<?php require_once('requires/footer.php') ?>