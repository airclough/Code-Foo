package codeFooLicensePlate;

import java.awt.*;
import java.applet.*;
import java.util.Random;

public class platesByCodeFoo extends Applet
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
	int x;
	int[] plates = new int[3];
	int[] numberPatterns = new int[3];
	int[] letterPatterns = new int[3];
	int[] excess = new int[3];  
	TextField popString;
    String p = "";
    String plateNumbers = "";
    String plateLetters = "";
    String totalPlates = "";
    String excessPlates = "";
    int pop;
    Image fooYork;
    String randomLicenseLetters = "";
    String randomLicenseNumbers = "";
    String examplePlate = "";
      
    public void init()
    {
         java.net.URL imgURL = getClass().getResource("/images/fooYork.jpg");
         fooYork = Toolkit.getDefaultToolkit().getImage(imgURL);
    	 resize(930, 190);
    	 popString = new TextField(10);
    	 add(popString);
    	 popString.setText("");
         
    }

    public void paint(Graphics g)
    {
    	g.setColor(Color.BLUE);
    	g.drawImage(fooYork, 0, 0, this);
    	g.drawString("Least excess. No Code-Foolery. Guaranteed.",415,50);
        try
        {
        	Font f1 = new Font("Arial",Font.BOLD,12);
        	g.setFont(f1);
        	p = popString.getText();
            pop = Integer.parseInt(p);
            base10(pop);
            base26(pop);
            combo(pop);
            leastExcess();
            plateLetters();
        	plateNumbers();
        	concat();
         }
        catch(Exception e) {}

        g.drawString("Population:",415,75);
        g.drawString(p, 715, 75);
        g.drawString("Number Pattern:",415,100);
        g.drawString(plateNumbers, 715, 100);
        g.drawString("Letter Pattern:",415,125);
        g.drawString(plateLetters, 715, 125);
        g.drawString("Total Plates:",415,150);
        g.drawString(totalPlates, 715, 150);
        g.drawString("Excess Plates:",415,175);
        g.drawString(excessPlates, 715, 175);
        Font f2 = new Font("Arial",Font.BOLD,80);
    	g.setFont(f2);
    	FontMetrics fm = g.getFontMetrics();
    	x = 190 - fm.stringWidth(examplePlate)/2;
        g.drawString(examplePlate,x,140);
        
    }

    public boolean action(Event event, Object obj)
    {
          repaint();
          return true;
    }
    
    public void base10(int pop)
	{
		population = pop;
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
	}
    
    public void base26(int pop)
	{
    	population = pop;
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
	}
	
	public void combo(int pop)
	{
		population = pop;
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
						letters++;
						numbers--;
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
		numbers = numberPatterns[smallestIndex];
		letters = letterPatterns[smallestIndex];
		plateNumbers = String.valueOf(numberPatterns[smallestIndex]);
		plateLetters = String.valueOf(letterPatterns[smallestIndex]);
		totalPlates = String.valueOf(plates[smallestIndex]);
		excessPlates = String.valueOf(excess[smallestIndex]);
	}
	
	public int getNumbers()
	{
		return numbers;
	}
	
	public int getLetters()
	{
		return letters;
	}
	
	public void plateLetters()
	{
		Random l = new Random();
		String licenseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] text = new char[letters];
	    for (int i = 0; i < letters; i++)
	    {
	        text[i] = licenseLetters.charAt(l.nextInt(licenseLetters.length()));
	    }
	    randomLicenseLetters = String.valueOf(text);
	}
	
	public void plateNumbers()
	{
		Random n = new Random();
		String licenseNumbers = "0123456789";
		char[] textDeuce = new char[numbers];
	    for (int j = 0; j < numbers; j++)
	    {
	        textDeuce[j] = licenseNumbers.charAt(n.nextInt(licenseNumbers.length()));
	    }
	    randomLicenseNumbers = String.valueOf(textDeuce);
	}
	
	public void concat()
	{
		examplePlate = randomLicenseLetters.concat(randomLicenseNumbers);
	}
}