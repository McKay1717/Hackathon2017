import java.math.BigInteger;
import java.util.*;

class Checker {
    private String nombre;

    private int size;

    public Checker(int first, int second) {
        nombre=first+""+second;
        size =2;
        for (int i=nombre.length(); i<6;i++){
            addChiffre();
        }
    }

    static int getInt(String string, int i){
        return Character.getNumericValue(string.charAt(i));
    }

    static boolean isChaineOnze(String nombre){
        for (int i=0; i<nombre.length()-2; i++){
            int triple=0;
            triple+=getInt(nombre, i)*100;
            triple+=getInt(nombre, i+1)*10;
            triple+=getInt(nombre, i+2);

            if(triple%11!=0){
                return false;
            }
        }
        return true;
    }

    public void addChiffre(){
        for (int i=0; i<10; i++){
            if(isChaineOnze(nombre+i)){
                nombre+=i;
                size++;
                break;
            }
        }
    }


    /* check() :
       prend en paramètre un indice et un chiffre et renvoie :
       - 1 si le digit de la chaineonze à l'indice donné correspond au chiffre en paramètre
       - 0 sinon
    */
    public boolean check(long taille, int chiffre) {

        taille--;
        if(size<6&&taille>=6){
            return false;
        }
        int indice = (int) (taille%6);

        if(indice<0){
            indice=indice+6;
        }


        return getInt(nombre, indice)==chiffre;
    }

    public String toString(){
        return nombre+"size="+size;
    }
}


class Chaineonze {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        int firstValue = -1;
        int secondValue = -1;
        int nbCases;
        Checker c = null;


        Scanner scan = new Scanner(System.in);

        Checker checker= new Checker(scan.nextInt(), scan.nextInt());


        int kmax = scan.nextInt();
        for(int k=0;k<kmax;k++){
            if(checker.check(scan.nextLong(),scan.nextInt())){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }

	/*
	   - lire avec scan premier chiffre de la chaineonze -> firstValue
	   - lire avec scan deuxième chiffre de la chaineonze -> secondValue
	   - instancier c
	   - lire avec scan le nombre de cas à traiter -> nbCases
	   - pour chaque cas :
	      - lire l'indice du digit
	      - lire la valeur du digit
	      - utiliser c pour déterminer si cette valeur est bien la bonne pour l'indice donné
	      - selon le cas afficher 0 ou 1
	*/
    }
}