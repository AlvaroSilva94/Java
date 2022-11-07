package TestingSkill;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Anagram 
{

	
	public static boolean isAnagram(String s1, String s2)
	{
		
		//remove whitespace from both strings
		s1.trim();
		s2.trim();
		
		//if the length are different, no way they will be an anagram 
		if (s1.length() != s2.length())
		{
			return false;
		}
		else
		{
			//Convert both strings to array characters
			char[] Arr1 = s1.toLowerCase().toCharArray();
			char[] Arr2 = s2.toLowerCase().toCharArray();
			
			//sort both arrays
			Arrays.sort(Arr1);
			Arrays.sort(Arr2);
			
			return (Arrays.equals(Arr1,Arr2));
		}

		
		
	}
	
	public static void main(String[] args) 
	{
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input the first string to compare: ");
		String ss1 = sc.nextLine();
		System.out.print("Input the second string to compare: ");
		String ss2 = sc.nextLine();
		
		if(isAnagram(ss1,ss2))
		{
			System.out.println("The strings " + ss1 + " and " + ss2 + " are anagrams!");
		}
		else
		{
			System.out.println("The strings " + ss1 + " and " + ss2 + " are not anagrams!");
		}
		
		sc.close();
	}

}
