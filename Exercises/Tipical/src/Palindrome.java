package TestingSkill;

import java.util.Locale;
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Input the string to compare: ");
		String s1 = sc.nextLine();

		if (isPalindrome(s1)) 
		{
			System.out.println("The string is a palindrome indeed!");
		}
		else
		{
			System.out.println("The string isn't a palindrome after all!");
		}

	}


	public static boolean isPalindrome(String s1)
	{
		//remove spaces
		s1.trim();
		
		//Staring and ending positions
		int i=0, j=s1.length()-1;
		
		//meeting in the middle of the word
		while(i<j)
		{
			if(s1.toLowerCase().charAt(i)!=s1.toLowerCase().charAt(j))
			{
				return false;
			}
			//to make the increment in one and the decrement in the other meet in the middle
				i++;
				j--;
		}
		return true; //meaning all the chars in positions i/j were the same ->palindrome
	}

}
