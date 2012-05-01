package Pimp_my_Ride;
import java.util.Scanner;

public class License_Plate 
{
	int population;
	int smallestIndex = 0;
	double exponent;
	double[] plates = new double[3];
	double[] patterns = new double[3];
	double[] remainders = new double[3];
	
	public static void main(String[] args)
	{
		License_Plate pimpMyRide = new License_Plate();
		pimpMyRide.getPopulation();
		pimpMyRide.base10();
		pimpMyRide.base26();
		pimpMyRide.base36();
		pimpMyRide.leastExcess();
		pimpMyRide.manufacture();
	}
		
		public void getPopulation()
		{
			System.out.println("Enter the population:");
			Scanner keyboard = new Scanner(System.in);
			population = keyboard.nextInt();
		}
		
		public void base10()
		{
			exponent = 1;
			while (population > (Math.pow(10, exponent)))
			{
				exponent++;
			}
			double platesGenerated = (Math.pow(10, exponent));
			double remainder = platesGenerated - population;
			plates[0] = platesGenerated;
			patterns[0] = exponent;
			remainders[0] = remainder;
			System.out.println("In base 10 there will be " + platesGenerated + " license plates generated using a pattern of " + exponent + " number(s) and " + remainder + " left over.");
		}
		
		public void base26()
		{
			exponent = 1;
			while (population > (Math.pow(26, exponent)))
			{
				exponent++;
			}
			double platesGenerated = (Math.pow(26, exponent));
			double remainder = platesGenerated - population;
			plates[1] = platesGenerated;
			patterns[1] = exponent;
			remainders[1] = remainder;
			System.out.println("In base 26 there will be " + platesGenerated + " license plates generated using a pattern of " + exponent + " letters(s) and " + remainder + " left over.");
		}
		
		public void base36()
		{
			exponent = 1;
			while (population > (Math.pow(36, exponent)))
			{
				exponent++;
			}
			double platesGenerated = (Math.pow(36, exponent));
			double remainder = platesGenerated - population;
			plates[2] = platesGenerated;
			patterns[2] = exponent;
			remainders[2] = remainder;
			System.out.println("In base 36 there will be " + platesGenerated + " license plates generated using any combo of " + exponent + " number(s) and letter(s) and " + remainder + " left over.");
		}
		
		public void leastExcess() 
		{
			double currentValue = remainders[0]; 
			for (int i=0; i < 3; i++) 
			{
				if (remainders[i] < currentValue)
	                        { 
								currentValue = remainders[i];
	                            smallestIndex = i;
	                        }
			}
			System.out.println();
			System.out.println("The smallest index is: "+ smallestIndex);
		}
		
		public void manufacture()
		{
			System.out.println();
			System.out.println("Population: " + population);
			
			if (smallestIndex == 0)
			System.out.println("Pattern: " + patterns[smallestIndex] + " number(s)");
				else if (smallestIndex ==1)
				System.out.println("Pattern: " + patterns[smallestIndex] + " letter(s)");
					else
					System.out.println("Pattern: " + patterns[smallestIndex] + " number(s) or letter(s)");
			
			System.out.println("Total Plates: " + plates[smallestIndex]);
			System.out.println("Excess Plates: " + remainders[smallestIndex]);
		}
}
