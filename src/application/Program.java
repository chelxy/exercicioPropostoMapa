package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String fullPath = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(fullPath))){
			
			Map<String, Integer> wishes = new HashMap<>();
			
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				
				if(wishes.containsKey(fields[0])) {
					int votesSoFar = wishes.get(fields[0]);
					wishes.put(fields[0], Integer.parseInt(fields[1]) + votesSoFar);
				}else {
					wishes.put(fields[0], Integer.parseInt(fields[1]));
				}
				line = br.readLine();
			}
			
			for(String key : wishes.keySet()) {
				
				System.out.println(key + ", " + wishes.get(key));
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
