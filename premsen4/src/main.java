import java.io.*;
import java.util.*;
import java.math.*;

class Calculator {

    List<Integer> solus;
    // autres attributs

    public Calculator() {
	solus = new ArrayList<Integer>();
	// définition autres attributs

	calcSolution();
    }

    static boolean premier(int n){
    	if(n==0 || n==1){
    		return false;
		}

    	for (int i=2; i<=Math.sqrt(n); i++){
    		if(n%i==0){
    			return false;
			}
		}
    	return true;
	}

    private void createAllNumber(){
    	for (int a=1; a<10; a++){
			for (int b=0; b<10; b++){
				for (int c=0; c<10; c++){
					for (int d=0; d<10; d++){
						solus.add(createNumber(a, b, c, d));
					}
				}
			}
		}
	}

	static int getInt(String string, int i){
    	return Character.getNumericValue(string.charAt(i));
	}

	private void cleanNumber(){
		List<Integer> noGoog = new ArrayList<>();
    	for (int i=0; i<solus.size(); i++){
			boolean good=true;
    		String number = Integer.toString(solus.get(i));

			for(int y=0; y<number.length(); y++){
				for(int x=0; x<number.length(); x++){
					if(y!=x&&getInt(number, x)==getInt(number,y)){
						good=false;
					}
				}
			}


			if((!premier(getInt(number,0)))||(!premier(getInt(number,1)))){
				good=false;
			}

			if(!(premier(getInt(number,0)+getInt(number,1)))){
				good=false;
			}

			if(!(premier(getInt(number,0)+getInt(number,1)+getInt(number,2)))){
				good=false;
			}

			if(!(premier(getInt(number,1)+getInt(number,2)+getInt(number,3)))){
				good=false;
			}

			if (!good){
				noGoog.add(solus.get(i));
			}

		}

		solus.removeAll(noGoog);
	}

    private int createNumber(int a, int b, int c, int d){
    	int number=0;
    	number+=a*1000;
    	number+=b*100;
    	number+=c*10;
    	number+=d;
    	return number;
	}

    public void calcSolution() {
    	createAllNumber();
    	cleanNumber();
    }
}


class Chiffres {

    public static void main(String[] args) {


    	/*
    	System.out.println("false-");
    	System.out.println(Calculator.premier(0));
		System.out.println(Calculator.premier(1));
		System.out.println(Calculator.premier(9));
		System.out.println(Calculator.premier(6));
		System.out.println(Calculator.premier(8));
		System.out.println(Calculator.premier(12));
		System.out.println(Calculator.premier(24));
		System.out.println(Calculator.premier(614));
		System.out.println("true-");
		System.out.println(Calculator.premier(2));
		System.out.println(Calculator.premier(3));
		System.out.println(Calculator.premier(19));
		System.out.println(Calculator.premier(29));
		System.out.println(Calculator.premier(31));
		System.out.println(Calculator.premier(5));
		System.out.println(Calculator.premier(7));
		System.out.println(Calculator.premier(11));
		System.out.println(Calculator.premier(13));
		System.out.println(Calculator.premier(7));
		System.out.println(Calculator.premier(17));
		System.out.println(Calculator.premier(37));
		System.out.println(Calculator.premier(31));
		System.out.println(Calculator.premier(23));
		*/

		Locale.setDefault(Locale.ENGLISH);

		Scanner scan = new Scanner(System.in);
		// lit une ligne qui ne sert à rien
		String expr = scan.next();
		Calculator c = new Calculator();
		// affiche le nombre de solutions
		System.out.println(c.solus.size());
		// affiche les solutions
		for(Integer i : c.solus) {
	    	System.out.println(i);
		}
    }
}