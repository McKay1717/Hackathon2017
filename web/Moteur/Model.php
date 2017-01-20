<?php

/**
 * Created by PhpStorm.
 * User: guillaume
 * Date: 20/01/17
 * Time: 11:22
 */

include "Board.php";

class Model{

    private $tableau;

    private $player;

    private $redPawn;
    private $bluePawn;



    function __construct() {
        $this->tableau=new Board();
        $this->player=true;

        $this->redPawn=1;
        $this->bluePawn=-1;
    }

    public function typePawn($i){
        if($this->tableau->getPawn($i)==Board::voidCell){
            return 0;
        }
        if($this->tableau->getPawn($i)>0){
            return 1;
        }
        return 2;
    }

    public function playing($i){

        $pawn=0;
        if($this->player){
            $pawn=$this->redPawn;
        }else{
            $pawn=$this->bluePawn;
        }
        if($this->tableau->setPawn($i, $pawn)){
            if($this->player){
                $this->redPawn++;
                $this->player=false;
            }else{
                $this->bluePawn--;
                $this->player=true;
            }
        }
    }

    public function endGame(){
        $n=0;
        for ($i=0; $i<20; $i++){
            if($this->tableau->getPawn($i)==Board::voidCell){
                $n++;
            }
        }

        if($n>1){
            return false;
        }

        $this->tableau->calculBoard();
        return true;
    }

    public function getStringPawn($i){


        if($this->tableau->getPawn($i)==Board::voidCell){
            return "_";
        }

        $retour="";


        $retour=abs($this->tableau->getPawn($i));

        return $retour;
    }

    static function caseExist($X, $Y){
        $case=[];
        $i=0;
        for ($y=1; $y<=11; $y++){
            if($y%2==0){
                $i++;
            }else{
                $nb=0;
                for ($x=1; $x<=11; $x++){
                    if($x>=6-$i&&$nb<$y-$i){
                        $case[count($case)]=[$x, $y];
                        $x++;
                        $nb++;
                    }
                }
            }
        }
        for ($t=0; $t<count($case); $t++){
            if($case[$t][0]==$X&&$case[$t][1]==$Y){
                return true;
            }
        }

        return false;
    }

    public function dispScore(){
        $string="<h3>Joueur rouge ".$this->tableau->redScore." Joueur bleu ".$this->tableau->blueScore."</h3>";
        return $string;
    }
}