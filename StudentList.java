import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String studentData = reader.readLine();
			String studentName[] = studentData.split(",");
			for(String name : studentName) {
				System.out.println(name);
			}
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String studentData = reader.readLine();
			System.out.println(studentData);
			String studentName[] = studentData.split(",");
			Random random = new Random();
				int index = random.nextInt(studentName.length);
					System.out.println(studentName[index]);
			} catch (Exception e){
				System.out.println(e);
			}
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter("students.txt", true));
			String newStudentName = args[0].substring(1);
	        Date currentDate = new Date();
	        String dataFormatPattern  = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(dataFormatPattern );
	        String formatedDate= dateFormat.format(currentDate);
			writer.write(", "+newStudentName+"\nList last updated on "+formatedDate);
			writer.close();
			} catch (Exception e){
				System.out.println(e);
			}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader s = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String studentData = s.readLine();
			String i[] = studentData.split(",");
			boolean found = false;
			String t = args[0].substring(1);
			for(int idx = 0; idx<i.length && !found; idx++) {
				if(i[idx].equals(t)) {
					System.out.println("We found it!");
					found=true;
				}
			}
			} catch (Exception e){
				System.out.println(e);
			}
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String studentData  = reader.readLine();
			char characters[] = studentData .toCharArray();
			boolean found = false;
			int count=0;
			for(char character:characters) {
				if(character ==' ')
				{
					if (!found) {
						count++;
						found =true;
					}
					else {
						found=false;
					}
				}
			}
			System.out.println(count +" word(s) found ");
			} catch (Exception e){
				System.out.println(e);
			}
			System.out.println("Data Loaded.");				
		}
		else{
			System.out.println("!Invalid Argument .");
		}

	}
}