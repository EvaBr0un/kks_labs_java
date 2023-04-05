import java.util.Scanner;

public class TestComplex {

public static void enter(Complex num){
	
	Scanner sc = new Scanner(System.in);
	num.x = sc.nextInt();
	System.out.printf("imaginary part = ");
	sc = new Scanner(System.in);
	num.y = sc.nextInt();

}

public static void main (String args[]) {
		
		Complex example1 = new Complex();
		Complex example2 = new Complex();

		System.out.printf("Please, enter the first complex num:\n real part = ");
		enter(example1);

		System.out.printf("Please, enter the second complex num:\n real part = ");
		enter(example2);

		System.out.printf("Module of first complex num: %f\n", example1.module());
		System.out.printf("Module of second complex num: %f\n", example2.module());
		System.out.printf("Arg of first complex num: %f\n", example1.arg());
		System.out.printf("Arg of second complex num: %f\n", example2.arg());
		
		System.out.printf("First num plus second num: ");
		example1.add(example2);
		example1.getValue();

		System.out.printf("First num minus second num: ");
		example1.sub(example2);
		example1.sub(example2);
		example1.getValue();

	}

}