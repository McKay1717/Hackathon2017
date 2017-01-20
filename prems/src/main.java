import java.io.*;
import java.util.*;

/* Checker :
   permet de tester grâce à la méthode check si une valeur est un nombre super non-premier.

   conseil : puisqu'il faut déterminer si plein de valeurs sont ou non des nombres premiers, il est
   judicieux de générer la liste des nombres premiers de 2 jusqu'à lim.
 */
class Checker {
    private int lim; // la valeur max. des nombres à traiter
    private List<Integer> listNumber;

    public Checker(int lim) {
        this.lim = lim;
        listNumber=new ArrayList<>();

        createList();
    }

    private void createList(){
        for (int n=10;n<=lim; n++){
            if(isSuperNonPremier(n)){
                listNumber.add(n);
            }
        }
    }

    static boolean isSuperNonPremier(int number){

        if(!(number>=10)){
            return false;
        }

        if(isPrime(number)){
            return false;
        }

        if(!goodDigit(number)){
            return false;
        }

        return true;
    }

    static boolean isPrime(int number){
        if(number<2){
            return false;
        }
        for (int i=2; i<=Math.sqrt(number); i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    static int getIntInString(String string, int i){
        return Character.getNumericValue(string.charAt(i));
    }

    static boolean goodDigit(int number){
        String string = String.valueOf(number);

        /*
        check the digit one for one
         */
        for (int i=0; i<string.length(); i++){
            int digit = getIntInString(string, i);
            if(digit!=1 && !isPrime(digit)){
                return false;
            }
        }

        int nbDigit=string.length();

        if(nbDigit<2){
            return true;
        }

        for(int d=2; d<nbDigit; d++){
            if(!suiteDigits(d, string)){
                return false;
            }
        }

        return true;
    }

    static boolean suiteDigits(int d, String nombe){
        for (int i=0; i<nombe.length()-(d-1); i++){
            int value=0;
            int count=i;
            for (int p = (int) Math.pow(10.0, d-1); p>0; p=p/10){
                value+=getIntInString(nombe, count)*p;
                count++;
            }
            if(!isPrime(value)){
                return false;
            }
        }
        return true;
    }

    public String check(int value) {
        boolean good=false;

        for (int i=0; i<listNumber.size(); i++){
            if(listNumber.get(i)==value){
                good=true;
                break;
            }
        }

        if(good){
            return "yes";
        }else {
            return "no";
        }
    }

    public String toString(){
        return listNumber.toString();
    }
}


class SuperNonPremier {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);



        Checker c = new Checker(100000); // check for number till 100000
        //System.out.println(c);
        Scanner scan = new Scanner(System.in);
        int nbCases = scan.nextInt(); // get numbers of cases from stdin

        for(int i=0;i<nbCases;i++) {
            int value = scan.nextInt(); // get the value from stdin
            System.out.println(c.check(value)); // print answer on stdout
        }

    }
}