<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Plateau</title>
<LINK href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<a href="http://localhost/www/PhpstormProjects/Pyramidas/Vue/initialisation.php">New game</a>
<table>
    <?php
    include "../Moteur/Model.php";

    session_start();

    if(empty($_SESSION["Model"])){
        echo "attention";
        $_SESSION["Model"]=new Model();
    }

    $model=$_SESSION["Model"];

    if(($_GET["id"])!=null && is_numeric($_GET["id"])){
        $model->playing($_GET["id"]);
    }

    $id=0;
    for ($y=1; $y<=11; $y++){
        echo "<tr>";
        for ($x=1; $x<=11; $x++){

            if(Model::caseExist($x, $y)){
                switch ($model->typePawn($id)){
                    case 0:
                        echo "<td id='use'>";
                        break;
                    case 1:
                        echo "<td id='j1'>";
                        break;
                    case 2:
                        echo "<td id='j2'>";
                        break;
                }

                $pion=$model->getStringPawn($id);

                $balise="<a href='plateau.php?id=".$id."'>".$pion."</a>";
                echo $balise;

                $id++;
            }else{
                echo "<td>";
            }

            echo "</td>";

        }
        echo "</tr>";
    }

    if($model->endGame()){
        header("Location: http://localhost/www/PhpstormProjects/Pyramidas/Vue/endgame.php");
    }
    ?>
</table>
</body>
</html>