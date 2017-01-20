
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Plateau</title>
</head>
<body>
<a href="http://localhost/www/PhpstormProjects/Pyramidas/Vue/initialisation.php">New game</a>
<h1>Fin de party</h1>
<?php
include "../Moteur/Model.php";

session_start();

$model=new Model();
if(empty($_SESSION["Model"])){
    echo "erreur";
    $_SESSION["Model"]=new Model();
}

$model=$_SESSION["Model"];

echo $model->dispScore();

?>
</body>
</html>