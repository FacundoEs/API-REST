<?php 

// Iniciar la sesión
if (session_status() == PHP_SESSION_NONE) {
    // Si no hay sesión activa, la iniciamos
    session_start();
}

?>