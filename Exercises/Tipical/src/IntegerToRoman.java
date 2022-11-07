package TestingSkill;

public class IntegerToRoman {

	public static void main(String[] args) {
		
	}
	
	public String IntToRoman(int num)
	{
		
		String[] units = {"", "I","II","III","IV","V", "VI","VII","VIII","IX"};
		
		return units[num % 10];
	}

}
