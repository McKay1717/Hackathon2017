<?php
/**
 * Created by PhpStorm.
 * User: guillaume
 * Date: 20/01/17
 * Time: 16:16
 */

include "../Moteur/Model.php";

session_start();

$_SESSION["Model"]=new Model();


header("Location: http://localhost/www/PhpstormProjects/Pyramidas/Vue/plateau.php");
