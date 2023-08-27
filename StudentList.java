import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	// Read the content from the File
	public static String FileReader()
	{
		String studentData = null;
		try{
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.FILE_PATH)));
			studentData = reader.readLine();

		}catch (Exception e)
		{
			System.out.println(e);
		}
		return studentData;

	}
	// Write content to the file
	public static void fileWriter(String content)
	{
		try{BufferedWriter writer = new BufferedWriter(
				new FileWriter(Constants.FILE_PATH, true));
			writer.write(content);
			writer.close();


		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

//		Check arguments

		if(args.length<1)
		{
			System.out.println(Constants.INVALID);
		}
		if(args[0].equals("a")) {
			System.out.println(Constants.LOADING_DATA);
			for(String name : FileReader().split(Constants.SPLIT)) {
				System.out.println(name);
			}
			System.out.println(Constants.LOADED_DATA);
		}
		// Display a random student's name
		else if(args[0].equals("r")) 
		{
			System.out.println(Constants.LOADING_DATA);
			String studentData = FileReader();
			System.out.println(studentData);
			String studentName[] = studentData.split(",");
			Random random = new Random();
				int index = random.nextInt(studentName.length);
					System.out.println(studentName[index]);

			System.out.println(Constants.LOADED_DATA);
		}
		//Adding Date with formatting
		else if(args[0].contains("+")){
			System.out.println(Constants.LOADING_DATA);
			try {

			String newStudentName = args[0].substring(1);
	        Date currentDate = new Date();
	        String dataFormatPattern  = Constants.DATE_FORMATE;
	        DateFormat dateFormat = new SimpleDateFormat(dataFormatPattern );
	        String formattedDate= dateFormat.format(currentDate);
				fileWriter(", "+newStudentName+Constants.LAST_UPDATE+formattedDate);
			} catch (Exception e){
				System.out.println(e);
			}
							
			System.out.println(Constants.LOADED_DATA);
		}

		// Search for a student by name
		else if(args[0].contains("?"))
		{
			System.out.println(Constants.LOADING_DATA);
			String studentData = FileReader();
			String i[] = studentData.split(",");
			boolean found = false;

			for(int idx = 0; idx<FileReader().split(Constants.SPLIT).length && !found; idx++) {
				if(FileReader().split(Constants.SPLIT)[idx].equals(args[0].substring(1))) {
					System.out.println(Constants.FOUND);
					found=true;
				}
			}
			System.out.println(Constants.LOADED_DATA);
		}
		// Count the number of words in the student data
		else if(args[0].contains("c"))
		{
			System.out.println(Constants.LOADING_DATA);
			try {
				String studentData = FileReader();
				String studentName[] = studentData.split(Constants.SPLIT);

				System.out.println(studentName.length +Constants.WORDS_FOUND );
			} catch (Exception e){
				System.out.println(e);
			}
			System.out.println(Constants.LOADED_DATA);
		}
		else{
			System.out.println("!Invalid Argument .");
		}


	}
}