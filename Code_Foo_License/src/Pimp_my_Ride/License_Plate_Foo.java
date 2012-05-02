package Pimp_my_Ride;
import java.util.Scanner;

public class License_Plate_Foo 
{
	int population;
	int base10Digits;
	int base26Digits;
	int platesGenerated;
	int totalExcess;
	int letters;
	int numbers;
	int combo;
	int smallestIndex;
	int[] plates = new int[4];
	int[] numberPatterns = new int[4];
	int[] letterPatterns = new int[4];
	int[] excess = new int[4];
	
	public static void main(String[] args)
	{
		License_Plate_Foo pimpMyRide = new License_Plate_Foo();
		pimpMyRide.getPopulation();
		pimpMyRide.base10();
		pimpMyRide.base26();
		pimpMyRide.combo();
		pimpMyRide.leastExcess();
		pimpMyRide.manufacturePlates();
	}
		
		public void getPopulation()
		{
			System.out.println("Enter the population of your city or state. We will do the rest:");
			Scanner keyboard = new Scanner(System.in);
			population = keyboard.nextInt();
		}
		
		public void base10()
		{
			base10Digits = 1;
			while (population > (Math.pow(10, base10Digits)))
			{
				base10Digits++;
			}
			platesGenerated = (int) (Math.pow(10, base10Digits));
			totalExcess = platesGenerated - population;
			plates[0] = platesGenerated;
			numberPatterns[0] = base10Digits;
			letterPatterns[0] = 0;
			excess[0] = totalExcess;
			//System.out.println("In base 10 (numbers only) there will be " + platesGenerated + " license plates generated using a pattern of " + base10Digits + " number(s) and " + totalExcess + " plates left over.");
		}
		
		public void base26()
		{
			base26Digits = 1;
			while (population > (Math.pow(26, base26Digits)))
			{
				base26Digits++;
			}
			platesGenerated = (int) (Math.pow(26, base26Digits));
			totalExcess = platesGenerated - population;
			plates[1] = platesGenerated;
			numberPatterns[1] = 0;
			letterPatterns[1] = base26Digits;
			excess[1] = totalExcess;
			//System.out.println("In base 26 (letters only) there will be " + platesGenerated + " license plates generated using a pattern of " + base26Digits + " letters(s) and " + totalExcess + " plates left over.");
		}
		
		public void combo()
		{
			letters = base26Digits;
			numbers = 0;
			combo = platesGenerated;
				while (platesGenerated > population)
				{
					letters--;
					numbers++;
					combo = platesGenerated;
					if (letters == 0)
					{
						letters++;
						numbers--;
						break;
					}
					else
						platesGenerated = (int) ((Math.pow(26, letters)) * (Math.pow(10, numbers)));
						if (platesGenerated < population)
						{
							break;
						}
						else
							combo = platesGenerated;
				}
				totalExcess = combo - population;
				plates[2] = combo;
				numberPatterns[2] = numbers;
				letterPatterns[2] = letters;
				excess[2] = totalExcess;
		}
		
		public void leastExcess() 
		{
			smallestIndex = 0;
			int currentValue = excess[0]; 
			for (int i=0; i < 3; i++) 
			{
				if (excess[i] < currentValue)
	                        { 
								currentValue = excess[i];
	                            smallestIndex = i;
	                        }
			}
		}
		
		public void manufacturePlates()
		{
			System.out.println();
			System.out.println("Code Foo License Plate Manufacturing Co.");
			System.out.println("Least excess. No code-foolery. Guaranteed.");
			System.out.println();
			
			System.out.println("Population: " + population);
			if (smallestIndex == 0)
			System.out.println("Pattern: " + numberPatterns[smallestIndex] + " number(s)");
				else if (smallestIndex == 1)
				System.out.println("Pattern: " + letterPatterns[smallestIndex] + " letter(s)");
					else
					System.out.println("Pattern: " + numberPatterns[smallestIndex] + " number(s) and " + letterPatterns[smallestIndex] + " letter(s)");
			
			System.out.println("Total Plates: " + plates[smallestIndex]);
			System.out.println("Excess Plates: " + excess[smallestIndex]);
		}
}
