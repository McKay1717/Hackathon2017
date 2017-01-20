<?php

/**
 * Created by PhpStorm.
 * User: guillaume
 * Date: 20/01/17
 * Time: 12:40
 */
class Board {

    const voidCell=1000;

    private $board;
    private $neighbors;

    public $redScore;
    public $blueScore;


    function __construct() {

        $this->board=[];
        $this->neighbors=[[]];

        $this->blueScore=0;
        $this->redScore=0;

        $this->confNeighbors();
        $this->confBoard();

    }

    private function confNeighbors(){

        //[numero cellule][n]=numero voisin
        $this->neighbors[0][0]=1;
        $this->neighbors[0][1]=2;

        $this->neighbors[1][0]=0;
        $this->neighbors[1][1]=3;
        $this->neighbors[1][2]=2;

        $this->neighbors[2][0]=1;
        $this->neighbors[2][1]=0;
        $this->neighbors[2][2]=5;

        $this->neighbors[3][0]=1;
        $this->neighbors[3][1]=4;
        $this->neighbors[3][2]=7;
        $this->neighbors[3][3]=6;

        $this->neighbors[4][0]=1;
        $this->neighbors[4][1]=2;
        $this->neighbors[4][2]=5;
        $this->neighbors[4][3]=8;
        $this->neighbors[4][4]=7;
        $this->neighbors[4][5]=3;

        $this->neighbors[5][0]=2;
        $this->neighbors[5][1]=4;
        $this->neighbors[5][2]=8;
        $this->neighbors[5][3]=9;

        $this->neighbors[6][0]=3;
        $this->neighbors[6][1]=7;
        $this->neighbors[6][2]=11;
        $this->neighbors[6][3]=10;

        $this->neighbors[7][0]=3;
        $this->neighbors[7][1]=4;
        $this->neighbors[7][2]=8;
        $this->neighbors[7][3]=12;
        $this->neighbors[7][4]=11;
        $this->neighbors[7][5]=6;

        $this->neighbors[8][0]=4;
        $this->neighbors[8][1]=5;
        $this->neighbors[8][2]=9;
        $this->neighbors[8][3]=13;
        $this->neighbors[8][4]=12;
        $this->neighbors[8][5]=7;

        $this->neighbors[9][0]=5;
        $this->neighbors[9][1]=8;
        $this->neighbors[9][2]=13;
        $this->neighbors[9][3]=14;

        $this->neighbors[10][0]=6;
        $this->neighbors[10][1]=11;
        $this->neighbors[10][2]=16;
        $this->neighbors[10][3]=15;

        $this->neighbors[11][0]=6;
        $this->neighbors[11][1]=7;
        $this->neighbors[11][2]=12;
        $this->neighbors[11][3]=17;
        $this->neighbors[11][4]=16;
        $this->neighbors[11][5]=10;

        $this->neighbors[12][0]=7;
        $this->neighbors[12][1]=8;
        $this->neighbors[12][2]=13;
        $this->neighbors[12][3]=18;
        $this->neighbors[12][4]=17;
        $this->neighbors[12][5]=11;

        $this->neighbors[13][0]=8;
        $this->neighbors[13][1]=9;
        $this->neighbors[13][2]=14;
        $this->neighbors[13][3]=19;
        $this->neighbors[13][4]=18;
        $this->neighbors[13][5]=12;

        $this->neighbors[14][0]=9;
        $this->neighbors[14][1]=13;
        $this->neighbors[14][2]=19;
        $this->neighbors[14][3]=20;

        $this->neighbors[15][0]=10;
        $this->neighbors[15][1]=16;

        $this->neighbors[16][0]=15;
        $this->neighbors[16][1]=10;
        $this->neighbors[16][2]=11;
        $this->neighbors[16][3]=17;

        $this->neighbors[17][0]=16;
        $this->neighbors[17][1]=11;
        $this->neighbors[17][2]=12;
        $this->neighbors[17][3]=18;

        $this->neighbors[18][0]=17;
        $this->neighbors[18][1]=12;
        $this->neighbors[18][2]=13;
        $this->neighbors[18][3]=19;

        $this->neighbors[19][0]=18;
        $this->neighbors[19][1]=13;
        $this->neighbors[19][2]=14;
        $this->neighbors[19][3]=20;

        $this->neighbors[20][0]=14;
        $this->neighbors[20][1]=19;
    }


    public function voidCellIndex(){
        $nb=0;
        for ($i=0; $i<20; $i++){
            if($this->getPawn($i)==Board::voidCell){
                $nb=$i;
            }
        }
        return $nb;
    }

    public function calculBoard(){
        $this->blueScore = 0;
        $this->redScore = 0;
        $idVoid = $this->voidCellIndex();
        for($i=0;$i<6;$i++) {
            if ($this->neighbors[$idVoid][$i] != null) {
                if ($this->board[$this->neighbors[$idVoid][$i]] < 0) {
                    $this->blueScore += abs($this->board[$this->neighbors[$idVoid][$i]]);
            } else {
                    $this->redScore += abs($this->board[$this->neighbors[$idVoid][$i]]);
            }
        }
        }
    }

    private function confBoard(){
        for($i=0;$i<=20; $i++){
            $this->board[$i]=Board::voidCell;
        }
    }

    public function getPawn($i){
        return $this->board[$i];
    }

    public function setPawn($i, $v){
        if($i<0||$i>20){
            return false;
        }
        if($this->board[$i]==Board::voidCell){
            $this->board[$i]=$v;
            return true;
        }else{
            return false;
        }
    }

}