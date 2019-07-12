package day7_advanced_topic;// Example of the URL class that reads www.wikipedia.org

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadURL
{
	public static void main(String[] args)
	{
		try
		{
			URL website = new URL("http://www.google.com");
			Scanner inputStream = new Scanner(new InputStreamReader(
				website.openStream()));

			while (inputStream.hasNextLine())
			{
			  String s = inputStream.nextLine();
			  System.out.println(s);
			}
			inputStream.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
}