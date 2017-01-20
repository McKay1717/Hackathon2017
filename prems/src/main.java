import java.io.*;
import java.util.*;

/* Checker :
   permet de tester grâce à la méthode check si une valeur est un nombre super non-premier.

   conseil : puisqu'il faut déterminer si plein de valeurs sont ou non des nombres premiers, il est
   judicieux de générer la liste des nombres premiers de 2 jusqu'à lim.
 */
class Checker {
    int lim; // la valeur max. des nombres à traiter

    // autres attributs

    public Checker(int lim) {
        this.lim = lim;
        // init. autres attributs
    }

    public String check(int value) {
        boolean good=true;
        // retourne "yes" su value est un super non-premier
        // "false" sinon
        if(good){
            return "yes";
        }else {
            return "false";
        }
    }

    // autres méthodes.
}


class SuperNonPremier {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        Checker c = new Checker(100000); // check for number till 100000
        Scanner scan = new Scanner(System.in);
        int nbCases = scan.nextInt(); // get numbers of cases from stdin

        for(int i=0;i<nbCases;i++) {
            int value = scan.nextInt(); // get the value from stdin
            System.out.println(c.check(value)); // print answer on stdout
        }
    }
}