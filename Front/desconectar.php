<?php require_once('validates/iniciar_sesion.php') ?>
<?php
    unset($_SESSION['ingresado']);
    echo 'Te desconectaste correctamente';
    header("refresh:2;url=index.php");
?>